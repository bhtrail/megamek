package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityAmmoChangePacket extends AbstractPacket {
    public EntityAmmoChangePacket(int nEntity, int nWeapon, int nAmmo, int reason)
    {
        super(PacketCommand.ENTITY_AMMOCHANGE, nEntity, nWeapon, nAmmo, reason);
    }

    public int getEntityId() {
        return getIntValue(0);
    }
    
    public int getWeaponId() {
        return getIntValue(1);
    }
    
    public int getAmmoId() {
        return getIntValue(2);
    }
    
    public int getReason() {
        return getIntValue(3);
    }
}
