package megamek.common.net.packets;

import megamek.common.actions.WeaponAttackAction;
import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class CFRAPDSAssignPacket extends ClientFeedbackRequestPacket {
    public CFRAPDSAssignPacket(int entityId, List<Integer> apdsData, List<WeaponAttackAction> actions) {
        super(PacketCommand.CFR_APDS_ASSIGN, entityId, apdsData, actions);
    }

    public int getEntityId()
    {
        return getIntValue(1);
    }

    @SuppressWarnings("unchecked")
    public List<Integer> getAPDSData()
    {
        return (List<Integer>)getObject(2);
    }

    @SuppressWarnings("unchecked")
    public List<WeaponAttackAction> getActions()
    {
        return (List<WeaponAttackAction>) getObject(3);
    }
}
