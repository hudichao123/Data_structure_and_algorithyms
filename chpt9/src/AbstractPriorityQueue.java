import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V>{
    protected class PQEntry<K, V> implements Entry<K, V> {
        public K k;
        public V v;

        public PQEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public V getValue() {
            return v;
        }

        public K getKey() {
            return k;
        }

        public String toString() {
            return "(" + k + ", " + v + ")";
        }
    }
        private Comparator<K> comp;

        protected AbstractPriorityQueue(Comparator<K> comp) {
            this.comp = comp;
        }

        protected int compare(PQEntry<K, V> p, PQEntry<K, V> q) {
            return comp.compare(p.k, q.k);
        }
        protected AbstractPriorityQueue() {
            this(new DefaultComparator<K>());

        }

        protected boolean checkKey(K k) {
            try {
                return comp.compare(k, k) == 0;
            } catch(ClassCastException e) {
                throw new IllegalArgumentException();
            }
        }

        public boolean isEmpty() {
            return size() == 0;
        }
}
