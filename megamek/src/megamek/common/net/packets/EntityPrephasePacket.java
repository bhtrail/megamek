package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityPrephasePacket extends AbstractPacket {
    public EntityPrephasePacket(Object... data) {
        super(PacketCommand.ENTITY_PREPHASE, data);
    }

    public EntityPrephasePacket(int entityId)
    {
        super(PacketCommand.ENTITY_PREPHASE, entityId);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
}
