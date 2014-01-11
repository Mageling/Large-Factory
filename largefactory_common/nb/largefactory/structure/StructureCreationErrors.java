package nb.largefactory.structure;

public enum StructureCreationErrors {
    CONTROL_BLOCK("The control block failed to validate"), INNER_BLOCK(
            "Exposed component"), INNER_CASING_BLOCK("Exposed filler casing"), FACE_CASING_BLOCK(
                    "Edges expected"), EDGE_CASING_BLOCK("Corners expected"), TWO_CONTROL_BLOCK(
                            "Multiple control blocks of the same type found"), MISSING_BLOCK(
                                    "This structure requires a component that was not found"), ALREADY_IN_STRUCTURE(
                                            "This block is already in a structure"), ADJACENT_MULTIBLOCK(
                                                    "Multiblock components of the same type cannot be adjascent"), INCORRECT_MULTIBLOCK(
                                                            "This multiblock is formed incorrectly"),

                                                            OTHER("Unknown Error");

    private String message;

    StructureCreationErrors(String message) {
        this.message = message;
    }

    public void printError(int x, int y, int z) {
        String error = "An error occured at" + x + ", " + y + ", " + z + ": "
                + message;
        System.out.println(error);
    }

}
