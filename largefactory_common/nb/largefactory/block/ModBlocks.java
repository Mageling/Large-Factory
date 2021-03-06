package nb.largefactory.block;

import nb.largefactory.lib.BlockIDs;
import nb.largefactory.lib.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    public static Block saltCondenser;
    public static Block saltBlock;
    public static Block structureComponent;
    public static Block teaPlant;

    public static void registerBlocks() {
        saltCondenser = new BlockSaltCondenser();
        GameRegistry.registerBlock(saltCondenser, Strings.SALT_CONDENSER_NAME);
        LanguageRegistry.addName(saltCondenser, "Salt Condenser");

        saltBlock = new BlockSalt();
        GameRegistry.registerBlock(saltBlock, Strings.SALT_BLOCK_NAME);
        LanguageRegistry.addName(saltBlock, "Salt Block");

        structureComponent = new BlockStructure();
        GameRegistry.registerBlock(structureComponent, Strings.STRUCTURE_BLOCK_NAME);
        LanguageRegistry.addName(structureComponent, "Structure Component");

        teaPlant = new BlockTea();
        GameRegistry.registerBlock(teaPlant, Strings.TEA_PLANT_NAME);
        LanguageRegistry.addName(teaPlant, "Tea Plant");
    }

}
