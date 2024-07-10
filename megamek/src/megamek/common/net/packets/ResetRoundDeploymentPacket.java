package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ResetRoundDeploymentPacket extends AbstractPacket {
    public ResetRoundDeploymentPacket(Object... data) {
        super(PacketCommand.RESET_ROUND_DEPLOYMENT);
    }

    public ResetRoundDeploymentPacket() {
        super(PacketCommand.RESET_ROUND_DEPLOYMENT);
    }
}
