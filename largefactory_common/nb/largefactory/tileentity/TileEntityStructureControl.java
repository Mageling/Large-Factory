package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureType;

public class TileEntityStructureControl extends TileEntityStructure {

    public TileEntityStructureControl(String componentName) {
        super(componentName);
        this.controlBlockLocation = new int[3];
    }

    @Override
    public boolean validateStructure() {
        StructureType structureType = this.getStructureType();
        if(numAdjacentInner(structureType) == 1) {
            if(this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord)).getStructureType() == structureType) {
                    if(!(this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if(this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    } 
                    return false;
                } 
            }  
            if(this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord)).getStructureType() == structureType) {
                    if(!(this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if(this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    } 
                    return false;
                } 
            } 
            if(this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
                if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getStructureType() == structureType) {
                    if(!(this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if(this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
                            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    } 
                    return false;
                } 
            }  
            if(this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
                if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getStructureType() == structureType) {
                    if(!(this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if(this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
                            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    } 
                    return false;
                } 
            }
            if(this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
                if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getStructureType() == structureType) {
                    if(!(this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if(this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
                            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    } 
                    return false;
                } 
            }  
            if(this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
                if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getStructureType() == structureType) {
                    if(!(this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if(this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
                            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getStructureType() != structureType) {
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
    public void setControlBlockLocation(int x, int y, int z) {
        this.controlBlockLocation[0] = x;
        this.controlBlockLocation[1] = y;
        this.controlBlockLocation[2] = z;
        

    }

    @Override
    public void onBlockBreak() {
        if(inStructure) {
            this.deleteStructure();
        }
    }

    private void deleteStructure() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public StructureType getStructureType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isFace(StructureType structureType) {
        return true;
    }

}