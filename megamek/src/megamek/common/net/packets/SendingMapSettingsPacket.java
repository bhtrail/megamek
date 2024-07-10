package megamek.common.net.packets;

import megamek.common.MapSettings;
import megamek.common.net.enums.PacketCommand;

public class SendingMapSettingsPacket extends AbstractPacket {
    public SendingMapSettingsPacket(Object... data) {
        super(PacketCommand.SENDING_MAP_SETTINGS, data);
    }

    public SendingMapSettingsPacket(MapSettings mapSettings) {
        super(PacketCommand.SENDING_MAP_SETTINGS, mapSettings);
    }

    public MapSettings getMapSettings() {
        return (MapSettings) getObject(0);
    }
}
