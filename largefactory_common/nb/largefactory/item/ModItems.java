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
import nb.largefactory.lib.ItemIDs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

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
        salt = new ItemSalt(ItemIDs.SALT);
        LanguageRegistry.addName(salt, "Salt");

        saltChickenRaw = new ItemSaltChickenRaw(ItemIDs.SALT_CHICKEN_RAW);
        LanguageRegistry.addName(saltChickenRaw, "Salted Raw Chicken");

        saltChickenCooked = new ItemSaltChickenCooked(ItemIDs.SALT_CHICKEN_COOKED);
        LanguageRegistry.addName(saltChickenCooked, "Salted Chicken");

        saltFlesh = new ItemSaltFlesh(ItemIDs.SALT_FLESH);
        LanguageRegistry.addName(saltFlesh, "Salted Flesh");

        saltPorkRaw = new ItemSaltPorkRaw(ItemIDs.SALT_PORK_RAW);
        LanguageRegistry.addName(saltPorkRaw, "Salted Raw Pork");

        saltPorkCooked = new ItemSaltPorkCooked(ItemIDs.SALT_PORK_COOKED);
        LanguageRegistry.addName(saltPorkCooked, "Salted Porkchop");

        saltSteakRaw = new ItemSaltSteakRaw(ItemIDs.SALT_STEAK_RAW);
        LanguageRegistry.addName(saltSteakRaw, "Salted Raw Steak");

        saltSteakCooked = new ItemSaltSteakCooked(ItemIDs.SALT_STEAK_COOKED);
        LanguageRegistry.addName(saltSteakCooked, "Salted Steak");

        saltFishRaw = new ItemSaltFishRaw(ItemIDs.SALT_FISH_RAW);
        LanguageRegistry.addName(saltFishRaw, "Salted Raw Fish");

        saltFishCooked = new ItemSaltFishCooked(ItemIDs.SALT_FISH_COOKED);
        LanguageRegistry.addName(saltFishCooked, "Salted Fish");
    }

}
