package megamek.common.net.packets;

import megamek.common.TagInfo;
import megamek.common.net.enums.PacketCommand;

import java.util.Vector;

public class SendingTagInfoPacket extends AbstractPacket {
    public SendingTagInfoPacket(Vector<TagInfo> tagInfo) {
        super(PacketCommand.SENDING_TAG_INFO, tagInfo);
    }

    @SuppressWarnings("unchecked")
    public Vector<TagInfo> getTagInfo() {
        return (Vector<TagInfo>) getObject(0);
    }
}
