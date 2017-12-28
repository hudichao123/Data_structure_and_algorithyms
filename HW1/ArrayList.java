/**
 * Your implementation of an ArrayList.
 * This is an implementation of an ArrayList.
 * @author Dichao Hu
 * @userid dhu64
 * @GTID 903253306
 * @version 1
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

    public class Iterator1<E> implements java.util.Iterator<E> {
        private int j = 0;
        private boolean removable = false;

        private Iterator1() {

        }

        private boolean hasNext() {
            if (j >= size) {
                return false;
            }
            return true;
        }

        private E next() {
            if (j >= size) {
                throw new java.lang.IllegalAccessException();
            } else {
                removable = true;
                return backingArray[j++];
            }
        }

        private void remove() throws Exception {
            if (removable == false) {
                throw new java.lang.IllegalStateException();
            } else {
                removeAtIndex(j - 1);
                j--;
                removable = false;
            }
        }



    }
    public ArrayList() {
        size = 0;
        backingArray = (T[])new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the element to the index specified.
     *
     * @param index The index where you want the new element.
     * @param data Any object of type T.
     * @throws java.lang.IndexOutOfBoundsException if index is negative
     * or index > size.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new java.lang.IndexOutOfBoundsException(
                "The index is out of bounds");
        }
        
        else if (data == null) {
            throw new java.lang.IllegalArgumentException(
                "can not store null");
        }
        else {
           if (size == backingArray.length) {
               doubleCapacity();
           }
           if (index > 0 && index < size) {
           rightShiftAtIndex(index);
           addElementAtIndex(index, data);
           size++;
           } else if (index == 0) {
               rightShiftAtIndex(0);
               backingArray[0] = data;
               size++;
           } else {
               addElementAtIndex(index, data);
               size++;
           }
        }
    }

    /**
     * Add the given data to the front of your array list.
     * @param data The data to add to the list.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addToFront(T data) {
        addAtIndex(0, data);
    }

    /**
     * Add the given data to the front of your array list.
     *
     * Remember that this add may require elements to be shifted.
     * Must be O(n).
     *
     * @param data The data to add to the list.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addToBack(T data) {
        addAtIndex(size, data);
    }

    /**
     * Removes and returns the element at index.
     * @param index The index of the element
     * @return The object that was formerly at that index.
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or
     * index >= size.
     */
    @Override
    public T removeAtIndex(int index) {
        T element = (T) backingArray[index];
        if (index >= size || index < 0) {
            throw new java.lang.IndexOutOfBoundsException(
                "The index is out of bounds");
        } else if (index == size - 1) {
            removeLastOne();
            size--;
        } else {
            backingArray[index] = null;
            leftShiftAtIndex(index + 1);
            size--;
        }
        return element;
    }

    /**
     * Remove the first element in the list and return it.
     * @return The data from the front of the list or null.
     */
    @Override
    public T removeFromFront() {
        T element = backingArray[0];
        removeAtIndex(0);
        return element;
    }

    /**
     * Remove the last element in the list and return it.
     *
     * If the list is empty, return {@code null}.
     * Must be O(1).
     *
     * @return The data from the back of the list or null.
     */
    @Override
    public T removeFromBack() {
        return removeAtIndex(size - 1);
    }

    /**
     * Returns the element at the given index.
     * @param index The index of the element
     * @return The data stored at that index.
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or
     * index >= size.
     */
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new java.lang.IndexOutOfBoundsException(
                "The index is out of bounds");
        } else {
            return backingArray[index];
        }
    }

    /**
     * Return a boolean value representing whether or not the list is empty.
     * @return true if empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return backingArray[0] == null;
    }

    /**
     * Return the size of the list as an integer.
     * @return The size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clear the list. Reset the backing array to a new array of the initial
     * capacity.
     */
    @Override
    public void clear() {
        T[] newArray = (T[]) new Object[INITIAL_CAPACITY];
        backingArray = newArray;
        size  = 0;
    }

    /**
     * Access the array in the arraylist.
     * @ return the backingArray instance variable
     */
    @Override
    public Object[] getBackingArray() {
        // DO NOT MODIFY.
        return backingArray;
    }

    /**
     * Double the capacity of the array if size equals capacity
     * @ return a new array which has been double-sized
     */
    private void doubleCapacity() {
        T[] newArray = (T[]) new Object[backingArray.length * 2];
        for (int i = 0; i < backingArray.length; i++) {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
    }

    /**
     * shift the designated indeces in the array to the right,
     * starting from the "index" index
     * @ param index The index to start shifting the array
     */
    private void rightShiftAtIndex(int index) {
        for (int i = size - 1; i >= index; i--) {
            backingArray[i + 1] = backingArray[i];
        }
        backingArray[index] = null;
    }

    /**
     * add the required element to the designated index
     * @ param index The index to add the element into
     * @ param data  The data to add into the designated index.
     */
    private void addElementAtIndex(int index, T data) {
        backingArray[index] = data;
    }

    /**
     * remove the last element in the array
     */
    private void removeLastOne() {
        backingArray[size - 1] = null;
    }

    /**
     * shift the designated indeces in the array one index to the left,
     * starting from the "index" index
     * @ param index The index to start shifting the array
     */
    private void leftShiftAtIndex(int index) {
        for (int i = index; i < size; i++) {
            backingArray[i - 1] = backingArray[i];
        }
        backingArray[size - 1] = null;
    }
}
