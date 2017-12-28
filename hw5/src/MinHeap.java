import java.util.NoSuchElementException;

/**
 * Your implementation of a min heap.
 *
 * @author Dichao Hu
 * @userid dhu64
 * @GTID 903253306
 * @version 1.0
 */


public class MinHeap<T extends Comparable<? super T>>
    implements HeapInterface<T> {

    private T[] backingArray;
    private int size;
    // Do not add any more instance variables. Do not change the declaration
    // of the instance variables above.

    /**
     * Creates a Heap with an initial capacity of {@code INITIAL_CAPACITY}
     * for the backing array.
     *
     * Use the constant field in the interface. Do not use magic numbers!
     */
    public MinHeap() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds an item to the heap. If the backing array is full and you're trying
     * to add a new item, then double its capacity. The data passed in will not
     * be in the heap. Therefore, there will be no duplicates.
     *
     * @throws IllegalArgumentException if the item is null
     * @param item the item to be added to the heap
     */
    @Override
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Data"
                    + "can not be null");
        }
        if (size == backingArray.length - 1) {
            regrow();
        }
        int i = 1;
        while (backingArray[i] != null) {
            i++;
        }
        backingArray[i] = item;
        size++;
        upheap(i);
    }

    /**
     * regrow the array if size + 1 = backdingArray.length
     */
    private void regrow() {
        T[] newArray = (T[]) (new Comparable[INITIAL_CAPACITY * 2]);
        for (int i = 0; i < size; i++) {
            newArray[i + 1] = backingArray[i + 1];
        }
        backingArray = newArray;
    }

    /**
     * upheap bubbling
     * @param i the index to implement upheap
     */
    private void upheap(int i) {
        int parent = i / 2;
        while (parent != 0 && backingArray[parent].compareTo(
                backingArray[i]) > 0) {
            swap(parent, i);
            i = parent;
            parent = i / 2;
        }
    }

    /**
     * swap data in two given indices
     * @param i1 the first index
     * @param i2 the second index
     */
    private void swap(int i1, int i2) {
        T element1 = backingArray[i1];
        T element2 = backingArray[i2];
        T temp = element1;
        backingArray[i1] = backingArray[i2];
        backingArray[i2] = temp;
    }

    /**
     * Removes and returns the first item of the heap. Null out all elements not
     * existing in the heap after this operation. Do not decrease the capacity
     * of the backing array.
     *
     * @throws java.util.NoSuchElementException if the heap is empty
     * @return the item removed
     */
    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T t = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        downHeap(1);
        return t;
    }

    /**
     *  downheap bubbling
     * @param i the index to implement downheap
     */
    private void downHeap(int i) {
        int leftChildIndex = 2 * i;
        int rightChildIndex = 2 * i + 1;
        int minChildIndex = minIndex(leftChildIndex, rightChildIndex);
        while (backingArray[minChildIndex] != null
                && backingArray[minChildIndex].compareTo(backingArray[i]) < 0) {
            swap(minChildIndex, i);
            i = minChildIndex;
            leftChildIndex = 2 * i;
            rightChildIndex = 2 * i + 1;
            minChildIndex = minIndex(leftChildIndex, rightChildIndex);
        }
    }

    /**
     * return the index that contains the min data
     * @param i1 the first index to compare
     * @param i2 the second index to compare
     * @return the index of the min data
     */
    private int minIndex(int i1, int i2) {
        if (i1 > size && i2 > size) {
            return 0;
        }
        if (i1 == size && i2 > size) {
            return i1;
        }
        if (i2 == size && i1 > size) {
            return i2;
        }
        if (backingArray[i1].compareTo(backingArray[i2]) < 0) {
            return i1;
        }
        return i2;
    }

    /**
     * Returns if the heap is empty or not.
     * @return a boolean representing if the heap is empty
     */
    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    /**
     * Returns the size of the heap.
     * @return the size of the heap
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Clears the heap and returns array to starting capacity.
     */
    @Override
    public void clear() {

    }

    /**
     * Used for grading purposes only.
     *
     * DO NOT USE OR EDIT THIS METHOD!
     *
     * @return the backing array
     */
    @Override
    public Comparable[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }
}
