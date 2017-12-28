/**
 * Your implementation of an array-backed stack.
 *
 * @author Dichao Hu
 * @userid dhu64(i.e. gburdell3)
 * @GTID 903253306 (i.e. 900000000)
 * @version 1.0
 * @param <T> data to use in the function
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int front;
    private int back;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        front = -1;
        back = -1;
        size = 0;
    }

    /**
     * Dequeue from the front of the queue.
     *
     * This method should be implemented in O(1) time.
     *
     * @return the data from the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    @Override
    public T dequeue() throws java.util.NoSuchElementException {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Can not"
                + "dequeue in an empty queue");
        }
        T element = backingArray[front];
        if (size == 1) {
            backingArray[front] = null;
            size--;
            front = (front + 1 + backingArray.length) % backingArray.length;
            back = front;
            return element;
        } else {
            backingArray[front] = null;
            front = (front + 1 + backingArray.length) % backingArray.length;
            size--;
            return element;
        }

    }

    /**
     * Add the given data to the queue.
     *
     * This method should be implemented in (if array-backed, amortized) O(1)
     * time.
     *
     * @param data the data to add
     * @throws IllegalArgumentException if data is null
     */
    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("DATA CANNOT BE NULL");
        } else if (size == 0) {
            back++;
            front = back;
            backingArray[back] = data;
            size++;
        } else if (size == backingArray.length) {
            int i = front;
            int j = 0;
            T[] newArray = (T[]) new Object[backingArray.length * 2];
            while (j < size) {
                newArray[j] = backingArray[i];
                i = (i + 1) % backingArray.length;
                j++;
            }
            backingArray = newArray;
            front = 0;
            back = size - 1;
            back = (back + 1) % backingArray.length;
            backingArray[back] = data;
            size++;
        } else {
            back = (back + 1) % backingArray.length;
            backingArray[back] = data;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns the backing array of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the backing array
     */
    public Object[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

}