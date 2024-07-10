package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityNovaNetworkChangePacket extends AbstractPacket {
    public EntityNovaNetworkChangePacket(Object... data) {
        super(PacketCommand.ENTITY_NOVA_NETWORK_CHANGE, data);
    }

    public EntityNovaNetworkChangePacket(int id, String net) {
        super(PacketCommand.ENTITY_NOVA_NETWORK_CHANGE, id, net);
    }

    public int getId() {
        return getIntValue(0);
    }

    public String getNet() {
        return getObject(1).toString();
    }
}
