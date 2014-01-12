package nb.largefactory.structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import nb.largefactory.structure.component.ComponentFactory;
import nb.largefactory.util.errors.StructureCreationErrors;
import nb.largefactory.util.errors.XMLErrors;
import net.minecraft.world.World;

import org.w3c.dom.NodeList;

public class StructureTypeFactory {

    public static Map<String, StructureType> structureList;

    public static void instantiate() {
        structureList = new HashMap<String, StructureType>();
    }

    public static void createStructureType(NodeList structure) {
        StructureType a = new StructureType(structure.item(0).getTextContent());
        for (int k = 1; k < structure.getLength(); k++) {
            String type = structure.item(k).getTextContent();
            switch (type) {
            case "input":
                a.setIsInput();
                break;
            case "output":
                a.setIsOutput();
                break;
            case "special":
                a.setSpecialValidation();
                break;
            case "type":
                a.addRequiredType(type);
                break;
            case "required":
                a.addRequiredComponent(type);
            default:
                // nothing
                break;
            }
        }
        structureList.put(structure.item(0).getTextContent(), a);
        XMLErrors.ADDED_ENTRY.printError(a.getName());
    }

    public static boolean validateStructure(String structureType, String[] tempComponentList, World world, int xCoord,
            int yCoord, int zCoord) {
        StructureType q = structureList.get(structureType);
        // components are of correct structure
        for (String c : tempComponentList) {
            if (ComponentFactory.componentList.get(c).getStructureType() != structureType) {
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
