/*
 * Copyright (c) 2022 - The MegaMek Team. All Rights Reserved.
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
package megamek.common;

import megamek.common.actions.EntityAction;
import megamek.common.event.GameBoardNewEvent;
import megamek.common.event.GameEvent;
import megamek.common.event.GameListener;
import megamek.common.event.GameNewActionEvent;
import megamek.common.force.Forces;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * This is a base class to derive all types of Game (TW, AS, BF, SBF...) from. Any such game will have players, units
 * (InGameObjects) and Forces (even if empty); the base class manages these.
 */
public abstract class AbstractGame implements IGame {

    private static final int AWAITING_FIRST_TURN = -1;

    /** The players present in the game mapped to their id as key */
    protected final ConcurrentHashMap<Integer, Player> players = new ConcurrentHashMap<>();

    /** The InGameObjects (units such as Entity and others) present in the game mapped to their id as key */
    protected final ConcurrentHashMap<Integer, InGameObject> inGameObjects = new ConcurrentHashMap<>();

    /** The teams present in the game */
    protected final CopyOnWriteArrayList<Team> teams = new CopyOnWriteArrayList<>();

    protected transient Vector<GameListener> gameListeners = new Vector<>();

    /** The currently pending actions such as attacks */
    protected final List<EntityAction> pendingActions = new ArrayList<>();

    /**
     * This Map holds all game boards together with a unique ID for each.
     * For the "legacy" Game that currently only allows a single board, that board always uses ID 0.
     * To support game types that use board types other than hex boards, a superclass or interface should
     * be used instead of Board in the future.
     */
    private final Map<Integer, Board> gameBoards = new HashMap<>();

    /**
     * The forces present in the game. The top level force holds all forces and force-less entities
     * and should therefore not be shown.
     */
    protected Forces forces = new Forces(this);

    /**
     * This map links deployment rounds to lists of Deployables that deploy in respective rounds. It only contains
     * units/objects that are not yet deployed or will redeploy (returning Aeros, units going from one board to
     * another if implemented). For those, the list is updated every round.
     */
    private final Map<Integer, List<Deployable>> deploymentTable = new HashMap<>();

    /**
     * The round counter. It gets incremented before initiative; round 0 is initial deployment only.
     */
    protected int currentRound = -1;

    protected int turnIndex = AWAITING_FIRST_TURN;

    @Override
    public Forces getForces() {
        return forces;
    }

    @Override
    public Player getPlayer(int id) {
        return players.get(id);
    }

    @Override
    public void addPlayer(int id, Player player) {
        players.put(id, player);
    }

    @Override
    @Deprecated
    public Vector<Player> getPlayersVector() {
        return new Vector<>(players.values());
    }

    @Override
    @Deprecated
    public Enumeration<Player> getPlayers() {
        return players.elements();
    }

    @Override
    public List<Player> getPlayersList() {
        return new ArrayList<>(players.values());
    }

    @Override
    public int getNoOfPlayers() {
        return players.size();
    }

    @Override
    public List<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    @Override
    public int getNoOfTeams() {
        return teams.size();
    }

    @Override
    public List<InGameObject> getInGameObjects() {
        return new ArrayList<>(inGameObjects.values());
    }

    @Override
    public void addGameListener(GameListener listener) {
        // Since gameListeners is transient, it could be null
        if (gameListeners == null) {
            gameListeners = new Vector<>();
        }
        gameListeners.add(listener);
    }

    @Override
    public void removeGameListener(GameListener listener) {
        // Since gameListeners is transient, it could be null
        if (gameListeners == null) {
            gameListeners = new Vector<>();
        }
        gameListeners.remove(listener);
    }

    /**
     * @return All registered GameListeners.
     */
    public List<GameListener> getGameListeners() {
        // Since gameListeners is transient, it could be null
        if (gameListeners == null) {
            gameListeners = new Vector<>();
        }
        return Collections.unmodifiableList(gameListeners);
    }

    @Override
    public void fireGameEvent(GameEvent event) {
        // Since gameListeners is transient, it could be null
        if (gameListeners == null) {
            gameListeners = new Vector<>();
        }
        // The iteration must allow and support concurrent modification of the list!
        // Testing shows that a CopyOnWriteArrayList does not work
        for (Enumeration<GameListener> e = gameListeners.elements(); e.hasMoreElements(); ) {
            event.fireEvent(e.nextElement());
        }
    }

