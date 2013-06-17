package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureType;

public abstract class TileEntityStructure extends TileEntityLargeFactory {
    
    public TileEntityStructure(String componentName) {
        this.componentName = componentName;
    }
    
    protected String componentName;
    protected int[] controlBlockLocation;
    protected boolean inStructure = false; 
    
    public abstract boolean validateStructure();
    public abstract void setControlBlockLocation(int x, int y, int z);
    public abstract boolean isFace(StructureType structureType);
    public abstract void onBlockBreak();
    public abstract StructureType getStructureType();
    
    public int numAdjacentInner(StructureType structureType) {
        int i = 0;
        if(this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord)).getStructureType() == structureType) {
                i++;
            }
        }
        if(this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord)).getStructureType() == structureType) {
                i++;
            }
        }
        if(this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getStructureType() == structureType) {
                i++;
            }
        }
        if(this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getStructureType() == structureType) {
                i++;
            }
        }
        if(this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getStructureType() == structureType) {
                i++;
            }
        }
        if(this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
            if(((TileEntityStructureInner) this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getStructureType() == structureType) {
                i++;
            }
        }
        return i;
    }
    
}