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
    public HashMap<String, Integer> provideInformation(
            HashMap<String, Integer> current) {
        return null;
    }
    /**
     * This returns inner, multinner, control, casing
     */
    public String getType(){
        if (this.name.equals("casing")){
            return "casing";
        }else if(this.controlBlock){
            return "control";
        }else if(this.dimensions != null){
            return "multinner";
        }else{
            return "inner";
        }
        
    }
    public int[] getMultiSize(){
        if(this.dimensions == null){
            return int[] dog = [1,1,1];
        }else{
            return this.dimensions;
        }
        
    }
}
