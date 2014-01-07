package nb.largefactory.block;

import nb.largefactory.lib.Strings;
import nb.largefactory.tileentity.TileEntityStructureCasing;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStructure extends BlockContainerLargeFactory {

	public BlockStructure(int id) {
		super(id, Material.iron);
		setUnlocalizedName(Strings.STRUCTURE_BLOCK_NAME);
		setHardness(5F);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityStructureCasing("casing");
	}

}
