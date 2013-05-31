package nb.largefactory.item;

import nb.largefactory.item.salt.ItemSalt;
import nb.largefactory.item.salt.ItemSaltChickenCooked;
import nb.largefactory.item.salt.ItemSaltChickenRaw;
import nb.largefactory.item.salt.ItemSaltFishCooked;
import nb.largefactory.item.salt.ItemSaltFishRaw;
import nb.largefactory.item.salt.ItemSaltFlesh;
import nb.largefactory.item.salt.ItemSaltPorkCooked;
import nb.largefactory.item.salt.ItemSaltPorkRaw;
import nb.largefactory.item.salt.ItemSaltSteakCooked;
import nb.largefactory.item.salt.ItemSaltSteakRaw;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

    static int saltId = 7770;
    static int saltFleshId = 7771;
    static int saltPorkRawId = 7772;
    static int saltPorkCookedId = 7773;
    static int saltSteakRawId = 7774;
    static int saltSteakCookedId = 7775;
    static int saltChickenRawId = 7776;
    static int saltChickenCookedId = 7777;
    static int saltFishRawId = 7778;
    static int saltFishCookedId = 7779;

    public static Item salt;
    public static Item saltFlesh;
    public static Item saltPorkRaw;
    public static Item saltPorkCooked;
    public static Item saltSteakRaw;
    public static Item saltSteakCooked;
    public static Item saltChickenRaw;
    public static Item saltChickenCooked;
    public static Item saltFishRaw;
    public static Item saltFishCooked;

    public static void registerItems() {
        salt = new ItemSalt(saltId);
        LanguageRegistry.addName(salt, "Salt");

        saltChickenRaw = new ItemSaltChickenRaw(saltChickenRawId);
        LanguageRegistry.addName(saltChickenRaw, "Salted Raw Chicken");

        saltChickenCooked = new ItemSaltChickenCooked(saltChickenCookedId);
        LanguageRegistry.addName(saltChickenCooked, "Salted Chicken");

        saltFlesh = new ItemSaltFlesh(saltFleshId);
        LanguageRegistry.addName(saltFlesh, "Salted Flesh");

        saltPorkRaw = new ItemSaltPorkRaw(saltPorkRawId);
        LanguageRegistry.addName(saltPorkRaw, "Salted Raw Pork");

        saltPorkCooked = new ItemSaltPorkCooked(saltPorkCookedId);
        LanguageRegistry.addName(saltPorkCooked, "Salted Porkchop");

        saltSteakRaw = new ItemSaltSteakRaw(saltSteakRawId);
        LanguageRegistry.addName(saltSteakRaw, "Salted Raw Steak");

        saltSteakCooked = new ItemSaltSteakCooked(saltSteakCookedId);
        LanguageRegistry.addName(saltSteakCooked, "Salted Steak");

        saltFishRaw = new ItemSaltFishRaw(saltFishRawId);
        LanguageRegistry.addName(saltFishRaw, "Salted Raw Fish");

        saltFishCooked = new ItemSaltFishCooked(saltFishCookedId);
        LanguageRegistry.addName(saltFishCooked, "Salted Fish");
    }

}
