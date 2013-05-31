package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltFlesh extends ItemFoodLargeFactory {

    public ItemSaltFlesh(int id) {
        super(id, 5, 0.2F, true);
        this.setUnlocalizedName("saltFlesh");
        this.setCreativeTab(CreativeTabs.tabFood);

    }

}
