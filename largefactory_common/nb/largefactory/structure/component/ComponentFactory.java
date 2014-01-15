package nb.largefactory.structure.component;

import java.util.HashMap;
import java.util.Map;

import nb.largefactory.util.logging.XMLErrors;
import nb.largefactory.util.logging.XMLLogger;

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

    public static boolean createComponent(NodeList component) {
        if(component.item(0).getNodeName() == "name"){
            ComponentDataClass a = new ComponentDataClass(component.item(0).getTextContent());
            for (int k = 1; k < component.getLength(); k++) {
                a.AddtoHash(component.item(k).getNodeName(), component.item(k).getTextContent());
            }
            if(a.isValid()){
                componentList.put(component.item(0).getTextContent(), a);
                XMLLogger.ADDED_ENTRY.printLog(a.name);
            }else{
                XMLErrors.INVALID_XML.printError(a.name);
            }
            return true;
        }else{
            return false;
        }
    }
}
