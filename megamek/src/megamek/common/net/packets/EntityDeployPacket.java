package megamek.common.net.packets;

import megamek.common.Coords;
import megamek.common.Entity;
import megamek.common.net.enums.PacketCommand;

import java.util.List;
import java.util.stream.Collectors;

public class EntityDeployPacket extends AbstractPacket {
    public EntityDeployPacket(int id, Coords c, int nFacing, int elevation, List<Entity> loadedUnits, boolean assaultDrop) {
        
        super(PacketCommand.ENTITY_DEPLOY, id, c, nFacing, elevation, loadedUnits.size(), assaultDrop, 
                loadedUnits.stream().map(Entity::getId).collect(Collectors.toList()));
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
