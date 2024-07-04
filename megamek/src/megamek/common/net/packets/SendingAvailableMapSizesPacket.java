package megamek.common.net.packets;

import megamek.common.BoardDimensions;
import megamek.common.net.enums.PacketCommand;

import java.util.Set;

public class SendingAvailableMapSizesPacket extends AbstractPacket {
    public SendingAvailableMapSizesPacket(Set<BoardDimensions> dimensions) {
        super(PacketCommand.SENDING_AVAILABLE_MAP_SIZES, dimensions);
    }

    @SuppressWarnings("unchecked")
    public Set<BoardDimensions> getAvailableMapSizes() {
        return (Set<BoardDimensions>) getObject(0);
    }
}
