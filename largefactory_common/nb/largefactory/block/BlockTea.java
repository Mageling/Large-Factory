package nb.largefactory.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTea extends BlockFlower implements IPlantable {

    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public BlockTea(int id) {
        super(id);
        setTickRandomly(true);
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(0.3F);
        setStepSound(soundGrassFootstep);
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l < 7) {
                float f = getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int) (25.0F / f) + 1) == 0) {
                    ++l;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                }
            }
        }
    }

    public float getGrowthRate(World par1World, int par2, int par3, int par4) {
        return 1.0F;
        // TODO Growth rate code
    }

    public void fertilize(World par1World, int par2, int par3, int par4) {
        int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

        if (l == 3) {
            l++;
        }

        if (l > 5) {
            l = 5;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 > 5) {
            par2 = 5;
        }

        return iconArray[par2];
    }
    
@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        iconArray = new Icon[6];

        for (int i = 0; i < iconArray.length; ++i) {
            iconArray[i] = par1IconRegister.registerIcon(getTextureName() + "_stage_" + i);
        }
    }

    

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer,
            int par6, float par7, float par8, float par9) {
        int l = par1World.getBlockMetadata(par2, par3, par4);

        if (l <= 2)
            return false;
        else if (l == 3) {
            // TODO entity drop code
        } else if (l == 4) {

        } else if (l <= 5) {

        }
        par1World.setBlock(par2, par3, par4, blockID, 2,3);
        return true;
    }

    public boolean onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer,
            int par6, float par7, float par8, float par9) {
        return onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    }
    
    @Override
    public int damageDropped (int metadata)
    {
        return 0;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool (World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        if (l < 1)
        {
            return AxisAlignedBB.getBoundingBox((double) x + 0.25D, y, (double) z + 0.25D, (double) x + 0.75D, (double) y + 0.5D, (double) z + 0.75D);
        }
        else if (l < 2)
        {
            return AxisAlignedBB.getBoundingBox((double) x + 0.125D, y, (double) z + 0.125D, (double) x + 0.875D, (double) y + 0.75D, (double) z + 0.875D);
        }
        else
        {
            return AxisAlignedBB.getBoundingBox(x, y, z, (double) x + 1.0D, (double) y + 1.0D, (double) z + 1.0D);
        }
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool (World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        if (l < 1)
        {
            return AxisAlignedBB.getBoundingBox((double) x + 0.25D, y, (double) z + 0.25D, (double) x + 0.75D, (double) y + 0.5D, (double) z + 0.75D);
        }
        else if (l < 2)
        {
            return AxisAlignedBB.getBoundingBox((double) x + 0.125D, y, (double) z + 0.125D, (double) x + 0.875D, (double) y + 0.75D, (double) z + 0.875D);
        }
        else
        {
            return AxisAlignedBB.getBoundingBox(x, y, z, (double) x + 1.0D, (double) y + 1.0D, (double) z + 1.0D);
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState (IBlockAccess iblockaccess, int x, int y, int z)
    {
        int md = iblockaccess.getBlockMetadata(x, y, z);

        float minX;
        float minY = 0F;
        float minZ;
        float maxX;
        float maxY;
        float maxZ;

        if (md < 1)
        {
            minX = minZ = 0.25F;
            maxX = maxZ = 0.75F;
            maxY = 0.5F;
        }
        else

        if (md < 2)
        {
            minX = minZ = 0.125F;
            maxX = maxZ = 0.875F;
            maxY = 0.75F;
        }

        else
        {
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
