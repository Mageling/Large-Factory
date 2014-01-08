package nb.largefactory.structure.component;

import java.util.HashMap;
import java.util.Map;

import nb.largefactory.lib.locations.Textures;

public class ComponentDataClass {
    String name;
    String[] recipe;
    String structureType;
    int[] dimensions;
    int maxNumber;
    boolean main;
    boolean controlBlock;
    Map<String, String> information;

    public ComponentDataClass(String compname, String structure_type) {
        name = compname;
        structureType = structure_type;
        information = new HashMap<String, String>();
        information.put("texturefilelocation", Textures.DEFAULT_TEXTURE_FILE_LOCATION);
        
    }
    // TODO recipes and controlBlock
    public void AddtoHash(String name, String data){
        switch (name){
        case "dimensions":
            String[] temp = data.split(",");
            if(temp.length != 3) {
                //ERROR not sure how to do this
            }
            dimensions[0] = Integer.parseInt(temp[0]);
            dimensions[1] = Integer.parseInt(temp[1]);
            dimensions[2] = Integer.parseInt(temp[2]);
            break;
        case "maxNumber": maxNumber = Integer.parseInt(data);
            break;
        case "required": main = true;
            break;
        case "texturefile": information.put("texturefilelocation", data);
            break;
        default: information.put(name, data);
            break;
        }
    }

    public String getStructureType() {
        return structureType;
    }

    public boolean isRequired() {
        return main;
    }
    /**
     * This returns anything that is a string
     * @return
     */
    public String provideInformation(String key) {
        if(information.containsKey(key))
            return information.get(key);
        return null;
    }

    /**
     * This returns inner, multinner, control, casing
     */
    public String getType(){
        if (name.equals("casing"))
            return "casing";
        else if(controlBlock)
            return "control";
        else if(dimensions != null)
            return "multinner";
        else
            return "inner";

    }
    public int[] getMultiSize() {
        if (dimensions == null)
            return new int[] { 1, 1, 1 };
        else
            return dimensions;

    }
}
