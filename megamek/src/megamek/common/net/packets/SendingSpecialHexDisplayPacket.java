package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.SpecialHexDisplay;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;
import java.util.Hashtable;

public class SendingSpecialHexDisplayPacket extends AbstractPacket {
    public SendingSpecialHexDisplayPacket(Hashtable<Coords, Collection<SpecialHexDisplay>> specialHexesDisplay) {
        super(PacketCommand.SENDING_SPECIAL_HEX_DISPLAY, specialHexesDisplay);
    }

    @SuppressWarnings("unchecked")
    public Hashtable<Coords, Collection<SpecialHexDisplay>> getSpecialHexesDisplay() {
        return (Hashtable<Coords, Collection<SpecialHexDisplay>>) getObject(0);
    }
}
