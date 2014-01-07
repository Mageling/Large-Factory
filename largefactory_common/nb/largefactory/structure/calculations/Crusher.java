package nb.largefactory.structure.calculations;

import java.util.HashMap;

public class Crusher {

	Float oreValue;
	Float mainOre;
	Float slag;
	Float slagPercentBonus;
	Float slagOre;
	Float ergCost;
	Float timeCost;
	Float timePercent;
	Float ergPercent;
	String attuneMetal;
	int attuneValue;
	int attuneDisvalue;
	int secondaryBonus;
	Float secondaryPercentBonus;
	HashMap<String, Float> solid;
	HashMap<String, Float> waste;

	Crusher(){
		Float oreValue = 120f;
		Float mainOre = 120f;
		Float slag = 880f;
		Float slagPercentBonus = 0f;
		Float slagOre = 120f;
		Float ergCost = 1000f;
		Float timeCost = 2000f;
		Float timePercent = 1f;
		Float ergPercent = 1f;
		String attuneMetal = null;
		int attuneValue = 0;
		int attuneDisvalue = 0;
		int secondaryBonus = 0;
		Float secondaryPercentBonus = 0f;
		//modify them
	}

	public CycleData RunCrusher(Imput start){
		int numberOfBlocks = start.numberOfItems;
		Float oreSlag = 0f;
		solid = new HashMap<String, Float>();
		waste = new HashMap<String, Float>();
		MetalClass currentMetal = MetalFactory.metalList.get(start.getNameOfMaterial());
		if(currentMetal.getYield() != null){
			if(start.getNameOfMaterial().equals(attuneMetal) || attuneMetal == null){
				solid.put(start.getNameOfMaterial(), (mainOre + attuneValue) * YieldValues.YIELD.percentYield() * numberOfBlocks);
			}else{
				solid.put(start.getNameOfMaterial(), (mainOre + attuneDisvalue) * YieldValues.YIELD.percentYield() * numberOfBlocks);
			}
		}
		if(currentMetal.getPrimary() != null){
			waste.put(currentMetal.getPrimary(), (oreValue + secondaryBonus) * (secondaryPercentBonus + 1)* YieldValues.PRIMARY.percentYield() * numberOfBlocks);
		}

		CycleData out = new CycleData(StateEnum.Solid, solid, waste, timeCost*timePercent, ergCost*ergPercent);
		return out;

	}
}
