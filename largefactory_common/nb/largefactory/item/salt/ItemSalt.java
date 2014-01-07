package nb.largefactory.item.salt;

import nb.largefactory.item.ItemLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSalt extends ItemLargeFactory {

	public ItemSalt(int id) {
		super(id);
		setUnlocalizedName(Strings.SALT_NAME);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

}
