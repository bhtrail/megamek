package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.net.enums.PacketCommand;

import java.util.HashSet;
import java.util.concurrent.Flow;

public class SendingIllumHexesPacket extends AbstractPacket {
    public SendingIllumHexesPacket(HashSet<Coords> illuminatedHexes) {
        super(PacketCommand.SENDING_ILLUM_HEXES, illuminatedHexes);
    }
    
    @SuppressWarnings("unchecked")
    public HashSet<Coords> getIlluminatedHexes() {
        return (HashSet<Coords>) getObject(0);
    }
}
