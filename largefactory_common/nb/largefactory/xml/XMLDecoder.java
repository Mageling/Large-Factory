package nb.largefactory.xml;

import java.io.File;

import nb.largefactory.util.FileOpener;
import nb.largefactory.util.logging.XMLErrors;
import nb.largefactory.util.logging.XMLLogger;

import org.w3c.dom.NodeList;

public class XMLDecoder {
    static NodeList node;
    static NodeList node1;
    public static File[] xmlFiles;

    public static void instantiate() {
        for (File file : xmlFiles) {
            if (instantializeComponents(file.getAbsolutePath())) {
                XMLLogger.LOADED_FILE.printLog(file.getName());
            } else {
                XMLErrors.FAILED_TO_LOAD.printError(file.getName());
            }
        }
    }

    private static boolean instantializeComponents(String location) {
        node = FileOpener.openXML(location);
        String mainname = node.item(0).getNodeName();
        XMLLogger.FILE_EXISTS.printLog(location);
        NodeList componentNodes = node.item(0).getChildNodes();
        for (int k = 0; k < componentNodes.getLength(); k++) {
            if (componentNodes.item(k).getNodeName() != "#text") {
                NodeList components = componentNodes.item(k).getChildNodes();
                components = FileOpener.trimNodelist(components);
                switch (mainname) {
                case "components":
                    if(!nb.largefactory.structure.component.ComponentFactory.createComponent(components))
                        XMLErrors.INVALID_FIRST_NODE.printError(location);
                    break;
                case "structure":
                    if (!nb.largefactory.structure.StructureTypeFactory.createStructureType(components)){
                        XMLErrors.INVALID_FIRST_NODE.printError(location);
                    }
                    break;
                case "metal":
                    if(!nb.largefactory.structure.calculations.MetalFactory.learnMetal(components))
                        XMLErrors.INVALID_FIRST_NODE.printError(location);
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
