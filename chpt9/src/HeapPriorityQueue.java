import java.util.ArrayList;
import java.util.Comparator;


public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    private ArrayList<Entry<K, V>> heap;

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
        heap = new ArrayList<> ();
    }

    public HeapPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    protected int parent(int j) {
        return (j - 1)/2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    public boolean hasLeft(int j) {
        return left(j) < heap.size();

    }

    public boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    public void swap(int i, int j) {
        if (heap.get(i) == null || heap.get(j) == null) {
            return;
        }
        Entry<K, V> temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j, temp);
    }

    public void upheap(int j) {
         while(j > 0 && compare((PQEntry<K, V>)heap.get(j), (PQEntry<K, V>)heap.get(parent(j))) < 0) {
             int p = parent(j);
             swap(p, j);
             j = p;
         }

    }

    public void downheap(int j) {
        while (hasRight(j) || hasLeft(j)) {
            int i = 0;
            if (!hasLeft(j)) {
                if (compare((PQEntry<K, V>)heap.get(j), (PQEntry<K, V>)heap.get(right(j))) < 0) {
                    break;
                }
                 i = right(j);
                swap(j, right(j));
                j = i;
            }
            else if (!hasRight(j)) {
                if (compare((PQEntry<K, V>)heap.get(j), (PQEntry<K, V>)heap.get(left(j))) < 0) {
                    break;
                }
                i = left(j);
                swap(j, left(j));
                j = i;
            } else {
                    if ((compare((PQEntry<K, V>)heap.get(left(j)), (PQEntry<K, V>)heap.get(right(j)))) > 0) {
                        if (compare((PQEntry<K, V>)heap.get(j), (PQEntry<K, V>)heap.get(right(j))) < 0) {
                            break;
                        }
                        i = right(j);
                        swap(j, right(j));
                        j = i;
                    } else {
                        if (compare((PQEntry<K, V>)heap.get(j), (PQEntry<K, V>)heap.get(left(j))) < 0) {
                            break;
                        }
                        i = left(j);
                        swap(j, left(j));
                        j = i;
                    }
                }
            }
        }

    public void printH () {
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap.get(i));
        }
    }
    public int size() {
        return heap.size();

    }

    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public Entry<K, V> insert(K key, V value) {
        checkKey(key);
        Entry<K, V> e = new PQEntry<>(key, value);
        heap.add(heap.size(), e);
        int j = heap.size() - 1;
        upheap(j);
        return e;
    }

    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        swap(0, heap.size() - 1);
        Entry<K, V> e = heap.remove(size() - 1);
        downheap(0);
        return e;
        }



    public static void main(String[] args) {
        HeapPriorityQueue<Integer, String> h = new HeapPriorityQueue<>();
        h.insert(3,"S");
        h.insert(5,"P");
        h.insert(1,"a");
        h.insert(2,"b");
        h.printH();
        h.removeMin();
        h.removeMin();
        h.printH();

    }
}
