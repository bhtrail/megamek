package megamek.common.net.packets;

import megamek.common.Entity;
import megamek.common.force.Forces;
import megamek.common.net.enums.PacketCommand;

import java.util.List;
import java.util.Vector;

public class SendingEntitiesPacket extends AbstractPacket {
    public SendingEntitiesPacket(Object... data) {
        super(PacketCommand.SENDING_ENTITIES, data);
    }

    public SendingEntitiesPacket(List<Entity> entities) {
        super(PacketCommand.SENDING_ENTITIES, entities);
    }
    
    public SendingEntitiesPacket(List<Entity> entities, Vector<Entity> outOfGameEntities) {
        super(PacketCommand.SENDING_ENTITIES, entities, outOfGameEntities);
    }

    public SendingEntitiesPacket(List<Entity> entities, Vector<Entity> outOfGameEntities, Forces forces) {
        super(PacketCommand.SENDING_ENTITIES, entities, outOfGameEntities, forces);
    }

    @SuppressWarnings("unchecked")
    public List<Entity> getEntities() {
        return (List<Entity>) getObject(0);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<Entity> getOutOfGameEntities() {
        return (Vector<Entity>) getObject(1);
    }
    
    public Forces getForces() {
        return (Forces) getObject(2);
    }
}
