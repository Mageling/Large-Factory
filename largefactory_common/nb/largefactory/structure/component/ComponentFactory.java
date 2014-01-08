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
 * required
 * texturefile
 */

public class ComponentFactory {
    public static Map<String, ComponentDataClass> componentList;

    public static void instantiate() {
        componentList = new HashMap<String, ComponentDataClass>();

    }

    public static void createComponent(NodeList component, String structtype_string) {
        StructureType structure_type = nb.largefactory.structure.StructureType.stringToStructureType(structtype_string);
        ComponentDataClass a = new ComponentDataClass(component.item(0).getTextContent(), structure_type);
        for(int k = 1; k < component.getLength(); k++){
            a.AddtoHash(component.item(k).getNodeName(), component.item(k).getTextContent());
        }
        componentList.put(component.item(0).getTextContent(), a);
    }
}
