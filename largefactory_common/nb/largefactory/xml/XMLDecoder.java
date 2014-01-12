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
        node = FileOpener.openXML(Files.XML_COMPONENT_LOCATION);
        if (node.item(0).getNodeName().equals("components")) {
            NodeList componentNodes = node.item(0).getChildNodes();
            for (int k = 0; k < componentNodes.getLength(); k++) {
                if (componentNodes.item(k).getNodeName() != "#text") {
                    NodeList components = componentNodes.item(k).getChildNodes();
                    components = FileOpener.trimNodelist(components);
                    nb.largefactory.structure.component.ComponentFactory.createComponent(components);
                }
            }
            XMLErrors.LOADED_COMPONENTS.printError();
        } else {
            XMLErrors.COMPONENT_MISSING.printError();
        }
        // This does metals
        node = FileOpener.openXML(Files.XML_METAL_LOCATION);
        if (node.item(0).getNodeName().equals("metal")) {
            NodeList componentNodes = node.item(0).getChildNodes();
            for (int k = 0; k < componentNodes.getLength(); k++) {
                if (componentNodes.item(k).getNodeName() != "#text") {
                    NodeList components = componentNodes.item(k).getChildNodes();
                    components = FileOpener.trimNodelist(components);
                    nb.largefactory.structure.calculations.MetalFactory.learnMetal(components);
                }
            }
            XMLErrors.LOADED_METAL.printError();
        } else {
            XMLErrors.METAL_MISSING.printError();
        }
        // This does structures
        node = FileOpener.openXML(Files.XML_STRUCTURE_LOCATION);
        if (node.item(0).getNodeName().equals("structure")) {
            NodeList componentNodes = node.item(0).getChildNodes();
            for (int k = 0; k < componentNodes.getLength(); k++) {
                if (componentNodes.item(k).getNodeName() != "#text") {
                    NodeList components = componentNodes.item(k).getChildNodes();
                    components = FileOpener.trimNodelist(components);
                    nb.largefactory.structure.StructureTypeFactory.createStructureType(components);
                }
            }
            XMLErrors.LOADED_STRUCTURE.printError();
        } else {
            XMLErrors.STRUCTURE_MISSING.printError();
        }

    }

}
