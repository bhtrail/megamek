package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.force.Force;
import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class EntityAddPacket extends AbstractPacket {
    public EntityAddPacket(Object... data) {
        super(PacketCommand.ENTITY_ADD, data);
    }

    public EntityAddPacket(List<Entity> entities) {
        super(PacketCommand.ENTITY_ADD, entities);
    }
    
    public EntityAddPacket(List<Entity> entities, List<Force> forces) {
        super(PacketCommand.ENTITY_ADD, entities, forces);
    }
    
    @SuppressWarnings("unchecked")
    public List<Entity> getEntities()
    {
        return (List<Entity>) getObject(0);
    }
    
    @SuppressWarnings("unchecked")
    public List<Force> getForces()
    {
        return (List<Force>) getObject(1);
    }
}
