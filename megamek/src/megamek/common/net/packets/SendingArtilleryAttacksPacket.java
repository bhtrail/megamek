package megamek.common.net.packets;

import megamek.common.actions.ArtilleryAttackAction;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingArtilleryAttacksPacket extends AbstractPacket {
    public SendingArtilleryAttacksPacket(Vector<ArtilleryAttackAction> actions) {
        super(PacketCommand.SENDING_ARTILLERY_ATTACKS, actions);
    }

    @SuppressWarnings("unchecked")
    public Vector<ArtilleryAttackAction> getActions() {
        return (Vector<ArtilleryAttackAction>) getObject(0);
    }
}
