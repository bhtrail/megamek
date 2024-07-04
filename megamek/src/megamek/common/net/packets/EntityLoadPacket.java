package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityLoadPacket extends AbstractPacket {
    public EntityLoadPacket(int id, int loaderId, int bayNumber) {
        super(PacketCommand.ENTITY_LOAD, id, loaderId, bayNumber);
    }

    public int getId() {
        return getIntValue(0);
    }

    public int getLoaderId() {
        return getIntValue(1);
    }

    public int getBayNumber() {
        return getIntValue(2);
    }
}
