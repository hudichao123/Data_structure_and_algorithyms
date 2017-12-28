import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;


public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K,V> {
    private LinkedList<Entry<K, V>> l = new LinkedList<>();
    private Comparator<K> comp;

    public UnsortedPriorityQueue() {
        super();

    }

    public UnsortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    public Entry<K, V> insert(K k, V v) {
        checkKey(k);
        Entry<K, V> e = new PQEntry<>(k, v);
        l.addLast(e);
        return e;
    }

    public Entry<K, V> min() {
        return null;
    }

    public Entry<K, V> removeMin() {
        return null;
    }

    public int size() {
        return l.size();

    }
}
