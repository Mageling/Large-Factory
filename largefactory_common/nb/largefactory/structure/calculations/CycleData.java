package nb.largefactory.structure.calculations;

import java.util.HashMap;
import java.util.Map;

/*
 * some high level stuff right here
 * Cycle data needs to contain everything
 * It starts with a hashmap of imported blocks
 * 
 */
public class CycleData {
    Float timeRequired = new Float(null);
    
    public CycleData(HashMap<String, Float> input){
        Map<String, Float> Blocks = new HashMap<String, Float>();
        Map<String, Float> LiquidSlag1 = new HashMap<String, Float>();
        Map<String, Float> LiquidOre1 = new HashMap<String, Float>();
        Map<String, Float> GassSlag1 = new HashMap<String, Float>();
        Map<String, Float> GassOre1 = new HashMap<String, Float>();
        Blocks = input;
    }
    
    public HashMap GetBlocks(){
        return Blocks;
    }
}
