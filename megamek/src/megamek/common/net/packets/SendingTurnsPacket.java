package megamek.common.net.packets;

import megamek.common.PlayerTurn;
import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class SendingTurnsPacket extends AbstractPacket {
    public SendingTurnsPacket(List<? extends PlayerTurn> playerTurns) {
        super(PacketCommand.SENDING_TURNS, playerTurns);
    }
    
    @SuppressWarnings("unchecked")
    public List<? extends PlayerTurn> getPlayerTurns() {
        return (List<? extends  PlayerTurn>) getObject(0);
    }
}
