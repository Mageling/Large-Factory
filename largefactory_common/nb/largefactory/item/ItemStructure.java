package nb.largefactory.item;

import nb.largefactory.block.ModBlocks;
import nb.largefactory.structure.component.ComponentFactory;
import nb.largefactory.tileentity.TileEntityStructure;
import nb.largefactory.tileentity.TileEntityStructureCasing;
import nb.largefactory.tileentity.TileEntityStructureControl;
import nb.largefactory.tileentity.TileEntityStructureInner;
import nb.largefactory.tileentity.TileEntityStructureMultiblock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemStructure extends ItemReedLargeFactory {

	public ItemStructure(int id) {
		super(id, ModBlocks.structureComponent);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4,
			int par5, int par6, int par7, float par8, float par9, float par10) {
		if (super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10)) {
			par3World.removeBlockTileEntity(par4, par5, par6);
			par3World.setBlockTileEntity(par4, par5, par6, getTileEntity(par1ItemStack));
			return true;
		}
		return false;
	}

	private TileEntityStructure getTileEntity(ItemStack itemStack) {
		NBTTagCompound nbtTagCompound = itemStack.getTagCompound();
		String type = ComponentFactory.componentList.get(nbtTagCompound.getString("Component Name")).getType();
		switch (type) {
		case "control":
			return new TileEntityStructureControl(nbtTagCompound.getString("Component Name"));
		case "casing":
			return new TileEntityStructureCasing("casing");
		case "inner":
			return new TileEntityStructureInner(nbtTagCompound.getString("Component Name"));
		case "multinner":
			return new TileEntityStructureMultiblock(nbtTagCompound.getString("Component Name"));
		default:
			return null;

		}
	}
}
