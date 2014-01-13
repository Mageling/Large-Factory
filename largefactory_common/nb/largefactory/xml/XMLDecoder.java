package nb.largefactory.xml;

import java.io.File;

import nb.largefactory.lib.Reference;
import nb.largefactory.lib.locations.Files;
import nb.largefactory.util.FileOpener;
import nb.largefactory.util.logging.XMLErrors;
import nb.largefactory.util.logging.XMLLogger;

import org.w3c.dom.NodeList;

public class XMLDecoder {
    static NodeList node;
    static NodeList node1;
    public static File[] xmlFiles;

    public static void instantiate() {
        if (Reference.DEBUG_MODE) {
            for (File file : xmlFiles) {
                if (instantializeComponents(file.getAbsolutePath())) {
                    XMLLogger.LOADED_FILE.printLog(file.getName());
                } else {
                    XMLErrors.FAILED_TO_LOAD.printError(file.getName());
                }
            }
        } else {

            // This does the components
            if (instantializeComponents(Files.XML_COMPONENT_LOCATION)) {
                XMLLogger.LOADED_COMPONENTS.printLog();
            } else {
                XMLErrors.COMPONENT_MISSING.printError();
            }
            // This does metals
            if (instantializeComponents(Files.XML_METAL_LOCATION)) {
                XMLLogger.LOADED_METAL.printLog();
            } else {
                XMLErrors.METAL_MISSING.printError();
            }
            // This does structures
            if (instantializeComponents(Files.XML_STRUCTURE_LOCATION)) {
                XMLLogger.LOADED_STRUCTURE.printLog();
            } else {
                XMLErrors.STRUCTURE_MISSING.printError();

            }
        }
    }

    private static boolean instantializeComponents(String location) {
        node = FileOpener.openXML(location);
        String mainname = node.item(0).getTextContent();
        NodeList componentNodes = node.item(0).getChildNodes();
        for (int k = 0; k < componentNodes.getLength(); k++) {
            if (componentNodes.item(k).getNodeName() != "#text") {
                NodeList components = componentNodes.item(k).getChildNodes();
                components = FileOpener.trimNodelist(components);
                switch (mainname) {
                case "components":
                    nb.largefactory.structure.component.ComponentFactory.createComponent(components);
                    break;
                case "structure":
                    nb.largefactory.structure.StructureTypeFactory.createStructureType(components);
                    break;
                case "metal":
                    nb.largefactory.structure.calculations.MetalFactory.learnMetal(components);
                    break;
                default:
                    XMLErrors.XML_STARTING_NODE_INVALID.printError(location);
                    return false;
                }
            }
        }
        return true;
    }

}
