package nb.largefactory.xml;

import nb.largefactory.lib.locations.Files;
import nb.largefactory.util.FileOpener;
import nb.largefactory.util.errors.XMLErrors;

import org.w3c.dom.NodeList;

public class XMLDecoder {
    static NodeList node;
    static NodeList node1;

    public static void instantiate() {
        // This does the components
        if (instantializeComponents(Files.XML_COMPONENT_LOCATION,"components")) {
            XMLErrors.LOADED_COMPONENTS.printError();
        } else {
            XMLErrors.COMPONENT_MISSING.printError();
        }
        // This does metals
        if (instantializeComponents(Files.XML_METAL_LOCATION,"metal")){
            XMLErrors.LOADED_METAL.printError();
        } else {
            XMLErrors.METAL_MISSING.printError();
        }
        // This does structures
        if (instantializeComponents(Files.XML_STRUCTURE_LOCATION,"structure")){
            XMLErrors.LOADED_STRUCTURE.printError();
        } else {
            XMLErrors.STRUCTURE_MISSING.printError();
        }

    }
    
    private static boolean instantializeComponents(String location, String mainname){
        node = FileOpener.openXML(location);
        if (node.item(0).getNodeName().equals("components")) {
            NodeList componentNodes = node.item(0).getChildNodes();
            for (int k = 0; k < componentNodes.getLength(); k++) {
                if (componentNodes.item(k).getNodeName() != "#text") {
                    NodeList components = componentNodes.item(k).getChildNodes();
                    components = FileOpener.trimNodelist(components);
                    switch(mainname){
                        case "components":nb.largefactory.structure.component.ComponentFactory.createComponent(components);
                        break;
                        case "structure": nb.largefactory.structure.StructureTypeFactory.createStructureType(components);
                        break;
                        case "metal": nb.largefactory.structure.calculations.MetalFactory.learnMetal(components);
                        break;
                        default: XMLErrors.UNKNOWN_ERROR.printError();
                        break;
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }

}
