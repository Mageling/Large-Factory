package nb.largefactory.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nb.largefactory.lib.locations.Files;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class FileOpener {
    public static NodeList openXML(String location){
        try{
            File file = new File(location);
            if(file.exists()){
                DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse(Files.XML_COMPONENT_LOCATION);
                NodeList node = doc.getElementsByTagName("*");
                for (int k = 0; k < node.getLength(); k++) {
                    if (node.item(k).getTextContent().trim().length() == 0) {
                        node.item(k).getParentNode().removeChild(node.item(k));
                    }
                }
                return node;
            }
            return null;
        }
        catch  (Exception e){
            return null;
        }
    }
}
