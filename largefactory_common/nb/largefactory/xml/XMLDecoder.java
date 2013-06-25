package nb.largefactory.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nb.largefactory.structure.StructureType;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDecoder {
    static NodeList node;
    static Map<String,Object> componentList;
    
    public static void instantiate() {
        componentList = new HashMap<String, Object>();
        try {
            File file = new File("test.xml");
            if (file.exists()) {
                DocumentBuilderFactory fact = DocumentBuilderFactory
                        .newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse("test.xml");
                node = doc.getElementsByTagName("*");
                for (int i=0; i < node.getLength(); i++){
                    if(node.item(i).getNodeName().equals("component")){
                        componentList.put(node.item(i).getFirstChild().getTextContent(), createStructureObjectFromNode(node.item(i)));
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static StructureType getStructureType(String ComponentType) {
        for (int i = 0; i < node.getLength(); i++) {
            if (node.item(i).getTextContent().equals(ComponentType)) {
                return StructureType.stringToStructureType(node.item(i).getParentNode().getParentNode().getNodeName().replace("_components",""));
            }
        }
        return null;
    }
    public static Object createStructureObjectFromNode(Node componentNode) {
        // do some stuff
        return null;
    }
}
