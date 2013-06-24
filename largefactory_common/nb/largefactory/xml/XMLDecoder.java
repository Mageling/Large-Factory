package nb.largefactory.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nb.largefactory.structure.StructureType;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLDecoder {
    static NodeList node;

    public static void instantiate() {
        try {
            File file = new File("test.xml");
            if (file.exists()) {
                DocumentBuilderFactory fact = DocumentBuilderFactory
                        .newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse("test.xml");
                // Node node = doc.getDocumentElement();
                node = doc.getElementsByTagName("*");
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
}
