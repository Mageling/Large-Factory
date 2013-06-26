package nb.largefactory.structure;

import nb.largefactory.structure.component.ComponentFactory;

public enum StructureType {

    CASING(false, false, true),
    // T1
    CRUSHER(true, false, false),
    GRINDER(false, false, true),
    EXTRACTOR(false, false, false),
    SCRAPER(false, false, false),
    SOLID_SEPARATOR(false, false, false),
    COMPACTOR(false, true, false),
    SMELTER(false, true, false),
    COAGULATOR(false, true, false),

    // T2
    MELTER(true, false, false),
    REFINER(false, false, false),
    SKIMMER(false, false, false),
    PURIFIER(false, false, false),
    LIQUID_SEPARATOR(false, false, false),
    BLAST_INJECTOR(false, false, false),
    COOLER(false, true, false),
    HEATED_STORAGE_UNIT(false, true, false);

    // T3 to be reworked

    private boolean isInput;
    private boolean isOutput;
    private boolean specialValidation;

    private StructureType(boolean isInput, boolean isOutput,
            boolean specialValidation) {
        this.isInput = isInput;
        this.isOutput = isOutput;
        this.specialValidation = specialValidation;
    }

    public boolean isInput() {
        return isInput;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public static StructureType stringToStructureType(String structureName) {
        return StructureType.valueOf(structureName.toUpperCase().replace(" ",
                "_"));
    }

    public boolean validateStructure(String[] components, int x, int y, int z) {
        if (specialValidation) {
            if (SpecialValidationHandler.validateStructure(this, components)) {
                return true;
            }
            StructureCreationErrors.MISSING_BLOCK.printError(x, y, z);
            return false;
        }
        for (String component : components) {
            if (ComponentFactory.componentList.get(component).isRequired()) {
                return true;
            }
        }
        StructureCreationErrors.MISSING_BLOCK.printError(x, y, z);
        return false;
    }

}
