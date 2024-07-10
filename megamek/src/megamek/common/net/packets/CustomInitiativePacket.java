package megamek.common.net.packets;

import megamek.common.Player;
import megamek.common.net.enums.PacketCommand;

public class CustomInitiativePacket extends AbstractPacket {
    public CustomInitiativePacket(Object... data) {
        super(PacketCommand.CUSTOM_INITIATIVE, data);
    }

    public CustomInitiativePacket(Player player) {
        super(PacketCommand.CUSTOM_INITIATIVE, player);
    }

    public Player getPlayer() {
        return (Player) getObject(0);
    }
}
