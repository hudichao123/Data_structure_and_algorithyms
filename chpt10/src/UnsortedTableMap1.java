import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;

public class UnsortedTableMap1<K,V> extends AbstractMap1<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap1() { }

    public int findIndex(K k) {
        int index;
        for (index = 0; index < table.size(); index++) {
            if (table.get(index).getKey() == k) {
                return index;
            }
        }
        return -1;
    }

    public int size() {
        return table.size();

    }

    public V get(K k) {
        int index = findIndex(k);
        if (index == -1) {
            return null;
        }
        return table.get(index).getValue();
    }

    public V put(K k, V v) {
        int index = findIndex(k);
        if (index == -1) {
            table.add(new MapEntry<K,V>(k,v));
            return null;


        } else {
            V value = ((MapEntry<K,V>)(table.get(index))).v;
            ((MapEntry<K,V>)(table.get(index))).v = v;
            return v;
        }
    }

    public V remove(K k) {
        int index = findIndex(k);
        MapEntry<K, V> entry = table.get(table.size() - 1);
        if (index == -1) {
            return null;
        } else {
            V value = table.get(index).v;
        if (index != table.size() - 1) {
            table.get(index).v = entry.v;
        }
        table.remove(size() - 1);
        return value;
        }
    }

    public class EntryIterator implements Iterator<Entry<K, V>> {
        int j = 0;
        public Entry<K, V> next() {
            if (j == size()) {
                throw new java.util.NoSuchElementException();
            }
            return table.get(j++);
        }

        public boolean hasNext() {
            return j >= table.size();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class EntryIterable implements Iterable<Entry<K, V>> {
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    public Iterable<Entry<K,V>> entrySet() {
        return new EntryIterable();
    }

}
