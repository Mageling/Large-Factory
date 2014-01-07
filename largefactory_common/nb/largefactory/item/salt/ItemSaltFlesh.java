package nb.largefactory.item.salt;

import nb.largefactory.item.ItemFoodLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltFlesh extends ItemFoodLargeFactory {

	public ItemSaltFlesh(int id) {
		super(id, 5, 0.2F, true);
		setUnlocalizedName(Strings.SALT_FLESH_NAME);
		setCreativeTab(CreativeTabs.tabFood);

	}

}
