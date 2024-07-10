package megamek.common.net.packets;

import megamek.common.FighterSquadron;
import megamek.common.net.enums.PacketCommand;

import java.util.Collection;

public class SquadronAddPacket extends AbstractPacket {
    public SquadronAddPacket(Object... data) {
        super(PacketCommand.SQUADRON_ADD, data);
    }

    public SquadronAddPacket(FighterSquadron squadron, Collection<Integer> fightersIds) {
        super(PacketCommand.SQUADRON_ADD, squadron, fightersIds);
    }

    public FighterSquadron getSquadron() {
        return (FighterSquadron) getObject(0);
    }

    @SuppressWarnings("unchecked")
    public Collection<Integer> getFightersIds() {
        return (Collection<Integer>) getObject(1);
    }
}
