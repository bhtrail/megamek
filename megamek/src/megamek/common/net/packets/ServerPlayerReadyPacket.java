package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ServerPlayerReadyPacket extends AbstractPacket {
    public ServerPlayerReadyPacket(int playerId, boolean done) {
        super(PacketCommand.SERVER_PLAYER_READY, playerId, done); 
    }
    
    public int getPlayerId()
    {
        return getIntValue(0);
    }
    
    public boolean isReady()
    {
        return getBooleanValue(1);
    }
}
