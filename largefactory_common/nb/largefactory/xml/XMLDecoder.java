package nb.largefactory.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nb.largefactory.lib.Files;
import nb.largefactory.structure.StructureType;
import nb.largefactory.structure.component.ComponentFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLDecoder {
    static NodeList node;

    public static void instantiate() {
        try {
            File file = new File(Files.XML_FILE_LOCATION);
            if (file.exists()) {
                DocumentBuilderFactory fact = DocumentBuilderFactory
                        .newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse("test.xml");
                node = doc.getElementsByTagName("*");
                for (int i = 0; i < node.getLength(); i++) {
                    if (node.item(i).getNodeName().equals("component")) {
                        ComponentFactory.createComponent(node.item(i)
                                .getChildNodes(), StructureType
                                .stringToStructureType(node.item(i)
                                        .getParentNode().getNodeName()));
                    }
                }
            }
        } catch (Exception e) {
        }
    }

}
