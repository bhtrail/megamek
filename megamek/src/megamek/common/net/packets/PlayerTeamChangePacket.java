package megamek.common.net.packets;

import megamek.common.Player;
import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class PlayerTeamChangePacket extends AbstractPacket {
    
    public PlayerTeamChangePacket(Collection<Player> players, int newTeamId) {
        super(PacketCommand.PLAYER_TEAM_CHANGE, players, newTeamId);
    }

    @SuppressWarnings("unchecked")
    public @Nullable Collection<Player> getPlayers() {
        return (Collection<Player>) getObject(0);
    }
    
    public int getNewTeamId() {
        return getIntValue(1);
    }
}
