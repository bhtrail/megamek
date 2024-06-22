package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntitySystemModeChangePacket extends AbstractPacket {
    public EntitySystemModeChangePacket(int nEntity, int nSystem, int nMode)
    {
        super(PacketCommand.ENTITY_SYSTEMMODECHANGE, nEntity, nSystem, nMode);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
    
    public int getSystemId()
    {
        return getIntValue(1);
    }
    
    public int getMode()
    {
        return getIntValue(2);
    }
}
