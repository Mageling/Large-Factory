package nb.largefactory.client.renderer.item;

import nb.largefactory.client.model.ModelSaltCondenser;
import nb.largefactory.lib.Textures;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemSaltCondenserRenderer implements IItemRenderer {

    private ModelSaltCondenser modelSaltCondenser = new ModelSaltCondenser();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
            ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch (type) {
            case ENTITY: {
                renderSaltCondenser(0.0F, 0.0F, 0.0F, 1.0F);
                return;
            }
            case EQUIPPED: {
                renderSaltCondenser(0.5F, -0.0F, 0.5F, 1.0F);
                return;
            }
            case EQUIPPED_FIRST_PERSON: {
                renderSaltCondenser(0.5F, -0.5F, 0.5F, 1.5F);
                return;
            }
            case INVENTORY: {
                renderSaltCondenser(0.0F, -0.5F, 0.0F, 1.0F);
                return;
            }
            default:
                return;
        }
    }

    private void renderSaltCondenser(float x, float y, float z, float scale) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(0F, 1F, 0, 0);

        // Bind Texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.SALT_CONDENSER);

        // Render
        modelSaltCondenser.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();

    }

}
