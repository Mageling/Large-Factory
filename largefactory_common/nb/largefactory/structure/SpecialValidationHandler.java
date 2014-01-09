package nb.largefactory.structure;

public class SpecialValidationHandler {

    public static boolean validateStructure(String structureType, String[] components) {
        switch (structureType) {
        case "CASING":
            return false;
        case "GRINDER":
            // TODO Grinder validation code
            break;
        default:
            return false;
        }
        return false;
    }

}
