package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class CFRAPDSAssignResponsePacket extends ClientFeedbackResponsePacket {
    public CFRAPDSAssignResponsePacket(Integer waaIndex)
    {
        super(PacketCommand.CFR_APDS_ASSIGN, waaIndex);
    }

    public Integer getWAAIndex() {
        return (Integer) getObject(1);
    }
}
