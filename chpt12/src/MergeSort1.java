
public class MergeSort1<T extends Comparable<T>> {
    public  void merge(Queue1<T> q1, Queue1<T> q2, Queue1<T> q) {
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.first().compareTo(q2.first()) < 0) {
                q.enqueue(q1.dequeue());
            } else {
                q.enqueue(q2.dequeue());
            }
        }

        while (!q1.isEmpty()) {
            q.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            q.enqueue(q2.dequeue());
        }
    }

    public  void mergeSort(Queue1<T> q) {
        if (q.size() < 2) {

        } else {
            Queue1<T> q1 = new Queue1<>();
            Queue1<T> q2 = new Queue1<>();
            for (int i = 0; i < q.size()/2; i++) {
                q1.enqueue(q.dequeue());
            }
            while(!q.isEmpty()) {
                q2.enqueue(q.dequeue());
            }
            mergeSort(q1);
            mergeSort(q2);
            merge(q1,q2,q);
        }
    }

    public static void main(String[] args) {
        MergeSort1<Integer> m1 = new MergeSort1<>();
        Queue1<Integer> q = new Queue1<>();
q.enqueue(37);
q.enqueue(4);
q.enqueue(8);
q.enqueue(9);
        m1.mergeSort(q);
        for (int i = 0; i < 4; i++) {
            System.out.print(q.dequeue() + " ");
        }
    }
}
