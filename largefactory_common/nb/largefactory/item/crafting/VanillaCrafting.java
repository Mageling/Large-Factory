package nb.largefactory.item.crafting;

import nb.largefactory.block.ModBlocks;
import nb.largefactory.item.ModItems;
import nb.largefactory.util.CraftingHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class VanillaCrafting {

    public static void registerVanillaCrafting() {
        CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.saltPorkRaw, 1), new Object[] { "salt",
                Item.porkRaw });
        CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.saltSteakRaw, 1), new Object[] { "salt",
                Item.beefRaw });
        CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.saltChickenRaw, 1), new Object[] { "salt",
                Item.chickenRaw });
        CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.saltFishRaw, 1), new Object[] { "salt",
                Item.fishRaw });
        CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.saltFlesh, 1), new Object[] { "salt",
                ModItems.salt, Item.rottenFlesh });
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltCondenser, 1), new Object[] { "G G", "PBP", "PCP", 'G',
                Block.glass, 'P', Block.planks, 'B', Item.bucketEmpty, 'C', Block.chest });
        CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.saltChunk), new Object[] { "salt", "salt", "salt",
                "salt", "salt", "salt", "salt", "salt" });
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.saltBlock), new Object[] { ModItems.saltChunk,
                ModItems.saltChunk, ModItems.saltChunk, ModItems.saltChunk, ModItems.saltChunk, ModItems.saltChunk,
                ModItems.saltChunk, ModItems.saltChunk });
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltChunk, 8), ModBlocks.saltBlock);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 8), ModItems.saltChunk);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.basketTeaWhite), Item.bowlEmpty, ModItems.teaWhite,
                ModItems.teaWhite, ModItems.teaWhite, ModItems.teaWhite, ModItems.teaWhite, ModItems.teaWhite,
                ModItems.teaWhite, ModItems.teaWhite);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.basketTeaGreen), Item.bowlEmpty, ModItems.teaGreen,
                ModItems.teaGreen, ModItems.teaGreen, ModItems.teaGreen, ModItems.teaGreen, ModItems.teaGreen,
                ModItems.teaGreen, ModItems.teaGreen);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.basketTeaBlack), Item.bowlEmpty, ModItems.teaBlack,
                ModItems.teaBlack, ModItems.teaBlack, ModItems.teaBlack, ModItems.teaBlack, ModItems.teaBlack,
                ModItems.teaBlack, ModItems.teaBlack);

    }

    public static void registerVanillaSmelting() {
        GameRegistry.addSmelting(ModItems.saltPorkRaw.itemID, new ItemStack(ModItems.saltPorkCooked, 1), 0.35F);
        GameRegistry.addSmelting(ModItems.saltSteakRaw.itemID, new ItemStack(ModItems.saltSteakCooked, 1), 0.35F);
        GameRegistry.addSmelting(ModItems.saltChickenRaw.itemID, new ItemStack(ModItems.saltChickenCooked, 1), 0.35F);
        GameRegistry.addSmelting(ModItems.saltFishRaw.itemID, new ItemStack(ModItems.saltFishCooked, 1), 0.35F);
        GameRegistry.addSmelting(ModItems.teaGreen.itemID, new ItemStack(ModItems.teaBlack, 1), 0.35F);
        GameRegistry.addSmelting(ModItems.basketTeaGreen.itemID, new ItemStack(ModItems.teaBlack, 8), 0.7F);
    }

}
