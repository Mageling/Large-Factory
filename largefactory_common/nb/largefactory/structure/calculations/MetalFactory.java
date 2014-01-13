package nb.largefactory.structure.calculations;

import java.util.HashMap;
import java.util.Map;

import nb.largefactory.util.logging.XMLErrors;
import nb.largefactory.util.logging.XMLLogger;

import org.w3c.dom.NodeList;

public class MetalFactory {
    public static Map<String, MetalClass> metalList;

    public static void instantiate() {
        metalList = new HashMap<String, MetalClass>();
    }

    /*
     * possible tags required states forge ore dictionary melting point
     */

    public static void learnMetal(NodeList metal) {
        MetalClass a = new MetalClass(metal.item(0).getTextContent());
        XMLLogger.ADDED_ENTRY.printLog(a.getName());
        for (int k = 1; k < metal.getLength(); k++) {
            // this is everything that is hidden as slag
            if (metal.item(k).getNodeName() == "yield") {
                a.importYieldValue(metal.item(k).getAttributes().getNamedItem("material").getNodeValue(),
                        Float.parseFloat(metal.item(k).getTextContent()));
                // this is primary yield so not hidden as slag
            } else if (metal.item(k).getNodeName() == "primary") {
                a.importPrimaryValue(metal.item(k).getAttributes().getNamedItem("material").getNodeValue(),
                        Float.parseFloat(metal.item(k).getTextContent()));
                // error catch
            } else {
                XMLErrors.METAL_INVALID.printError(a.getName());
            }
        }
        metalList.put(metal.item(0).getTextContent(), a);
    }
}
