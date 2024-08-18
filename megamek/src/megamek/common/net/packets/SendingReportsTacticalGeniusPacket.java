package megamek.common.net.packets;

import megamek.common.Report;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingReportsTacticalGeniusPacket extends SendingReportsPacketBase {
    public SendingReportsTacticalGeniusPacket(Object... data) {
        super(PacketCommand.SENDING_REPORTS_TACTICAL_GENIUS, data);
    }

    public SendingReportsTacticalGeniusPacket(Vector<Report> reports) {
        super(PacketCommand.SENDING_REPORTS_TACTICAL_GENIUS, reports);
    }
}
