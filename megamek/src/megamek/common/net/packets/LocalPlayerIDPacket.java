package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class LocalPlayerIDPacket extends AbstractPacket {
    
    public LocalPlayerIDPacket(int playerId)
    {
        super(PacketCommand.LOCAL_PN, playerId);
    }
    
    public int getPlayerId()
    {
        return (Integer)getObject(0);
    }
}
