package nb.largefactory.block;

import nb.largefactory.lib.BlockIDs;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    public static Block saltCondenser;
    public static Block structureComponent;

    public static void registerBlocks() {
        saltCondenser = new BlockSaltCondenser(BlockIDs.SALT_CONDENSER_ID);
        GameRegistry.registerBlock(saltCondenser, "saltCondenser");
        LanguageRegistry.addName(saltCondenser, "Salt Condenser");
    }

}
