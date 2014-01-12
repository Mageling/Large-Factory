package nb.largefactory.item;

import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemBasketTeaWhite extends ItemLargeFactory {
    
    public ItemBasketTeaWhite(int id) {
        super(id);
        setUnlocalizedName(Strings.WHITE_TEA_BASKET_NAME);
        setCreativeTab(CreativeTabs.tabMisc);
    }

}
