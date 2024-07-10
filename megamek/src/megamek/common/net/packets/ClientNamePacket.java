package megamek.common.net.packets;

import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

public class ClientNamePacket extends AbstractPacket {
    public ClientNamePacket(Object... data) {
        super(PacketCommand.CLIENT_NAME, data);
    }
    
    public ClientNamePacket(String name, boolean isBot) {
        super(PacketCommand.CLIENT_NAME, name, isBot);
    }
    
    public @Nullable String getClientName() {
        return (String) getObject(0);
    }
    
    public boolean isBot()
    {
        return (boolean) getObject(1);
    }
}
