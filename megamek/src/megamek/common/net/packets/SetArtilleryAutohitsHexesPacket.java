package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.containers.PlayerIDandList;
import megamek.common.net.enums.PacketCommand;

public class SetArtilleryAutohitsHexesPacket extends AbstractPacket {
    public SetArtilleryAutohitsHexesPacket(PlayerIDandList<Coords> hexes) {
        super(PacketCommand.SET_ARTILLERY_AUTOHIT_HEXES, hexes);
    }

    @SuppressWarnings("unchecked")
    public PlayerIDandList<Coords> getHexes() {
        return (PlayerIDandList<Coords>) getObject(0);
    }
}
