package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltSteakRaw extends ItemFoodLargeFactory {

    public ItemSaltSteakRaw(int id) {
        super(id, 4, 0.3F, true);
        this.setUnlocalizedName("saltSteakRaw");
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
