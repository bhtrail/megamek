package megamek.common.net.packets;

import megamek.common.Report;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingReportsPacket extends AbstractPacket {
    public SendingReportsPacket(Object... data) {
        super(PacketCommand.SENDING_REPORTS, data);
    }

    public SendingReportsPacket(Vector<Report> reports) {
        super(PacketCommand.SENDING_REPORTS, reports);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<Report> getReports() {
        return (Vector<Report>) getObject(0);
    }
}
