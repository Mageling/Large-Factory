package nb.largefactory.tileentity;

import nb.largefactory.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.biome.BiomeGenBase;

public class TileEntitySaltCondenser extends TileEntityLargeFactory implements IInventory {

    public static final int INVENTORY_SIZE = 1;
    public static final int OUTPUT_INVENTORY_INDEX = 0;

    private ItemStack[] saltCondenserItemStacks;
    public int saltCondenserTimeRemaining = 1152000; // ticks in 16 hours
    public int saltProgress = 0;
    public boolean ceaseFunction = false;

    public TileEntitySaltCondenser() {
        saltCondenserItemStacks = new ItemStack[INVENTORY_SIZE];
    }

    @Override
    public void updateEntity() {
        if (saltCondenserTimeRemaining > 0) {
            saltCondenserTimeRemaining--;
            if (this.canProduce()) {
                if (worldObj.getBiomeGenForCoords(xCoord, zCoord) == BiomeGenBase.beach
                        || worldObj.getBiomeGenForCoords(xCoord, zCoord) == BiomeGenBase.ocean) {
                    saltProgress = saltProgress + 4;
                } else {
                    saltProgress = saltProgress + 1;
                }
                if (saltProgress >= 72000) { // ticks in an hour
                    this.makeSalt();
                    saltProgress = saltProgress - 72000;
                }
            }
        } else {
            ceaseFunction = true;
        }
    }

    private void makeSalt() {
        if (saltCondenserItemStacks[0] == null) {
            saltCondenserItemStacks[0] = new ItemStack(ModItems.salt, 1);
            return;
        } else {
            if (saltCondenserItemStacks[0].itemID == ModItems.salt.itemID) {
                if (saltCondenserItemStacks[0].stackSize < 64) {
                    saltCondenserItemStacks[0] = new ItemStack(ModItems.salt, saltCondenserItemStacks[0].stackSize + 1);
                    return;
                }
            }
        }
    }

    private boolean canProduce() {
        if (worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord)) {
            if (worldObj.getBlockId(xCoord + 1, yCoord, zCoord) == Block.waterStill.blockID) {
                return true;
            }
            if (worldObj.getBlockId(xCoord - 1, yCoord, zCoord) == Block.waterStill.blockID) {
                return true;
            }
            if (worldObj.getBlockId(xCoord, yCoord, zCoord + 1) == Block.waterStill.blockID) {
                return true;
            }
            if (worldObj.getBlockId(xCoord, yCoord, zCoord - 1) == Block.waterStill.blockID) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        saltCondenserItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < saltCondenserItemStacks.length) {
                saltCondenserItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        saltCondenserTimeRemaining = par1NBTTagCompound.getInteger("TimeRemaining");
        saltProgress = par1NBTTagCompound.getInteger("SaltProgress");
        ceaseFunction = par1NBTTagCompound.getBoolean("CeaseFunction");

    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("TimeRemaining", saltCondenserTimeRemaining);
        par1NBTTagCompound.setInteger("SaltProgress", saltProgress);
        par1NBTTagCompound.setBoolean("CeaseFunction", ceaseFunction);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < saltCondenserItemStacks.length; ++i) {
            if (saltCondenserItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                saltCondenserItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);

    }

    @Override
    public int getSizeInventory() {
        return saltCondenserItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return saltCondenserItemStacks[i];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {
        if (saltCondenserItemStacks[par1] != null) {
            ItemStack itemstack;

            if (saltCondenserItemStacks[par1].stackSize <= par2) {
                itemstack = saltCondenserItemStacks[par1];
                saltCondenserItemStacks[par1] = null;
                return itemstack;
            } else {
                itemstack = saltCondenserItemStacks[par1].splitStack(par2);

                if (saltCondenserItemStacks[par1].stackSize == 0) {
                    saltCondenserItemStacks[par1] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1) {
        if (saltCondenserItemStacks[par1] != null) {
            ItemStack itemstack = saltCondenserItemStacks[par1];
            saltCondenserItemStacks[par1] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        saltCondenserItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? customName : "container.saltCondenser";
    }

    @Override
    public boolean isInvNameLocalized() {
        return customName != null && customName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : par1EntityPlayer.getDistanceSq(
                xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        return false;
    }

}
