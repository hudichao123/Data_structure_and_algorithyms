public class Stack1<E> {
    public final int CAPACITY = 3;
    private E[] data;
    private int t = -1;

    public Stack1() {
        data = (E[]) new Object[CAPACITY];
    }

    public void push(E e) throws IllegalStateException {
        if (t + 1 == CAPACITY) {
            throw new IllegalStateException("The stack is full.");
        } else {
            t++;
            data[t] = e;
        }
    }

    public E pop() {
        E e;
        if (isEmpty()) {
            return null;
        } else {
            e = data[t];
            data[t] = null;
            t--;
            
            return e;
        }
    }

    public E top() {
        E e;
        if (isEmpty()) {
            return null;
        } else {
            e = data[t];
            return e;
        }

    }

    public int size() {
        return t + 1;
    }

    public boolean isEmpty() {
        return t == -1;
    }
    
    public void printStack() {
        System.out.print("[");
        for (int i = 0; i < t + 1; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]\nsize:" + (t + 1));
    }
    
    public static void main(String[] args) {
        Stack1<String> s = new Stack1<> ();
        String a = "s";
        s.push(a);
    }
}