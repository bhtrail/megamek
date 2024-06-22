package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.net.enums.PacketCommand;

public class EntityGTAHexSelectPacket extends AbstractPacket {
    public EntityGTAHexSelectPacket(int targetId, int attackerId, Coords pos)
    {
        super(PacketCommand.ENTITY_GTA_HEX_SELECT, targetId, attackerId, pos);
    }
    
    public int getTargetId()
    {
        return getIntValue(0);
    }
    
    public int getAttackerId()
    {
        return getIntValue(1);
    }
    
    public Coords getCoords()
    {
        return (Coords) getObject(2);
    }    
}
