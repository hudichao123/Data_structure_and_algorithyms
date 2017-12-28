public class Test {

    

    
    public class A {
        private int a;
        private A(int a) {
            this.a = a;
        }
        
        private int getA() {
            return a;
        }
    }
    public A a2;
    public int b;
    public Test() {
        a2 = null;
        b = 1;
    }

    public static void main(String[] args) {
        A test = new A(1);
        System.out.println(test.getA());
    
    }

    private void printList() {
        LinkedListNode<T> n = head;
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(n.getNext().getData() + " ");
            n = n.getNext();
        }
        System.out.println("]\nsize: " + size);
    }
}