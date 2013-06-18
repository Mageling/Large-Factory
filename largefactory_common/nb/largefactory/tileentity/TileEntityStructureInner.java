package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureType;
import nb.largefactory.xml.XMLDecoder;

public class TileEntityStructureInner extends TileEntityStructure {

    public TileEntityStructureInner(String componentName) {
        super(componentName);
    }

    @Override
    public boolean validateStructure() {
        if (this.numAdjascent(this.getStructureType()) == 6) {
            return true;
        }
        return false;
    }

    @Override
    public void setControlBlockLocation(int x, int y, int z) {
        if (controlBlockLocation != null) {
            // error message
            return;
        }
        controlBlockLocation = new int[3];
        controlBlockLocation[0] = x;
        controlBlockLocation[1] = y;
        controlBlockLocation[2] = z;
    }

    @Override
    public void onBlockBreak() {
        notifyControlBlock();
        removeFromStructure();
    }

    private void removeFromStructure() {
        controlBlockLocation = null;
        inStructure = false;

    }

    private void notifyControlBlock() {
        // TODO Auto-generated method stub

    }

    @Override
    public StructureType getStructureType() {
        return XMLDecoder.getStructureTypeFromComponentName(componentName);
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
