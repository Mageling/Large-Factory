package nb.largefactory.item;

import nb.largefactory.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoodLargeFactory extends ItemFood {

    public ItemFoodLargeFactory(int id, int hunger, float saturationModifier, boolean dogFood) {
        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION, hunger, saturationModifier, dogFood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
