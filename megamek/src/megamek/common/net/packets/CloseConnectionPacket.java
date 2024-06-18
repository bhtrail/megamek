package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class CloseConnectionPacket extends AbstractPacket {
    /**
     * Creates a <code>Packet</code> with a command
     *
     */
    public CloseConnectionPacket() {
        super(PacketCommand.CLOSE_CONNECTION);
    }
}
