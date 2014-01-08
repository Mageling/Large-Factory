package nb.largefactory.util;

import java.util.HashMap;

@SuppressWarnings("serial")
public class DataMap<S, F> extends HashMap<String, Float>{
    public void add(String key, Float value){
           this.put(key, value + this.get(key));

    }

}
