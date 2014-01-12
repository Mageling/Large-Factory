package nb.largefactory.item;

import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTeaBlack extends ItemLargeFactory {
    
    public ItemTeaBlack(int id) {
        super(id);
        setUnlocalizedName(Strings.BLACK_TEA_NAME);
        setCreativeTab(CreativeTabs.tabMisc);
    }

}
