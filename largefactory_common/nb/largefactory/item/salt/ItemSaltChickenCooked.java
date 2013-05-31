package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltChickenCooked extends ItemFoodLargeFactory {

    public ItemSaltChickenCooked(int id) {
        super(id, 7, 0.6f, true);
        this.setUnlocalizedName("saltChickenCooked");
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
