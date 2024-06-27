package megamek.common.net.packets;

import megamek.common.enums.GamePhase;
import megamek.common.net.enums.PacketCommand;

public class PhaseChangePacket extends AbstractPacket {
    public PhaseChangePacket(GamePhase phase) {
        super(PacketCommand.PHASE_CHANGE, phase);
    }
    
    public GamePhase getPhase() {
        return (GamePhase) getObject(0);
    }
}
