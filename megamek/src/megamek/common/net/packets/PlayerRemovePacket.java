package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class PlayerRemovePacket extends AbstractPacket {
    public PlayerRemovePacket(Object... data) {
        super(PacketCommand.PLAYER_REMOVE, data);
    }

    public PlayerRemovePacket(int playerId)
    {
        super(PacketCommand.PLAYER_REMOVE, playerId);
    }
    
    public int getPlayerID()
    {
        return getIntValue(0);
    }
}
