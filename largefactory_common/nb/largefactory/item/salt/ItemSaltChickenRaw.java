package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltChickenRaw extends ItemFoodLargeFactory {

    public ItemSaltChickenRaw(int id) {
        super(id, 3, 0.3f, true);
        setUnlocalizedName(Strings.SALT_CHICKEN_RAW_NAME);
        setCreativeTab(CreativeTabs.tabFood);
    }

}
