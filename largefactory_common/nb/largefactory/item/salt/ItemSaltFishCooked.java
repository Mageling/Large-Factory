package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltFishCooked extends ItemFoodLargeFactory {

    public ItemSaltFishCooked(int id) {
        super(id, 6, 0.6F, false);
        this.setUnlocalizedName("saltFishCooked");
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
