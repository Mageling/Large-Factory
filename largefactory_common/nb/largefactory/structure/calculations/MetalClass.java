package nb.largefactory.structure.calculations;

import java.util.HashMap;

public class MetalClass {
    String name;
    // don't know if we need this
    String forgeOreName;
    String primary;
    Float primaryYield;
    HashMap<String, Float> yields;

    public MetalClass(String metalname) {
        name = metalname;
        yields = new HashMap<String, Float>();
    }

    public String getName() {
        return name;
        // return forgeOreName;
    }

    public void importPrimaryValue(String metal, Float value) {
        primary = metal;
        primaryYield = value;
    }

    public Float getPrimaryValue() {
        return primaryYield;
    }

    public void importYieldValue(String metal, Float value) {
        yields.put(metal, value);
    }

    public HashMap<String, Float> getAllYieldValue() {
        return yields;
    }

    public Float getYieldValue(String metal) {
        return yields.get(metal);
    }
}
