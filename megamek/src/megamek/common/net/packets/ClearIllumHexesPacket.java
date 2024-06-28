package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ClearIllumHexesPacket extends AbstractPacket {
    public ClearIllumHexesPacket() {
        super(PacketCommand.CLEAR_ILLUM_HEXES);
    }
}
