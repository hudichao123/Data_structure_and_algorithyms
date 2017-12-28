public interface PriorityQueue<K, V>{
    Entry<K, V>  insert(K k, V v) throws IllegalArgumentException;
    Entry<K, V> min();
    Entry<K, V> removeMin();
    int size();
    boolean isEmpty();


}
