package nb.largefactory.structure.calculations;

import java.util.HashMap;

public class Crusher {
    
    int mainOre;
    int slag;
    int slagPercentBonus;
    int slagOre;
    int ergCost;
    int timeCost;
    int timePercent;
    int ergPercent;
    String attuneMetal;
    int attuneValue;
    int secondaryBonus;
    int secondaryPercentBonus;
    
    Crusher(){
        int mainOre = 120;
        int slag = 880;
        int slagPercentBonus = 0;
        int slagOre = 120;
        int ergCost = 1000;
        int timeCost = 2000;
        int timePercent = 100;
        int ergPercent = 100;
        String attuneMetal = null;
        int attuneValue = 0;
        int secondaryBonus = 0;
        int secondaryPercentBonus = 0;
        //modify them
    }
    
    public CycleData RunCrusher(Imput start){
        
        
        CycleData out = new CycleData(StateEnum.Solid, output, slag, timeCost*timePercent, ergCost*ergPercent)
        return out;
    }
}
