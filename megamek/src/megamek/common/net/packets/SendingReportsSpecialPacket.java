package megamek.common.net.packets;

import megamek.common.Report;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingReportsSpecialPacket extends AbstractPacket {
    public SendingReportsSpecialPacket(Vector<Report> reports) {
        super(PacketCommand.SENDING_REPORTS_SPECIAL, reports);
    }

    @SuppressWarnings("unchecked")
    public Vector<Report> getReports() {
        return (Vector<Report>) getObject(0);
    }
}
