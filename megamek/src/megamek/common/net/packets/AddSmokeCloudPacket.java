package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;
import megamek.server.SmokeCloud;

public class AddSmokeCloudPacket extends AbstractPacket {
    public AddSmokeCloudPacket(SmokeCloud cloud) {
        super(PacketCommand.ADD_SMOKE_CLOUD, cloud);
    }
    
    public SmokeCloud getCloud() {
        return (SmokeCloud) getObject(0);
    }
}
