package nb.largefactory.block;

import java.util.Random;

import nb.largefactory.LargeFactory;
import nb.largefactory.lib.GuiIDs;
import nb.largefactory.lib.RenderIds;
import nb.largefactory.lib.Strings;
import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSaltCondenser extends BlockContainerLargeFactory {

    private final Random saltRand = new Random();

    protected BlockSaltCondenser(int par1) {
        super(par1, Material.wood);
        setUnlocalizedName(Strings.SALT_CONDENSER_NAME);
        setHardness(5F);
        setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntitySaltCondenser();
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return 0;
    }

    @Override
    public boolean renderAsNormalBlock() {

        return false;
    }

    @Override
    public int getRenderType() {
        return RenderIds.saltCondenserRenderId;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public void dropItemStack(ItemStack itemstack, World world, int x, int y,
            int z) {

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
                EntityItem entityitem = new EntityItem(world, x + f, y + f1, z
                        + f2, new ItemStack(itemstack.itemID, k1,
                                itemstack.getItemDamage()));

                if (itemstack.hasTagCompound()) {
                    entityitem.getEntityItem().setTagCompound(
                            (NBTTagCompound) itemstack.getTagCompound().copy());
                }

                float f3 = 0.05F;
                entityitem.motionX = (float) saltRand.nextGaussian() * f3;
                entityitem.motionY = (float) saltRand.nextGaussian() * f3
                        + 0.2F;
                entityitem.motionZ = (float) saltRand.nextGaussian() * f3;
                world.spawnEntityInWorld(entityitem);
            }
        }
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4,
            int par5, int par6) {

        dropItemStack(new ItemStack(Item.bucketEmpty, 1), par1World, par2,
                par3, par4);
        dropItemStack(new ItemStack(Block.glass, 2), par1World, par2, par3,
                par4);
        dropItemStack(new ItemStack(Block.chest, 1), par1World, par2, par3,
                par4);

        TileEntitySaltCondenser tileentitysaltcondenser = (TileEntitySaltCondenser) par1World
                .getBlockTileEntity(par2, par3, par4);

        if (tileentitysaltcondenser != null) {
            for (int j1 = 0; j1 < tileentitysaltcondenser.getSizeInventory(); ++j1) {
                ItemStack itemstack = tileentitysaltcondenser
                        .getStackInSlot(j1);

                dropItemStack(itemstack, par1World, par2, par3, par4);

                par1World.func_96440_m(par2, par3, par4, par5);
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int par6, float par7, float par8, float par9) {

        if (player.isSneaking())
            return false;
        else {
            if (!world.isRemote) {
                TileEntitySaltCondenser tileEntitySaltCondenser = (TileEntitySaltCondenser) world
                        .getBlockTileEntity(x, y, z);

                if (tileEntitySaltCondenser != null) {
                    player.openGui(LargeFactory.instance,
                            GuiIDs.SALT_CONDENSER, world, x, y, z);
                }
            }

            return true;
        }
    }

}
