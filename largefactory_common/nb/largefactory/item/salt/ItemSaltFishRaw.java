package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltFishRaw extends ItemFoodLargeFactory {

	public ItemSaltFishRaw(int id) {
		super(id, 3, 0.3F, false);
		setUnlocalizedName(Strings.SALT_FISH_RAW_NAME);
		setCreativeTab(CreativeTabs.tabFood);
	}

}
