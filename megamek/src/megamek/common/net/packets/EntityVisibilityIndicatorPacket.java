package megamek.common.net.packets;

import megamek.common.Player;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class EntityVisibilityIndicatorPacket extends AbstractPacket {
    public EntityVisibilityIndicatorPacket(Object... data) {
        super(PacketCommand.ENTITY_VISIBILITY_INDICATOR, data);
    }

    public EntityVisibilityIndicatorPacket(int entityId, boolean everSeen, boolean visibleToEnemy, boolean detectedByEnemy, Vector<Player> whoCanSee, Vector<Player> whoCanDetect) {
        super(PacketCommand.ENTITY_VISIBILITY_INDICATOR, entityId, everSeen, visibleToEnemy, detectedByEnemy, whoCanSee, whoCanDetect);
    }
    
    public int getEntityId() { 
        return getIntValue(0);
    }
    
    public boolean getEverSeenByEnemy() {
        return getBooleanValue(1);
    }
    
    public boolean getIsVisibleToEnemy() {
        return getBooleanValue(2);
    }
    
    public boolean getIsDetectedByEnemy() {
        return getBooleanValue(3);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<Player> getWhoCanSee() {
        return (Vector<Player>) getObject(4);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<Player> getWhoCanDetect() {
        return (Vector<Player>) getObject(5);
    }
}
