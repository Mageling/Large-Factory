package nb.largefactory.item.salt;

import nb.largefactory.item.ItemLargeFactory;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSalt extends ItemLargeFactory {

    public ItemSalt(int id) {
        super(id);
        this.setUnlocalizedName("salt");
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

}
