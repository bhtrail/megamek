package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class ForceDeletePacket extends AbstractPacket {
    public ForceDeletePacket(Object... data) {
        super(PacketCommand.FORCE_DELETE, data);
    }

    public ForceDeletePacket(Collection<Integer> forceIds) {
        super(PacketCommand.FORCE_DELETE, forceIds);
    }
    
    @SuppressWarnings("unchecked")
    public Collection<Integer> getForceIds()
    {
        return (Collection<Integer>) getObject(0);
    }
}
