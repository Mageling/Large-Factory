package nb.largefactory.util;

import java.util.List;

public class MathHelper {

    public static Float calcualteMaximumF(List<Float> timeRemaining){
        Float max = 0.0f;
        if(!timeRemaining.isEmpty()){
            for(Float mark: timeRemaining){
                if(mark > max){
                    max = mark;
                }
            }
        }
        return max;
    }

}
