package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureType;

public class TileEntityStructureInner extends TileEntityStructure {

    public TileEntityStructureInner(String componentName) {
        super(componentName);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validateStructure() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setControlBlockLocation(int x, int y, int z) {
        // TODO Auto-generated method stub

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
