package nb.largefactory.structure.calculations;

public enum YieldValues {
	YIELD(1f),
	PRIMARY(.5f),
	SECONDARY(.1f),
	TERTIARY(.02f),
	QUATERNARY(.005f)
	;
	private Float percent;

	private YieldValues(Float percent){
		this.percent = percent;
	}
	public static YieldValues stringToMetal(String metalName) {
		return YieldValues.valueOf(metalName.toUpperCase());
	}

	public Float percentYield(){
		return percent;
	}
}
