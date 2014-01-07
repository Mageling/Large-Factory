package nb.largefactory.block;

import nb.largefactory.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSalt extends BlockLargeFactory {

	public BlockSalt(int id) {
		super(id, Material.rock);
		setUnlocalizedName(Strings.SALT_BLOCK_NAME);
		setHardness(1.5F);
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
