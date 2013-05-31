package nb.largefactory.client.model;

import nb.largefactory.lib.Models;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelSaltCondenser {

    private IModelCustom modelSaltCondenser;

    public ModelSaltCondenser() {
        modelSaltCondenser = AdvancedModelLoader
                .loadModel(Models.SALT_CONDENSER);
    }

    public void render() {
        modelSaltCondenser.renderAll();
    }

    public void renderPart(String partName) {
        modelSaltCondenser.renderPart(partName);
    }

}
