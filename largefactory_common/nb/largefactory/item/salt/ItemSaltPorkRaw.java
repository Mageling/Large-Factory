package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltPorkRaw extends ItemFoodLargeFactory {

    public ItemSaltPorkRaw(int id) {
        super(id, 4, 0.3f, true);
        this.setUnlocalizedName("saltPorkRaw");
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
