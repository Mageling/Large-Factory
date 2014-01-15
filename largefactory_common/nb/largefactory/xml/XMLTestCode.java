package nb.largefactory.xml;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import nb.largefactory.lib.locations.Files;
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
    public void TestXMLLocation(){
        try{ 
        URL dog = this.getClass().getResource("Metals");
        File file = new File(URLDecoder.decode(dog.getFile(), "URF-8"));
        FMLLog.log(Level.INFO, file.getAbsolutePath());
        }
        catch (Exception e){
            FMLLog.log(Level.SEVERE, e.getMessage());
        }
    }

}
