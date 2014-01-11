package nb.largefactory.structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import nb.largefactory.structure.component.ComponentFactory;

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
            case "type": a.addRequiredType(type);
            break;
            default: a.addRequiredComponent(type);
            break;
            }
        }
        structureList.put(structure.item(0).getTextContent(), a);
    }

    public static boolean validateStructure(String structureType,
            String[] tempComponentList, int xCoord, int yCoord, int zCoord) {
        for (String s : structureList.get(structureType).getRequiredComponents()){
            if(!Arrays.asList(tempComponentList).contains(s)){
                return false;
            }
        }
        if(structureList.get(structureType).getRequiredType() != null){
            boolean found = false;
            for(String t : tempComponentList){
                if(ComponentFactory.componentList.get(t).provideInformation("type") == structureList.get(structureType).getRequiredType()){
                   found = true;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }

}
