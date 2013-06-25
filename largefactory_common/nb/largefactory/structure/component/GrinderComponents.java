package nb.largefactory.structure.component;

import nb.largefactory.structure.StructureType;

public class GrinderComponents extends ComponentDataClass {
    boolean disk = false;
    float ergCost = 0;
    float percentYieldIncreace = 0;
    float ergCostReduction = 0;

    public GrinderComponents(String nameSet, String[] recipieSet,
            int[] dimensionsSet, int maxNumberSet, boolean diskSet) {
        strutureType = StructureType.GRINDER;
        name = nameSet;
        if (nameSet.equals("grinder")) {
            main = true;
        }
        recipie = recipieSet;
        dimensions = dimensionsSet;
        maxNumber = maxNumberSet;
        disk = diskSet;
    }

}
