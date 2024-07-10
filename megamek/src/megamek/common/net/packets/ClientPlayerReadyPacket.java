package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ClientPlayerReadyPacket extends AbstractPacket {
    public ClientPlayerReadyPacket(Object... data)
    {
        super(PacketCommand.CLIENT_PLAYER_READY, data);
    }
    
    public ClientPlayerReadyPacket(boolean done)
    {
        super(PacketCommand.CLIENT_PLAYER_READY, done);
    }
    
    public boolean isReady()
    {
        return getBooleanValue(0);
    }
}
