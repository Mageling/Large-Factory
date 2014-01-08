package nb.largefactory.structure.calculations;

import java.util.Map;

import nb.largefactory.util.DataMap;

public class Crusher {

	Float mainOreBonus;
	Float slagPercentBonus;
	Float slagBonus;
	Float ergCost;
	Float timeCost;
	Float timePercent;
	Float ergPercent;
	String attuneMetal;
	int attuneValue;
	int attuneDisvalue;
	int secondaryBonus;
	Float secondaryPercentBonus;
	DataMap<String, Float> solid;
	DataMap<String, Float> waste;
	CycleData out;

	Crusher(){
		mainOreBonus = 0f;
		slagPercentBonus = 0f;
		slagBonus = 0f;
		ergCost = 1000f;
		timeCost = 2000f;
		timePercent = 1f;
		ergPercent = 1f;
		attuneMetal = null;
		attuneValue = 0;
		attuneDisvalue = 0;
		secondaryBonus = 0;
		secondaryPercentBonus = 0f;
		//modify them
	}

	public CycleData RunCrusher(Imput start){
	    solid = new DataMap<String, Float>();
        waste = new DataMap<String, Float>();
	    for(int i = 0; i < 5; i++/*some stuff */){
	        int numberOfBlocks = start.numberOfItems;
	        Float oreSlag = 0f;
		    MetalClass currentMetal = MetalFactory.metalList.get(start.getNameOfMaterial());
		    
		    if(attuneMetal == currentMetal.getName()){
		        solid.add(currentMetal.getName(), (currentMetal.getPrimaryValue() + mainOreBonus + attuneValue) * numberOfBlocks);
		    }else{
		        solid.add(currentMetal.getName(), (currentMetal.getPrimaryValue() + mainOreBonus + attuneDisvalue) * numberOfBlocks);
		    }
		    for (Map.Entry<String, Float> entry : currentMetal.getAllYieldValue().entrySet()){
		        if(entry.getKey() != "slag"){
		            Float tmp = (currentMetal.getYieldValue(entry.getKey()) + secondaryBonus) * secondaryPercentBonus * numberOfBlocks;
		            waste.add(currentMetal.getName(), tmp);
		            oreSlag += tmp;
		        }else{
		            waste.add("slag", ((currentMetal.getYieldValue(entry.getKey()) + slagBonus) * slagPercentBonus * numberOfBlocks));
		        }
		    }
	    }
	    out = new CycleData(StateEnum.Solid, solid, waste, timeCost * timePercent, ergCost * ergPercent);
	    return out;

	}
}
