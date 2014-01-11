package nb.largefactory.structure;

public enum StructureCreationErrors {
    CONTROL_BLOCK("The control block failed to validate",""),
    INNER_BLOCK("Exposed component",""),
    INNER_CASING_BLOCK("Exposed filler casing",""),
    FACE_CASING_BLOCK("Edges expected",""),
    EDGE_CASING_BLOCK("Corners expected",""),
    TWO_CONTROL_BLOCK("Multiple control blocks of the same type found",""),
    MISSING_BLOCK("This structure requires a component that was not found",""),
    ALREADY_IN_STRUCTURE("There is already a "," type component in this structure"),
    ADJACENT_MULTIBLOCK("Multiblock components of the same type cannot be adjascent",""),
    INCORRECT_MULTIBLOCK("This multiblock ", " was formed incorrectly"),

    OTHER("Unknown Error","");

    private String part1;
    private String part2;

    StructureCreationErrors(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public void printError(int x, int y, int z) {
        String error = "An error occured at" + x + ", " + y + ", " + z + ": " + part1;
        System.out.println(error);
    }
    
    public void printErrorExtraInformation(int x, int y, int z, String s){
        String error = "An error occured at" + x + ", " + y + ", " + z + ": " + part1 + s + part2;
        System.out.println(error);
    }

}
