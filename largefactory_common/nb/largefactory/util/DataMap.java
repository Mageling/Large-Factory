package nb.largefactory.util;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class DataMap<S, F> extends HashMap<String, Float> {
    public void add(String key, Float value) {
        put(key, value + get(key));
    }

    public DataMap<S, F> combine(DataMap<S, F> other) {
        for (Map.Entry<String, Float> entry : other.entrySet()) {
            this.add(entry.getKey(), other.get(entry));
        }
        return this;
    }

}
