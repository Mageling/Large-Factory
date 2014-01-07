package nb.largefactory.structure.calculations;

import java.util.ArrayList;
import java.util.HashMap;
import nb.largefactory.structure.calculations.StateEnum;
import nb.largefactory.util.MathHelper;

/*
 * some high level stuff right here
 * Cycle data needs to contain everything
 * It starts with a hashmap of imported blocks
 * 
 */
public class CycleData {
    public HashMap<String, HashMap<String, Float>> Resources;
    ArrayList<Float> timeremaining;
    Float powerUse;

    public CycleData(StateEnum state, HashMap<String, Float> input, HashMap<String, Float> slag, Float time, Float power){
        Resources = new HashMap<String, HashMap<String, Float>>();
        timeremaining = new ArrayList<Float>();
        timeremaining.set(0, time);
        powerUse = power;
        switch(state){
            case Gas: Resources.put("MainGas",input);
                Resources.put("MainGasSlag",slag);
                break;
            case Liquid: Resources.put("MainLiquid",input);
                Resources.put("MainLiquidSlag",slag);
                break;
            case Solid: Resources.put("MainSolid",input);
                Resources.put("MainSolidSlag",slag);
                break;
            default:    Resources.put("UNKNOWNSTATE", input);
                Resources.put("UNKNOWNSTATESlag", input);
                break;
        }
    }
        
    public Float GetTimeRequired(){
        return MathHelper.calcualteMaximumF(timeremaining);
    }
    
    public void AddTimeRequired(Float time, int number){
        timeremaining.set(number, time);
    }
}
    

