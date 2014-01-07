package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltPorkRaw extends ItemFoodLargeFactory {

	public ItemSaltPorkRaw(int id) {
		super(id, 4, 0.3f, true);
		setUnlocalizedName(Strings.SALT_PORK_RAW_NAME);
		setCreativeTab(CreativeTabs.tabFood);
	}

}
