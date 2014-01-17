package nb.largefactory.structure.calculations;

import java.util.HashMap;
import java.util.Map;

import nb.largefactory.util.logging.XMLErrors;
import nb.largefactory.util.logging.XMLLogger;

import org.w3c.dom.NodeList;

public class OreFactory {
    public static Map<String, OreClass> metalList;

    public static void instantiate() {
        metalList = new HashMap<String, OreClass>();
    }

    /*
     * possible tags required states forge ore dictionary melting point
     */

    public static boolean learnMetal(NodeList metal) {
        if(metal.item(0).getNodeName() == "name"){
            OreClass a = new OreClass(metal.item(0).getTextContent());
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
            if(a.isValid()){
                metalList.put(metal.item(0).getTextContent(), a);
            }else{
                XMLErrors.INVALID_XML.printError(a.getName());
            }            
            return true;
        }else{
            return false;
        }
    }
}
