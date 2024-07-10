package megamek.common.net.packets;

import megamek.common.Game;
import megamek.common.net.enums.PacketCommand;

public class LoadGamePacket extends AbstractPacket {
    public LoadGamePacket(Object... data) {
        super(PacketCommand.LOAD_GAME, data);
    }

    public LoadGamePacket(Game game) {
        super(PacketCommand.LOAD_GAME, game);
    }

    public Game getGame() {
        return (Game) getObject(0);
    }
}
