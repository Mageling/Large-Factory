package nb.largefactory.xml;

import java.io.File;
import java.io.IOException;

import nb.largefactory.lib.locations.Files;
import nb.largefactory.util.FileHelper;
import nb.largefactory.util.logging.XMLErrors;
import nb.largefactory.util.logging.XMLLogger;

import org.apache.commons.io.FileUtils;

public class XMLUpdater {
    static File xmldir;
    static File[] xmlDefaults = FileHelper.getDefaultXMLFiles();

    public static void checkXMLs() throws IOException {
        xmldir = new File(Files.CONFIG_LOCATION + Files.XML_LOCATION_MODIFIER);
        File[] xmls = xmldir.listFiles(FileHelper.xmlFilter);
        if (isValidXMLs(xmls)) {
            XMLLogger.VALIDATED_XML.printLog();
            XMLDecoder.xmlFiles = xmls;
        } else if (!isValidXMLs(xmlDefaults)) {
            XMLErrors.DEFAULT_XML_INVALID.printError();
            throw new IllegalArgumentException("Internal XML files are not valid");
        } else {
            XMLLogger.REPLACING_XMLS.printLog();
            for (File file : xmls) {
                file.delete();
            }
            for (File file : xmlDefaults) {
                FileUtils.copyFileToDirectory(file, xmldir);
            }
            XMLDecoder.xmlFiles = xmldir.listFiles(FileHelper.xmlFilter);
        }
    }


    public static void init() {
        try {
            checkXMLs();
        } catch (IOException e) {
            XMLErrors.FILE_TRANSFER.printError();
            e.printStackTrace();
        }
    }

}
