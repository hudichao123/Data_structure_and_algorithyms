import java.util.ArrayList;


public class ChainHashMap1<K,V> extends AbstractHashMap1<K, V> {
    private UnsortedTableMap1<K,V>[] table;
    public ChainHashMap1() {
        super();
    }


    public ChainHashMap1(int capacity, int prime) {
        super(capacity, prime);
    }

    public void createTable( ) {
        table = (UnsortedTableMap1<K,V>[ ]) new UnsortedTableMap1[capacity];
    }

    public V bucketGet(int h, K k) {
        if (table[h] == null) {
            return null;
        } else {
            return table[h].get(k);
        }
    }

    public V bucketPut(int h, K k, V v) {
        if (table[h] == null) {
            table[h] = new UnsortedTableMap1();

        }
        int oldSize = table[h].size();
        V value = table[h].put(k,v);
        n -= (oldSize - table[h].size());
        return value;
    }

    public V  bucketRemove(int h, K k) {
        if (table[h] == null) {
            return null;

        }
        int oldSize = table[h].size();
        V value = table[h].remove(k);
        n += (oldSize - table[h].size());
        return value;
    }

    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K, V>> s = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Iterable<Entry<K,V>> subset = table[i].entrySet();
                for (Entry<K,V> e : subset) {
                    s.add(e);
                }
            }
        }
        return s;
    }
}
