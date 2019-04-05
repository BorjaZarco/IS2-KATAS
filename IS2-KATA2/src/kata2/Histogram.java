
package kata2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Histogram<T> {
    private Map <T, Integer> histogram;

    public Histogram(T[] data) {
        this.histogram = new HashMap <>();
        setHistogram(data);
    }
    
    public void initHistogram () {
        this.histogram = new HashMap <>();
    }
    
    public void initHistogram (T[] data) {
        this.histogram = new HashMap <>();
        setHistogram(data);
    }
    
    private void setHistogram (T[] data) {
        for (T key : data) {
            this.histogram.put(key, this.histogram.containsKey(key)
            ? this.histogram.get(key)+1
            : 1);            
        }
    }
    
    public Map <T, Integer> getHistogram () {
        return histogram;
    };
    
    public void printHistogram () {
        Iterator i = histogram.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = (Map.Entry) i.next();
            System.out.println(entry.getKey() + "==>" +entry.getValue());
        }
    }
    
}
