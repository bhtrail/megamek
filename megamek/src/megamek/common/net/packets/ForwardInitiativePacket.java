package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

public class ForwardInitiativePacket extends AbstractPacket {
    
    public ForwardInitiativePacket(){
        super(PacketCommand.FORWARD_INITIATIVE);
    }
}
