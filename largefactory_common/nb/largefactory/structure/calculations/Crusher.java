package nb.largefactory.structure.calculations;

import java.util.HashMap;

public class Crusher {
    
    Float mainOre;
    Float slag;
    int slagPercentBonus;
    int slagOre;
    Float ergCost;
    Float timeCost;
    int timePercent;
    int ergPercent;
    String attuneMetal;
    int attuneValue;
    int attuneDisvalue;
    int secondaryBonus;
    int secondaryPercentBonus;
    HashMap<String, Float> solid;
    HashMap<String, Float> waste;
    
    Crusher(){
        Float mainOre = 120f;
        Float slag = 880f;
        int slagPercentBonus = 0;
        int slagOre = 120;
        Float ergCost = 1000f;
        Float timeCost = 2000f;
        int timePercent = 100;
        int ergPercent = 100;
        String attuneMetal = null;
        int attuneValue = 0;
        int attuneDisvalue = 0;
        int secondaryBonus = 0;
        int secondaryPercentBonus = 0;
        //modify them
    }
    
    public CycleData RunCrusher(Imput start){
        int numberOfBlocks = start.numberOfItems;
        Float oreSlag = 0f;
        solid = new HashMap<String, Float>();
        waste = new HashMap<String, Float>();
        if(start.getNameOfMaterial().equals(attuneMetal) || attuneMetal == null){
            solid.put(start.getNameOfMaterial(), (mainOre + attuneValue) * numberOfBlocks);
        }else{
        solid.put(start.getNameOfMaterial(), (mainOre + attuneDisvalue) * numberOfBlocks);
        }
        waste.put(key, value)
        
        CycleData out = new CycleData(StateEnum.Solid, solid, waste, timeCost*timePercent, ergCost*ergPercent);
        return out;

    }
}
