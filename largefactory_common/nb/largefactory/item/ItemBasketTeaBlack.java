package nb.largefactory.item;

import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemBasketTeaBlack extends ItemLargeFactory {

    public ItemBasketTeaBlack(int id) {
        super(id);
        setUnlocalizedName(Strings.BLACK_TEA_BASKET_NAME);
        setCreativeTab(CreativeTabs.tabMisc);
    }

}
