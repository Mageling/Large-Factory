package nb.largefactory.structure.calculations;

import java.util.HashMap;
import java.util.Map;

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
        for (int k = 1; k < metal.getLength(); k++) {
            // this is everything that is hidden as slag
            if (metal.item(k).getNodeName() == "yield") {
                a.importYieldValue(metal.item(k).getAttributes().getNamedItem("material").getNodeValue(),
                        Float.parseFloat(metal.item(k).getTextContent()));
                // this is primary yield so not hidden as slag
            } else if (metal.item(k).getNodeName() == "primary") {
                a.importPrimaryValue(metal.item(k).getAttributes().getNamedItem("primary").getNodeValue(),
                        Float.parseFloat(metal.item(k).getTextContent()));
                // error catch
            } else {
                System.out.println("The material " + metal.item(0).getTextContent() + " has an improper yield");
            }
        }
        metalList.put(metal.item(0).getTextContent(), a);
    }
}
