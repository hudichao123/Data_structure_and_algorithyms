import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Your implementation of HashMap.
 * 
 * @author Weihang Yuan
 * @userid wyuan47
 * @GTID 903251734
 * @version 1.0
 */
public class HashMap2<K, V> implements HashMapInterface<K, V> {

    // Do not make any new instance variables.
    private MapEntry<K, V>[] table;
    private int size;

    /**
     * Create a hash map with no entries. The backing array has an initial
     * capacity of {@code INITIAL_CAPACITY}.
     *
     * Do not use magic numbers!
     *
     * Use constructor chaining.
     */
    public HashMap2() {
        table = new MapEntry[INITIAL_CAPACITY];
    }

    /**
     * Create a hash map with no entries. The backing array has an initial
     * capacity of {@code initialCapacity}.
     *
     * You may assume {@code initialCapacity} will always be positive.
     *
     * @param initialCapacity initial capacity of the backing array
     */
    public HashMap2(int initialCapacity) {
        table = new MapEntry[initialCapacity];
    }

    @Override
    public V put(K key, V value) {
        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException("data input cannot be null");
        }
        if (((double)size / (double)table.length) > MAX_LOAD_FACTOR) {
            resizeBackingTable(table.length * 2 + 1);
        }
        int aInd = (key.hashCode() % table.length);
        while (table[aInd] != null) {
            if (table[aInd].isRemoved()) {
                table[aInd].setRemoved(false);
                table[aInd].setKey(key);
                table[aInd].setValue(value);
                size += 1;
                return null;
            }
            if (table[aInd].getKey().equals(key)) {
                V result = table[aInd].getValue();
                table[aInd].setValue(value);
                return result;
            }
            aInd = ((aInd + 1) % table.length);
        }
        table[aInd] = new MapEntry<>(key, value);
        size += 1;
        return null;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("data input cannot be null");
        }
        int bInd = 0;
        int aInd = key.hashCode() % table.length;
        while ((table[aInd] != null) && (bInd < table.length)) {
            if (table[aInd].isRemoved()) {
                bInd += 1;
                aInd = (aInd + 1) % table.length;
            } else if (table[aInd].getKey().equals(key)) {
                V result = table[aInd].getValue();
                table[aInd].setRemoved(true);
                size -= 1;
                return result;
            } else {
                bInd += 1;
                aInd = (aInd + 1) % table.length;
            }
        }
        throw new java.util.NoSuchElementException("cannot find element");
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("data input cannot be null");
        }
        int bInd = 0;
        int aInd = key.hashCode() % table.length;
        while ((table[aInd] != null) && (bInd < table.length)) {
            if (table[aInd].isRemoved()) {
                bInd += 1;
                aInd = (aInd + 1) % table.length;
            } else if (table[aInd].getKey().equals(key)) {
                V result = table[aInd].getValue();
                return result;
            } else {
                bInd += 1;
                aInd = (aInd + 1) % table.length;
            }
        }
        throw new java.util.NoSuchElementException("cannot find element");
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("data input cannot be null");
        }
        int bInd = 0;
        int aInd = key.hashCode() % table.length;
        while ((table[aInd] != null) && (bInd < table.length)) {
            if (table[aInd].isRemoved()) {
                bInd += 1;
                aInd = (aInd + 1) % table.length;
            } else if (table[aInd].getKey().equals(key)) {
                return true;
            } else {
                bInd += 1;
                aInd = (aInd + 1) % table.length;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        MapEntry<K, V>[] bTable = new MapEntry[INITIAL_CAPACITY];
        table = bTable;
        size = 0;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> result = new HashSet();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (!table[i].isRemoved()) {
                    result.add(table[i].getKey());
                }
            }
        }
        return result;
    }

    @Override
    public List<V> values() {
        ArrayList<V> result = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (!table[i].isRemoved()) {
                    result.add(table[i].getValue());
                }
            }
        }
        return result;
    }

    @Override
    public void resizeBackingTable(int length) {
        MapEntry<K, V>[] bTable = new MapEntry[length];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (!table[i].isRemoved()) {
                    bTable[i] = table[i];
                }
            }
        }
    }
    
    @Override
    public MapEntry<K, V>[] getTable() {
        // DO NOT EDIT THIS METHOD!
        return table;
    }

}
