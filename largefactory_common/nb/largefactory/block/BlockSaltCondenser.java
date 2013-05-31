package nb.largefactory.block;

import java.util.Random;

import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSaltCondenser extends BlockContainer {

    private final Random saltRand = new Random();

    protected BlockSaltCondenser(int par1) {
        super(par1, Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return 0;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4,
            int par5, int par6) {

        TileEntitySaltCondenser tileentitysaltcondenser = (TileEntitySaltCondenser) par1World
                .getBlockTileEntity(par2, par3, par4);

        if (tileentitysaltcondenser != null) {
            for (int j1 = 0; j1 < tileentitysaltcondenser.getSizeInventory(); ++j1) {
                ItemStack itemstack = tileentitysaltcondenser
                        .getStackInSlot(j1);

                if (itemstack != null) {
                    float f = saltRand.nextFloat() * 0.8F + 0.1F;
                    float f1 = saltRand.nextFloat() * 0.8F + 0.1F;
                    float f2 = saltRand.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0) {
                        int k1 = saltRand.nextInt(21) + 10;

                        if (k1 > itemstack.stackSize) {
                            k1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= k1;
                        EntityItem entityitem = new EntityItem(par1World, par2
                                + f, par3 + f1, par4 + f2,
                                new ItemStack(itemstack.itemID, k1,
                                        itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound()) {
                            entityitem.getEntityItem().setTagCompound(
                                    (NBTTagCompound) itemstack.getTagCompound()
                                            .copy());
                        }

                        float f3 = 0.05F;
                        entityitem.motionX = (float) saltRand.nextGaussian()
                                * f3;
                        entityitem.motionY = (float) saltRand.nextGaussian()
                                * f3 + 0.2F;
                        entityitem.motionZ = (float) saltRand.nextGaussian()
                                * f3;
                        par1World.spawnEntityInWorld(entityitem);
                    }
                }

                par1World.func_96440_m(par2, par3, par4, par5);
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

}
