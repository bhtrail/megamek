package megamek.common.net.packets;

import megamek.common.MapSettings;
import megamek.common.net.enums.PacketCommand;

public class SendingMapDimensionsPacket extends AbstractPacket {
    public SendingMapDimensionsPacket(MapSettings mapDimensions) {
        super(PacketCommand.SENDING_MAP_DIMENSIONS, mapDimensions);
    }

    public MapSettings getMapDimensions() {
        return (MapSettings)getObject(0);
    }
}
