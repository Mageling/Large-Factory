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
	Float dustmultiplyer;
	HashMap<String, Float> solid;
	HashMap<String, Float> waste;

	Crusher(){
		oreValue = 120f;
		mainOre = 120f;
		slag = 880f;
		slagPercentBonus = 0f;
		slagOre = 120f;
		ergCost = 1000f;
		timeCost = 2000f;
		timePercent = 1f;
		ergPercent = 1f;
		attuneMetal = null;
		attuneValue = 0;
		attuneDisvalue = 0;
		secondaryBonus = 0;
		secondaryPercentBonus = 0f;
		dustmultiplyer = 1f;
		//modify them
	}

	public CycleData RunCrusher(Imput start){
		int numberOfBlocks = start.numberOfItems;
		Float oreSlag = 0f;
		solid = new HashMap<String, Float>();
		waste = new HashMap<String, Float>();
		MetalClass currentMetal = MetalFactory.metalList.get(start.getNameOfMaterial());
		if(currentMetal.getDust() != null){
		    dustmultiplyer = currentMetal.getDust();
		}
		if(currentMetal.getYield() != null){
			if(start.getNameOfMaterial().equals(attuneMetal) || attuneMetal == null){
				solid.put(start.getNameOfMaterial(), (mainOre + attuneValue) * dustmultiplyer * YieldValues.YIELD.percentYield() * numberOfBlocks);
			}else{
				solid.put(start.getNameOfMaterial(), (mainOre + attuneDisvalue) * dustmultiplyer * YieldValues.YIELD.percentYield() * numberOfBlocks);
			}
			if(start.getNameOfMaterial().equals(attuneMetal) || attuneMetal == null){
                waste.put(start.getNameOfMaterial(), (slagOre) * YieldValues.YIELD.percentYield() * numberOfBlocks);
            }else{
                waste.put(start.getNameOfMaterial(), (slagOre + attuneDisvalue) * YieldValues.YIELD.percentYield() * numberOfBlocks);
            }
		}
		if(currentMetal.getPrimary() != null){
		    Float tmp = (oreValue + secondaryBonus) * (secondaryPercentBonus + 1) * YieldValues.PRIMARY.percentYield() * numberOfBlocks;
			waste.put(currentMetal.getPrimary(), tmp);
			oreSlag += tmp;
		}
		if(currentMetal.getSecondary() != null){
		    Float tmp = oreValue * YieldValues.SECONDARY.percentYield() * numberOfBlocks;
            waste.put(currentMetal.getSecondary(), tmp);
            oreSlag += tmp;
		}
		if(currentMetal.getTertiary() != null){
            Float tmp = oreValue * YieldValues.TERTIARY.percentYield() * numberOfBlocks;
            waste.put(currentMetal.getTertiary(), tmp);
            oreSlag += tmp;
        }
		if(currentMetal.getQuaternary() != null){
            Float tmp = oreValue * YieldValues.QUATERNARY.percentYield() * numberOfBlocks;
            waste.put(currentMetal.getQuaternary(), tmp);
            oreSlag += tmp;
        }
		if(oreSlag > slag * (slagPercentBonus + 1)){
		    waste.put("slag", slag - oreSlag);
		}
		CycleData out = new CycleData(StateEnum.Solid, solid, waste, timeCost * timePercent, ergCost * ergPercent);
		return out;

	}
}
