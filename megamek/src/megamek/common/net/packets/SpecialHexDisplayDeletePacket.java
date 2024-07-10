package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.SpecialHexDisplay;
import megamek.common.net.enums.PacketCommand;

public class SpecialHexDisplayDeletePacket extends AbstractPacket {
    public SpecialHexDisplayDeletePacket(Object... data) {
        super(PacketCommand.SPECIAL_HEX_DISPLAY_DELETE, data);
    }

    public SpecialHexDisplayDeletePacket(Coords coords, SpecialHexDisplay hexDisplay) {
        super(PacketCommand.SPECIAL_HEX_DISPLAY_DELETE, coords, hexDisplay);
    }

    public Coords getCoords() {
        return (Coords) getObject(0);
    }

    public SpecialHexDisplay getHexDisplay()  {
        return (SpecialHexDisplay) getObject(1);
    }
}
