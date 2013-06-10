package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltSteakRaw extends ItemFoodLargeFactory {

    public ItemSaltSteakRaw(int id) {
        super(id, 4, 0.3F, true);
        this.setUnlocalizedName(Strings.SALT_STEAK_RAW_NAME);
        this.setCreativeTab(CreativeTabs.tabFood);
    }

}
