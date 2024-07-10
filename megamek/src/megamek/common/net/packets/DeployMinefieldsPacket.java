package megamek.common.net.packets;

import megamek.common.Minefield;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class DeployMinefieldsPacket extends AbstractPacket {
    public DeployMinefieldsPacket(Object... data) {
        super(PacketCommand.DEPLOY_MINEFIELDS, data);
    }

    public DeployMinefieldsPacket(Vector<Minefield> minefields) {
        super(PacketCommand.DEPLOY_MINEFIELDS, minefields);
    }

    @SuppressWarnings("unchecked")
    public Vector<Minefield> getMinefields() {
        return (Vector<Minefield>) getObject(0);
    }
}
