package megamek.common.net.packets;

import megamek.common.Player;
import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

public class PlayerUpdatePacket extends AbstractPacket {
    public PlayerUpdatePacket(Object... data) {
        super(PacketCommand.PLAYER_UPDATE, data);
    }

    public PlayerUpdatePacket(int playerId, Player player) {
        super(PacketCommand.PLAYER_UPDATE, playerId, player);
    }
    
    public PlayerUpdatePacket(Player player) {
        super(PacketCommand.PLAYER_UPDATE, -1, player);
    }
    
    public int getPlayerId() {
        return getIntValue(0);
    }
    
    public @Nullable Player getPlayer() {
        return (Player) getObject(1);
    }
}
