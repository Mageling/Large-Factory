package nb.largefactory.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nb.largefactory.lib.Files;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLDecoder {
    static NodeList node;

    public static void instantiate() {
        try {
            File file = new File(Files.XML_FILE_LOCATION);
            if (file.exists()) {
                DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse(Files.XML_FILE_LOCATION);
                node = doc.getElementsByTagName("*");
                for (int i = 0; i < node.getLength(); i++) {
                    NodeList nodeinfo;
                    if (node.item(i).getNodeName().equals("component")){
                        nodeinfo = node.item(i).getChildNodes();
                        for(int k = 0; k < nodeinfo.getLength(); k++){
                            if(nodeinfo.item(k).getTextContent().trim().length() == 0){
                                nodeinfo.item(k).getParentNode().removeChild(nodeinfo.item(k));
                            }
                        }
                        nb.largefactory.structure.component.ComponentFactory.createComponent(nodeinfo, node.item(i).getParentNode().getNodeName().replaceAll("\\s+",""));
                        /*
                        System.out.println("Node info");
                        System.out.println("number of nodes " + nodeinfo.getLength());
                        for(int k = 0; k < nodeinfo.getLength(); k++){
                            System.out.println(nodeinfo.item(k).getNodeName().replace("#text",""));
                            System.out.println(nodeinfo.item(k).getTextContent());
                        }
                        System.out.println("Parent Node");
                        System.out.println(node.item(i).getParentNode().getNodeName().replaceAll("\\s+",""));
                        ComponentFactory.createComponent(node.item(i)
                                .getChildNodes(), StructureType
                                .stringToStructureType(node.item(i)
                                        .getParentNode().getNodeName()));
                                       */
                    }
                }
            }
        } catch (Exception e) {
        }
    }

}
