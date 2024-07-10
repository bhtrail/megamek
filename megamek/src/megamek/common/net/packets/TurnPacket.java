package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class TurnPacket extends AbstractPacket {
    public TurnPacket(Object... data) {
        super(PacketCommand.TURN, data);
    }
    
    public TurnPacket(int turnIndex, int prevPlayerId) {
        super(PacketCommand.TURN, turnIndex, prevPlayerId);
    }
    
    public int getTurnIndex() {
        return getIntValue(0);
    }
    
    public int getPrevPlayerId() {
        return getIntValue(1);
    }
}
