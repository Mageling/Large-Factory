package nb.largefactory.structure.component;

import java.util.HashMap;
import java.util.Map;

import nb.largefactory.structure.StructureType;

import org.w3c.dom.NodeList;

/*  This is a list of every allowed entry in a XMl component 
 * IMPORTANT, the name of the component must be first
 * **************
 * name (required)
 * recipe (required)
 * dimensions (required)
 * maxnumber (required)
 * disk
 * ergcost
 * percentyield
 * ergcostreduction
 * controlblock
 * timeincrease
 * slagergcost
 */

public class ComponentFactory {
    public static Map<String, ComponentDataClass> componentList;

    public static void instantiate() {
        componentList = new HashMap<String, ComponentDataClass>();

    }

    public static void createComponent(NodeList component, StructureType strucType) {
        String compName = component.item(0).getTextContent();

        HashMap<String, String> xmlOutput = new HashMap<String, String>();
        for (int i = 0; i < component.getLength(); i++) {
            xmlOutput.put(component.item(i).getNodeName(), component.item(i).getTextContent());
        }
        switch (strucType) {
            case GRINDER:
                GrinderComponents foo = new GrinderComponents(compName, xmlOutput.get("recipe"),
                        xmlOutput.get("dimensions"), xmlOutput.get("maxnumber"), xmlOutput.get("disk"),
                        xmlOutput.get("ergcost"), xmlOutput.get("percentyield"), xmlOutput.get("ergcostreduction"),
                        xmlOutput.get("texturefile"), xmlOutput.get("controlblock"), xmlOutput.get("timeincrease"),
                        xmlOutput.get("slagergcost"));
                componentList.put(compName, foo);
                break;
            case CRUSHER:
                break;
            case BLAST_INJECTOR:
                break;
            case CASING:
                break;
            case COAGULATOR:
                break;
            case COMPACTOR:
                break;
            case COOLER:
                break;
            case EXTRACTOR:
                break;
            case HEATED_STORAGE_UNIT:
                break;
            case LIQUID_SEPARATOR:
                break;
            case MELTER:
                break;
            case PURIFIER:
                break;
            case REFINER:
                break;
            case SCRAPER:
                break;
            case SKIMMER:
                break;
            case SMELTER:
                break;
            case SOLID_SEPARATOR:
                break;
            default:
                break;
        }
    }
}
