package nb.largefactory.structure;

public class SpecialValidationHandler {

    public static boolean validateStructure(StructureType structureType,
            String[] components) {
        switch (structureType) {
            case CASING:
                return false;
            case GRINDER:
                // TODO grinder validation code
                break;
            default:
                return false;
        }
        return false;
    }

}
