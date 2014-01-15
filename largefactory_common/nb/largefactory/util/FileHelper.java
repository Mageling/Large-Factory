package nb.largefactory.util;

import java.io.File;
import java.io.FilenameFilter;

import nb.largefactory.xml.XMLTestCode;

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
    
}
