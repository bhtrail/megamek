package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class CFRTeleguidedTargetPacket extends ClientFeedbackRequestPacket {
    public CFRTeleguidedTargetPacket(Object... data) {
        super(data);
    }

    public CFRTeleguidedTargetPacket(List<Integer> targetIds, List<Integer> toHitValues) {
        super(PacketCommand.CFR_TELEGUIDED_TARGET, targetIds, toHitValues);
    }

    @SuppressWarnings("unchecked")
    public List<Integer> getTargetIds()
    {
        return (List<Integer>)getObject(1);
    }

    @SuppressWarnings("unchecked")
    public List<Integer> getToHitValues() {
        return (List<Integer>) getObject(2);
    }
}
