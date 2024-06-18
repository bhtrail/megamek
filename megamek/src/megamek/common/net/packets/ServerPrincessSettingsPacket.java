package megamek.common.net.packets;

import megamek.client.bot.princess.BehaviorSettings;
import megamek.common.net.enums.PacketCommand;

import java.util.Map;

public class ServerPrincessSettingsPacket extends AbstractPacket {
    
    public ServerPrincessSettingsPacket(Map<String, BehaviorSettings> botSettings) {
        super(PacketCommand.SERVER_PRINCESS_SETTINGS, botSettings);
    }
    
    @SuppressWarnings("unchecked")
    public Map<String, BehaviorSettings> getBotSettings() {
        return (Map<String, BehaviorSettings>) getObject(0);
    }
}
