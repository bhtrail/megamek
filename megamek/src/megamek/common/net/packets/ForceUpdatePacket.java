package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.force.Force;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class ForceUpdatePacket extends AbstractPacket {
    public ForceUpdatePacket(Object... data) {
        super(PacketCommand.FORCE_UPDATE, data);
    }

    public ForceUpdatePacket(Collection<Force> changedForces, Collection<Entity> entities) {
        super(PacketCommand.FORCE_UPDATE, changedForces, entities);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Force> getChangedForces()
    {
        return (Collection<Force>) getObject(0);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Entity> getEntities()
    {
        return (Collection<Entity>) getObject(1);
    }
}
