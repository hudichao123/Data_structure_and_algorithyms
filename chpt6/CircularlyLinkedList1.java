public class CircularlyLinkedList1<E> {
    public static class Node<E> {
        private Node<E> next;
        private E data;
        public Node(E data, Node<E> next) {
            this.next = next;
            this.data = data;
        }
        
        public void setNext(Node<E> n) {
            next = n;
        }
        
        public E getData() {
            return data;
        }
        
        public Node<E> getNext() {
            return next;
        }
    
    }
    
    private Node<E> tail;
    private int size;
    
    public CircularlyLinkedList1() {
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
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) tail.next.data;
        }   
    }
    
    public E last() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) tail.data;
        }   
    }
    
    public void rotate() {
        if (!isEmpty()) {
            tail = tail.next;
        } else {
        }
    }
    
    public void addFirst(E e) {
        Node<E> head = null;
        Node<E> n = null;
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.next = tail;
        } else {
            head = tail.next;
            n= new Node<>(e, head);
            tail.next = n;
        }
        size++;
        
    }
    
    public void addLast(E e) {
        addFirst(e);
        tail = tail.next;
    }
    
    public E removeFirst() {
        E e = null;
        Node head;
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else if (size == 1) {
            e = (E) tail.data;
            tail = null;
            size--;
        } else {
            e = (E) tail.next.data;
            head = tail.next;
            tail.next = head.next;
            size--;
        }
        return e;
    }
    
    public void printList() {
        Node<E> n = tail;
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(n.next.data + " ");
            n = n.next;
        }
        System.out.println("]\nsize: " + size);
    }
    
    public static void main(String[] args) {
        CircularlyLinkedList1<String> c = new CircularlyLinkedList1<> ();
        c.printList();
        c.addFirst("a");
        c.printList();
        c.addLast("b");
        c.printList(); 
        c.rotate();
        c.printList(); 
        c.addLast("tr");
        c.printList();
        c.rotate();
                c.printList(); 
        System.out.println(c.removeFirst());
        c.printList();
    }

}