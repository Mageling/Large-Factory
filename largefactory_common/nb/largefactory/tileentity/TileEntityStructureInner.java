package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureCreationErrors;
import nb.largefactory.structure.StructureType;
import nb.largefactory.xml.XMLDecoder;

public class TileEntityStructureInner extends TileEntityStructure {

    public TileEntityStructureInner(String componentName) {
        super(componentName);
    }

    @Override
    public boolean validateStructure(StructureType structureType) {
        if (this.getStructureType() != structureType) {
            StructureCreationErrors.INNER_BLOCK.printError(xCoord, yCoord,
                    zCoord);
            return false;
        }
        if (this.numAdjacent(this.getStructureType()) == 6) {
            return true;
        }
        StructureCreationErrors.INNER_BLOCK.printError(xCoord, yCoord, zCoord);
        return false;
    }

    @Override
    public boolean setControlBlockLocation(int x, int y, int z) {
        if (controlBlockLocation != null) {
            return false;
        }
        controlBlockLocation = new int[3];
        controlBlockLocation[0] = x;
        controlBlockLocation[1] = y;
        controlBlockLocation[2] = z;
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
        ((TileEntityStructureControl) worldObj.getBlockTileEntity(
                controlBlockLocation[0], controlBlockLocation[1],
                controlBlockLocation[2])).onNotified();

    }

    @Override
    public StructureType getStructureType() {
        return XMLDecoder.getStructureType(componentName);
    }

    @Override
    public boolean isFace(StructureType structureType) {
        return false;
    }

    @Override
    public void onNotified() {
        this.removeFromStructure();
    }

}
