package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class CFRTagTargetResponsePacket extends ClientFeedbackResponsePacket {
    public CFRTagTargetResponsePacket(Object... data){
        super(data);
    }

    public CFRTagTargetResponsePacket(int targetIndex) {
        super(PacketCommand.CFR_TAG_TARGET, targetIndex);
    }

    public int getTargetIndex() {
        return getIntValue(1);
    }
}
