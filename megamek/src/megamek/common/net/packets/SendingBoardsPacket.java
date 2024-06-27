package megamek.common.net.packets;

import megamek.common.Board;
import megamek.common.net.enums.PacketCommand;

import java.util.HashMap;

public class SendingBoardsPacket extends AbstractPacket {
    public SendingBoardsPacket(HashMap<Integer, Board> boards)
    {
        super(PacketCommand.SENDING_BOARD, boards);
    }
    
    @SuppressWarnings("unchecked")
    public HashMap<Integer, Board> getBoards() {
        return (HashMap<Integer, Board>) getObject(0);
    }
}
