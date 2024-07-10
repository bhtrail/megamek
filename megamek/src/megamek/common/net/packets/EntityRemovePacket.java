package megamek.common.net.packets;

import megamek.common.force.Force;
import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class EntityRemovePacket extends AbstractPacket {
    public EntityRemovePacket(Object... data) {
        super(PacketCommand.ENTITY_REMOVE, data);
    }
    
    public EntityRemovePacket(List<Integer> entityIds, int condition, List<Force> forces)
    {
        super(PacketCommand.ENTITY_REMOVE, entityIds, condition, forces);
    }
    
    public EntityRemovePacket(List<Integer> entityIds)
    {
        super(PacketCommand.ENTITY_REMOVE, entityIds);
    }
    
    @SuppressWarnings("unchecked")
    public List<Integer> getEntityIds()
    {
        return (List<Integer>) getObject(0);
    }
    
    public int getCondition()
    {
        return getIntValue(1);
    }
    
    @SuppressWarnings("unchecked")
    public List<Force> getForces()
    {
        return (List<Force>) getObject(2);
    }
}
