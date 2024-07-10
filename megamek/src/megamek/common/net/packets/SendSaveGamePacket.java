package megamek.common.net.packets;

import megamek.common.net.enums.PacketCommand;

import java.util.List;

public class SendSaveGamePacket extends AbstractPacket {
    public SendSaveGamePacket(Object... data) {
        super(PacketCommand.SEND_SAVEGAME, data);
    }
    
    public SendSaveGamePacket(String finalSaveName, List<Integer> data, String localPath) {
        super(PacketCommand.SEND_SAVEGAME, finalSaveName, data, localPath);
    }

    public String getFinalSaveName() {
        return (String) getObject(0);
    }

    @SuppressWarnings("unchecked")
    public List<Integer> getSaveData()  {
        return (List<Integer>) getObject(1);
    }

    public String getLocalPath() {
        return (String) getObject(2);
    }
}
