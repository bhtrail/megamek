package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class UnloadStrandedPacket extends AbstractPacket {
    public UnloadStrandedPacket(Object... data) {
        super(PacketCommand.UNLOAD_STRANDED, data);
    }

    public UnloadStrandedPacket(int[] ids) {
        super(PacketCommand.UNLOAD_STRANDED, ids);
    }

    public int[] getIds() {
        return (int[]) getObject(0);
    }
}
