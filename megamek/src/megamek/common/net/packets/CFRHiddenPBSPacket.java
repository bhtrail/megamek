package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class CFRHiddenPBSPacket extends ClientFeedbackRequestPacket {
    public CFRHiddenPBSPacket(Object... data) {
        super(data);
    }

    public CFRHiddenPBSPacket(int hiddenId, int targetId) {
        super(PacketCommand.CFR_HIDDEN_PBS, hiddenId, targetId);
    }

    public int getHiddenId() {
        return getIntValue(1);
    }

    public int getTargetId() {
        return getIntValue(2);
    }
}
