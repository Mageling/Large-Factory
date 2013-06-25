package nb.largefactory.item.salt;

import nb.largefactory.item.ItemLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltChunk extends ItemLargeFactory {

    public ItemSaltChunk(int id) {
        super(id);
        this.setUnlocalizedName(Strings.SALT_CHUNK_NAME);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

}
