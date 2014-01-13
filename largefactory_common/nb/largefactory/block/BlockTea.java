package nb.largefactory.block;

import java.util.Random;

import nb.largefactory.item.ModItems;
import nb.largefactory.lib.Reference;
import nb.largefactory.lib.Scalables;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTea extends BlockCrops {

    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public BlockTea(int id) {
        super(id);
        setTickRandomly(true);
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(0.3F);
        setStepSound(soundGrassFootstep);
        setUnlocalizedName("teaPlant");
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l < 5) {
                float f = getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int) (25.0F / f) + 1) == 0) {
                    ++l;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                }
            }
        }
    }

    public float getGrowthRate(World par1World, int par2, int par3, int par4) {
        int l = par1World.getBlockMetadata(par2, par3, par4);

        float base;

        switch (l) {
        case 0:
            base = 1.5f;
            break;
        case 1:
            base = 1.5f;
            break;
        case 2:
            base = 1.0f;
            break;
        case 3:
            base = 3.0f;
            break;
        case 4:
            base = 0.5f;
            break;
        default:
            return 0f;
        }

        float f1 = par1World.getBiomeGenForCoords(par2, par4).temperature;
        float f2 = par1World.getBiomeGenForCoords(par2, par4).rainfall;
        float f3 = Scalables.TEA_GROWTH_FACTOR / 100F;

        return base * f1 * f2 * f3;
    }

    @Override
    public void fertilize(World par1World, int par2, int par3, int par4) {
        int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

        if (l == 3) {
            l++;
        }

        if (l > 5) {
            l = 5;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 3);
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return blockID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 > 5) {
            par2 = 5;
        }

        if (par2 == 3) {
            switch (par1) {
            case 1:
                return iconArray[6];
            case 0:
                return iconArray[2];
            default:
                return iconArray[3];
            }
        }

        return iconArray[par2];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        iconArray = new Icon[8];

        for (int i = 0; i < 6; ++i) {
            iconArray[i] = par1IconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(),
                    getUnwrappedUnlocalizedName(getUnlocalizedName()) + "_stage_" + i));
        }

        iconArray[6] = par1IconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(),
                getUnwrappedUnlocalizedName(getUnlocalizedName()) + "_stage_3_top"));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {

        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public int getRenderType() {
        return 0;
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer,
            int par6, float par7, float par8, float par9) {
        if (par1World.isRemote)
            return false;

        if (par5EntityPlayer.getCurrentEquippedItem() != null)
            return false;

        int l = par1World.getBlockMetadata(par2, par3, par4);

        if (l <= 2)
            return false;
        else if (l == 3) {
            EntityItem entityitem = new EntityItem(par1World, par5EntityPlayer.posX, par5EntityPlayer.posY - 1.0D,
                    par5EntityPlayer.posZ, new ItemStack(ModItems.teaWhite.itemID, 2, 0));
            par1World.spawnEntityInWorld(entityitem);
        } else if (l == 4) {
            EntityItem entityitem = new EntityItem(par1World, par5EntityPlayer.posX, par5EntityPlayer.posY - 1.0D,
                    par5EntityPlayer.posZ, new ItemStack(ModItems.teaGreen.itemID, 4, 0));
            par1World.spawnEntityInWorld(entityitem);
        } else if (l <= 5) {
            EntityItem entityitem = new EntityItem(par1World, par5EntityPlayer.posX, par5EntityPlayer.posY - 1.0D,
                    par5EntityPlayer.posZ, new ItemStack(ModItems.teaGreen.itemID, 3, 0));
            par1World.spawnEntityInWorld(entityitem);
        }
        par1World.setBlock(par2, par3, par4, blockID, 2, 3);
        return true;
    }

    @Override
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
        if (par1World.isRemote)
            return;

        if (par5EntityPlayer.getCurrentEquippedItem() != null)
            return;

        int l = par1World.getBlockMetadata(par2, par3, par4);

        if (l <= 2)
            return;
        else if (l == 3) {
            EntityItem entityitem = new EntityItem(par1World, par5EntityPlayer.posX, par5EntityPlayer.posY - 1.0D,
                    par5EntityPlayer.posZ, new ItemStack(ModItems.teaWhite.itemID, 2, 0));
            par1World.spawnEntityInWorld(entityitem);
        } else if (l == 4) {
            EntityItem entityitem = new EntityItem(par1World, par5EntityPlayer.posX, par5EntityPlayer.posY - 1.0D,
                    par5EntityPlayer.posZ, new ItemStack(ModItems.teaGreen.itemID, 4, 0));
            par1World.spawnEntityInWorld(entityitem);
        } else if (l <= 5) {
            EntityItem entityitem = new EntityItem(par1World, par5EntityPlayer.posX, par5EntityPlayer.posY - 1.0D,
                    par5EntityPlayer.posZ, new ItemStack(ModItems.teaGreen.itemID, 3, 0));
            par1World.spawnEntityInWorld(entityitem);
        }
        par1World.setBlock(par2, par3, par4, blockID, 2, 3);
        return;
    }

    @Override
    public int damageDropped(int metadata) {
        return 0;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z);
        if (l < 1)
            return AxisAlignedBB.getBoundingBox(x + 0.25D, y, z + 0.25D, x + 0.75D, y + 0.5D, z + 0.75D);
        else if (l < 2)
            return AxisAlignedBB.getBoundingBox(x + 0.125D, y, z + 0.125D, x + 0.875D, y + 0.75D, z + 0.875D);
        else
            return AxisAlignedBB.getBoundingBox(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z);
        if (l < 1)
            return AxisAlignedBB.getBoundingBox(x + 0.25D, y, z + 0.25D, x + 0.75D, y + 0.5D, z + 0.75D);
        else if (l < 2)
            return AxisAlignedBB.getBoundingBox(x + 0.125D, y, z + 0.125D, x + 0.875D, y + 0.75D, z + 0.875D);
        else
            return AxisAlignedBB.getBoundingBox(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int x, int y, int z) {
        int md = iblockaccess.getBlockMetadata(x, y, z);

        float minX;
        float minY = 0F;
        float minZ;
        float maxX;
        float maxY;
        float maxZ;

        if (md < 1) {
            minX = minZ = 0.25F;
            maxX = maxZ = 0.75F;
            maxY = 0.5F;
        } else

        if (md < 2) {
            minX = minZ = 0.125F;
            maxX = maxZ = 0.875F;
            maxY = 0.75F;
        }

        else {
            minX = minZ = 0.0F;
            maxX = maxZ = 1.0F;
            maxY = 1.0F;
        }
        setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z) {
        return EnumPlantType.Plains;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z) {
        return blockID;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z) {
        return world.getBlockMetadata(x, y, z);
    }

}
