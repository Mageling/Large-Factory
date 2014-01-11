package nb.largefactory.structure.calculations.components;

import java.util.ArrayList;
import java.util.Map;

import nb.largefactory.structure.calculations.CycleData;
import nb.largefactory.structure.calculations.Imput;
import nb.largefactory.structure.calculations.MetalClass;
import nb.largefactory.structure.calculations.MetalFactory;
import nb.largefactory.util.DataMap;

public class Crusher {

    float                  mainOreBonus;
    float                  slagPercentBonus;
    float                  slagBonus;
    float                  ergCost;
    float                  timeCost;
    float                  timePercent;
    float                  ergPercent;
    String                 attuneMetal;
    int                    attuneValue;
    int                    attuneDisvalue;
    int                    secondaryBonus;
    float                  secondaryPercentBonus;
    DataMap<String, Float> solid;
    DataMap<String, Float> waste;
    CycleData              out;

    Crusher() {
        mainOreBonus = 0f;
        slagPercentBonus = 0f;
        slagBonus = 0f;
        ergCost = 1000f;
        timeCost = 2000f;
        timePercent = 1f;
        ergPercent = 1f;
        attuneMetal = null;
        attuneValue = 0;
        attuneDisvalue = 0;
        secondaryBonus = 0;
        secondaryPercentBonus = 0f;
        // modify them
    }

    public CycleData RunCrusher(ArrayList<Imput> start) {
        solid = new DataMap<String, Float>();
        waste = new DataMap<String, Float>();
        for (Imput I : start) {
            int numberOfBlocks = I.getNumberOfItems();
            Float oreSlag = 0f;
            MetalClass currentMetal = MetalFactory.metalList.get(I.getNameOfMaterial());

            if (attuneMetal == currentMetal.getName() || attuneMetal == null) {
                solid.add(currentMetal.getName(), (currentMetal.getPrimaryValue() + mainOreBonus + attuneValue)
                        * numberOfBlocks);
            } else {
                solid.add(currentMetal.getName(), (currentMetal.getPrimaryValue() + mainOreBonus + attuneDisvalue)
                        * numberOfBlocks);
            }
            for (Map.Entry<String, Float> entry : currentMetal.getAllYieldValue().entrySet()) {
                if (entry.getKey() != "slag") {
                    Float tmp = (currentMetal.getYieldValue(entry.getKey()) + secondaryBonus) * secondaryPercentBonus
                            * numberOfBlocks;
                    waste.add(currentMetal.getName(), tmp);
                    oreSlag += tmp;
                } else {
                    waste.add("slag", (currentMetal.getYieldValue(entry.getKey()) + slagBonus) * slagPercentBonus
                            * numberOfBlocks);
                }
            }
        }
        out = new CycleData(solid, waste, timeCost * timePercent, ergCost * ergPercent);
        return out;

    }
}
