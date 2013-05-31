package nb.largefactory.block;

import nb.largefactory.lib.BlockIDs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockLargeFactory {

    public static BlockSaltCondenser saltCondenser = new BlockSaltCondenser(
            BlockIDs.SALT_CONDENSER_ID);

    public static void registerBlocks() {
        GameRegistry.registerBlock(saltCondenser, "saltCondenser");
        LanguageRegistry.addName(saltCondenser, "Salt Condenser");
    }

}
