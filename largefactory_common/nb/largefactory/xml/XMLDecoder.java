package nb.largefactory.xml;

import java.io.File;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nb.largefactory.lib.locations.Files;
import nb.largefactory.util.FileOpener;
import nb.largefactory.util.errors.XMLErrors;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import cpw.mods.fml.common.FMLLog;

public class XMLDecoder {
    static NodeList node;

    public static void instantiate() {
        // This does the components
        node = FileOpener.openXML(Files.XML_COMPONENT_LOCATION);
        if(node.item(0).getNodeName().equals("components")){
            NodeList componentNodes = node.item(0).getChildNodes();
            for(int k = 0; k < componentNodes.getLength(); k++){
                NodeList components = componentNodes.item(k).getChildNodes();
                for(int i = 0; i < components.getLength(); i++){
                    nb.largefactory.structure.component.ComponentFactory.createComponent(components, node.item(i).getParentNode().getNodeName().replaceAll("\\s+", ""));
                }
            }
        }
            

        try {
            File file = new File(Files.XML_METAL_LOCATION);
            if (file.exists()) {
                DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse(Files.XML_METAL_LOCATION);
                node = doc.getElementsByTagName("*");
                for (int i = 0; i < node.getLength(); i++) {
                    NodeList nodeinfo;
                    if (!node.item(i).getNodeName().equals("metal")){
                        if (node.item(i).getParentNode().getNodeName().equals("metal")) {
                            nodeinfo = node.item(i).getChildNodes();
                            for (int k = 0; k < nodeinfo.getLength(); k++) {
                                if (nodeinfo.item(k).getTextContent().trim().length() == 0) {
                                    nodeinfo.item(k).getParentNode().removeChild(nodeinfo.item(k));
                                }
                            }
                            nb.largefactory.structure.calculations.MetalFactory.learnMetal(nodeinfo);
                        }
                    }
                }
                XMLErrors.LOADED_METAL.printError();
            }else{
                XMLErrors.METAL_MISSING.printError();
            }
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE,e.getMessage());
        }

        try {
            File file = new File(Files.XML_STRUCTURE_LOCATION);
            if (file.exists()) {
                DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse(Files.XML_STRUCTURE_LOCATION);
                node = doc.getElementsByTagName("*");
                for (int i = 1; i < node.getLength(); i++) {
                    NodeList nodeinfo;
                    if (node.item(i).getParentNode().getNodeName().equals("structure")) {
                        nodeinfo = node.item(i).getChildNodes();
                        for (int k = 0; k < nodeinfo.getLength(); k++) {
                            if (nodeinfo.item(k).getTextContent().trim().length() == 0) {
                                nodeinfo.item(k).getParentNode().removeChild(nodeinfo.item(k));
                            }
                        }
                        nb.largefactory.structure.StructureTypeFactory.createStructureType(nodeinfo);
                    }
                }
                XMLErrors.LOADED_STRUCTURE.printError();
            }else{
                XMLErrors.STRUCTURE_MISSING.printError();
            }
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE,e.getMessage());
        }

    }

}
