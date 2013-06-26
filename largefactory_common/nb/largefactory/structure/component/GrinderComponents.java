package nb.largefactory.structure.component;

import nb.largefactory.structure.StructureType;

public class GrinderComponents extends ComponentDataClass {
    boolean disk = false;
    float ergCost = 0;
    float percentYieldIncreace = 0;
    float ergCostReduction = 0;

    /**
     * 
     * @param nameSet
     * @param recipeSet
     * @param dimensionsSet
     * @param maxNumberSet
     * @param diskSet
     * @param ergCostSet
     * @param percentYieldIncreaceSet
     * @param ergCostReductionSet
     * @param textureFileLocationSet
     */
    public GrinderComponents(String nameSet, String recipeSet,
            String dimensionsSet, String maxNumberSet, String diskSet,
            String ergCostSet, String percentYieldIncreaceSet,
            String ergCostReductionSet, String textureFileLocationSet) {
        structureType = StructureType.GRINDER;
        name = nameSet;
        if (nameSet.equals("grinder")) {
            main = true;
        }
        // recipe = recipeSet;
        // dimensions = dimensionsSet;
        // TODO make these parse correctly
        maxNumber = Integer.parseInt(maxNumberSet);
        textureFileLocation = textureFileLocationSet;
        if (diskSet != null) {
            disk = Boolean.valueOf(diskSet);
        }
        if (ergCostSet != null) {
            ergCost = Float.parseFloat(ergCostSet);
        }
        if (percentYieldIncreaceSet != null) {
            percentYieldIncreace = Float.parseFloat(percentYieldIncreaceSet);
        }
        if (ergCostReductionSet != null) {
            ergCostReduction = Float.parseFloat(ergCostReductionSet);
        }
    }
}
