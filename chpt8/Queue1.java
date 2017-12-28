public class Queue1<E> {
    public final int CAPACITY = 3;
    private E[] data;
    private int t = -1;


    
    public Queue1(int cap) {
        data = (E[]) new Object[cap];
    }

    public Queue1() {
        this(5);
    }

    public void enqueue(E e) throws IllegalStateException {
        if (t + 1 == CAPACITY) {
            throw new IllegalStateException("The stack is full.");
        } else {
            t++;
            data[t] = e;
        }
    }

    public E dequeue() {
        E e;
        if (isEmpty()) {
            return null;
        } else {
            e = data[0];
            data[0] = null;
            for (int i = 1; i < size(); i++) {
                data[i - 1] = data[i];
            }
            data[t] = null;
            t--;
            
            return e;
        }
    }

    public E first() {
        E e;
        if (isEmpty()) {
            return null;
        } else {
            e = data[0];
            return e;
        }

    }

    public int size() {
        return t + 1;
    }

    public boolean isEmpty() {
        return t == -1;
    }
    
    public void printQueue() {
        System.out.print("[");
        for (int i = 0; i < t + 1; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]\nsize:" + (t + 1));
    }
    
    public static void main(String[] args) {
        Queue1<Integer> q = new Queue1 <> ();
        q.enqueue(1);
    }
}