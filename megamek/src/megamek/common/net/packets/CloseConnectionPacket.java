package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class CloseConnectionPacket extends AbstractPacket {
    public CloseConnectionPacket(Object... data) {
        super(PacketCommand.CLOSE_CONNECTION);
    }

    public CloseConnectionPacket() {
        super(PacketCommand.CLOSE_CONNECTION);
    }
}
