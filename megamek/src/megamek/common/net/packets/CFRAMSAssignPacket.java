package megamek.common.net.packets;

import megamek.common.actions.WeaponAttackAction;
import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class CFRAMSAssignPacket extends ClientFeedbackRequestPacket {
    public CFRAMSAssignPacket(int entityID, int equipNum, List<WeaponAttackAction> actions) {
        super(PacketCommand.CFR_AMS_ASSIGN, entityID, equipNum, actions);
    }

    public int getEntityId() {
        return getIntValue(1);
    }

    public int getEquipNum() {
        return getIntValue(2);
    }

    @SuppressWarnings("unchecked")
    public List<WeaponAttackAction> getActions() {
        return (List<WeaponAttackAction>) getObject(3);
    }
}
