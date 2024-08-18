package megamek.common.net.packets;

import megamek.common.Report;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public abstract class SendingReportsPacketBase extends AbstractPacket {
    protected SendingReportsPacketBase(PacketCommand command, Object... objects)
    {
        super(command, objects);
    }

    protected SendingReportsPacketBase(PacketCommand command, Vector<Report> reports)
    {
        super(command, reports);
    }

    @SuppressWarnings("unchecked")
    public Vector<Report> getReports() {
        return (Vector<Report>) getObject(0);
    }
}
