import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
  * Simple test cases for heaps and priority queues.
  * Write your own tests to ensure you cover all edge cases.
  *
  * @author CS 1332 TAs
  * @version 1.0
  */
public class HeapPQStudentTests {

    private static final int TIMEOUT = 200;
    private HeapInterface<Integer> minHeap;
    private PriorityQueueInterface<Integer> minPriorityQueue;

    @Before
    public void setUp() {
        minHeap = new MinHeap<>();
        minPriorityQueue = new MinPriorityQueue<>();
    }

    @Test(timeout = TIMEOUT)
    public void testHeap() {
        minHeap.add(43);
        minHeap.add(89);
        minHeap.add(17);
        minHeap.add(64);
        minHeap.add(5);

        Integer[] expected = new Integer[HeapInterface.INITIAL_CAPACITY];
        expected[1] = 5;
        expected[2] = 17;
        expected[3] = 43;
        expected[4] = 89;
        expected[5] = 64;
        assertArrayEquals(expected,
                ((MinHeap<Integer>) minHeap).getBackingArray());

        assertEquals(new Integer(5), minHeap.remove());
        assertEquals(new Integer(17), minHeap.remove());
        assertEquals(3, minHeap.size());
        assertFalse(minHeap.isEmpty());
        assertEquals(new Integer(43), minHeap.remove());
        assertEquals(new Integer(64), minHeap.remove());
        assertEquals(new Integer(89), minHeap.remove());
        assertTrue(minHeap.isEmpty());
        Integer[] finalExpected = new Integer[HeapInterface.INITIAL_CAPACITY];
        assertArrayEquals(finalExpected,
                ((MinHeap<Integer>) minHeap).getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testPriorityQueue() {
        minPriorityQueue.enqueue(43);
        minPriorityQueue.enqueue(89);
        minPriorityQueue.enqueue(17);
        minPriorityQueue.enqueue(64);
        minPriorityQueue.enqueue(5);

        assertEquals(new Integer(5), minPriorityQueue.dequeue());
        assertEquals(new Integer(17), minPriorityQueue.dequeue());
        assertEquals(3, minPriorityQueue.size());
        assertFalse(minPriorityQueue.isEmpty());
        assertEquals(new Integer(43), minPriorityQueue.dequeue());
        assertEquals(new Integer(64), minPriorityQueue.dequeue());
        assertEquals(new Integer(89), minPriorityQueue.dequeue());
        assertTrue(minPriorityQueue.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testResize() {
        for (int i = 0; i < HeapInterface.INITIAL_CAPACITY - 1; i++) {
            minHeap.add(i * i * i - 74);
        }

        assertEquals(HeapInterface.INITIAL_CAPACITY - 1, minHeap.size());
        assertEquals(HeapInterface.INITIAL_CAPACITY, ((MinHeap<Integer>) minHeap).getBackingArray().length);

        minHeap.add(9 * 9 * (HeapInterface.INITIAL_CAPACITY - 1) - 74);

        assertEquals(HeapInterface.INITIAL_CAPACITY, minHeap.size());
        assertEquals(HeapInterface.INITIAL_CAPACITY * 2, ((MinHeap<Integer>) minHeap).getBackingArray().length);
    }
}