    @Override
    public void receiveBoard(int boardId, Board board) {
        Board oldBoard = getBoard(boardId);
        setBoard(boardId, board);
        fireGameEvent(new GameBoardNewEvent(this, oldBoard, board));
    }

    @Override
    public void receiveBoards(Map<Integer, Board> boards) {
        // cycle the entries so an event can be fired for each to allow listeners to register and unregister
        boards.forEach(this::receiveBoard);
        // some old boards might not have been replaced by new ones, so clear the map and refill
        gameBoards.clear();
        gameBoards.putAll(boards);
    }

    @Override
    public void setBoard(int boardId, Board board) {
        gameBoards.put(boardId, board);
    }

    @Override
    public Map<Integer, Board> getBoards() {
        return Collections.unmodifiableMap(gameBoards);
    }

    @Override
    public int getCurrentRound() {
        return currentRound;
    }

    @Override
    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    /**
     * Empties the list of pending EntityActions completely.
     * @see #getActionsVector()
     */
    public void clearActions() {
        pendingActions.clear();
    }

    /**
     * Removes all pending EntityActions by the InGameObject (Entity, unit) of the given ID from the list
     * of pending actions.
     */
    public void removeActionsFor(int id) {
        pendingActions.removeIf(action -> action.getEntityId() == id);
    }

    /**
     * Remove the given EntityAction from the list of pending actions.
     */
    public void removeAction(EntityAction action) {
        pendingActions.remove(action);
    }

    /**
     * Returns the pending EntityActions. Do not use to modify the actions; Arlith said: I will be
     * angry. &gt;:[
     */
    public List<EntityAction> getActionsVector() {
        return Collections.unmodifiableList(pendingActions);
    }

    /**
     * Adds the specified action to the list of pending EntityActions for this phase and fires a GameNewActionEvent.
     */
    public void addAction(EntityAction action) {
        pendingActions.add(action);
        fireGameEvent(new GameNewActionEvent(this, action));
    }

    /**
     * Clears and re-calculates the deployment table, i.e. assembles all units/objects in the game
     * that are undeployed (that includes returning units or reinforcements) together with the game
     * round that they are supposed to deploy on. This method can be called at any time in the game
     * and will assemble deployment according to the present game state.
     */
    public void setupDeployment() {
        deploymentTable.clear();
        for (Deployable unit : deployableInGameObjects()) {
            if (!unit.isDeployed()) {
                deploymentTable.computeIfAbsent(unit.getDeployRound(), k -> new ArrayList<>()).add(unit);
            }
        }
    }

    protected List<Deployable> deployableInGameObjects() {
        return inGameObjects.values().stream()
                .filter(unit -> unit instanceof Deployable)
                .map(unit -> (Deployable) unit)
                .collect(Collectors.toList());
    }

    public int lastDeploymentRound() {
        return deploymentTable.isEmpty() ? -1 : Collections.max(deploymentTable.keySet());
    }

    public boolean isDeploymentComplete() {
        return lastDeploymentRound() < currentRound;
    }

    /**
     * Check to see if we should deploy this round
     */
    public boolean shouldDeployThisRound() {
        return shouldDeployForRound(currentRound);
    }

    public boolean shouldDeployForRound(int round) {
        return deploymentTable.containsKey(round);
    }

    /**
     * Clear this round from this list of entities to deploy
     */
    public void clearDeploymentThisRound() {
        deploymentTable.remove(currentRound);
    }

    /**
     * Resets the turn index to {@link #AWAITING_FIRST_TURN}
     */
    public void resetTurnIndex() {
        turnIndex = AWAITING_FIRST_TURN;
    }

    @Override
    public int getTurnIndex() {
        return turnIndex;
    }

    @Override
    public int getNextEntityId() {
        return inGameObjects.isEmpty() ? 0 : Collections.max(inGameObjects.keySet()) + 1;
    }

    @Override
    public synchronized void setForces(Forces fs) {
        forces = fs;
        forces.setGame(this);
    }

    @Override
    public void incrementCurrentRound() {
        currentRound++;
    }
}