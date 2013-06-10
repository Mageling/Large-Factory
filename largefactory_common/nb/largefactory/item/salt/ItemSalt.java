package nb.largefactory.item.salt;

import nb.largefactory.item.ItemLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSalt extends ItemLargeFactory {

    public ItemSalt(int id) {
        super(id);
        this.setUnlocalizedName(Strings.SALT_NAME);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

}
