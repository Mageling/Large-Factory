package nb.largefactory.item;

import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTeaGreen extends ItemLargeFactory {
    
    public ItemTeaGreen(int id) {
        super(id);
        setUnlocalizedName(Strings.GREEN_TEA_NAME);
        setCreativeTab(CreativeTabs.tabMisc);
    }

}
