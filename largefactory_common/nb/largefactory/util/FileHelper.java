package nb.largefactory.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

import nb.largefactory.util.logging.XMLErrors;
import nb.largefactory.xml.XMLDefaultFileNames;
import nb.largefactory.xml.XMLTestCode;
import nb.largefactory.xml.XMLChecker;

public class FileHelper {

    public static FilenameFilter xmlFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".xml");
        }

    };

    public static String[] getNames(File[] files) {
        String[] filenames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            filenames[i] = files[i].getName();
        }
        return filenames;
    }
    
    public static File[] getDefaultXMLFiles() {
        try {
            ArrayList<File> xmlFiles = new ArrayList<File>();
            for(XMLDefaultFileNames x : XMLDefaultFileNames.values()){
                URL url = XMLChecker.class.getResource(x + ".xml");
                xmlFiles.add(new File(URLDecoder.decode(url.getFile(), "UTF-8")));
                XMLErrors.FOUND_INTERNAL_FILES.printError(URLDecoder.decode(url.getPath(), "UTF-8"));
            }
            return xmlFiles.toArray(new File[xmlFiles.size()]);
    } catch(UnsupportedEncodingException e) {
        throw new IllegalArgumentException("default XML location not findable", e);
    }
    }
    
}
