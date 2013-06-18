package nb.largefactory.proxy;

import nb.largefactory.client.gui.inventory.GuiSaltCondenser;
import nb.largefactory.inventory.ContainerSaltCondenser;
import nb.largefactory.lib.GuiIDs;
import nb.largefactory.lib.Strings;
import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        if (ID == GuiIDs.SALT_CONDENSER) {
            TileEntitySaltCondenser tileEntitySaltCondenser = (TileEntitySaltCondenser) world
                    .getBlockTileEntity(x, y, z);
            return new ContainerSaltCondenser(player.inventory,
                    tileEntitySaltCondenser);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        if (ID == GuiIDs.SALT_CONDENSER) {
            TileEntitySaltCondenser tileEntitySaltCondenser = (TileEntitySaltCondenser) world
                    .getBlockTileEntity(x, y, z);
            return new GuiSaltCondenser(player.inventory,
                    tileEntitySaltCondenser);
        }
        return null;
    }

    public void initRenderingandTextures() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntitySaltCondenser.class,
                Strings.TE_SALT_CONDENSER_NAME);
    }

    public void handleTileEntityPacket(int x, int y, int z, String customName) {

    }

    public void handleTileWithItemPacket(int x, int y, int z,
            String customName, int itemID, int metaData, int stackSize,
            int color) {

    }
}
