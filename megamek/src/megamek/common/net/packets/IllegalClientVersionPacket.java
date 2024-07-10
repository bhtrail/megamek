package megamek.common.net.packets;

import megamek.Version;
import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

public class IllegalClientVersionPacket extends AbstractPacket {
    public IllegalClientVersionPacket(Object... data) {
        super(PacketCommand.ILLEGAL_CLIENT_VERSION, data);
    }
    
    public IllegalClientVersionPacket(Version version)
    {
        super(PacketCommand.ILLEGAL_CLIENT_VERSION, version);
    }
    
    public @Nullable Version getVersion()
    {
        return (Version)getObject(0);
    }
}
