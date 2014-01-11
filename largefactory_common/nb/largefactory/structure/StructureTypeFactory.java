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
        StructureType q = structureList.get(structureType);
        //checks that components are of correct structure
        for (String c : tempComponentList){
            if(ComponentFactory.componentList.get(c).getStructureType() != structureType){
                return false;
            }
        }
        //has required components
        for (String s : q.getRequiredComponents()){
            if(!Arrays.asList(tempComponentList).contains(s)){
                return false;
            }
        }
        //has a component of required type
        if(structureList.get(structureType).getRequiredType() != null){
            boolean found = false;
            for(String t : tempComponentList){
                if(ComponentFactory.componentList.get(t).provideInformation("type") == q.getRequiredType()){
                   found = true;
                }
            }
            if(!found){
                return false;
            }
        }
        //checks for special
        if(q.isSpecialValidation()){
            //something
        }
        return true;
    }

}
