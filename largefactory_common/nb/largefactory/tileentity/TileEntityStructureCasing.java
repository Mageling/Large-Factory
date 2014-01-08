package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureCreationErrors;
import nb.largefactory.structure.StructureType;

public class TileEntityStructureCasing extends TileEntityStructure {

    public TileEntityStructureCasing(String componentName) {
        super(componentName);
        controlBlockLocation = new int[0];
    }

    @Override
    public boolean validateStructure(StructureType structureType) {
        if (numAdjacentInner(structureType) >= 2)
            return numAdjacent(structureType) == 6;
        if (numAdjacentInner(structureType) == 1) {
            if (numAdjacent(structureType) == 6)
                return true;
            if (numAdjacent(structureType) < 5) {
                StructureCreationErrors.FACE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                return false;
            }
            if (numAdjacent(structureType) == 5) {
                if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                    if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                            .getStructureType() == structureType) {
                        if (!(worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructure))
                            return true;
                        else {
                            if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                                        .getStructureType() != structureType)
                                    return true;
                            }
                        }
                        StructureCreationErrors.FACE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                    if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                            .getStructureType() == structureType) {
                        if (!(worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructure))
                            return true;
                        else {
                            if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                                        .getStructureType() != structureType)
                                    return true;
                            }
                        }
                        StructureCreationErrors.FACE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
                    if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getStructureType() == structureType) {
                        if (!(worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructure))
                            return true;
                        else {
                            if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
                                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                                        .getStructureType() != structureType)
                                    return true;
                            }
                        }
                        StructureCreationErrors.FACE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
                    if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getStructureType() == structureType) {
                        if (!(worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructure))
                            return true;
                        else {
                            if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
                                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                                        .getStructureType() != structureType)
                                    return true;
                            }
                        }
                        StructureCreationErrors.FACE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
                    if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getStructureType() == structureType) {
                        if (!(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructure))
                            return true;
                        else {
                            if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
                                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                                        .getStructureType() != structureType)
                                    return true;
                            }
                        }
                        StructureCreationErrors.FACE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
                    if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getStructureType() == structureType) {
                        if (!(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructure))
                            return true;
                        else {
                            if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
                                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                                        .getStructureType() != structureType)
                                    return true;
                            }
                        }
                        StructureCreationErrors.FACE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
            }
        }
        if (numAdjacentInner(structureType) == 0) {
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord)).isFace(structureType)
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                    .isFace(structureType)) {
                if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                        .isFace(structureType)
                        || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                        .isFace(structureType)) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructure && worldObj
                            .getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructure)) {
                        StructureCreationErrors.EDGE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
            }
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord)).isFace(structureType)
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                    .isFace(structureType)) {
                if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                        .isFace(structureType)
                        || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                        .isFace(structureType)) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructure && worldObj
                            .getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructure)) {
                        StructureCreationErrors.EDGE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
            }
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord)).isFace(structureType)
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                    .isFace(structureType)) {
                if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                        .isFace(structureType)
                        || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                        .isFace(structureType)) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructure && worldObj
                            .getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructure)) {
                        StructureCreationErrors.EDGE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
            }
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord)).isFace(structureType)
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                    .isFace(structureType)) {
                if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                        .isFace(structureType)
                        || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                        .isFace(structureType)) {
                    if (!(worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructure && worldObj
                            .getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructure)) {
                        StructureCreationErrors.EDGE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
            }
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1)).isFace(structureType)
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                    .isFace(structureType)) {
                if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                        .isFace(structureType)
                        || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                        .isFace(structureType)) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructure && worldObj
                            .getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructure)) {
                        StructureCreationErrors.EDGE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
            }
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1)).isFace(structureType)
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                    .isFace(structureType)) {
                if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                        .isFace(structureType)
                        || ((TileEntityStructure) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                        .isFace(structureType)) {
                    if (!(worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructure && worldObj
                            .getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructure)) {
                        StructureCreationErrors.EDGE_CASING_BLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
            }
            return true;
        }
        StructureCreationErrors.OTHER.printError(xCoord, yCoord, zCoord);
        return false;
    }

    @Override
    public boolean setControlBlockLocation(int x, int y, int z) {
        int[] controlBlockLocationNew = new int[controlBlockLocation.length + 3];
        for (int i = 0; i < controlBlockLocation.length; i++) {
            controlBlockLocationNew[i] = controlBlockLocation[i];
        }
        controlBlockLocationNew[controlBlockLocation.length] = x;
        controlBlockLocationNew[controlBlockLocation.length + 1] = y;
        controlBlockLocationNew[controlBlockLocation.length + 2] = z;
        return true;
    }

    @Override
    public boolean isFace(StructureType structureType) {
        return numAdjacentInner(structureType) == 1;
    }

    @Override
    public void onBlockBreak() {
        notifyControlBlock();
    }

    @Override
    public StructureType getStructureType() {
        return StructureType.CASING;
    }

    @Override
    public void onNotified() {
        notifyControlBlock();
        removeFromStructure();
    }

    @Override
    protected void notifyControlBlock() {
        for (int i = 0; i < controlBlockLocation.length; i = i + 3) {
            ((TileEntityStructureControl) worldObj.getBlockTileEntity(controlBlockLocation[i],
                    controlBlockLocation[i + 1], controlBlockLocation[i + 2])).onNotified();
        }
    }

    @Override
    protected void removeFromStructure() {
        controlBlockLocation = new int[0];
        inStructure = false;
    }

}
