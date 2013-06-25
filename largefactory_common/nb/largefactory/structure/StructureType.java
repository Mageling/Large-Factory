package nb.largefactory.structure;

import nb.largefactory.structure.component.ComponentDataClass;
import nb.largefactory.structure.component.GrinderComponents;

public enum StructureType {

    CASING(false, false, null),
    // T1
    CRUSHER(true, false, null),
    GRINDER(false, false, GrinderComponents.class),
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
    private Class<? extends ComponentDataClass> componentClass;

    private StructureType(boolean isInput, boolean isOutput,
            Class<? extends ComponentDataClass> componentClass) {
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
    
    public Class<? extends ComponentDataClass> getComponentClass() {
        return componentClass;
    }

    public static StructureType stringToStructureType(String structureName) {
        return StructureType.valueOf(structureName.toUpperCase().replace(" ",
                "_"));
    }

    public boolean validateStructure(String[] components, int x, int y, int z) {
        for (String component : components) {
             // TODO check for required block
        }
        StructureCreationErrors.MISSING_BLOCK.printError(x, y, z);
        return false;
    }

}
