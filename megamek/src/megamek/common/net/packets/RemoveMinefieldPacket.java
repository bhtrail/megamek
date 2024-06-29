package megamek.common.net.packets;

import megamek.common.Minefield;
import megamek.common.net.enums.PacketCommand;

public class RemoveMinefieldPacket extends AbstractPacket {
    public RemoveMinefieldPacket(Minefield minefield) {
        super(PacketCommand.REMOVE_MINEFIELD, minefield);
    }

    public Minefield getMinefield() {
        return (Minefield) getObject(0);
    }
}
