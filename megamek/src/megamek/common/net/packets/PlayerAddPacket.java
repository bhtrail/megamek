package megamek.common.net.packets;

import megamek.common.Player;
import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

public class PlayerAddPacket extends AbstractPacket {
    public PlayerAddPacket(Object... data) {
        super(PacketCommand.PLAYER_ADD, data);
    }
    
    public PlayerAddPacket(int playerId, Player player) {
        super(PacketCommand.PLAYER_ADD, playerId, player);
    }
    
    public int getPlayerId() {
        return (Integer)getObject(0);
    }
    
    public @Nullable Player getPlayer() {
        return (Player)getObject(1);
    }
}
