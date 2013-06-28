package nb.largefactory.structure.component;

import java.util.HashMap;

import nb.largefactory.structure.StructureType;

public class GrinderComponents extends ComponentDataClass {
    boolean disk = false;
    int ergCost = 0;
    int percentYieldIncreace = 0;
    int ergCostReduction = 0;
    int slagErgCost = 0;
    int timeIncreace = 0;

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
     * @param controlBlockSet
     * @param timeIncreaseSet
     * @param slagErgCostSet
     */
    public GrinderComponents(String nameSet, String recipeSet,
            String dimensionsSet, String maxNumberSet, String diskSet,
            String ergCostSet, String percentYieldIncreaceSet,
            String ergCostReductionSet, String textureFileLocationSet,
            String controlBlockSet, String timeIncreaseSet,
            String slagErgCostSet) {
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
        if (slagErgCostSet != null) {
            slagErgCost = Integer.parseInt(slagErgCostSet);
        }
        if (timeIncreaseSet != null) {
            timeIncreace = Integer.parseInt(timeIncreaseSet);
        }
        if (controlBlockSet != null) {
            controlBlock = true;
        }
        if (diskSet != null) {
            disk = true;
        }
        if (ergCostSet != null) {
            ergCost = Integer.parseInt(ergCostSet);
        }
        if (percentYieldIncreaceSet != null) {
            percentYieldIncreace = Integer.parseInt(percentYieldIncreaceSet);
        }
        if (ergCostReductionSet != null) {
            ergCostReduction = Integer.parseInt(ergCostReductionSet);
        }
    }

    @Override
    public HashMap<String, Integer> provideInformation(
            HashMap<String, Integer> current) {
        current.put("ergcost", current.get("ergcost") + ergCost);
        current.put("percentyield", current.get("percentyield")
                + percentYieldIncreace);
        current.put("ergcostreduction", current.get("ergcostreduction")
                + ergCostReduction);
        current.put("slagergcost", current.get("slagergcost") + slagErgCost);
        current.put("timeincreace", current.get("timeincreace") + timeIncreace);
        return current;
    }
}
