package nb.largefactory.lib;

import nb.largefactory.util.ResourceLocationHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

public class Textures {

    // Base file paths
    public static final String MODEL_SHEET_LOCATION = "textures/models/";
    public static final String ARMOR_SHEET_LOCATION = "textures/armor/";
    public static final String GUI_SHEET_LOCATION = "textures/gui/";
    public static final String EFFECTS_LOCATION = "textures/effects/";

    // Item/Block sprite sheets
    public static final ResourceLocation VANILLA_BLOCK_TEXTURE_SHEET = TextureMap.field_110575_b;
    public static final ResourceLocation VANILLA_ITEM_TEXTURE_SHEET = TextureMap.field_110576_c;

    // Armor sprite sheets

    // GUI textures
    public static final ResourceLocation GUI_SALT_CONDENSER = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "guiSaltCondenser.png");

    // Model textures
    public static final ResourceLocation SALT_CONDENSER = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "saltCondenser.png");

    // Effect textures

}
