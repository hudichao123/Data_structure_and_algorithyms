public abstract class AbstractTree1<E> implements Tree1<E> {
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }
    public boolean isRoot(Position<E> p) {
        return p == root();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
}