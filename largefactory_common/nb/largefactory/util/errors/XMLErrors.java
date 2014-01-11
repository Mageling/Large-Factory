package nb.largefactory.util.errors;

public enum XMLErrors {
    METAL_MISSING("The XML file for metals is missing"),
    COMPONENT_MISSING("The XML file for components is missing"),
    STRUCTURE_MISSING("The XML file for structures is missing"),
    METAL_INVALID("The metal ", " has an invalid XML entry called"),
    INVALID_DIMENSIONS("The component ", " has invalid dimensions");
    
    private String part1;
    private String part2;
    
    XMLErrors(String part1, String part2){
        this.part1 = part1;
        this.part2 = part2;
    }
    
    public void printError(){
        System.out.println(message);
    }
}
