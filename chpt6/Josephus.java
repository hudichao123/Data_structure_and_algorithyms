public class Josephus {
    public static <E> E Josephus (int k, CircularQueue1<E> q) {
        if (q.isEmpty()) {
            return null;
        }
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.rotate();
            }
            q.dequeue();
        }
        return q.first();
    }
    
    public static void main(String[] args) {
        CircularQueue1<String> c = new CircularQueue1<> ();
        c.enqueue("a");
        c.enqueue("b");
        c.enqueue("c");
        c.enqueue("d");
        System.out.println(Josephus(3, c));
    
    }


}