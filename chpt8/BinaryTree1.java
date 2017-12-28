public interface BinaryTree1<E> extends Tree1<E> {
   Position<E> left(Position<E> p) throws IllegalArgumentException;

   Position<E> right(Position<E> p) throws IllegalArgumentException;

   Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}