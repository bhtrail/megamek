package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntitySinksChangePacket extends AbstractPacket {
    public EntitySinksChangePacket(Object... data) {
        super(PacketCommand.ENTITY_SINKSCHANGE, data);
    }

    public EntitySinksChangePacket(int entityId, int activeSinks)
    {
        super(PacketCommand.ENTITY_SINKSCHANGE, entityId, activeSinks);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
    
    public  int getActiveSinks()
    {
        return getIntValue(1);
    }
}
