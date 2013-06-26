package nb.largefactory.structure.component;

import nb.largefactory.structure.StructureType;

public class ComponentDataClass {
    String name = null;
    String[] recipe = null;
    StructureType structureType= null;
    int[] dimensions = null;
    int maxNumber = 1;
    boolean main = false;
    String textureFileLocation = null;
    
    public StructureType getStructureType(){
        return this.structureType;
    }
    public boolean isRequired(){
        return main;
    }
}
