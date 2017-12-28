/**
 * Your implementation of a DoublyLinkedList
 *
 * @author Dichao Hu
 * @userid dhu64
 * @GTID 903253306
 * @version 1.0
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T> {
    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    /**
     * Constructs a DoublyLinkedList with size equals to zero
     * and both head and tail equals null
      */
    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Adds the element to the index specified.
     * @param index The requested index for the new element.
     * @param data The data for the new element.
     * @throws java.lang.IndexOutOfBoundsException if index is negative or
     * index > size.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addAtIndex(int index, T data) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(data,
                null, null);
        LinkedListNode<T> traverse;
        if (index == 0) {
            addToFront(data);
        } else if (index == size) {
            addToBack(data);
        } else {
            if (data == null) {
                throw new java.lang.IllegalArgumentException(
                        "Data can not be null");
            } else if (index < 0 || index > size) {
                throw new java.lang.IndexOutOfBoundsException(
                        "Your index is out of bounds");
            } else {
                traverse = head;
                for (int i = 0; i < index - 1; i++) {
                    traverse = traverse.getNext();
                }
                newNode.setPrevious(traverse);
                newNode.setNext(traverse.getNext());
                traverse.setNext(newNode);
                traverse.getNext().getNext().setPrevious(newNode);
                size++;
            }
        }
    }

    /**
     * Adds the element to the front of the list. Make sure to update head.
     * @param data The data for the new element.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addToFront(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(data,
                null, null);
        if (data == null) {
            throw new java.lang.IllegalArgumentException(
                    "Your data can not be null");
        } else {
            if (size == 0) {
                head = newNode;
                tail = newNode;
                size++;
            } else {
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
                size++;
            }
        }
    }

    /**
     * Adds the element to the back of the list. Make sure to update tail.
     * @param data The data for the new element.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addToBack(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(data,
                null, null);
        if (data == null) {
            throw new java.lang.IllegalArgumentException(
                    "Your data can not be null");
        } else {
            if (size == 0) {
                head = newNode;
                tail = newNode;
                size++;
            } else {
                newNode.setPrevious(tail);
                tail.setNext(newNode);
                tail = newNode;
                size++;
            }
        }
    }

    /**
     * Removes and returns the element from the index specified.
     * @param index The requested index to be removed.
     * @return The object formerly located at index.
     * @throws java.lang.IndexOutOfBoundsException if index is negative or
     * index >= size.
     */
    @Override
    public T removeAtIndex(int index) {
        T t;
        LinkedListNode<T> traverse = null;
        LinkedListNode<T> n1 = null;
        LinkedListNode<T> n2 = null;
        if (index < 0 || index >= size) {
            throw new java.lang.IndexOutOfBoundsException(
                    "Your index is out of bounds");
        } else if (index == 0) {
            t = removeFromFront();
        } else if (index == size - 1) {
            t = removeFromBack();

        } else {
            traverse = head;
            for (int i = 0; i < index; i++) {
                traverse = traverse.getNext();
            }
            n1 = traverse.getPrevious();
            n2 = traverse.getNext();
            System.out.println(n1.getData());
            System.out.println(n2.getData());
            n1.setNext(n2);
            n2.setPrevious(n1);

            t = traverse.getData();
            size--;
        }
        return t;
    }

    /**
     * Removes and returns the element at the front of the list. If the list is
     * empty, return {@code null}.
     * @return The object formerly located at the front.
     */
    @Override
    public T removeFromFront() {
        T t;
        if (size == 0) {
            throw new java.lang.IndexOutOfBoundsException(
                    "Your index is out of bounds");
        } else {
            t = head.getData();
            if (size == 1) {
                head = null;
                tail = null;
                size--;
            } else {
                head.getNext().setPrevious(null);
                head = head.getNext();
                size--;
            }
        }
        return t;
    }

    /**
     * Removes and returns the element at the back of the list. If the list is
     * empty, return {@code null}.
     * @return The object formerly located at the back.
     */
    @Override
    public T removeFromBack() {
        T t;
        if (size == 0) {
            throw new java.lang.IndexOutOfBoundsException(
                    "Your index is out of bounds");
        } else {
            t = tail.getData();
            if (size == 1) {
                head = null;
                tail = null;
                size--;
            } else {
                tail.getPrevious().setNext(null);
                tail = tail.getPrevious();
                size--;
            }
        }
        return t;
    }

    /**
     * Removes the first copy of the given data from the list.
     * @param data The data to be removed from the list.
     * @return true if something was removed from the list; false otherwise.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public boolean removeFirstOccurrence(T data) {
        int pointer = 0;
        LinkedListNode<T> traverse;
        if (data == null) {
            throw new java.lang.IllegalArgumentException(
                    "Your data can not be null");
        } else if (size == 0) {
            return false;
        } else {
            traverse = head;
            while (pointer < size && traverse.getData() != data) {
                traverse = traverse.getNext();
                pointer++;
            }
            if (pointer == size) {
                return false;
            } else {
                removeAtIndex(pointer);
                return true;
            }
        }
    }

    /**
     * Returns the element at the specified index.
     * @param index The index of the requested element.
     * @return The object stored at index.
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or
     * index >= size.
     */
    @Override
    public T get(int index) {
        LinkedListNode<T> traverse;
        if (index < 0 || index >= size) {
            throw new java.lang.IndexOutOfBoundsException(
                    "Your index is out of bounds");
        } else {
            traverse = head;
            for (int i = 0; i < size; i++) {
                traverse = traverse.getNext();
            }
            return traverse.getData();
        }
    }

    /**
     * Returns an array representation of the linked list.
     * @return An array of length {@code size} holding all of the objects in
     * this list in the same order.
     */
    @Override
    public Object[] toArray() {
        Object[] array;
        LinkedListNode<T> traverse;
        if (size == 0) {
            return new Object[0];
        } else {
            array = new Object[size];
            traverse = head;
            for (int i = 0; i < size; i++) {
                array[i] = traverse.getData();
                traverse = traverse.getNext();
            }
            return array;
        }
    }

    /**
     * Returns a boolean value indicating if the list is empty.
     * @return true if empty; false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     * @return The size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clears the list of all data.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns the head node of the linked list.
     *
     * @return Node at the head of the linked list.
     */
    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    /**
     * Returns the tail node of the linked list.
     *
     * @return Node at the tail of the linked list.
     */
    @Override
    public LinkedListNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }
}
