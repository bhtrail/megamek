package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ServerVersionCheckPacket extends AbstractPacket {

    /**
     * Generates Server Version Check Packet
     */
    public ServerVersionCheckPacket() {
        super(PacketCommand.SERVER_VERSION_CHECK);
    }
    
}
