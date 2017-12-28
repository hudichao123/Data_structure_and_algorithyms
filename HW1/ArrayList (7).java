/**
 * Your implementation of an ArrayList.
 *
 * @author Weihang Yuan
 * @userid wyuan47
 * @GTID 903251734
 * @version 1.2
 */
public class ArrayList<T> implements ArrayListInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayList.
     *
     * You may add statements to this method.
     */
    public ArrayList() {
        size = 0;
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addAtIndex(int index, T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException(
                "data input cannot be null");
        }
        if ((index < 0) || (index > size)) {
            throw new java.lang.IndexOutOfBoundsException(
                "Index is negative or is bigger than the size.");
        }
        if (backingArray[backingArray.length - 1] != null) {
            T[] secondArray = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < backingArray.length; i++) {
                secondArray[i] = backingArray[i];
            }
            backingArray = secondArray;
            addAtIndex(index, data);
        }
        for (int i = size - 1; i > index; i--) {
            backingArray[i] = backingArray[i - 1];
        }
        backingArray[index] = data;
        size += 1;
        return;
    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException(
                "Index is negative or is bigger than the size.");
        }
        addAtIndex(0, data);
        return;
    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        int i = 0;
        while (backingArray[i + 1] != null) {
            i++;
        }
        addAtIndex(i + 1, data);
    }

    @Override
    public T removeAtIndex(int index) {
        if ((index < 0) || (index > size)) {
            throw new java.lang.IndexOutOfBoundsException(
                "Index is negative or is bigger than the size.");
        }
        if (backingArray[index] == null) {
            return null;
        }
        T result = backingArray[index];
        int i = index;
        while (backingArray[i] != null) {
            if (i != size) {
                backingArray[i] = backingArray[i + 1];
                i++;
            } else {
                backingArray[i] = null;
            }
        }
        size -= 1;
        return result;
    }

    @Override
    public T removeFromFront() {
        return removeAtIndex(0);
    }

    @Override
    public T removeFromBack() {
        T result = backingArray[size - 1];
        backingArray[size - 1] = null;
        size -= 1;
        return result;
    }

    @Override
    public T get(int index) {
        if ((index < 0) || (index > size)) {
            throw new java.lang.IndexOutOfBoundsException(
                "Index is negative or is bigger than the size.");
        }
        return backingArray[index];
    }

    @Override
    public boolean isEmpty() {
        if (backingArray[0] == null) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public Object[] getBackingArray() {
        // DO NOT MODIFY.
        return backingArray;
    }
}
