package megamek.common.net.packets;

import megamek.Version;
import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

public class ClientVersionsPacket extends AbstractPacket {
    public ClientVersionsPacket(Object... data)
    {
        super(PacketCommand.CLIENT_VERSIONS, data);
    }
    
    public ClientVersionsPacket(Version version, String hash) {
        super(PacketCommand.CLIENT_VERSIONS, version, hash);
    }
    
    public @Nullable Version getVersion() {
        return (Version) getObject(0);
    }
    
    public @Nullable String getClientHash() {
        return (String) getObject(1);
    }
}
