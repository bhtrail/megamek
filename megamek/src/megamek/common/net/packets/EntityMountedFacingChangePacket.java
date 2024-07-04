package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityMountedFacingChangePacket extends AbstractPacket {
    public EntityMountedFacingChangePacket(int entityId, int equipId, int facingId) {
        super(PacketCommand.ENTITY_MOUNTED_FACING_CHANGE, entityId, equipId, facingId);
    }

    public int getEntityId() {
        return getIntValue(0);
    }

    public int getEquipId() {
        return getIntValue(1);
    }

    public int getFacingId() {
        return getIntValue(2);
    }
}
