package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;
import megamek.common.options.GameOptions;

public class SendingGameSettingsServerPacket extends AbstractPacket {
    public SendingGameSettingsServerPacket(Object... data) {
        super(PacketCommand.SENDING_GAME_SETTINGS_SERVER, data);
    }

    public SendingGameSettingsServerPacket(GameOptions gameOptions) {
        super(PacketCommand.SENDING_GAME_SETTINGS_SERVER, gameOptions);
    }

    public GameOptions getGameOptions() {
        return (GameOptions) getObject(0);
    }
}
