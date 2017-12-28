import java.util.ArrayList;
public abstract class AbstractBinaryTree1<E> extends AbstractTree1<E> 
        implements BinaryTree1<E> {/** Returns the Position of p's sibling (or null if no sibling exists). */
        public Position<E> sibling(Position<E> p) throws IllegalArgumentException {Position<E> parent = parent(p);
        if (parent == null) return null; // p must be the root
        if (p == left(parent)) // p is a left child
        return right(parent); // (right child might be null)
        else // p is a right child
        return left(parent); // (left child might be null)
        } /** Returns the number of children of Position p. */
        public int numChildren(Position<E> p) throws IllegalArgumentException { int count=0;
        if (left(p) != null)
        count++;
        if (right(p) != null)
        count++;
        return count;
        } 
        public Iterable<Position<E>> children(Position<E> p)  throws IllegalArgumentException 
        {java.util.List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
        if (left(p) != null)
        snapshot.add(left(p));
        if (right(p) != null)
        snapshot.add(right(p));
        return snapshot;
        }
}
/*
public abstract class AbstractBinaryTree1<E> extends AbstractTree1<E> implements BinaryTree1<E> {
    public Position<E> sibling (Position<E> p) {
        Position<E> parent;
        if (parent == root()) {
            return null;
        } else {
            parent = parent(p);
            if (p == left(parent)) {
                return right(parent);
            } else {
                return left(parent);
            }
            
        }
    }
    
    public int numChildren(Position<E> p) {
        int n = 0;
        if (left(p) != null) {
            n++;
        } if (right(p) != null) {
            n++;
        }
        return n;
    }
    
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<Position<E>> (2);
        if (left(p) != null) {
            snapshot.add(left(p));
        } if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    } 
}*/