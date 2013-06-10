package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltPorkCooked extends ItemFoodLargeFactory {

    public ItemSaltPorkCooked(int id) {
        super(id, 9, 0.8f, true);
        this.setUnlocalizedName(Strings.SALT_PORK_COOKED_NAME);
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
