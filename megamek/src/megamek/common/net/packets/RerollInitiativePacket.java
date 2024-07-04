package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class RerollInitiativePacket extends AbstractPacket {
    public RerollInitiativePacket() {
        super(PacketCommand.REROLL_INITIATIVE);
    }
}
