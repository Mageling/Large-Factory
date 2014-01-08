package nb.largefactory.util;

import java.util.ArrayList;

public class MathHelper {

    public static Float calcualteMaximumF(ArrayList <Float> input){
        Float max = 0.0f;
        if(!input.isEmpty()){
            for(Float mark: input){
                if(mark > max){
                    max = mark;
                }
            }
        }
        return max;
    }

}
