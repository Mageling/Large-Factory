package nb.largefactory.client.gui.inventory;

import nb.largefactory.inventory.ContainerSaltCondenser;
import nb.largefactory.lib.Strings;
import nb.largefactory.lib.Textures;
import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSaltCondenser extends GuiContainer {

	private TileEntitySaltCondenser saltCondenser;

	public GuiSaltCondenser(InventoryPlayer player, TileEntitySaltCondenser saltCondenser) {
		super(new ContainerSaltCondenser(player, saltCondenser));
		ySize = 166;
		this.saltCondenser = saltCondenser;

	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {

		String containerName = saltCondenser.isInvNameLocalized() ? saltCondenser.getInvName() : StatCollector
				.translateToLocal(saltCondenser.getInvName());
		fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
		fontRenderer
		.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(Textures.GUI_SALT_CONDENSER);
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
	}
}
