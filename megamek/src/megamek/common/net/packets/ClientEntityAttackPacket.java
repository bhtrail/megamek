package megamek.common.net.packets;

import megamek.common.actions.EntityAction;
import megamek.common.net.enums.PacketCommand;

import java.util.List;
import java.util.Vector;

public class ClientEntityAttackPacket extends AbstractPacket {
    public ClientEntityAttackPacket(Object... data)
    {
        super(PacketCommand.CLIENT_ENTITY_ATTACK, data);
    }

    public ClientEntityAttackPacket(int attackerId, Vector<EntityAction> actions)
    {
        super(PacketCommand.CLIENT_ENTITY_ATTACK, attackerId, actions);
    }
    
    public int getAttackerId()
    {
        return getIntValue(0);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<EntityAction> getActions()
    {
        return (Vector<EntityAction>) getObject(1);
    }
}
