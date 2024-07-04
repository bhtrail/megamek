package megamek.common.net.packets;

import megamek.common.Flare;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingFlaresPacket extends AbstractPacket {
    public SendingFlaresPacket(Vector<Flare> flares) {
        super(PacketCommand.SENDING_FLARES, flares);
    }

    @SuppressWarnings("unchecked")
    public Vector<Flare> getFlares() {
        return (Vector<Flare>) getObject(0);
    }
}
