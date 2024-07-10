package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ServerVersionCheckPacket extends AbstractPacket {
    public ServerVersionCheckPacket(Object... data) {
        super(PacketCommand.SERVER_VERSION_CHECK);
    }

    public ServerVersionCheckPacket() {
        super(PacketCommand.SERVER_VERSION_CHECK);
    }
}
