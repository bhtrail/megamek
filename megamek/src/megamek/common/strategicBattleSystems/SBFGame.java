/*
 * Copyright (c) 2024 - The MegaMek Team. All Rights Reserved.
 *
 * This file is part of MegaMek.
 *
 * MegaMek is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MegaMek is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MegaMek. If not, see <http://www.gnu.org/licenses/>.
 */
package megamek.common.strategicBattleSystems;

import megamek.common.*;
import megamek.common.alphaStrike.AlphaStrikeElement;
import megamek.common.annotations.Nullable;
import megamek.common.enums.GamePhase;
import megamek.common.event.GameEntityChangeEvent;
import megamek.common.event.GamePhaseChangeEvent;
import megamek.common.options.GameOptions;
import megamek.common.options.OptionsConstants;
import megamek.common.planetaryconditions.PlanetaryConditions;
import megamek.server.sbf.SBFVisibilityHelper;
import org.apache.logging.log4j.LogManager;

import java.util.*;

/**
 * This is an SBF game's game object that holds all game information. As of 2024, this is under construction.
 */
public final class SBFGame extends AbstractGame implements PlanetaryConditionsUsing {

    private final GameOptions options = new GameOptions(); //TODO: SBFGameOptions()
    private GamePhase phase = GamePhase.UNKNOWN;
    private GamePhase lastPhase = GamePhase.UNKNOWN;
    private final PlanetaryConditions planetaryConditions = new PlanetaryConditions();
    private final SBFFullGameReport gameReport = new SBFFullGameReport();
    private final List<GameTurn> turnList = new ArrayList<>();
    private final SBFVisibilityHelper visibilityHelper = new SBFVisibilityHelper();

    /**
     * Contains all units that have left the game by any means.
     */
    private final List<InGameObject> graveyard = new ArrayList<>();

    public SBFGame() {
        setBoard(0, new Board());
    }

    @Override
    public PlayerTurn getTurn() {
        return null;
    }

    @Override
    public GameOptions getOptions() {
        return options;
    }

    @Override
    public GamePhase getPhase() {
        return phase;
    }

    public GamePhase getLastPhase() {
        return lastPhase;
    }

    @Override
    public void setPhase(GamePhase phase) {
        this.phase = phase;
    }

    @Override
    public void receivePhase(GamePhase phase) {
        GamePhase oldPhase = this.phase;
        setPhase(phase);
        fireGameEvent(new GamePhaseChangeEvent(this, oldPhase, phase));
    }

    @Override
    public boolean isForceVictory() { //TODO This should not be part of IGame! too specific
        return false;
    }

    @Override
    public void addPlayer(int id, Player player) { // Server / Client-side?
        super.addPlayer(id, player);
        player.setGame(this);
        setupTeams();

        if ((player.isBot()) && (!player.getSingleBlind())) {
            boolean sbb = getOptions().booleanOption(OptionsConstants.ADVANCED_SINGLE_BLIND_BOTS);
            boolean db = getOptions().booleanOption(OptionsConstants.ADVANCED_DOUBLE_BLIND);
            player.setSingleBlind(sbb && db);
        }
    }

    @Override
    public boolean isCurrentPhasePlayable() {
        switch (phase) {
            case INITIATIVE:
            case END:
            case TARGETING:
            case PHYSICAL:
            case OFFBOARD:
            case OFFBOARD_REPORT:
                return false;
            case DEPLOYMENT:
            case PREMOVEMENT:
            case MOVEMENT:
            case PREFIRING:
            case FIRING:
            case DEPLOY_MINEFIELDS:
            case SET_ARTILLERY_AUTOHIT_HEXES:
                return hasMoreTurns();
            default:
                return true;
        }
    }

    @Override
    public void setPlayer(int id, Player player) {

    }

    @Override
    public void removePlayer(int id) {

    }

