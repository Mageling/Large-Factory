package nb.largefactory.client.renderer.tileentity;

import nb.largefactory.client.model.ModelSaltCondenser;
import nb.largefactory.lib.locations.Textures;
import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class TileEntitySaltCondenserRenderer extends TileEntitySpecialRenderer {

    private ModelSaltCondenser modelSaltCondenser = new ModelSaltCondenser();

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y,
            double z, float tick) {

        if (tileentity instanceof TileEntitySaltCondenser) {
            // TileEntitySaltCondenser tileentitysaltcondenser =
            // (TileEntitySaltCondenser) tileentity;

            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_LIGHTING);

            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F,
                    (float) z + 0.5F);

            // Bind Texture
            FMLClientHandler.instance().getClient().renderEngine
            .bindTexture(Textures.SALT_CONDENSER);

            modelSaltCondenser.render();

            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
        }

    }

}
