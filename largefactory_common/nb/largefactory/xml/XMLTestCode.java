package nb.largefactory.xml;

import java.util.Map;

import nb.largefactory.structure.component.ComponentDataClass;
import nb.largefactory.structure.component.ComponentFactory;
import nb.largefactory.util.errors.XMLErrors;

public class XMLTestCode {
    public static void TestComponents(){
        for(Map.Entry<String, ComponentDataClass> entry: ComponentFactory.componentList.entrySet()){
            XMLErrors.ADDED_ENTRY.printError(entry.getValue().toString());
            XMLErrors.ADDED_ENTRY.printError(entry.getValue().informationAsString());
        }
    }

}
