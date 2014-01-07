package nb.largefactory.structure.calculations;

public class MetalClass {
    String name = null;
    String yield = null;
    String primary = null;
    String secondary = null;
    String tertiary = null;
    String quaternary = null;
    
    public MetalClass(String metalname){
        name = metalname;
    }
    
    public String getName() {
        return name;
    }

    public String getYield() {
        return yield;
    }

    public String getPrimary() {
        return primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public String getTertiary() {
        return tertiary;
    }

    public String getQuaternary() {
        return quaternary;
    }

    public void addSecondaries(YieldValues second, String data){
        switch(second){
            case PRIMARY: primary = data;
                break;
            case QUATERNARY: quaternary = data;
                break;
            case SECONDARY: secondary = data;
                break;
            case TERTIARY: tertiary = data;
                break;
            case YIELD: yield = data;
                break;
            default: yield = data;
                break;
            
        }
    }
}
