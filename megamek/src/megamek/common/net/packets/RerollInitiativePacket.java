package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class RerollInitiativePacket extends AbstractPacket {
    public RerollInitiativePacket(Object... data) {
        super(PacketCommand.REROLL_INITIATIVE);
    }

    public RerollInitiativePacket() {
        super(PacketCommand.REROLL_INITIATIVE);
    }
}
