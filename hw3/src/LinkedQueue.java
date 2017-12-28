/**
 * Your implementation of an array-backed stack.
 *
 * @author Dichao Hu
 * @userid dhu64(i.e. gburdell3)
 * @GTID 903253306 (i.e. 900000000)
 * @version 1.0
 * @param <T> data to use in the function
 */
public class LinkedQueue<T> implements QueueInterface<T> {
    // Do not add new instance variable
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

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
        T element;

        if (size == 0) {
            throw new java.util.NoSuchElementException("Can"
                + "not dequeue from an empty queue");
        } else if (size == 1) {
            element = head.getData();
            head = null;
            tail = null;
            size--;
        } else {
            element = head.getData();
            head = head.getNext();

            size--;
        }
        return element;
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
        LinkedNode<T> n = new LinkedNode<T>(data, null);
        if (data == null) {
            throw new java.lang.IllegalArgumentException("DATA CANNOT BE NULL");
        } else if (size == 0) {
            head = n;
            tail = n;
            size++;
        } else {
            tail.setNext(n);
            tail = n;
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
     * Returns the head of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the head node
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the tail node
     */
    public LinkedNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

}