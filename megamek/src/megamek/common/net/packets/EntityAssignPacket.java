package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class EntityAssignPacket extends AbstractPacket {
    public EntityAssignPacket(Object... data) {
        super(PacketCommand.ENTITY_ASSIGN, data);
    }

    public EntityAssignPacket(Collection<Entity> entities, int newOwnerId)
    {
        super(PacketCommand.ENTITY_ASSIGN, entities, newOwnerId);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Entity> getEntities()
    {
        return (Collection<Entity>) getObject(0);
    }
    
    public int getOwnerId()
    {
        return getIntValue(1);
    }
}
