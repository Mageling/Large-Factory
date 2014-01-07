package nb.largefactory.structure.calculations;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.NodeList;

public class MetalFactory {
	public static Map<String, MetalClass> metalList;

	public static void instantiate(){
		metalList = new HashMap<String, MetalClass>();
	}

	public static void learnMetal(NodeList metal){
		MetalClass a = new MetalClass(metal.item(0).getTextContent());
		for(int k = 1; k < metal.getLength(); k++){
			a.addSecondaries(YieldValues.stringToMetal(metal.item(k).getNodeName()), metal.item(k).getTextContent());
		}
		metalList.put(metal.item(0).getTextContent(), a);
	}
}
