package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.net.enums.PacketCommand;

public class ClientEntityUpdatePacket extends AbstractPacket {
    public ClientEntityUpdatePacket(Object... data) {
        super(PacketCommand.CLIENT_ENTITY_UPDATE, data);
    }

    public ClientEntityUpdatePacket(Entity entity)
    {
        super(PacketCommand.CLIENT_ENTITY_UPDATE, entity);
    }
    
    public Entity getEntity()
    {
        return (Entity) getObject(0);
    }
}
