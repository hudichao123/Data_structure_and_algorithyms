import java.util.ArrayList;


public class ProbeHashMap1<K,V> extends AbstractHashMap1<K, V> {
    private MapEntry<K,V>[] table;
    private MapEntry<K,V> DEFUNCT = new MapEntry<K,V> (null, null);
    public ProbeHashMap1() {
        super();
    }

    public boolean isAvailable(int j) {
        return table[j] == null | table[j] == DEFUNCT;
    }



    public int findSlot(int h, K k) {
        int available = -1;
        int j = h;
        do {if (isAvailable(j)) {
            if (available != -1) {
                available = j;
            }  if (table[j] == null) {
                break;
            }
        } else if (table[j].k == k) {
            return j;
        }
        j = (j + 1) % capacity;

        } while (h != j);
        return -(available + 1);
    }

    public ProbeHashMap1(int capacity, int prime) {
        super(capacity, prime);
    }

    public void createTable( ) {
        table = (MapEntry<K,V>[ ]) new MapEntry[capacity];
    }

    public V bucketGet(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) {
            return null;
        } else {
            return table[j].v;
        }
    }

    public V bucketPut(int h, K k, V v) {
        int j = findSlot(h, k);
        if (j < 0) {
            table[-(j + 1)] = new MapEntry<K, V>(k, v);
            n++;
            return null;
        } else {
            V value = table[j].v;
            table[j].v = v;
            return value;
        }
    }

    public V  bucketRemove(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) {
            return null;
        } else {
            V value = table[j].v;
            table[j] = DEFUNCT;
            n--;
            return value;
        }
    }

    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> l = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i] != DEFUNCT) {
                l.add(table[i]);
            }
        }
        return l;
    }
}
