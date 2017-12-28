import java.util.ArrayList;
import java.util.Random;



public abstract class AbstractHashMap1<K,V> extends AbstractMap1<K,V>{
    protected int n = 0;
    protected int capacity;
    protected int prime;
    private long scale;
    private long shift;

    public AbstractHashMap1(int capacity, int prime) {
        this.capacity = capacity;
        this.prime = prime;
        createTable();
        Random rand = new Random();
        int scale = rand.nextInt(prime - 1) + 1;
        int shift = rand.nextInt(prime);
    }

    public AbstractHashMap1() {
        capacity = 13;
        prime = 109345121;
    }

    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public V get(K k) {
        int h = hashValue(k);
        return bucketGet(h, k);
    }


    public V put(K k, V v) {
        int h = hashValue(k);
        V value = bucketPut(h, k, v);
        if (n > capacity / 2) {
            resize(capacity * 2 - 1);
        }
        return value;
    }

    public V remove(K k) {
        int h = hashValue(k);
        if (n > capacity / 2) {
            resize(capacity * 2 - 1);
        }
        return bucketRemove(h, k);
    }

    public int hashValue(K k) {
        return (int) ((Math.abs(k.hashCode( )*scale + shift) % prime) % capacity);
    }

    public void resize(int newCapacity) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<> (n);
        for (Entry<K,V> e : entrySet()) {
            buffer.add(e);
        }
        capacity = newCapacity;
        createTable();
        n = 0;
        for (Entry<K, V> e : buffer) {
            put(e.getKey(), e.getValue());
        }

    }

    public abstract void createTable();

    public abstract V bucketGet(int h, K k);

    public abstract V bucketPut(int h, K k, V v);

    public abstract V bucketRemove(int h, K k);

}

