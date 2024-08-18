package megamek.common.net.packets;

import megamek.common.Report;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingReportsSpecialPacket extends SendingReportsPacketBase {
    public SendingReportsSpecialPacket(Object... data) {
        super(PacketCommand.SENDING_REPORTS_SPECIAL, data);
    }

    public SendingReportsSpecialPacket(Vector<Report> reports) {
        super(PacketCommand.SENDING_REPORTS_SPECIAL, reports);
    }
}
