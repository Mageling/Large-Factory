package nb.largefactory.structure.calculations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.NodeList;

import nb.largefactory.structure.component.*;

public class Grinder {
    public HashMap<String, Integer> process(NodeList components, HashMap<String, Integer> input){
        HashMap<String, Integer> effect = new HashMap<String, Integer>();
        effect.put("ergcost", 0);
        effect.put("percentyield", 0);
        effect.put("ergcostreduction", 0);
        effect.put("timeincreace", 0);
        effect.put("slagergcost", 0);
        int ergcost = 1000;
        
        for(int i = 0; i < components.getLength(); i++){
            effect = ComponentFactory.componentList.get(components.item(i).getTextContent()).provideInformation(effect);            
        }

        Iterator<Entry<String, Integer>> it = input.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
            //System.out.println(entry.getKey() + " = " + entry.getValue());
            input.put(entry.getKey(),entry.getValue()*1000);
            ergcost = ergcost + entry.getValue()*1000;
            it.remove(); // avoids a ConcurrentModificationException        
        }
        return input;
    }
}
