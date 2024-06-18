package megamek.common.net.packets;

import megamek.common.annotations.Nullable;
import megamek.common.net.enums.PacketCommand;

public class LoadSavedGamePacket extends AbstractPacket {
    
    public LoadSavedGamePacket(String sFileName)
    {
        super(PacketCommand.LOAD_SAVEGAME, sFileName);
    }
    
    public @Nullable String getSavedGameName()
    {
        return (String)getObject(0);
    }
}
