package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class CFRTagTargetPacket extends ClientFeedbackRequestPacket {
    public CFRTagTargetPacket(List<Integer> targetIds, List<Integer> targetTypes)
    {
        super(PacketCommand.CFR_TAG_TARGET, targetIds, targetTypes);
    }

    @SuppressWarnings("unchecked")
    public List<Integer> getTargetIds()
    {
        return (List<Integer>) getObject(1);
    }

    @SuppressWarnings("unchecked")
    public List<Integer> getTargetTypes()
    {
        return (List<Integer>) getObject(2);
    }
}
