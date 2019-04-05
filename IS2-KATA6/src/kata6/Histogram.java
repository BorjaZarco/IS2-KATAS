package kata6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram<T> {
    private final Map<T, Integer> map;

    public Histogram(Iterator<T> iterator) {
        this(iterableOf(iterator));
    }

    private static <T> Iterable<T> iterableOf(Iterator<T> iterator) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }
        };
    }

    public Histogram(Iterable<T> iterable) {
        this.map = new HashMap<T, Integer>();
        for (T item : iterable) add(item);
    }

    private void add(T item) {
        map.put(item, get(item)+1);
    }

    private int get(T item) {
        return map.containsKey(item) ? map.get(item) : 0;
    }
}
