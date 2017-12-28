import javax.naming.OperationNotSupportedException;
import java.util.Iterator;


public abstract class AbstractMap1<K, V> implements Map1<K, V> {
    public class MapEntry<K, V> implements Entry<K,V> {
        public K k;
        public V v;
        public MapEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

    }

    public class KeyIterator implements Iterator<K> {
        public Iterator<Entry<K, V>> entries = entrySet().iterator();

        public K next() {
            return entries.next().getKey();

        }

        public boolean hasNext() {
            return entries.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public class KeyIterable implements Iterable<K> {
        public KeyIterator iterator() {
            return new KeyIterator();
        }
    }

    public class ValueIterator implements Iterator<V> {
        public Iterator<Entry<K,V>> entries = entrySet().iterator();
        public V next() {
            return entries.next().getValue();

        }

        public boolean hasNext() {
            return entries.hasNext();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class ValueIterable implements Iterable<V> {
        public ValueIterator iterator() {
            return new ValueIterator();
        }
    }

    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    public Iterable<V> values() {
        return new ValueIterable();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
