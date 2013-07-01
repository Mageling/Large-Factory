package nb.largefactory.item;

import nb.largefactory.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemReed;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemReedLargeFactory extends ItemReed {

    public ItemReedLargeFactory(int id, Block par2Block) {
        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION, par2Block);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

}
