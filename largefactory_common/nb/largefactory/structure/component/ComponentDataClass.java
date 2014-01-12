package nb.largefactory.structure.component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import nb.largefactory.lib.locations.Textures;
import nb.largefactory.util.errors.XMLErrors;

public class ComponentDataClass {
    String name;
    String[] recipe;
    String structureType;
    int[] dimensions;
    int maxNumber;
    boolean controlBlock;
    Map<String, String> information;

    public ComponentDataClass(String compname) {
        name = compname;
        information = new HashMap<String, String>();
        information.put("texturefilelocation", Textures.DEFAULT_TEXTURE_FILE_LOCATION);
        dimensions =  new int[3];
        Arrays.fill(dimensions, 1);

    }

    // TODO recipes and controlBlock
    public void AddtoHash(String name, String data) {
        switch (name) {
        case "dimensions":
            String[] temp = data.split(",");
            if (temp.length != 3) {
                XMLErrors.INVALID_DIMENSIONS.printError(name);
            }
            dimensions[0] = Integer.parseInt(temp[0]);
            dimensions[1] = Integer.parseInt(temp[1]);
            dimensions[2] = Integer.parseInt(temp[2]);
            break;
        case "max":
            maxNumber = Integer.parseInt(data);
            break;
        case "texturefile":
            information.put("texturefilelocation", data);
            break;
        default:
            information.put(name, data);
            break;
        }
    }

    public String getStructureType() {
        return structureType;
    }

    /**
     * This returns anything that is a string
     * 
     * @return
     */
    public String provideInformation(String key) {
        if (information.containsKey(key))
            return information.get(key);
        return null;
    }

    /**
     * This returns inner, multinner, control, casing
     */
    public String getType() {
        int[] test = new int[3];
        Arrays.fill(test,1);
        if (name.equals("casing"))
            return "casing";
        else if (controlBlock)
            return "control";
        else if (!Arrays.equals(dimensions, test))
            return "multinner";
        else
            return "inner";

    }

    public int[] getMultiSize() {
        return dimensions;

    }
    
    public String informationAsString(){
        String output = "";
        for(Map.Entry<String, String> entry: information.entrySet()){
            output = output + " " + entry.getKey() + ": " + entry.getValue();
        }
        return output;
    }
    
    public String toString(){
        return "Name: "+ name +" Type: " + getType() + " Structure Type: " + getStructureType();
    }
    
    
}
