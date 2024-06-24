package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class BldgCollapsePacket extends AbstractPacket {
    public BldgCollapsePacket(Vector<Coords> coords) {
        super(PacketCommand.BLDG_COLLAPSE, coords);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<Coords> getCoords()
    {
        return (Vector<Coords>) getObject(0);
    }
}
