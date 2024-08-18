package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.Entity;
import megamek.common.net.enums.PacketCommand;

import java.util.List;
import java.util.stream.Collectors;

public class EntityDeployPacket extends AbstractPacket {
    public EntityDeployPacket(Object... data)
    {
        super(PacketCommand.ENTITY_DEPLOY, data);
    }

    public EntityDeployPacket(int id, Coords c, int nFacing, int elevation, List<Entity> loadedUnits, boolean assaultDrop) {
        super(PacketCommand.ENTITY_DEPLOY, buildInputParams(id, c, nFacing, elevation, loadedUnits, assaultDrop));
    }

    private static Object[] buildInputParams(int id, Coords c, int nFacing, int elevation, List<Entity> loadedUnits, boolean assaultDrop)
    {
        int packetCount = 6 + loadedUnits.size();
        int index = 0;
        Object[] newData = new Object[packetCount];
        newData[index++] = id;
        newData[index++] = c;
        newData[index++] = nFacing;
        newData[index++] = elevation;
        newData[index++] = loadedUnits.size();
        newData[index++] = assaultDrop;

        for (Entity ent : loadedUnits) {
            newData[index++] = ent.getId();
        }

        return newData;
    }
    
    public int getEntityId()
    {
        return getIntValue(0);
    }
    
    public Coords getCoords() {
        return (Coords)getObject(1);
    }
    
    public int getFacing() {
        return getIntValue(2);
    }
    
    public int getElevation() {
        return getIntValue(3);
    }
    
    public int getLoadedUnitsCount()
    {
        return getIntValue(4);
    }
    
    public boolean getAssaultDrop() {
        return getBooleanValue(5);
    }
    
    public int getLoadedUnitId(int idx){
        return getIntValue(6 + idx);
    }
}
