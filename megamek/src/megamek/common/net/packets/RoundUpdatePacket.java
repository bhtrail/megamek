package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class RoundUpdatePacket extends AbstractPacket {
    public RoundUpdatePacket(int currentRound) {
        super(PacketCommand.ROUND_UPDATE, currentRound);
    }
    
    public int getCurrentRound() {
        return getIntValue(0);
    }
}
