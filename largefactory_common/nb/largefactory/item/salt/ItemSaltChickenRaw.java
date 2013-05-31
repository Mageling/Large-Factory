package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltChickenRaw extends ItemFoodLargeFactory {

    public ItemSaltChickenRaw(int id) {
        super(id, 3, 0.3f, true);
        this.setUnlocalizedName("saltChickenRaw");
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
