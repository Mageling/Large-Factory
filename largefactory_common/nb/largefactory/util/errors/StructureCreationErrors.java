package nb.largefactory.util.errors;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

public enum StructureCreationErrors {
    CONTROL_BLOCK("The control block failed to validate", ""),
    INNER_BLOCK("Exposed component", ""),
    INNER_CASING_BLOCK("Exposed filler casing", ""),
    FACE_CASING_BLOCK("Edges expected", ""),
    EDGE_CASING_BLOCK("Corners expected", ""),
    TWO_CONTROL_BLOCK("Multiple control blocks of the same type found", ""),
    MISSING_BLOCK("This structure requires a component that was not found:", ""),
    ALREADY_IN_STRUCTURE("This block is already in a structure", ""),
    TYPE_ALREADY_EXISTS("There is already a ", " in the structure"),
    INCORRECT_MULTIBLOCK("The multiblock ", " was formed incorrectly"),
    NO_TYPE("There is not component of ","  type"),

    OTHER("Unknown Error", "");

    private String part1;
    private String part2;

    StructureCreationErrors(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public void printError(int x, int y, int z) {
        printError(x, y, z, "");
    }

    public void printError(int x, int y, int z, String s) {
        String error = "An error occured at" + x + ", " + y + ", " + z + ": " + part1 + s + part2;
        FMLLog.log(Level.WARNING, error);
    }

}
