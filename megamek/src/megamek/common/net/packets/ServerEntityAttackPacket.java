package megamek.common.net.packets;

import megamek.common.actions.EntityAction;
import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class ServerEntityAttackPacket extends AbstractPacket {
    public ServerEntityAttackPacket(Object... data) {
        super(PacketCommand.SERVER_ENTITY_ATTACK, data);
    }

    public ServerEntityAttackPacket(List<? extends EntityAction> actions, boolean isChargeAttack) {
        super(PacketCommand.SERVER_ENTITY_ATTACK, actions, isChargeAttack);
    }
    
    @SuppressWarnings("unchecked")
    public List<? extends EntityAction> getActions()
    {
        return (List<? extends EntityAction>) getObject(0);
    }
    
    public boolean isChargeAttack()
    {
        return getBooleanValue(1);
    }
}
