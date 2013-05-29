package nb.largefactory.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemLargeFactory {
    static int saltId = 7770;
    static int saltFleshId = 7771;
    static int saltPorkRawId = 7772;
    static int saltPorkCookedId = 7773;
    static int saltSteakRawId = 7774;
    static int saltSteakCookedId = 7775;
    static int saltChickenRawId = 7776;
    static int saltChickenCookedId = 7777;

    public static Item salt = new Item(saltId).setUnlocalizedName("salt")
            .setCreativeTab(CreativeTabs.tabFood);
    public static Item saltFlesh = new ItemFood(saltFleshId, 5, 0.2f, true)
            .setUnlocalizedName("saltFlesh").setCreativeTab(
                    CreativeTabs.tabFood);
    public static Item saltPorkRaw = new ItemFood(saltPorkRawId, 4, 0.3f, true)
            .setUnlocalizedName("saltPorkRaw").setCreativeTab(
                    CreativeTabs.tabFood);
    public static Item saltPorkCooked = new ItemFood(saltPorkCookedId, 9, 0.8f,
            true).setUnlocalizedName("saltPorkCooked").setCreativeTab(
            CreativeTabs.tabFood);
    public static Item saltSteakRaw = new ItemFood(saltSteakRawId, 4, 0.3f,
            true).setUnlocalizedName("saltSteakRaw").setCreativeTab(
            CreativeTabs.tabFood);
    public static Item saltSteakCooked = new ItemFood(saltSteakCookedId, 9,
            0.8f, true).setUnlocalizedName("saltSteakCooked").setCreativeTab(
            CreativeTabs.tabFood);
    public static Item saltChickenRaw = new ItemFood(saltChickenRawId, 3, 0.3f,
            true).setUnlocalizedName("saltChickenRaw").setCreativeTab(
            CreativeTabs.tabFood);
    public static Item saltChickenCooked = new ItemFood(saltChickenCookedId, 7,
            0.6f, true).setUnlocalizedName("saltChickenCooked").setCreativeTab(
            CreativeTabs.tabFood);

    public static void registerItems() {
        GameRegistry.registerItem(salt, "salt");
        LanguageRegistry.addName(salt, "Salt");

        GameRegistry.registerItem(saltChickenRaw, "saltChickenRaw");
        LanguageRegistry.addName(saltChickenRaw, "Salted Raw Chicken");

        GameRegistry.registerItem(saltChickenCooked, "saltChickenCooked");
        LanguageRegistry.addName(saltChickenCooked, "Salted Chicken");

        GameRegistry.registerItem(saltFlesh, "saltFlesh");
        LanguageRegistry.addName(saltFlesh, "Salted Flesh");

        GameRegistry.registerItem(saltPorkRaw, "saltPorkRaw");
        LanguageRegistry.addName(saltPorkRaw, "Salted Raw Pork");

        GameRegistry.registerItem(saltPorkCooked, "saltPorkCooked");
        LanguageRegistry.addName(saltPorkCooked, "Salted Porkchop");

        GameRegistry.registerItem(saltSteakRaw, "saltSteakRaw");
        LanguageRegistry.addName(saltSteakRaw, "Salted Raw Steak");

        GameRegistry.registerItem(saltSteakCooked, "saltSteakCooked");
        LanguageRegistry.addName(saltSteakCooked, "Salted Steak");
    }

}
