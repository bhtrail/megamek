package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class CFRAMSAssignResponsePacket extends ClientFeedbackResponsePacket {
    public CFRAMSAssignResponsePacket(Integer waaIndex)
    {
        super(PacketCommand.CFR_AMS_ASSIGN, waaIndex);
    }

    public Integer getWAAIndex() {
        return (Integer) getObject(1);
    }
}
