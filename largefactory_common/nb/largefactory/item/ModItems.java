package nb.largefactory.item;

import nb.largefactory.item.salt.ItemSalt;
import nb.largefactory.item.salt.ItemSaltChickenCooked;
import nb.largefactory.item.salt.ItemSaltChickenRaw;
import nb.largefactory.item.salt.ItemSaltChunk;
import nb.largefactory.item.salt.ItemSaltFishCooked;
import nb.largefactory.item.salt.ItemSaltFishRaw;
import nb.largefactory.item.salt.ItemSaltFlesh;
import nb.largefactory.item.salt.ItemSaltPorkCooked;
import nb.largefactory.item.salt.ItemSaltPorkRaw;
import nb.largefactory.item.salt.ItemSaltSteakCooked;
import nb.largefactory.item.salt.ItemSaltSteakRaw;
import nb.largefactory.lib.ItemIDs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

    public static Item salt;
    public static Item saltChunk;
    public static Item saltFlesh;
    public static Item saltPorkRaw;
    public static Item saltPorkCooked;
    public static Item saltSteakRaw;
    public static Item saltSteakCooked;
    public static Item saltChickenRaw;
    public static Item saltChickenCooked;
    public static Item saltFishRaw;
    public static Item saltFishCooked;
    
    public static Item teaWhite;
    public static Item teaGreen;
    public static Item teaBlack;
    public static Item basketTeaWhite;
    public static Item basketTeaGreen;
    public static Item basketTeaBlack;

    public static Item itemStructure;

    public static void registerItems() {
        salt = new ItemSalt(ItemIDs.SALT);
        LanguageRegistry.addName(salt, "Salt");
        OreDictionary.registerOre("salt", salt);

        saltChunk = new ItemSaltChunk(ItemIDs.SALT_CHUNK);
        LanguageRegistry.addName(saltChunk, "Salt Chunk");

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
        
        teaWhite = new ItemTeaWhite(ItemIDs.WHITE_TEA);
        LanguageRegistry.addName(teaWhite, "White Tea Leaf");
        
        teaGreen = new ItemTeaGreen(ItemIDs.GREEN_TEA);
        LanguageRegistry.addName(teaGreen, "Green Tea Leaf");
        
        teaBlack = new ItemTeaBlack(ItemIDs.BLACK_TEA);
        LanguageRegistry.addName(teaBlack, "Black Tea Leaf");
        
        basketTeaWhite = new ItemBasketTeaWhite(ItemIDs.WHITE_TEA_BASKET);
        LanguageRegistry.addName(basketTeaWhite, "Basket of White Tea");
        
        basketTeaGreen = new ItemBasketTeaGreen(ItemIDs.GREEN_TEA_BASKET);
        LanguageRegistry.addName(basketTeaGreen, "Basket of Green Tea");
        
        basketTeaBlack = new ItemBasketTeaBlack(ItemIDs.BLACK_TEA_BASKET);
        LanguageRegistry.addName(basketTeaBlack, "Basket of Black Tea");

        itemStructure = new ItemStructure(ItemIDs.ITEM_STRUCTURE);
        LanguageRegistry.addName(itemStructure, "Structure Block");
    }

}
