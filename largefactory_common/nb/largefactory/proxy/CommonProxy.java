package nb.largefactory.proxy;

import nb.largefactory.lib.Strings;
import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        // TODO Auto-generated method stub
        return null;
    }

    public void initRenderingandTextures() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntitySaltCondenser.class,
                Strings.TE_SALT_CONDENSER_NAME);
    }

    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName) {

    }

    public void handleTileWithItemPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName,
            int itemID, int metaData, int stackSize, int color) {

    }
}
