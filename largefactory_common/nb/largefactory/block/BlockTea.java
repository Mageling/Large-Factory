package nb.largefactory.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTea extends BlockFlower {

    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public BlockTea(int id) {
        super(id);
        setTickRandomly(true);
        setCreativeTab((CreativeTabs)null);
        setHardness(0.0F);
        setStepSound(soundGrassFootstep);
        disableStats();
    }

    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.tilledField.blockID;
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l < 7)
            {
                float f = getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(25.0F / f) + 1) == 0)
                {
                    ++l;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                }
            }
        }
    }

    public float getGrowthRate(World par1World, int par2, int par3, int par4) {
        return 1.0F;
        //TODO Growth rate code
    }

    public void fertilize(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

        if(l==3) {
            l++;
        }

        if (l > 5)
        {
            l = 5;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > 5)
        {
            par2 = 5;
        }

        return iconArray[par2];
    }

    @Override
    public int getRenderType()
    {
        return 6;
    }

    @Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        int l = par1World.getBlockMetadata(par2, par3, par4);

        if (l <= 2)
            return false;
        else if (l == 3) {
            //TODO entity drop code
        } else if (l == 4) {

        } else if (l <= 5) {

        }
        return true;
    }

    public boolean onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        return onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        iconArray = new Icon[8];

        for (int i = 0; i < iconArray.length; ++i)
        {
            iconArray[i] = par1IconRegister.registerIcon(getTextureName() + "_stage_" + i);
        }
    }

}
