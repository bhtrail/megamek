package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityCalledShotChangePacket extends AbstractPacket {
    public EntityCalledShotChangePacket(Object... data) {
        super(PacketCommand.ENTITY_CALLEDSHOTCHANGE, data);
    }

    public EntityCalledShotChangePacket(int entityID, int equipmentID) {
        super(PacketCommand.ENTITY_CALLEDSHOTCHANGE, entityID, equipmentID);
    }

    public int getEntityID() {
        return (Integer) getObject(0);
    }

    public int getEquipmentID()  {
        return (Integer) getObject(1);
    }
}
