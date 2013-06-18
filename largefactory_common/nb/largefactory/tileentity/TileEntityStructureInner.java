package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureType;

public class TileEntityStructureInner extends TileEntityStructure {

    public TileEntityStructureInner(String componentName) {
        super(componentName);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validateStructure() {
        if(this.numAdjascent(this.getStructureType()) == 6) {
            return true;
        }
        return false;
    }

    @Override
    public void setControlBlockLocation(int x, int y, int z) {
        if(controlBlockLocation != null) {
            //error message
            return;
        }
        controlBlockLocation = new int[3];
        controlBlockLocation[0] = x;
        controlBlockLocation[1] = y;
        controlBlockLocation[2] = z;
    }

    @Override
    public void onBlockBreak() {
        // TODO Auto-generated method stub

    }

    @Override
    public StructureType getStructureType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isFace(StructureType structureType) {
        return false;
    }

}
