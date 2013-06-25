package nb.largefactory.structure;

public enum StructureType {

    CASING(false, false, null),
    // T1
    CRUSHER(true, false, null),
    GRINDER(false, false, "GrinderComponents"),
    EXTRACTOR(false, false, null),
    SCRAPER(false, false, null),
    SOLID_SEPARATOR(false, false, null),
    COMPACTOR(false, true, null),
    SMELTER(false, true, null),
    COAGULATOR(false, true, null),

    // T2
    MELTER(true, false, null),
    REFINER(false, false, null),
    SKIMMER(false, false, null),
    PURIFIER(false, false, null),
    LIQUID_SEPARATOR(false, false, null),
    BLAST_INJECTOR(false, false, null),
    COOLER(false, true, null),
    HEATED_STORAGE_UNIT(false, true, null);

    // T3 to be reworked

    private boolean isInput;
    private boolean isOutput;
    private String componentClass;

    private StructureType(boolean isInput, boolean isOutput,
            String componentClass) {
        this.isInput = isInput;
        this.isOutput = isOutput;
        this.componentClass = componentClass;
    }

    public boolean isInput() {
        return isInput;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public String getComponentClass() {
        return componentClass;
    }

    public static StructureType getComponentClass(String structureName) {
        return getComponentClass(structureName);
    }

    public static StructureType stringToStructureType(String structureName) {
        return StructureType.valueOf(structureName.toUpperCase().replace(" ",
                "_"));
    }

    public boolean validateStructure(String[] components, int x, int y, int z) {
        for (String component : components) {

        }
        StructureCreationErrors.MISSING_BLOCK.printError(x, y, z);
        return false;
    }

}
