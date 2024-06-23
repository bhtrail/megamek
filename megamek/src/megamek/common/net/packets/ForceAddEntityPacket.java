package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class ForceAddEntityPacket extends AbstractPacket {
    public ForceAddEntityPacket(Collection<Entity> entities, int forceId) {
        super(PacketCommand.FORCE_ADD_ENTITY, entities, forceId);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Entity> getEntities()
    {
        return (Collection<Entity>) getObject(0);
    }
    
    public int getForceId()
    {
        return getIntValue(1);
    }
}
