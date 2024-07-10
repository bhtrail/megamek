package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class GameVictoryEventPacket extends AbstractPacket {
    public GameVictoryEventPacket(Object... data) {
        super(PacketCommand.GAME_VICTORY_EVENT, data);
    }

    public GameVictoryEventPacket() {
        super(PacketCommand.GAME_VICTORY_EVENT);
    }
}
