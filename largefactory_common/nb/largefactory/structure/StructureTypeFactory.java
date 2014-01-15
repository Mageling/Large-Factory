package nb.largefactory.structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import nb.largefactory.structure.component.ComponentFactory;
import nb.largefactory.util.logging.StructureCreationErrors;
import nb.largefactory.util.logging.XMLErrors;
import nb.largefactory.util.logging.XMLLogger;
import net.minecraft.world.World;

import org.w3c.dom.NodeList;

public class StructureTypeFactory {

    public static Map<String, StructureType> structureList;

    public static void instantiate() {
        structureList = new HashMap<String, StructureType>();
    }

    public static boolean createStructureType(NodeList structure) {
        if(structure.item(0).getNodeName() == "name"){
            StructureType a = new StructureType(structure.item(0).getTextContent());
            for (int k = 1; k < structure.getLength(); k++) {
                String type = structure.item(k).getNodeName();
                switch (type) {
                case "location":
                    if(structure.item(k).getTextContent() == "input"){
                        a.setIsInput();
                    }else if(structure.item(k).getTextContent() == "output"){
                        a.setIsOutput();
                    }else {
                        XMLErrors.INVALID_STRUCTURE_LOCATION.printError(a.getName());
                    }               
                    break;
                case "type":
                    a.addRequiredType(structure.item(k).getTextContent());
                    break;
                case "required":
                    a.addRequiredComponent(structure.item(k).getTextContent());
                    break;
                case "component":
                    a.addAllowedComponents(structure.item(k).getTextContent());
                    break;
                default:
                    XMLErrors.INVALID_XML.printError(a.getName());
                    break;
                }
            }
            if(a.isValid()){
                structureList.put(structure.item(0).getTextContent(), a);
                XMLLogger.ADDED_ENTRY.printLog(a.getName());
            }else{
                XMLErrors.INVALID_XML.printError(a.getName());
            }
            return true;
        }else{
            return false;
        }
    }

    public static boolean validateStructure(String structureType, String[] tempComponentList, World world, int xCoord,
            int yCoord, int zCoord) {
        StructureType q = structureList.get(structureType);
        // components are of correct structure
        for (String c : tempComponentList) {
            if (q.getAllowedComponents().contains(c)) {
                StructureCreationErrors.OTHER.printError(Level.SEVERE, xCoord, yCoord, zCoord);
                return false;
            }
        }
        // has required components
        for (String s : q.getRequiredComponents()) {
            if (!Arrays.asList(tempComponentList).contains(s)) {
                StructureCreationErrors.MISSING_BLOCK.printError(xCoord, yCoord, zCoord, s);
            }
            return false;
        }
        // has a component of correct type and only 1
        if (structureList.get(structureType).getRequiredType() != null) {
            boolean found = false;
            for (String t : tempComponentList) {
                if (ComponentFactory.componentList.get(t).provideInformation("type") == q.getRequiredType()) {
                    if (found) {
                        StructureCreationErrors.TYPE_ALREADY_EXISTS.printError(xCoord, yCoord, zCoord, t);
                        return false;
                    } else {
                        found = true;

                    }
                }
            }
            if (!found) {
                StructureCreationErrors.NO_TYPE.printError(xCoord, yCoord, zCoord, q.getRequiredType());
                return false;
            }
        }
        // special validation
        if (q.isSpecialValidation()) {
            // something
        }
        return true;

    }
}
