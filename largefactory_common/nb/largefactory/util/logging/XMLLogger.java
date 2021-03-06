package nb.largefactory.util.logging;

import java.util.logging.Level;

import nb.largefactory.lib.DefaultErrorLevels;
import cpw.mods.fml.common.FMLLog;

public enum XMLLogger {

    ADDED_ENTRY("Added ", ""),
    LOADED_FILE("The XML file ", " is loaded"),

    LOADED_METAL("The XML metal file is loaded", ""),
    LOADED_COMPONENTS("The XML component file is loaded", ""),
    LOADED_STRUCTURE("The XML structure file is loaded", ""),
    VALIDATED_XML("The XML files have been successfully validated", ""),
    REPLACING_XMLS("The current XML files are invalid. Replacing...", ""),
    FILE_EXISTS("The file: ", " exists"),
    CHECKING_XMLS("Checking XML files", "");

    private String part1;
    private String part2;

    XMLLogger(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;

    }

    public void printLog() {
        printLog("");
    }

    public void printLog(String s) {
        printLog(DefaultErrorLevels.INFO, s);
    }

    public void printLog(Level level) {
        printLog(level, "");
    }

    public void printLog(Level level, String s) {
        String error = part1 + s + part2;
        FMLLog.log(level, error);
    }

}
