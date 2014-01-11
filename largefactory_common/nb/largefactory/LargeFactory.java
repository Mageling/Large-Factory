package nb.largefactory;

import nb.largefactory.block.ModBlocks;
import nb.largefactory.item.ModItems;
import nb.largefactory.item.crafting.VanillaCrafting;
import nb.largefactory.lib.Reference;
import nb.largefactory.network.PacketHandler;
import nb.largefactory.proxy.CommonProxy;
import nb.largefactory.structure.StructureTypeFactory;
import nb.largefactory.structure.calculations.MetalFactory;
import nb.largefactory.structure.component.ComponentFactory;
import nb.largefactory.xml.XMLDecoder;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false,
        packetHandler = PacketHandler.class)
public class LargeFactory {

    @Instance(Reference.MOD_ID)
    public static LargeFactory instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy  proxy;

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {

    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Load the XML decoder
        XMLDecoder.instantiate();

        // Register Blocks and Items
        ModBlocks.registerBlocks();
        ModItems.registerItems();

        // Register crafting and smelting
        VanillaCrafting.registerVanillaCrafting();
        VanillaCrafting.registerVanillaSmelting();

    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        // Register the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);

        // Register Tile Entities
        proxy.registerTileEntities();

        // Initialize custom renderers
        proxy.initRenderingandTextures();

    }

    @EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {
        StructureTypeFactory.instantiate();
        MetalFactory.instantiate();
        ComponentFactory.instantiate();

    }

    @EventHandler
    public void handleIMCMessages(IMCEvent event) {

    }

}
