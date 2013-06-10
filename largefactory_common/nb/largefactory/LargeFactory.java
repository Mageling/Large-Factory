package nb.largefactory;

import nb.largefactory.proxy.CommonProxy;
import nb.largefactory.block.ModBlocks;
import nb.largefactory.item.ModItems;
import nb.largefactory.item.crafting.VanillaCrafting;
import nb.largefactory.lib.Reference;
import nb.largefactory.network.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class LargeFactory {
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.registerItems();
        ModBlocks.registerBlocks();

    }

    @Init
    public void load(FMLInitializationEvent event) {
        VanillaCrafting.registerVanillaCrafting();
        VanillaCrafting.registerVanillaSmelting();
        proxy.initRenderingandTextures();
        proxy.registerTileEntities();
    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {

    }

}
