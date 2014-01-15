package nb.largefactory.util.logging;

import java.util.logging.Level;

import nb.largefactory.lib.DefaultErrorLevels;
import cpw.mods.fml.common.FMLLog;

public enum XMLErrors {
    METAL_MISSING("The XML file for metals is missing", ""),
    COMPONENT_MISSING("The XML file for components is missing", ""),
    STRUCTURE_MISSING("The XML file for structures is missing", ""),
    METAL_INVALID("The metal ", " has an invalid XML entry called"),
    INVALID_DIMENSIONS("The component ", " has invalid dimensions"),
    XML_STARTING_NODE_INVALID("The first node in the the XML file: ", " is invalid"),
    DEFAULT_XML_INVALID("The XMLs in your mod file have been corrupted. Please redownload the mod.", ""),
    FAILED_TO_LOAD("The XML file ", "Failed to load"),
    FILE_TRANSFER("Files failed to update properly", ""),
    FOUND_INTERNAL_FILES("Found internal file :", ""),
    UNKNOWN_ERROR("THIS IS VERY BAD", "");

    private String part1;
    private String part2;

    XMLErrors(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public void printError() {
        printError("");
    }

    public void printError(String s) {
        printError(DefaultErrorLevels.XML, s);
    }

    public void printError(Level level, String s) {
        String error = part1 + s + part2;
        FMLLog.log(level, error);
    }
}
