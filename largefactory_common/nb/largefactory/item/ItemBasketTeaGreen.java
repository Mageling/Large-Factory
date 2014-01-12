package nb.largefactory.item;

import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemBasketTeaGreen extends ItemLargeFactory {

    public ItemBasketTeaGreen(int id) {
        super(id);
        setUnlocalizedName(Strings.GREEN_TEA_BASKET_NAME);
        setCreativeTab(CreativeTabs.tabMisc);
    }

}
