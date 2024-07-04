package megamek.common.net.packets;

import megamek.common.actions.EntityAction;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class CFRHiddenPBSResponsePacket extends ClientFeedbackResponsePacket {
    public CFRHiddenPBSResponsePacket(Vector<EntityAction> attacks) {
        super(PacketCommand.CFR_HIDDEN_PBS, attacks);
    }

    @SuppressWarnings("unchecked")
    public Vector<EntityAction> getActions()
    {
        return (Vector<EntityAction>) getObject(1);
    }
}
