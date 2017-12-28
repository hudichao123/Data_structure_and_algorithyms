/**
 * Your implementation of an array-backed stack.
 *
 * @author Dichao Hu
 * @userid dhu64(i.e. gburdell3)
 * @GTID 903253306 (i.e. 900000000)
 * @version 1.0
 * @param <T> data to use in the function
 */
public class ArrayStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayStack.
     */
    public ArrayStack() {
        size = 0;
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Pop from the stack.
     *
     *
     * @return the data from the front of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    @Override
    public T pop() throws java.util.NoSuchElementException {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Can"
                + "not pop from an empty stack");
        } else {
            T element = backingArray[size - 1];
            backingArray[size - 1] = null;
            size--;
            return element;
        }
    }

    /**
     * Push the given data onto the stack.
     *
     *
     * @param data the data to add
     * @throws IllegalArgumentException if data is null
     */
    @Override
    public void push(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("DATA"
                + "CAN NOT BE NULL");
        } else {
            if (size == backingArray.length) {
                T[] newArray = (T[]) new Object[backingArray.length * 2];
                for (int i = 0; i < backingArray.length; i++) {
                    newArray[i] = backingArray[i];
                }
                backingArray = newArray;
            }
            backingArray[size++] = data;
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
     * Returns the backing array of this stack.
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
