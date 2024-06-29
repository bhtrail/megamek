package megamek.common.net.packets;

import megamek.common.Minefield;
import megamek.common.net.enums.PacketCommand;

public class RevealMinefieldPacket extends AbstractPacket {
    public RevealMinefieldPacket(Minefield minefield) {
        super(PacketCommand.REVEAL_MINEFIELD, minefield);
    }

    public Minefield getMinefield() {
        return (Minefield) getObject(0);
    }
}
