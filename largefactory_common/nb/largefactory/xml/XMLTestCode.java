package nb.largefactory.xml;

import java.util.Map;

import nb.largefactory.structure.component.ComponentDataClass;
import nb.largefactory.structure.component.ComponentFactory;
import nb.largefactory.util.logging.XMLLogger;

public class XMLTestCode {
    public static void TestComponents() {
        for (Map.Entry<String, ComponentDataClass> entry : ComponentFactory.componentList.entrySet()) {
            XMLLogger.ADDED_ENTRY.printLog(entry.getValue().toString());
            XMLLogger.ADDED_ENTRY.printLog(entry.getValue().informationAsString());
        }
    }

}
