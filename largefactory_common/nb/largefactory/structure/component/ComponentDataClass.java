package nb.largefactory.structure.component;

import java.util.HashMap;

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

    /**
     * 
     * this overridden always
     */
    public HashMap<String, Integer> provideInformation(HashMap<String, Integer> current) {
        return null;
    }

    /**
     * This returns inner, multinner, control, casing
     */
    public String getType() {
        if (name.equals("casing")) {
            return "casing";
        } else if (controlBlock) {
            return "control";
        } else if (dimensions != null && dimensions != new int[] { 1, 1, 1 }) {
            return "multinner";
        } else {
            return "inner";
        }

    }

    // TODO I need a version for this that can be put into a switch statement
    // (int, enum, or string)
    public int[] getMultiSize() {
        if (dimensions == null) {
            return new int[] { 1, 1, 1 };
        } else {
            return dimensions;
        }

    }
}
