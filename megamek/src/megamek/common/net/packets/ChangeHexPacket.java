package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.Hex;
import megamek.common.net.enums.PacketCommand;

public class ChangeHexPacket extends AbstractPacket {
    public ChangeHexPacket(Object... data) {
        super(PacketCommand.CHANGE_HEX, data);
    }

    public ChangeHexPacket(Coords coords, Hex hex) {
        super(PacketCommand.CHANGE_HEX, coords, hex);
    }
    
    public Coords getCoords() {
        return (Coords) getObject(0);
    }
    
    public Hex getHex() {
        return (Hex) getObject(1);
    }
}
