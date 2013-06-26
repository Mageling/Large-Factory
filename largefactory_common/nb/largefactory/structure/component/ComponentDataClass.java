package nb.largefactory.structure.component;

import nb.largefactory.structure.StructureType;

public class ComponentDataClass {
    String name = null;
    String[] recipe = null;
    StructureType structureType = null;
    int[] dimensions = null;
    int maxNumber = 1;
    boolean main = false;
    boolean controlBlock = false;
    String textureFileLocation = null;

    public StructureType getStructureType() {
        return structureType;
    }

    public boolean isRequired() {
        return main;
    }
}
