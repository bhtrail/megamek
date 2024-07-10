package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class EntityDeployUnloadPacket extends AbstractPacket {
    public EntityDeployUnloadPacket(Object... data) {
        super(PacketCommand.ENTITY_DEPLOY_UNLOAD, data);
    }

    public EntityDeployUnloadPacket(int loaderId, int loadedId) {
        super(PacketCommand.ENTITY_DEPLOY_UNLOAD, loaderId, loadedId);
    }
    
    public int getLoaderId() {
        return getIntValue(0);
    }
    
    public int getLoadedId() {
        return getIntValue(1);
    }
}
