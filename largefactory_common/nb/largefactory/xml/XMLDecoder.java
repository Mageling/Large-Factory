package nb.largefactory.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import nb.largefactory.structure.StructureType;


public class XMLDecoder {
    public void instantiate(){
        try{
        File file = new File("test.xml");
        if (file.exists()){
        DocumentBuilderFactory fact = 
         DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = fact.newDocumentBuilder();
        Document doc = builder.parse("test.xml");
        //Node node = doc.getDocumentElement();
        NodeList node = doc.getElementsByTagName("*");
        for (int i = 0; i < node.getLength(); i++) {
            Node currentNode = node.item(i);
            String x = currentNode.getNodeName();
            if(x == "component"){
                NodeList tmpNode = currentNode.getChildNodes();
                for (int j = 0; j < tmpNode.getLength(); j++) {
                    if(j % 2 == 1){
                    System.out.println(tmpNode.item(j).getNodeName());
                    System.out.println(tmpNode.item(j).getTextContent());
                    System.out.println("");
                    }
               }
            }
            //System.out.println(firstNode.getNodeName() + ' ' + ((NodeList) firstNode).item(0).getNodeValue());
        }
        }
        else{
        System.out.println("File not found!");
        }
        }
        catch(Exception e){}
        }
    public StructureType get_structure_type(String ComponentType){
        StructureType output = StructureType.CASING;
        //do some stuff
        return output;
        }
    }
