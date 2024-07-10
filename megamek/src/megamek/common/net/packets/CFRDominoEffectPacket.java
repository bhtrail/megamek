package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class CFRDominoEffectPacket extends ClientFeedbackRequestPacket {
    public CFRDominoEffectPacket(Object... data) {
        super(data);
    }

    public CFRDominoEffectPacket(int entityId) {
        super(PacketCommand.CFR_DOMINO_EFFECT, entityId);
    }

    public int getEntityId() {
        return getIntValue(1);
    }
}
