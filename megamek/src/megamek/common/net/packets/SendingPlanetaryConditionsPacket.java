package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;
import megamek.common.planetaryconditions.PlanetaryConditions;

public class SendingPlanetaryConditionsPacket extends AbstractPacket {
    public SendingPlanetaryConditionsPacket(Object... data) {
        super(PacketCommand.SENDING_PLANETARY_CONDITIONS, data);
    }

    public SendingPlanetaryConditionsPacket(PlanetaryConditions conditions) {
        super(PacketCommand.SENDING_PLANETARY_CONDITIONS, conditions);
    }

    public PlanetaryConditions getConditions() {
        return (PlanetaryConditions) getObject(0);
    }
}
