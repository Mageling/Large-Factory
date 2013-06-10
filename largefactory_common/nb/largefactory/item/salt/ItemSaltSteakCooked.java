package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltSteakCooked extends ItemFoodLargeFactory {

    public ItemSaltSteakCooked(int id) {
        super(id, 9, 0.8f, true);
        this.setUnlocalizedName(Strings.SALT_STEAK_COOKED_NAME);
        this.setCreativeTab(CreativeTabs.tabFood);

    }

}
