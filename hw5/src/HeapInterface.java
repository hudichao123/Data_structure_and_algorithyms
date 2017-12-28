/**
 * The interface describing the methods you will implement for your heap.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public interface HeapInterface<T extends Comparable<? super T>> {

    public static final int INITIAL_CAPACITY = 16;

    /**
     * Adds an item to the heap. If the backing array is full and you're trying
     * to add a new item, then double its capacity. The data passed in will not
     * be in the heap. Therefore, there will be no duplicates.
     *
     * @throws IllegalArgumentException if the item is null
     * @param item the item to be added to the heap
     */
    public void add(T item);

    /**
     * Removes and returns the first item of the heap. Null out all elements not
     * existing in the heap after this operation. Do not decrease the capacity
     * of the backing array.
     *
     * @throws java.util.NoSuchElementException if the heap is empty
     * @return the item removed
     */
    public T remove();

    /**
     * Returns if the heap is empty or not.
     * @return a boolean representing if the heap is empty
     */
    public boolean isEmpty();

    /**
     * Returns the size of the heap.
     * @return the size of the heap
     */
    public int size();

    /**
     * Clears the heap and returns array to starting capacity.
     */
    public void clear();

    /**
     * Used for grading purposes only.
     *
     * DO NOT USE OR EDIT THIS METHOD!
     *
     * @return the backing array
     */
    public Comparable[] getBackingArray();
}
