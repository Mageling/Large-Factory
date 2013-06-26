package nb.largefactory.structure;

import nb.largefactory.structure.component.*;

public enum StructureType {

    CASING(false, false),
    // T1
    CRUSHER(true, false),
    GRINDER(false, false),
    EXTRACTOR(false, false),
    SCRAPER(false, false),
    SOLID_SEPARATOR(false, false),
    COMPACTOR(false, true),
    SMELTER(false, true),
    COAGULATOR(false, true),

    // T2
    MELTER(true, false),
    REFINER(false, false),
    SKIMMER(false, false),
    PURIFIER(false, false),
    LIQUID_SEPARATOR(false, false),
    BLAST_INJECTOR(false, false),
    COOLER(false, true),
    HEATED_STORAGE_UNIT(false, true);

    // T3 to be reworked

    private boolean isInput;
    private boolean isOutput;

    private StructureType(boolean isInput, boolean isOutput) {
        this.isInput = isInput;
        this.isOutput = isOutput;
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
        for (String component : components) {
            if (ComponentFactory.componentList.get(component).isRequired()) {
                return true;
            }
        }
        StructureCreationErrors.MISSING_BLOCK.printError(x, y, z);
        return false;
    }

}