    @Override
    public void setupTeams() {
        Vector<Team> initTeams = new Vector<>();
        boolean useTeamInit = getOptions().getOption(OptionsConstants.BASE_TEAM_INITIATIVE)
                .booleanValue();

        // Get all NO_TEAM players. If team_initiative is false, all
        // players are on their own teams for initiative purposes.
        for (Player player : getPlayersList()) {
            // Ignore players not on a team
            if (player.getTeam() == Player.TEAM_UNASSIGNED) {
                continue;
            }
            if (!useTeamInit || (player.getTeam() == Player.TEAM_NONE)) {
                Team new_team = new Team(Player.TEAM_NONE);
                new_team.addPlayer(player);
                initTeams.addElement(new_team);
            }
        }

        if (useTeamInit) {
            // Now, go through all the teams, and add the appropriate player
            for (int t = Player.TEAM_NONE + 1; t < Player.TEAM_NAMES.length; t++) {
                Team new_team = null;
                for (Player player : getPlayersList()) {
                    if (player.getTeam() == t) {
                        if (new_team == null) {
                            new_team = new Team(t);
                        }
                        new_team.addPlayer(player);
                    }
                }

                if (new_team != null) {
                    initTeams.addElement(new_team);
                }
            }
        }

        // May need to copy state over from previous teams, such as initiative
        if (!getPhase().isLounge()) {
            for (Team newTeam : initTeams) {
                for (Team oldTeam : teams) {
                    if (newTeam.equals(oldTeam)) {
                        newTeam.setInitiative(oldTeam.getInitiative());
                    }
                }
            }
        }

        // Carry over faction settings
        for (Team newTeam : initTeams) {
            for (Team oldTeam : teams) {
                if (newTeam.equals(oldTeam)) {
                    newTeam.setFaction(oldTeam.getFaction());
                }
            }
        }

        teams.clear();
        teams.addAll(initTeams);
    }

    @Override
    public void replaceUnits(List<InGameObject> units) {

    }

    @Override
    public PlanetaryConditions getPlanetaryConditions() {
        return planetaryConditions;
    }

    @Override
    public void setPlanetaryConditions(@Nullable PlanetaryConditions conditions) {
        if (conditions == null) {
            LogManager.getLogger().error("Can't set the planetary conditions to null!");
        } else {
            planetaryConditions.alterConditions(conditions);
        }
    }

    public void addUnit(InGameObject unit) { // This is a server-side method!
        if (!isSupportedUnitType(unit)) {
            LogManager.getLogger().error("Tried to add unsupported object [{}] to the game!", unit);
            return;
        }

        // Add this unit, ensuring that its id is unique
        int id = unit.getId();
        if (inGameObjects.containsKey(id)) {
            id = getNextEntityId();
            unit.setId(id);
        }
        inGameObjects.put(id, unit);
    }

    public void receiveUnit(InGameObject unit) { // This is a client-side method to set a unit sent by the server!
        inGameObjects.put(unit.getId(), unit);
    }

    private boolean isSupportedUnitType(InGameObject object) {
        return object instanceof SBFFormation || object instanceof AlphaStrikeElement || object instanceof SBFUnit;
    }

    @Override
    public void setLastPhase(GamePhase lastPhase) {
        this.lastPhase = lastPhase;
    }

    /**
     * Adds the given reports this game's reports.
     *
     * @param reports the new reports to add
     */
    public void addReports(List<Report> reports) {
        gameReport.add(getCurrentRound(), reports);
    }

    @Override
    public ReportEntry getNewReport(int messageId) {
        return new Report(messageId);
    }

    public SBFFullGameReport getGameReport() {
        return gameReport;
    }

    /**
     * Replaces this game's entire reports with the given reports.
     *
     * @param newReports The new reports to keep as this game's reports
     */
    public void replaceAllReports(Map<Integer, List<Report>> newReports) {
        gameReport.replaceAllReports(newReports);
    }

    public void clearTurns() {
        turnList.clear();
    }

    /**
     * Sets the current list of turns to the given one, replacing any currently present turns.
     *
     * @param newTurns The new list of turns to use
     */
    public void setTurns(List<GameTurn> newTurns) {
        turnList.clear();
        turnList.addAll(newTurns);
    }

    /**
     * Returns the current list of turns. The returned list is unmodifiable but not a deep copy. If you're
     * not the SBFGameManager, don't even think about changing any of the turns.
     */
    @Override
    public List<GameTurn> getTurnsList() {
        return Collections.unmodifiableList(turnList);
    }

    /**
     * Changes to the next turn, returning it.
     */
    public PlayerTurn changeToNextTurn() {
        turnIndex++;
        return getTurn();
    }

    public List<InGameObject> getGraveyard() {
        return graveyard;
    }

    public void setUnitList(List<InGameObject> units) {
        inGameObjects.clear();
        for (InGameObject unit : units) {
            int id = unit.getId();
            inGameObjects.put(id, unit);
        }
        fireGameEvent(new GameEntityChangeEvent(this, null));
    }

    public void setGraveyard(List<InGameObject> graveyard) {
        this.graveyard.clear();
        this.graveyard.addAll(graveyard);
    }

    public SBFVisibilityHelper visibilityHelper() {
        return visibilityHelper;
    }

    public boolean isVisible(int viewingPlayer, int formationID) {
        return visibilityHelper.isVisible(viewingPlayer, formationID);
    }
}
