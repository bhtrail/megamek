package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntitySensorChangePacket extends AbstractPacket {
    public EntitySensorChangePacket(Object... data) {
        super(PacketCommand.ENTITY_SENSORCHANGE, data);
    }

    public EntitySensorChangePacket(int entityId, int sensorId)
    {
        super(PacketCommand.ENTITY_SENSORCHANGE, entityId, sensorId);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
    
    public int getSensorId()
    {
        return getIntValue(1);
    }
}
