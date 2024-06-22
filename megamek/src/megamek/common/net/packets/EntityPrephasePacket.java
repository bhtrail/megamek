package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityPrephasePacket extends AbstractPacket {
    public EntityPrephasePacket(int entityId)
    {
        super(PacketCommand.ENTITY_PREPHASE, entityId);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
}
