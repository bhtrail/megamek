package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ClientFeedbackResponsePacket extends AbstractPacket {
    public ClientFeedbackResponsePacket (Object... data) {
        super(PacketCommand.CLIENT_FEEDBACK_RESPONSE, data);
    }

    public PacketCommand getSubCommand() {
        return (PacketCommand) getObject(0);
    }
}
