package megamek.common.net.packets;

import megamek.common.enums.WeaponSortOrder;
import megamek.common.net.enums.PacketCommand;

import java.util.Map;

public class EntityWOrderPacket extends AbstractPacket {
    public EntityWOrderPacket(int entityId, WeaponSortOrder weaponSortOrder, Map<Integer, Integer> customSortOrder)
    {
        super(PacketCommand.ENTITY_WORDER_UPDATE, entityId, weaponSortOrder, customSortOrder);
    }
    
    public EntityWOrderPacket(int entityId, WeaponSortOrder weaponSortOrder)
    {
        super(PacketCommand.ENTITY_WORDER_UPDATE, entityId, weaponSortOrder);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
    
    public WeaponSortOrder getWeaponSortOrder()
    {
        return (WeaponSortOrder) getObject(1);
    }
    
    @SuppressWarnings("unchecked")
    public Map<Integer, Integer> getCustomSortOrder()
    {
        if (getData().length > 2)
            return (Map<Integer, Integer>) getObject(2);
        
        return null;
    }
}
