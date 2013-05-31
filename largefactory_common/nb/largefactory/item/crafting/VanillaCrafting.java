package nb.largefactory.item.crafting;

import nb.largefactory.block.BlockLargeFactory;
import nb.largefactory.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class VanillaCrafting {

    public static void registerVanillaCrafting() {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPorkRaw, 1),
                new Object[] { ModItems.salt, Item.porkRaw });
        GameRegistry.addShapelessRecipe(
                new ItemStack(ModItems.saltSteakRaw, 1), new Object[] {
                        ModItems.salt, Item.beefRaw });
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltChickenRaw,
                1), new Object[] { ModItems.salt, Item.chickenRaw });
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishRaw, 1),
                new Object[] { ModItems.salt, Item.fishRaw });
        GameRegistry
                .addShapelessRecipe(new ItemStack(ModItems.saltFlesh, 1),
                        new Object[] { ModItems.salt, ModItems.salt,
                                Item.rottenFlesh });
        GameRegistry
                .addRecipe(new ItemStack(BlockLargeFactory.saltCondenser, 1),
                        new Object[] { "G G", "PBP", "PCP", 'G', Block.glass,
                                'P', Block.planks, 'B', Item.bucketEmpty, 'C',
                                Block.chest });

    }

    public static void registerVanillaSmelting() {
        GameRegistry.addSmelting(ModItems.saltPorkRaw.itemID, new ItemStack(
                ModItems.saltPorkCooked, 1), 0.35F);
        GameRegistry.addSmelting(ModItems.saltSteakRaw.itemID, new ItemStack(
                ModItems.saltSteakCooked, 1), 0.35F);
        GameRegistry.addSmelting(ModItems.saltChickenRaw.itemID, new ItemStack(
                ModItems.saltChickenCooked, 1), 0.35F);
        GameRegistry.addSmelting(ModItems.saltFishRaw.itemID, new ItemStack(
                ModItems.saltFishCooked, 1), 0.35F);
    }

}
