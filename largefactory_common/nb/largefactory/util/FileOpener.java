package nb.largefactory.util;

import java.io.File;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nb.largefactory.lib.locations.Files;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import cpw.mods.fml.common.FMLLog;

public class FileOpener {
    public static NodeList openXML(String location){
        try{
            File file = new File(location);
            if(file.exists()){
                DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = fact.newDocumentBuilder();
                Document doc = builder.parse(location);
                NodeList node = doc.getElementsByTagName("*");
                node = trimNodelist(node);
                return node;
            }
            return null;
        }
        catch  (Exception e){
            FMLLog.log(Level.SEVERE,e.getMessage());
            return null;
        }
    }
    
    public static NodeList trimNodelist(NodeList node){
        for (int k = 0; k < node.getLength(); k++) {
            if (node.item(k).getTextContent().trim().length() == 0) {
                node.item(k).getParentNode().removeChild(node.item(k));
            }
        }
        return node;
    }
}
