import java.util.Set;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.HashSet;
import java.util.ArrayList;
/**
 * Your implementation of HashMap.
 *
 * @author Dichao Hu
 * @userid dhu64
 * @GTID 903253306
 * @version 1.0
 */
public class HashMap<K, V> implements HashMapInterface<K, V> {

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
    public HashMap() {
        table = new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Create a hash map with no entries. The backing array has an initial
     * capacity of {@code initialCapacity}.
     *
     * You may assume {@code initialCapacity} will always be positive.
     *
     * @param initialCapacity initial capacity of the backing array
     */
    public HashMap(int initialCapacity) {
        table = new MapEntry[initialCapacity];
        size = 0;
    }

    /**
     * Adds the given key-value pair to the HashMap.
     * If an entry in the HashMap already has this key, replace the entry's
     * value with the new one passed in.
     *
     * In the case of a collision, use linear probing as your resolution
     * strategy.
     *
     * Check to see if the backing array needs to be regrown BEFORE adding. For
     * example, if my HashMap has a backing array of length 5, and 3 elements in
     * it, I should regrow at the start of the next add operation (even if it
     * is a key that is already in the hash map). This means you must account
     * for the data pending insertion when calculating the load factor.
     *
     * When regrowing, increase the length of the backing table by
     * 2 * old length + 1. Use the resizeBackingTable method.
     *
     * Return null if the key was not already in the map. If it was in the map,
     * return the old value associated with it.
     *
     * @param key key to add into the HashMap
     * @param value value to add into the HashMap
     * @throws IllegalArgumentException if key or value is null
     * @return null if the key was not already in the map.  If it was in the
     * map, return the old value associated with it
     */
    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("key or value can not be null");
        }
        if ((double) size / (double) table.length >= MAX_LOAD_FACTOR) {
            resizeBackingTable(table.length * 2 + 1);
        }
        int h = Math.abs(key.hashCode());
        int index = h % table.length;
        int count = 0;
        boolean firstDef = true;
        int firstDefIndex = -1;
        while (count < table.length) {
            if (table[index] == null) {
                if (firstDefIndex == -1) {
                    table[index] = new MapEntry<>(key, value);
                } else {
                    table[firstDefIndex] = new MapEntry<>(key, value);
                }
                size++;
                return null;
            } else if (table[index].isRemoved()) {
                if (firstDef) {
                    firstDef = false;
                    firstDefIndex = index;
                }
                index = (index + 1) % table.length;
                count++;
            } else if (table[index].getKey().equals(key)) {
                V v = table[index].getValue();
                table[index].setValue(value);
                return v;
            } else {
                index = (index + 1) % table.length;
                count++;
            }
        }
        if (firstDefIndex != -1) {
            table[firstDefIndex] = new MapEntry<>(key, value);
        }
        size++;
        return null;

    }

    /**
     * Removes the entry with a matching key from the HashMap.
     *
     * @param key the key to remove
     * @throws IllegalArgumentException if key is null
     * @throws java.util.NoSuchElementException if the key does not exist
     * @return the value previously associated with the key
     */
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key"
                    + "can not be null");
        }
        int h = Math.abs(key.hashCode());
        int index = h % table.length;
        int count = 0;
        while (count < table.length) {
            if (table[index] == null) {
                throw new NoSuchElementException("Key"
                        + "is not in the table");
            }
            if (table[index].isRemoved()) {
                index = (index + 1) % table.length;
                count++;
            } else if (table[index].getKey().equals(key)) {
                MapEntry<K, V> m = table[index];
                table[index].setRemoved(true);
                size--;
                return m.getValue();
            } else {
                index = (index + 1) % table.length;
                count++;
            }
        }
        throw new NoSuchElementException("Key"
                + "is not in the table");
    }

    /**
     * Gets the value associated with the given key.
     *
     * @param key the key to search for
     * @throws IllegalArgumentException if key is null
     * @throws java.util.NoSuchElementException if the key is not in the map
     * @return the value associated with the given key
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key"
                    + "cannot be null");
        }
        int h = Math.abs(key.hashCode());
        int index = h % table.length;
        int count = 0;
        while (count < table.length) {
            if (table[index] == null) {
                throw new NoSuchElementException("The"
                        + "element is not in the table");
            } else if (table[index].isRemoved()) {
                index = (index + 1) % table.length;
                count++;
            } else if (table[index].getKey().equals(key)) {
                return table[index].getValue();
            } else {
                index = (index + 1) % table.length;
                count++;
            }
        }
        throw new NoSuchElementException("The"
                + "element is not in  table");

    }

    /**
     * Returns whether or not the key is in the map.
     *
     * @param key the key to search for
     * @throws IllegalArgumentException if key is null
     * @return whether or not the key is in the map
     */
    @Override
    public boolean containsKey(K key) {
        try {
            get(key);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Clears the table and resets it to the default length.
     */
    @Override
    public void clear() {
        table = new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Returns the number of elements in the map.
     *
     * @return number of elements in the HashMap
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns a Set view of the keys contained in this map.
     * Use {@code java.util.HashSet}.
     *
     * @return set of keys in this map
     */
    @Override
    public Set<K> keySet() {
        Set<K> s = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                s.add(table[i].getKey());
            }
        }
        return s;
    }

    /**
     * Returns a List view of the values contained in this map.
     * beginning with the first index of the backing array.
     * Use any class that implements the List interface
     * This includes {@code java.util.ArrayList} and
     * {@code java.util.LinkedList}.
     *
     * @return list of values in this map
     */
    @Override
    public List<V> values() {
        List<V> s = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                s.add(table[i].getValue());
            }
        }
        return s;
    }

    /**
     * Resize the backing table to {@code length}.
     *
     * After resizing, the table's load factor is permitted to exceed
     * MAX_LOAD_FACTOR. No adjustment to the backing table's length is necessary
     * should this occur.
     *
     * Remember that you cannot just simply copy the entries over to the new
     * array.
     *
     * @param length new length of the backing table
     * @throws IllegalArgumentException if length is non-positive or less than
     * the number of items in the hash map.
     */
    @Override
    public void resizeBackingTable(int length) {
        MapEntry<K, V>[] newTable = new MapEntry[length];
        if (length < table.length) {
            throw new IllegalArgumentException("Cannot"
                    + "resize to a smaller size");
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                int h = Math.abs(table[i].getKey().hashCode());
                int index = h % newTable.length;
                while (newTable[index] != null) {
                    index = (index + 1) % newTable.length;
                }
                newTable[index] = table[i];
            }
        }
        table = newTable;
    }

    /**
     * DO NOT USE THIS METHOD IN YOUR CODE.  IT IS FOR TESTING ONLY.
     *
     * @return the backing array of the data structure, not a copy.  INCLUDE
     * EMPTY SPACES
     */
    @Override
    public MapEntry<K, V>[] getTable() {
        // DO NOT EDIT THIS METHOD!
        return table;
    }
}
