package megamek.common.net.packets;

import megamek.common.Minefield;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class UpdateMinefieldsPacket extends AbstractPacket {
    public UpdateMinefieldsPacket(Object... data) {
        super(PacketCommand.UPDATE_MINEFIELDS, data);
    }

    public UpdateMinefieldsPacket(Vector<Minefield> minefields) {
        super(PacketCommand.UPDATE_MINEFIELDS, minefields);
    }

    @SuppressWarnings("unchecked")
    public Vector<Minefield> getMinefields() {
        return (Vector<Minefield>) getObject(0);
    }
}
