package nb.largefactory.xml;

import java.io.File;

import nb.largefactory.lib.locations.Files;
import nb.largefactory.util.FileHelper;
import nb.largefactory.util.logging.XMLErrors;

import org.apache.commons.io.FileUtils;

public class XMLUpdater {
    static File xmldir;
    static File[] xmlDefaults = new File(Files.DEFAULT_XML_LOCATION).listFiles(FileHelper.xmlFilter);

    public static void checkXMLs() throws Exception {
        xmldir = new File(Files.CONFIG_LOCATION + Files.XML_LOCATION_MODIFIER);
        File[] xmls = xmldir.listFiles(FileHelper.xmlFilter);
        if (isValidXMLs(xmls)) {
            XMLDecoder.xmlFiles = xmls;
        } else if (!isValidXMLs(xmlDefaults)) {
            XMLErrors.DEFAULT_XML_INVALID.printError();
            throw new Exception();
            // TODO make this exception work properly.
        } else {
            for (File file : xmls) {
                file.delete();
            }
            for (File file : xmlDefaults) {
                FileUtils.copyFileToDirectory(file, xmldir);
            }
            XMLDecoder.xmlFiles = xmldir.listFiles(FileHelper.xmlFilter);
        }
    }

    public static boolean isValidXMLs(File[] files) {
        for (String name : listDefaultXMLs()) {
            boolean flag = false;
            for (File file : files) {
                if (file.getName() == name) {
                    flag = true;
                }
            }
            if (!flag)
                return false;
        }
        return true;
    }

    public static String[] listDefaultXMLs() {
        return FileHelper.getNames(xmlDefaults);

    }

    public static void init() {
        try {
            checkXMLs();
        } catch (Exception e) {
            // TODO catch this exception
        }

    }

}
