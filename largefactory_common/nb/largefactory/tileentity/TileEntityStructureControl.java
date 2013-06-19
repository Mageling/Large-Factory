package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureType;
import nb.largefactory.xml.XMLDecoder;

public class TileEntityStructureControl extends TileEntityStructure {

    public TileEntityStructureControl(String componentName) {
        super(componentName);
        controlBlockLocation = new int[3];
        controlBlockLocation[0] = xCoord;
        controlBlockLocation[1] = yCoord;
        controlBlockLocation[2] = zCoord;
    }

    @Override
    public boolean validateStructure(StructureType structureType) {
        if(this.getStructureType() != structureType) {
            return false;
        }
        if (numAdjacentInner(structureType) == 1) {
            if (numAdjacent(structureType) != 5) {
                return false;
            }
            if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord + 1, yCoord, zCoord)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord - 1, yCoord,
                            zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord,
                                zCoord) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord - 1, yCoord,
                                            zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord - 1, yCoord, zCoord)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord + 1, yCoord,
                            zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord,
                                zCoord) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord + 1, yCoord,
                                            zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord, yCoord + 1, zCoord)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord - 1,
                            zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1,
                                zCoord) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1,
                                            zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord, yCoord - 1, zCoord)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord + 1,
                            zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1,
                                zCoord) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1,
                                            zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord, yCoord, zCoord + 1)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord,
                            zCoord - 1) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord,
                                zCoord - 1) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord, yCoord,
                                            zCoord - 1)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord, yCoord, zCoord - 1)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord,
                            zCoord + 1) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord,
                                zCoord + 1) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord, yCoord,
                                            zCoord + 1)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean setControlBlockLocation(int x, int y, int z) {
        if(x == this.xCoord) {
            if(y == this.yCoord) {
                if(z == this.zCoord) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onBlockBreak() {
        if (inStructure) {
            this.deleteStructure();
        }
    }

    private void deleteStructure() {
        // TODO Auto-generated method stub

    }

    @Override
    public StructureType getStructureType() {
        return XMLDecoder.getStructureType(componentName);
    }

    @Override
    public boolean isFace(StructureType structureType) {
        return this.getStructureType() == structureType;
    }

    public void createStructure() {

    }

    @Override
    public void onNotified() {
        this.deleteStructure();
    }

    @Override
    protected void notifyControlBlock() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void removeFromStructure() {
        // TODO Auto-generated method stub
        
    }
}
