package nb.largefactory.structure.component;

import nb.largefactory.structure.StructureType;

public class GrinderComponents extends ComponentDataClass {
    boolean disk = false;
    float ergCost = 0;
    float percentYieldIncreace = 0;
    float ergCostReduction = 0;

    public GrinderComponents(String nameSet, String recipeSet,
            String dimensionsSet, String maxNumberSet, String diskSet, String ergCostSet, String percentYieldIncreaceSet, String ergCostReductionSet) {
        strutureType = StructureType.GRINDER;
        name = nameSet;
        if (nameSet.equals("grinder")) {
            main = true;
        }
        //recipe = recipeSet;
        //dimensions = dimensionsSet;
        //TODO make these parse correctly
        maxNumber = Integer.parseInt(maxNumberSet);
        if(diskSet != null){
            disk = Boolean.valueOf(diskSet);
        }
        if(ergCostSet != null){
        ergCost = Float.parseFloat(ergCostSet);
        }
        if(percentYieldIncreaceSet != null){
        percentYieldIncreace = Float.parseFloat(percentYieldIncreaceSet);
        }
        if(ergCostReductionSet != null){
        ergCostReduction = Float.parseFloat(ergCostReductionSet);
        }
    }
}
