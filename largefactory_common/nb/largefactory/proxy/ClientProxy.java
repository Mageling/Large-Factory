package nb.largefactory.proxy;

import nb.largefactory.client.renderer.item.ItemSaltCondenserRenderer;
import nb.largefactory.client.renderer.tileentity.TileEntitySaltCondenserRenderer;
import nb.largefactory.lib.BlockIDs;
import nb.largefactory.lib.RenderIds;
import nb.largefactory.tileentity.TileEntityLargeFactory;
import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void initRenderingandTextures() {
        RenderIds.saltCondenserRenderId = RenderingRegistry.getNextAvailableRenderId();
        MinecraftForgeClient.registerItemRenderer(BlockIDs.SALT_CONDENSER, new ItemSaltCondenserRenderer());
    }

    @Override
    public void registerTileEntities() {
        super.registerTileEntities();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySaltCondenser.class,
                new TileEntitySaltCondenserRenderer());
    }

    @Override
    public void handleTileEntityPacket(int x, int y, int z, String customName) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);

        if (tileEntity != null) {
            if (tileEntity instanceof TileEntityLargeFactory) {
                ((TileEntityLargeFactory) tileEntity).setCustomName(customName);
            }
        }
    }

    @Override
    public void handleTileWithItemPacket(int x, int y, int z, String customName, int itemID, int metaData,
            int stackSize, int color) {

        // World world = FMLClientHandler.instance().getClient().theWorld;
        // TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        this.handleTileEntityPacket(x, y, z, customName);
        /**
         * empty if for now if (tileEntity != null) { if(tileEntity instanceof
         * TileEntitySaltCondenser) {
         * 
         * } }
         **/
    }

}
