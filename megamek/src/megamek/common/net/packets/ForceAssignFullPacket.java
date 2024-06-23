package megamek.common.net.packets;

import megamek.common.force.Force;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class ForceAssignFullPacket extends AbstractPacket {
    public ForceAssignFullPacket(Collection<Force> forceList, int newOwnerId)
    {
        super(PacketCommand.FORCE_ASSIGN_FULL, forceList, newOwnerId);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Force> getForces()
    {
        return (Collection<Force>) getObject(0);
    }
    
    public int getOwnerId()
    {
        return getIntValue(1);
    }
}
