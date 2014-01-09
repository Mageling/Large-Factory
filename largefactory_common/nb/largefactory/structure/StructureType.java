package nb.largefactory.structure;

import java.util.ArrayList;
import java.util.List;

import nb.largefactory.structure.component.ComponentFactory;

public class StructureType {
    String name;
    boolean isInput;
    boolean isOutput;
    boolean specialValidation;
    List<String> requiredComponents;

    public StructureType(String n) {
        name = n;
        isInput = false;
        isOutput = false;
        specialValidation = false;
        requiredComponents = new ArrayList<String>();
    }

    public List<String> getRequiredComponents(){
        return requiredComponents;
    }

    public void addRequiredComponent(String comp){
        requiredComponents.add(comp);
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

    public void setIsInput(){
        isInput = true;
    }

    public void setIsOutput(){
        isOutput = true;
    }

    public void setSpecialValidation(){
        specialValidation = true;
    }

    public boolean validateStructure(String[] components, int x, int y, int z) {
        if (specialValidation) {
            if (SpecialValidationHandler.validateStructure(name, components))
                return true;
            StructureCreationErrors.MISSING_BLOCK.printError(x, y, z);
            return false;
        }
        for (String component : components) {
            if (ComponentFactory.componentList.get(component).isRequired())
                return true;
        }
        StructureCreationErrors.MISSING_BLOCK.printError(x, y, z);
        return false;
    }

}
