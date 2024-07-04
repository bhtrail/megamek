package megamek.common.net.packets;

import megamek.common.MovePath;
import megamek.common.net.enums.PacketCommand;

public class CFRDominoEffectResponsePacket extends ClientFeedbackResponsePacket {
    public CFRDominoEffectResponsePacket(MovePath mp)
    {
        super(PacketCommand.CFR_DOMINO_EFFECT, mp);
    }

    public MovePath getPath() {
        return (MovePath) getObject(1);
    }
}
