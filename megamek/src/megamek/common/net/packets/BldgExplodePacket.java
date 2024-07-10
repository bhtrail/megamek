package megamek.common.net.packets;

import megamek.common.Building;
import megamek.common.net.enums.PacketCommand;

public class BldgExplodePacket extends AbstractPacket {
    public BldgExplodePacket(Object... data) {
        super(PacketCommand.BLDG_EXPLODE, data);
    }

    public BldgExplodePacket(Building.DemolitionCharge charge) {
        super(PacketCommand.BLDG_EXPLODE, charge);
    }
    
    public Building.DemolitionCharge getCharge() {
        return (Building.DemolitionCharge) getObject(0);
    }
}
