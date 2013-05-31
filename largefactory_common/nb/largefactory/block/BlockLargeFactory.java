package nb.largefactory.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockLargeFactory {

    static int saltCondenserId = 7670;

    public static BlockSaltCondenser saltCondenser = new BlockSaltCondenser(
            saltCondenserId);

    public static void registerBlocks() {
        GameRegistry.registerBlock(saltCondenser, "saltCondenser");
        LanguageRegistry.addName(saltCondenser, "Salt Condenser");
    }

}
