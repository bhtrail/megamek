package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.Hex;
import megamek.common.net.enums.PacketCommand;

import java.util.Set;

public class ChangeHexesPacket extends AbstractPacket {
    public ChangeHexesPacket(Object... data) {
        super(PacketCommand.CHANGE_HEXES, data);
    }

    public ChangeHexesPacket(Set<Coords> coords, Set<Hex> hexes) {
        super(PacketCommand.CHANGE_HEXES, coords, hexes);
    }
    
    @SuppressWarnings("unchecked")
    public Set<Coords> getCoords() {
        return (Set<Coords>) getObject(0);
    }
    
    @SuppressWarnings("unchecked")
    public Set<Hex> getHexes() {
        return (Set<Hex>) getObject(1);
    }
}
