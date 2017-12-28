/**
 * Your implementation of a min priority queue.
 *
 * @author YOUR NAME HERE
 * @userid YOUR USER ID HERE (i.e. gburdell3)
 * @GTID YOUR GT ID HERE (i.e. 900000000)
 * @version 1.0
 */
public class MinPriorityQueue<T extends Comparable<? super T>>
    implements PriorityQueueInterface<T> {

    private HeapInterface<T> backingHeap;
    // Do not add any more instance variables. Do not change the declaration
    // of the instance variables above.

    /**
     * Creates a priority queue.
     */
    public MinPriorityQueue() {
        backingHeap = new MinHeap<T>();
    }

    /**
     * Adds an item to the priority queue.
     *
     * @param item the item to be added
     * @throws IllegalArgumentException if the item is null
     */
    @Override
    public void enqueue(T item) {
        backingHeap.add(item);
    }

    /**
     * Removes and returns the first item in the priority queue.
     *
     * @throws java.util.NoSuchElementException if the priority queue is empty
     * @return the item dequeued
     */
    @Override
    public T dequeue() {
        return backingHeap.remove();
    }

    /**
     * Returns if the priority queue is empty.
     * @return a boolean representing if the priority queue is empty
     */
    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return backingHeap.isEmpty();
    }

    /**
     * Returns the size of the priority queue.
     * @return the size of the priority queue
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return backingHeap.size();
    }

    /**
     * Clears the priority queue.
     */
    @Override
    public void clear() {

    }

    /**
     * Used for grading purposes only.
     *
     * DO NOT USE OR EDIT THIS METHOD!
     *
     * @return the backing heap
     */
    @Override
    public HeapInterface<T> getBackingHeap() {
        // DO NOT MODIFY THIS METHOD!
        return backingHeap;
    }

}
