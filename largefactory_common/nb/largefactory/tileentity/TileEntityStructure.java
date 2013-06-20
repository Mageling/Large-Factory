package nb.largefactory.tileentity;

import nb.largefactory.structure.StructureType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public abstract class TileEntityStructure extends TileEntityLargeFactory {

    public TileEntityStructure(String componentName) {
        this.componentName = componentName;
    }

    protected String componentName;
    protected int[] controlBlockLocation;
    protected boolean inStructure = false;

    public abstract void onNotified();

    public abstract boolean validateStructure(StructureType structureType);

    public abstract boolean setControlBlockLocation(int x, int y, int z);

    public abstract boolean isFace(StructureType structureType);

    public abstract void onBlockBreak();

    public abstract StructureType getStructureType();
    
    protected abstract void notifyControlBlock();
    
    protected abstract void removeFromStructure();

    public int numAdjacentInner(StructureType structureType) {
        int i = 0;
        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
            if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                    xCoord + 1, yCoord, zCoord)).getStructureType() == structureType) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
            if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                    xCoord - 1, yCoord, zCoord)).getStructureType() == structureType) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
            if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord,
                    yCoord + 1, zCoord)).getStructureType() == structureType) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
            if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord,
                    yCoord - 1, zCoord)).getStructureType() == structureType) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
            if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord,
                    yCoord, zCoord + 1)).getStructureType() == structureType) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
            if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord,
                    yCoord, zCoord - 1)).getStructureType() == structureType) {
                i++;
            }
        }
        return i;
    }

    public int numAdjacent(StructureType structureType) {
        int i = 0;
        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructure) {
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord + 1,
                    yCoord, zCoord)).getStructureType() == structureType
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(
                            xCoord + 1, yCoord, zCoord)).getStructureType() == StructureType.CASING) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructure) {
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord - 1,
                    yCoord, zCoord)).getStructureType() == structureType
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(
                            xCoord - 1, yCoord, zCoord)).getStructureType() == StructureType.CASING) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructure) {
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord,
                    yCoord + 1, zCoord)).getStructureType() == structureType
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(
                            xCoord, yCoord + 1, zCoord)).getStructureType() == StructureType.CASING) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructure) {
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord,
                    yCoord - 1, zCoord)).getStructureType() == structureType
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(
                            xCoord, yCoord - 1, zCoord)).getStructureType() == StructureType.CASING) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructure) {
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord,
                    yCoord, zCoord + 1)).getStructureType() == structureType
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(
                            xCoord, yCoord, zCoord + 1)).getStructureType() == StructureType.CASING) {
                i++;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructure) {
            if (((TileEntityStructure) worldObj.getBlockTileEntity(xCoord,
                    yCoord, zCoord - 1)).getStructureType() == structureType
                    || ((TileEntityStructure) worldObj.getBlockTileEntity(
                            xCoord, yCoord, zCoord - 1)).getStructureType() == StructureType.CASING) {
                i++;
            }
        }
        return i;
    }
    
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setString("Component Name", componentName);
        par1NBTTagCompound.setBoolean("In Structure", inStructure);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < controlBlockLocation.length; ++i) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setInteger("Control Block Location:" + i, controlBlockLocation[i]);
                nbttaglist.appendTag(nbttagcompound1);
        }

        par1NBTTagCompound.setTag("Control Block Location", nbttaglist);
        
    }
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Control Block Location");
        controlBlockLocation = new int[nbttaglist.tagCount()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist
                    .tagAt(i);
            controlBlockLocation[i] = nbttagcompound1.getInteger("Control Block Location:" + i);


            }
        componentName = par1NBTTagCompound.getString("Component Name");
        inStructure = par1NBTTagCompound.getBoolean("In Structure");
        }
    }
