package nb.largefactory.structure.calculations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nb.largefactory.util.DataMap;
import nb.largefactory.util.MathHelper;

/*
 * some high level stuff right here
 * Cycle data needs to contain everything
 * It starts with a hashmap of imported blocks
 * 
 */
public class CycleData {
    public HashMap<String, DataMap<String, Float>> SolidResources;
    public HashMap<String, DataMap<String, Float>> LiquidResources;
    public HashMap<String, DataMap<String, Float>> GasResources;
    List<Float> timeRemaining;
    Float powerUse;

    public CycleData(HashMap<String, Float> input, HashMap<String, Float> slag, Float time, Float power){
        SolidResources = new HashMap<String, DataMap<String, Float>>();
        LiquidResources = new HashMap<String, DataMap<String, Float>>();
        GasResources = new HashMap<String, DataMap<String, Float>>();
        timeRemaining = new ArrayList<Float>();
        timeRemaining.set(0, time);
        powerUse = power;
    }

    public void addImput(StateEnum state, DataMap<String, Float> input, DataMap<String, Float> slag, String pathName, String slagPathName, Float time, int timeSpace, Float power){
        while(timeRemaining.size() < timeSpace){
            timeRemaining.add(0.0f);
        }
        timeRemaining.set(timeSpace, time);
        powerUse += power;

        switch(state){
        case SOLID: SolidResources.put(pathName, input.combine(SolidResources.get(pathName)));
        SolidResources.put(slagPathName, slag.combine(SolidResources.get(slagPathName)));
        break;
        case GAS: GasResources.put(pathName, input.combine(SolidResources.get(pathName)));
        GasResources.put(slagPathName, slag.combine(SolidResources.get(slagPathName)));
        break;
        case LIQUID: LiquidResources.put(pathName, input.combine(SolidResources.get(pathName)));
        LiquidResources.put(slagPathName, slag.combine(SolidResources.get(slagPathName)));
        break;
        default: //nothing
        break;
        }

    }

    public Float GetTimeRequired(){
        return MathHelper.calcualteMaximumF(timeRemaining);
    }

}


