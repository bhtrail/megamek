package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.SpecialHexDisplay;
import megamek.common.net.enums.PacketCommand;

public class SpecialHexDisplayAppendPacket extends AbstractPacket {
    public SpecialHexDisplayAppendPacket(Object... data) {
        super(PacketCommand.SPECIAL_HEX_DISPLAY_APPEND, data);
    }

    public SpecialHexDisplayAppendPacket(Coords coords, SpecialHexDisplay hex) {
        super(PacketCommand.SPECIAL_HEX_DISPLAY_APPEND, coords, hex);
    }

    public Coords getCoords() {
        return (Coords)getObject(0);
    }

    public SpecialHexDisplay getHex()  {
        return (SpecialHexDisplay)getObject(1);
    }
}
