package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class CFRTeleguidedTargetResponsePacket extends ClientFeedbackResponsePacket {
    public CFRTeleguidedTargetResponsePacket(int targetIndex) {
        super(PacketCommand.CFR_TELEGUIDED_TARGET, targetIndex);
    }

    public int getTargetIndex() {
        return getIntValue(1);
    }
}
