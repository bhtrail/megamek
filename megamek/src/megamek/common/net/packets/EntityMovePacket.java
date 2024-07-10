package megamek.common.net.packets;

import megamek.common.MovePath;
import megamek.common.net.enums.PacketCommand;

public class EntityMovePacket extends AbstractPacket {
    public EntityMovePacket(Object... data) {
        super(PacketCommand.ENTITY_MOVE, data);
    }

    public EntityMovePacket(int id, MovePath movePath) {
        super(PacketCommand.ENTITY_MOVE, id, movePath);
    }
    
    public int getEntityId() {
        return getIntValue(0);
    }
    
    public MovePath getMovePath() {
        return (MovePath) getObject(1);
    }
}
