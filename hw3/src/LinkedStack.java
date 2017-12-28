/**
 * Your implementation of an array-backed stack.
 *
 * @author Dichao Hu
 * @userid dhu64(i.e. gburdell3)
 * @GTID 903253306 (i.e. 900000000)
 * @version 1.0
 * @param <T> data to use in the function
 */
public class LinkedStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private int size;

    /**
     * Pop from the stack.
     *
     * Removes and returns the top-most element on the stack.
     * This method should be implemented in O(1) time.
     *
     * @return the data from the front of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    @Override
    public T pop() throws java.util.NoSuchElementException {
        T t;
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("CAN"
                + "NOT POP FROM AN EMPTY STACK");
        } else {
            t = head.getData();
            head = head.getNext();
            size--;
            return t;
        }
    }

    /**
     * Push the given data onto the stack.
     *
     * The given element becomes the top-most element of the stack.
     * This method should be implemented in (if array-backed, amortized) O(1)
     * time.
     *
     * @param data the data to add
     * @throws IllegalArgumentException if data is null
     */
    @Override
    public void push(T data) {
        LinkedNode<T> n = new LinkedNode<>(data, head);
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data"
                + "can not be null");
        } else {
            head = n;
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
     * Returns the head of this stack.
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

}