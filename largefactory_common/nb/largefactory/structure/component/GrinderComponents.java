package nb.largefactory.structure.component;

import nb.largefactory.structure.StructureType;

public class GrinderComponents extends ComponentDataClass{
    boolean disk = false;
    float ergCost = 0;
    float percentYieldIncreace = 0;
    float ergCostReduction = 0;
    
    public GrinderComponents(String nameSet, String[] recipieSet, int[] dimensionsSet, int maxNumberSet, boolean diskSet){
        this.strutureType = StructureType.GRINDER;
        this.name = nameSet;
        if(nameSet.equals("grinder")){
            this.main = true;
        }
        this.recipie = recipieSet;
        this.dimensions = dimensionsSet;
        this.maxNumber = maxNumberSet;
        this.disk = diskSet;
    }
    
}
