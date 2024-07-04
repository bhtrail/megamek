package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ResetTagInfoPacket extends AbstractPacket {
    public ResetTagInfoPacket() {
        super(PacketCommand.RESET_TAG_INFO);
    }
}
