package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public abstract class ClientFeedbackRequestPacket extends AbstractPacket {
    public ClientFeedbackRequestPacket(Object ... data) {
        super(PacketCommand.CLIENT_FEEDBACK_REQUEST, data);
    }

    public PacketCommand getSubCommand() {
        return (PacketCommand) getObject(0);
    }
}
