package nb.largefactory.item;

import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTeaWhite extends ItemLargeFactory {

    public ItemTeaWhite(int id) {
        super(id);
        setUnlocalizedName(Strings.WHITE_TEA_NAME);
        setCreativeTab(CreativeTabs.tabMisc);
    }

}
