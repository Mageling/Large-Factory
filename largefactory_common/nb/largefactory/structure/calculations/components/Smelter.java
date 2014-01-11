package nb.largefactory.structure.calculations.components;

import java.util.ArrayList;
import java.util.Map;

import nb.largefactory.structure.calculations.Imput;
import nb.largefactory.util.DataMap;

public class Smelter {

    float            orePerIngot;
    float            ergPerSlag;
    float            ergPerIngot;
    float            timeCost;
    float            ergCost;
    boolean          outPutBlocks;
    boolean          oreIsPure;
    String           attuneMetal;
    float            attuneValue;
    float            attuneDisvalue;
    ArrayList<Imput> output;

    Smelter() {
        orePerIngot = 120;
        ergPerSlag = 2;
        ergPerIngot = 120;
        timeCost = 0;
        ergCost = 0;
        outPutBlocks = false;
        oreIsPure = false;
        attuneMetal = null;
        attuneValue = 0;
        attuneDisvalue = 0;
        // modify
    }

    // nothing about time right now
    public ArrayList<Imput> RunSmelter(DataMap<String, Float> data, DataMap<String, Float> slag) {
        for (Map.Entry<String, Float> entry : slag.entrySet()) {
            ergCost += entry.getValue() * ergPerSlag;
        }
        if (ergCost == 0.0) {
            oreIsPure = true;
        }
        for (Map.Entry<String, Float> entry : data.entrySet()) {
            if (attuneMetal == entry.getKey() || attuneMetal == null) {
                int tmp = (int) (entry.getValue() / (orePerIngot - attuneValue));
                Imput a = new Imput(entry.getKey(), tmp);
                output.add(a);
                if (oreIsPure) {
                    ergCost += tmp * ergPerIngot / 2;
                } else {
                    ergCost += tmp * ergPerIngot;
                }
            } else {
                int tmp = (int) (entry.getValue() / (orePerIngot - attuneDisvalue));
                Imput a = new Imput(entry.getKey(), tmp);
                output.add(a);
                if (oreIsPure) {
                    ergCost += tmp * ergPerIngot / 2;
                } else {
                    ergCost += tmp * ergPerIngot;
                }
            }
        }
        return output;
    }

}
