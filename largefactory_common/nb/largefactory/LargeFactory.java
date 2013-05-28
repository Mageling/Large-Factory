package nb.largefactory;

import nb.largefactory.item.ItemLargeFactory;
import nb.largefactory.lib.Reference;
import nb.largefactory.network.PacketHandler;
import cpw.mods.fml.common.Mod;
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

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        ItemLargeFactory.registerItems();
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
        
    }
    
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {

    }

}
