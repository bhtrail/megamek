package megamek.common.net.packets;

import megamek.client.bot.princess.BehaviorSettings;
import megamek.common.net.enums.PacketCommand;

public class ClientPrincessSettingsPacket extends AbstractPacket {
    public ClientPrincessSettingsPacket(Object... data) {
        super(PacketCommand.CLIENT_PRINCESS_SETTINGS, data);
    }

    public ClientPrincessSettingsPacket(BehaviorSettings botSettings)
    {
        super(PacketCommand.CLIENT_PRINCESS_SETTINGS, botSettings);
    }
    
    public BehaviorSettings getBotSettings()
    {
        return (BehaviorSettings) getObject(0);
    }
}
