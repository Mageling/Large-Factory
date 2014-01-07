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

	public static void registerBlocks() {
		saltCondenser = new BlockSaltCondenser(BlockIDs.SALT_CONDENSER);
		GameRegistry.registerBlock(saltCondenser, Strings.SALT_CONDENSER_NAME);
		LanguageRegistry.addName(saltCondenser, "Salt Condenser");

		saltBlock = new BlockSalt(BlockIDs.SALT_BLOCK);
		GameRegistry.registerBlock(saltBlock, Strings.SALT_BLOCK_NAME);
		LanguageRegistry.addName(saltBlock, "Salt Block");

		structureComponent = new BlockStructure(BlockIDs.STRUCTURE_BLOCK);
		GameRegistry.registerBlock(structureComponent, Strings.STRUCTURE_BLOCK_NAME);
		LanguageRegistry.addName(structureComponent, "Structure Component");
	}

}
