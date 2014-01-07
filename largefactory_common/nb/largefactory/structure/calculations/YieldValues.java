package nb.largefactory.structure.calculations;

public enum YieldValues {
    Yeild(100f),
    Primary(50f),
    Secondary(10f),
    Tertiary(.2f),
    Quaternary(.05f)
    ;
    private Float percent;
    
    private YieldValues(Float percent){
        this.percent = percent;
    }
    
}
