package nb.largefactory.util.errors;

import java.util.logging.Level;

import nb.largefactory.lib.DefaultErrorLevels;
import cpw.mods.fml.common.FMLLog;

public enum XMLErrors {
    METAL_MISSING("The XML file for metals is missing", ""),
    COMPONENT_MISSING("The XML file for components is missing", ""),
    STRUCTURE_MISSING("The XML file for structures is missing", ""),
    METAL_INVALID("The metal ", " has an invalid XML entry called"),
    INVALID_DIMENSIONS("The component ", " has invalid dimensions"),
    ADDED_ENTRY("Added ",""),
    LOADED_METAL("The XML metal file is loaded", ""),
    LOADED_COMPONENTS("The XML component file is loaded", ""),
    LOADED_STRUCTURE("The XML structure file is loaded", ""),
    
    UNKNOWN_ERROR("THIS IS VERY BAD/TESTING PURPOSE","");

    private String part1;
    private String part2;

    XMLErrors(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public void printError() {
        FMLLog.log(DefaultErrorLevels.XML, part1);
    }

    public void printError(String s) {
        printError(DefaultErrorLevels.XML, s);
    }

    public void printError(Level level) {
        printError(level, "");
    }

    public void printError(Level level, String s) {
        String error = part1 + s + part2;
        FMLLog.log(level, error);
    }
}
