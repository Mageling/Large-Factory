package nb.largefactory.tileentity.structure;

import nb.largefactory.structure.StructureCreationErrors;

import nb.largefactory.structure.component.ComponentFactory;

public class TileEntityStructureInner extends TileEntityStructure {

    public TileEntityStructureInner(String componentName) {
        super(componentName);
    }

    @Override
    public boolean validateStructure(String structureType) {
        if (inStructure) {
            StructureCreationErrors.ALREADY_IN_STRUCTURE.printError(xCoord, yCoord, zCoord);
            return false;
        }
        if (getStructureType() != structureType) {
            StructureCreationErrors.INNER_BLOCK.printError(xCoord, yCoord, zCoord);
            return false;
        }
        if (numAdjacent(getStructureType()) == 6)
            return true;
        StructureCreationErrors.INNER_BLOCK.printError(xCoord, yCoord, zCoord);
        return false;
    }

    @Override
    public boolean setControlBlockLocation(int x, int y, int z) {
        if (controlBlockLocation != null)
            return false;
        controlBlockLocation = coordToArray(x, y, z);
        return true;
    }

    @Override
    public void onBlockBreak() {
        notifyControlBlock();
    }

    @Override
    protected void removeFromStructure() {
        controlBlockLocation = null;
        inStructure = false;

    }

    @Override
    protected void notifyControlBlock() {
        ((TileEntityStructureControl) worldObj.getBlockTileEntity(controlBlockLocation[0], controlBlockLocation[1],
                controlBlockLocation[2])).onNotified();

    }

    @Override
    public String getStructureType() {
        return ComponentFactory.componentList.get(componentName).getStructureType();
    }

    @Override
    public boolean isFace(String structureType) {
        return false;
    }

    @Override
    public void onNotified() {
        removeFromStructure();
    }

}
