package nb.largefactory.structure;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.NodeList;


public class StructureTypeFactory {

    public static Map<String, StructureType> structureList;

    public void instantiate() {
        structureList = new HashMap<String, StructureType>();
    }

    public static void createStructureType(NodeList structure){
        StructureType a = new StructureType(structure.item(0).getTextContent());
        for(int k = 1; k < structure.getLength(); k++){
            String type = structure.item(k).getTextContent();
            switch(type){
            case "input": a.setIsInput();
            break;
            case "output": a.setIsOutput();
            break;
            case "special": a.setSpecialValidation();
            break;
            default: a.addRequiredComponent(type);
            break;
            }
        }
        structureList.put(structure.item(0).getTextContent(), a);
    }

    public static boolean validateStructure(String structureType,
            String[] tempComponentList, int xCoord, int yCoord, int zCoord) {
        // TODO Auto-generated method stub
        return false;
    }

}
