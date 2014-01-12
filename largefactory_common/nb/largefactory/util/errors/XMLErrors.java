package nb.largefactory.util.errors;

import java.util.logging.Level;

import nb.largefactory.lib.DefaultErrorLevels;
import cpw.mods.fml.common.FMLLog;

public enum XMLErrors {
    METAL_MISSING("The XML file for metals is missing", "", DefaultErrorLevels.XML),
    COMPONENT_MISSING("The XML file for components is missing", "", DefaultErrorLevels.XML),
    STRUCTURE_MISSING("The XML file for structures is missing", "", DefaultErrorLevels.XML),
    METAL_INVALID("The metal ", " has an invalid XML entry called", DefaultErrorLevels.XML),
    INVALID_DIMENSIONS("The component ", " has invalid dimensions", DefaultErrorLevels.XML),
    ADDED_ENTRY("Added ", "", DefaultErrorLevels.INFO),
    LOADED_METAL("The XML metal file is loaded", "", DefaultErrorLevels.INFO),
    LOADED_COMPONENTS("The XML component file is loaded", "", DefaultErrorLevels.INFO),
    LOADED_STRUCTURE("The XML structure file is loaded", "", DefaultErrorLevels.INFO),

    UNKNOWN_ERROR("THIS IS VERY BAD/TESTING PURPOSE", "", DefaultErrorLevels.XML);

    private String part1;
    private String part2;
    private Level errorLevel;

    XMLErrors(String part1, String part2, Level errorlevel) {
        this.part1 = part1;
        this.part2 = part2;
        errorLevel = errorlevel;
    }

    public void printError() {
        FMLLog.log(errorLevel, part1);
    }

    public void printError(String s) {
        printError(errorLevel, s);
    }

    public void printError(Level level, String s) {
        String error = part1 + s + part2;
        FMLLog.log(level, error);
    }
}
