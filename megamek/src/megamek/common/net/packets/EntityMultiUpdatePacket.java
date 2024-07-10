package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class EntityMultiUpdatePacket extends AbstractPacket {
    public EntityMultiUpdatePacket(Object... data) {
        super(PacketCommand.ENTITY_MULTIUPDATE, data);
    }

    public EntityMultiUpdatePacket(Collection<Entity> entities)
    {
        super(PacketCommand.ENTITY_MULTIUPDATE, entities);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Entity> getEntities()
    {
        return (Collection<Entity>) getObject(0);
    }
}
