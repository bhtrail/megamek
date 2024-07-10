package megamek.common.net.packets;

import megamek.common.enums.GamePhase;
import megamek.common.net.enums.PacketCommand;

public class EntityActivateHiddenPacket extends AbstractPacket {
    public EntityActivateHiddenPacket(Object... data) {
        super(PacketCommand.ENTITY_ACTIVATE_HIDDEN, data);
    }

    public EntityActivateHiddenPacket(int entityId, GamePhase gamePhase) {
        super(PacketCommand.ENTITY_ACTIVATE_HIDDEN, entityId, gamePhase);
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
    
    public GamePhase getGamePhase()
    {
        return (GamePhase) getObject(1);
    }
}
