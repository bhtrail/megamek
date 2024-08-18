package megamek.common.net.packets;

import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class PlayerTeamChangePacket extends AbstractPacket {
    public PlayerTeamChangePacket(Object... data) {
        super(PacketCommand.PLAYER_TEAM_CHANGE, data);
    }

    public PlayerTeamChangePacket(Collection<Integer> playerIds, int newTeamId) {
        super(PacketCommand.PLAYER_TEAM_CHANGE, playerIds, newTeamId);
    }

    @SuppressWarnings("unchecked")
    public @Nullable Collection<Integer> getPlayers() {
        return (Collection<Integer>) getObject(0);
    }
    
    public int getNewTeamId() {
        return getIntValue(1);
    }
}
