package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityModeChangePacket extends AbstractPacket {
    public EntityModeChangePacket(int nEntity, int nEquip, int nMode)
    {
        super(PacketCommand.ENTITY_MODECHANGE, nEntity, nEquip, nMode);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
    
    public int getEquipId()
    {
        return getIntValue(1);
    }
    
    public int getModeId()
    {
        return getIntValue(2);
    }
}
