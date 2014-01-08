package nb.largefactory.util;

import java.util.HashMap;

@SuppressWarnings("serial")
public class DataMap<S, F> extends HashMap<String, Float>{
    public void add(String key, Float value){
        put(key, value + get(key));

    }

}
