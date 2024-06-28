package megamek.common.net.packets;

import megamek.common.Report;
import megamek.common.net.enums.PacketCommand;

import java.util.List;
import java.util.Map;

public class SendingReportsAllPacket extends AbstractPacket {
    public SendingReportsAllPacket(List<List<Report>> reports) {
        super(PacketCommand.SENDING_REPORTS_ALL, reports);
    }

    public SendingReportsAllPacket(Map<Integer, List<Report>> reports) {
        super(PacketCommand.SENDING_REPORTS_ALL, reports);
    }

    @SuppressWarnings("unchecked")
    public List<List<Report>> getReports() {
        return (List<List<Report>>) getObject(0);
    }

    @SuppressWarnings("unchecked")
    public Map<Integer, List<Report>> getReportsMap()  {
        return (Map<Integer, List<Report>>) getObject(0);
    }
}
