package nb.largefactory.structure;

public enum StructureCreationErrors {
    CONTROL_BLOCK("The control block failed to validate"),
    INNER_BLOCK(" "),
    INNER_CASING_BLOCK(" "),
    FACE_CASING_BLOCK(" "),
    EDGE_CASING_BLOCK(" "),
    TWO_CONTROL_BLOCK(" "),
    MISSING_BLOCK(" "),
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
