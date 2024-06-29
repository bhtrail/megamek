package megamek.common.net.packets;

import megamek.common.Minefield;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingMinefieldsPacket extends AbstractPacket {
    public SendingMinefieldsPacket(Vector<Minefield> minefields) {
        super(PacketCommand.SENDING_MINEFIELDS, minefields);
    }

    @SuppressWarnings("unchecked")
    public Vector<Minefield> getMinefields() {
        return (Vector<Minefield>) getObject(0);
    }
}
