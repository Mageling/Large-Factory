package nb.largefactory.item.crafting;

import nb.largefactory.item.ItemLargeFactory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class VanillaCrafting {

    public static void registerVanillaCrafting() {
        GameRegistry.addShapelessRecipe(new ItemStack(
                ItemLargeFactory.saltPorkRaw, 1), new Object[] {
                ItemLargeFactory.salt, Item.porkRaw });
        GameRegistry.addShapelessRecipe(new ItemStack(
                ItemLargeFactory.saltSteakRaw, 1), new Object[] {
                ItemLargeFactory.salt, Item.beefRaw });
        GameRegistry.addShapelessRecipe(new ItemStack(
                ItemLargeFactory.saltChickenRaw, 1), new Object[] {
                ItemLargeFactory.salt, Item.chickenRaw });
        GameRegistry.addShapelessRecipe(new ItemStack(
                ItemLargeFactory.saltFlesh, 1),
                new Object[] { ItemLargeFactory.salt, ItemLargeFactory.salt,
                        Item.rottenFlesh });
    }

    public static void registerVanillaSmelting() {
        GameRegistry.addSmelting(ItemLargeFactory.saltPorkRaw.itemID,
                new ItemStack(ItemLargeFactory.saltPorkCooked, 1), 0.35F);
        GameRegistry.addSmelting(ItemLargeFactory.saltSteakRaw.itemID,
                new ItemStack(ItemLargeFactory.saltSteakCooked, 1), 0.35F);
        GameRegistry.addSmelting(ItemLargeFactory.saltChickenRaw.itemID,
                new ItemStack(ItemLargeFactory.saltChickenCooked, 1), 0.35F);
    }

}
