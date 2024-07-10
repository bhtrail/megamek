package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;
import megamek.common.options.IBasicOption;

import java.util.Vector;

public class SendingGameSettingsClientPacket extends AbstractPacket {
    public SendingGameSettingsClientPacket(Object... data) {
        super(PacketCommand.SENDING_GAME_SETTINGS_CLIENT, data);
    }

    public SendingGameSettingsClientPacket(String password, Vector<? extends IBasicOption> options) {
        super(PacketCommand.SENDING_GAME_SETTINGS_CLIENT, password, options);
    }

    public String getPassword() {
        return (String) getObject(0);
    }

    @SuppressWarnings("unchecked")
    public Vector<? extends IBasicOption> getOptions() {
        return (Vector<? extends IBasicOption>) getObject(1);
    }
}
