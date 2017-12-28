public class CircularQueue1<E> {
    private CircularlyLinkedList1<E> list =
        new CircularlyLinkedList1<E>();
    
    public CircularQueue1() {
    }
    
    public void enqueue(E e) {
        list.addLast(e);
    }
    
    public E dequeue() {
        return (list.removeFirst());
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
       return list.isEmpty();
    }
    
    public E first() {
        return list.first();
    }
    
    public void rotate() {
        list.rotate();
    }
}