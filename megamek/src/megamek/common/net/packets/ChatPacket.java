package megamek.common.net.packets;

import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

public class ChatPacket extends AbstractPacket {
    
    public ChatPacket(String message)
    {
        super(PacketCommand.CHAT, message);
    }
    
    public ChatPacket(String message, int connID)
    {
        super(PacketCommand.CHAT, message, connID);
    }
    
    public @Nullable String getMessage()
    {
        return (String)getObject(0);
    }
    
    public int getConnID()
    {
        return getIntValue(1);
    }
}
