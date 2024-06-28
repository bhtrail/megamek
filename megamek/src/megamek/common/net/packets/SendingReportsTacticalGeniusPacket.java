package megamek.common.net.packets;

import megamek.common.Report;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingReportsTacticalGeniusPacket extends AbstractPacket {
    public SendingReportsTacticalGeniusPacket(Vector<Report> reports) {
        super(PacketCommand.SENDING_REPORTS_TACTICAL_GENIUS, reports);
    }

    @SuppressWarnings("unchecked")
    public Vector<Report> getReports() {
        return (Vector<Report>) getObject(0);
    }
}
