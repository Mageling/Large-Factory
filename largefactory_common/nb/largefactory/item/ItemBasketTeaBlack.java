package nb.largefactory.item;

import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBasketTeaBlack extends ItemLargeFactory {

    public ItemBasketTeaBlack(int id) {
        super(id);
        setUnlocalizedName(Strings.BLACK_TEA_BASKET_NAME);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

        if (par3EntityPlayer.isSneaking()) {
            if (!par2World.isRemote) {
                EntityItem bowl = new EntityItem(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY - 1.0D,
                        par3EntityPlayer.posZ, new ItemStack(Item.bowlEmpty, 1, 0));
                EntityItem tea = new EntityItem(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY - 1.0D,
                        par3EntityPlayer.posZ, new ItemStack(ModItems.teaBlack, 8, 0));
                par2World.spawnEntityInWorld(bowl);
                par2World.spawnEntityInWorld(tea);
            }
            return par1ItemStack.splitStack(par1ItemStack.stackSize - 1);
        }
        return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
    }

}
