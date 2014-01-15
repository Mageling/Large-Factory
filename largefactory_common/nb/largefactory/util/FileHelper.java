package nb.largefactory.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import nb.largefactory.xml.XMLTestCode;
import nb.largefactory.xml.XMLUpdater;

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
    
    public static String getDefaultXMLFiles() {
        try {
            URL url = XMLUpdater.class.getResource("Structure.xml");
            return URLDecoder.decode(url.getPath(), "UTF-8").replace("/Structure.xml", "");
    } catch(UnsupportedEncodingException e) {
        throw new IllegalArgumentException("default XML location not findable", e);
    }
    }
    
}
