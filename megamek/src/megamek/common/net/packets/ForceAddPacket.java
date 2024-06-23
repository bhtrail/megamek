package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.force.Force;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class ForceAddPacket extends AbstractPacket {
    public ForceAddPacket(Force force, Collection<Entity> entities)
    {
        super(PacketCommand.FORCE_ADD, force, entities);
    }
    
    public Force getForce()
    {
        return (Force) getObject(0);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Entity> getEntities()
    {
        return (Collection<Entity>) getObject(1);
    }
}
