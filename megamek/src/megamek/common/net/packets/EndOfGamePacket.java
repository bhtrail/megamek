package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EndOfGamePacket extends AbstractPacket {
    public EndOfGamePacket(String report, int playerId, int teamId) {
        super(PacketCommand.END_OF_GAME, report, playerId, teamId);
    }

    public String getReport() {
        return (String) getObject(0);
    }

    public int getPlayerId() {
        return (Integer) getObject(1);
    }

    public int getTeamId()  {
        return (Integer) getObject(2);
    }
}
