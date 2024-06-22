package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.UnitLocation;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class ServerEntityUpdatePacket extends AbstractPacket {
    public ServerEntityUpdatePacket(int entityId, Entity entity, Vector<UnitLocation> movePath)
    {
        super(PacketCommand.SERVER_ENTITY_UPDATE, entityId, entity, movePath);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
    
    public Entity getEntity()
    {
        return (Entity) getObject(1);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<UnitLocation> getMovePath()
    {
        return (Vector<UnitLocation>) getObject(2);
    }
}
