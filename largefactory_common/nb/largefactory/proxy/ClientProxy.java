package nb.largefactory.proxy;

import nb.largefactory.client.renderer.item.ItemSaltCondenserRenderer;
import nb.largefactory.client.renderer.tileentity.TileEntitySaltCondenserRenderer;
import nb.largefactory.lib.BlockIDs;
import nb.largefactory.lib.RenderIds;
import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void initRenderingandTextures() {
        RenderIds.saltCondenserRenderId = RenderingRegistry
                .getNextAvailableRenderId();
        MinecraftForgeClient.registerItemRenderer(BlockIDs.SALT_CONDENSER_ID,
                new ItemSaltCondenserRenderer());
    }

    @Override
    public void registerTileEntities() {
        super.registerTileEntities();

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntitySaltCondenser.class,
                new TileEntitySaltCondenserRenderer());
    }

}
