package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltChickenCooked extends ItemFoodLargeFactory {

    public ItemSaltChickenCooked(int id) {
        super(id, 7, 0.6f, true);
        this.setUnlocalizedName(Strings.SALT_CHICKEN_COOKED_NAME);
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
