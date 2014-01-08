package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltFishCooked extends ItemFoodLargeFactory {

    public ItemSaltFishCooked(int id) {
        super(id, 6, 0.6F, false);
        setUnlocalizedName(Strings.SALT_FISH_COOKED_NAME);
        setCreativeTab(CreativeTabs.tabFood);
    }

}
