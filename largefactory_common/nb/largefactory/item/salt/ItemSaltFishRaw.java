package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltFishRaw extends ItemFoodLargeFactory {

    public ItemSaltFishRaw(int id) {
        super(id, 3, 0.3F, false);
        this.setUnlocalizedName("saltFishRaw");
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
