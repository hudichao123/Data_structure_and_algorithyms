public class SinglyLinkedList1<E> {
    public static class Node<E> {
        public E data;
        public Node<E> next;
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public E getdata() {
            return data;
        }
        
        public Node<E> getNext() {
            return next;
        }
        
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public SinglyLinkedList1() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public E first() {
        if (size == 0) {
            throw new java.lang.IndexOutOfBoundsException();
        } else {
            return (E) head.data;  
        }
    }
    
    public E last() {
        if (size == 0) {
            throw new java.lang.IndexOutOfBoundsException();
        } else {
            return (E) tail.data;
            
        }
    }
    
    public void addFirst(E e) {
        Node<E> n = new Node<> (e, head);
        if (size == 0) {
            head = tail = n;
        } else {
            head = n;
        }
        size++;
    }
    
    public void addLast(E e) {
        Node<E> n = new Node<> (e, null);
        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }
    
    public E removeFirst() {
        E e;
        if (size == 0) {
            e = null;
            throw new java.lang.IndexOutOfBoundsException();
        } else if (size == 1) {
            e = (E) head.data;
            head = tail = null;
            size--;
        } else {
            e = (E) head.data;
            head = head.next;
            size--;
        }
        return e;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList1<String> s = new SinglyLinkedList1<> ();
        s.printList();

        System.out.println(s.isEmpty());
        s.addFirst("a");
        s.addLast("b");
        s.addFirst("x");
        s.printList();
        System.out.println(s.first());
        System.out.println(s.isEmpty());
        System.out.println(s.removeFirst());
        s.printList();
    
    }
    
    public void printList() {
        Node<E> traverse = head;
        System.out.print("[ ");
        while (traverse != null) {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
        System.out.println("]");
        System.out.println("size :" + size);
    }
}