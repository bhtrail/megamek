package megamek.common.net.packets;

import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

public class ServerCorrectNamePacket extends AbstractPacket {
    
    public ServerCorrectNamePacket(String serverName) {
        super(PacketCommand.SERVER_CORRECT_NAME, serverName);
    }
    
    public @Nullable String getCorrectName() {
        return (String) getObject(0);
    }
}
