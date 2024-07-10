package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ServerGreetingPacket extends AbstractPacket {
    public ServerGreetingPacket(Object... data) {
        super(PacketCommand.SERVER_GREETING);
    }
    
    public ServerGreetingPacket()
    {
        super(PacketCommand.SERVER_GREETING);
    }
}
