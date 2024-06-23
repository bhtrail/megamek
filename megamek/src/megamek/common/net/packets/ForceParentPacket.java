package megamek.common.net.packets;

import megamek.common.force.Force;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class ForceParentPacket extends AbstractPacket {
    public ForceParentPacket(Collection<Force> forces, int newParentId) {
        super(PacketCommand.FORCE_PARENT, forces, newParentId);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Force> getForces()
    {
        return (Collection<Force>) getObject(0);
    }
    
    public int getNewParentId() {
        return getIntValue(1);
    }
}
