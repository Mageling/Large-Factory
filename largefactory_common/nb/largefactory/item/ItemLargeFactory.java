package nb.largefactory.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemLargeFactory {
    static int saltid = 7770;
    static int saltfleshid = 7771;
    static int saltporkid = 7772;
    static int saltporkcookid = 7773;
    static int saltsteakid = 7774;
    static int saltsteakcookid = 7775;
    static int saltchickenid = 7776;
    static int saltchickencookid = 7777;
    
    static Item salt = (new Item(saltid)).setUnlocalizedName("salt").setCreativeTab(CreativeTabs.tabFood);
    static Item saltflesh = (new ItemFood(saltfleshid, 5, 0.2f, true)).setUnlocalizedName("saltFlesh").setCreativeTab(CreativeTabs.tabFood);
    static Item saltpork = (new ItemFood(saltporkid, 4, 0.3f, true)).setUnlocalizedName("saltpork").setCreativeTab(CreativeTabs.tabFood);
    static Item saltporkcook = (new ItemFood(saltporkcookid, 9, 0.8f, true)).setUnlocalizedName("saltporkcook").setCreativeTab(CreativeTabs.tabFood);
    static Item saltsteak = (new ItemFood(saltsteakid, 4, 0.3f, true)).setUnlocalizedName("saltsteak").setCreativeTab(CreativeTabs.tabFood);
    static Item saltsteakcook = (new ItemFood(saltsteakcookid, 9, 0.8f, true)).setUnlocalizedName("saltsteakcook").setCreativeTab(CreativeTabs.tabFood);
    static Item saltchicken = (new ItemFood(saltchickenid, 3, 0.3f, true)).setUnlocalizedName("saltchicken").setCreativeTab(CreativeTabs.tabFood);
    static Item saltchickencook = (new ItemFood(saltchickencookid, 7, 0.6f, true)).setUnlocalizedName("saltchickencook").setCreativeTab(CreativeTabs.tabFood);
    
    public static void registerItems() {
        GameRegistry.registerItem(salt, "salt");
        GameRegistry.registerItem(saltchicken, "saltchicken");
        GameRegistry.registerItem(saltchickencook, "saltchickencook");
        GameRegistry.registerItem(saltflesh, "saltFlesh");
        GameRegistry.registerItem(saltpork, "saltpork");
        GameRegistry.registerItem(saltporkcook, "saltporkcook");
        GameRegistry.registerItem(saltsteak, "saltsteak");
        GameRegistry.registerItem(saltsteakcook, "saltsteakcook");
    }

}
