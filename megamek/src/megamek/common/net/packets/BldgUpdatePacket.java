package megamek.common.net.packets;

import megamek.common.Building;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class BldgUpdatePacket extends AbstractPacket {
    public BldgUpdatePacket(Vector<Building> buildings)
    {
        super(PacketCommand.BLDG_UPDATE, buildings);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<Building> getBuildings()
    {
        return (Vector<Building>) getObject(0);
    }
}
