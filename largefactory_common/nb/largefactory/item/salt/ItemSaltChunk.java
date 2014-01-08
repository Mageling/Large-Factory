package nb.largefactory.item.salt;

import nb.largefactory.item.ItemLargeFactory;
import nb.largefactory.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSaltChunk extends ItemLargeFactory {

    public ItemSaltChunk(int id) {
        super(id);
        setUnlocalizedName(Strings.SALT_CHUNK_NAME);
        setCreativeTab(CreativeTabs.tabMaterials);
    }

}
