package nb.largefactory.structure;

import java.util.ArrayList;
import java.util.List;

public class StructureType {
    String       name;
    boolean      isInput;
    boolean      isOutput;
    boolean      specialValidation;
    List<String> requiredComponents;
    String       requiredType;

    public StructureType(String n) {
        name = n;
        isInput = false;
        isOutput = false;
        specialValidation = false;
        requiredComponents = new ArrayList<String>();
        requiredType = null;
    }

    public List<String> getRequiredComponents() {
        return requiredComponents;
    }

    public void addRequiredComponent(String comp) {
        requiredComponents.add(comp);
    }

    public String getRequiredType() {
        return requiredType;
    }

    public void addRequiredType(String type) {
        requiredType = type;
    }

    public String getName() {
        return name;
    }

    public boolean isInput() {
        return isInput;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public boolean isSpecialValidation() {
        return specialValidation;
    }

    public void setIsInput() {
        isInput = true;
    }

    public void setIsOutput() {
        isOutput = true;
    }

    public void setSpecialValidation() {
        specialValidation = true;
    }

}
