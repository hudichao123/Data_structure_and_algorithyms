import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Your implementation of various applications of course concepts.
 *
 * @author Dichao Hu
 * @userid dhu64
 * @GTID 903253306
 * @version 1.0
 */
public class ConceptApplication {

    /**
     * For this method, find the total number of pairs in a given array that
     * sum up to the given k value. Individual entries in the array cannot be
     * used for more than one pair and negative values may be present. You do
     * not have to worry about integer underflow or overflow.
     *
     * This solution should run in O(n) time and use O(n) extra space.
     * Only make one pass through the array when solving this problem.
     *
     * @param arr the array to find pairs within
     * @param k the desired sum of pairs to find
     * @return the number of pairs present in arr that sum up to k
     */
    public static int countAllPairs(int[] arr, int k) {
        int n = 0;
        if (arr == null) {
            return 0;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = k - arr[i];
            if (!m.containsKey(temp)) {
                m.put(temp, 0);
            }
            if (!m.containsKey(arr[i])) {
                m.put(arr[i], 0);
            }
            if (m.get(arr[i]) > 0) {
                n++;
                m.put(arr[i], m.get(arr[i]) - 1);
            } else {
                m.put(temp, m.get(temp) + 1);
            }
        }
        return n;
    }

    /**
     * Reverse the order of nodes contained in the given LinkedList. Given a
     * list of nodes a->b->c, the returned list from this method should be
     * c->b->a. The reverse of a singular or null node is simply the node
     * itself.
     *
     * Implement this method in O(n) time and O(1) space, not including the
     * recursive stack if utilized. Only make one pass through the list when
     * solving this problem.
     *
     * @param head the head reference for the LinkedList to reverse
     * @param <T> data type
     * @return a reverse of the passed in LinkedList
     */
    public static <T> LinkedListNode<T> reverse(LinkedListNode<T> head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }
        if (head.getNext().getNext() == null) {
            LinkedListNode<T> tail = head.getNext();
            tail.setNext(head);
            head.setNext(null);
            return tail;
        }
        LinkedListNode<T> prev = head;
        LinkedListNode<T> curr = head.getNext();
        LinkedListNode<T> next = curr.getNext();
        head.setNext(null);
        while (curr.getNext() != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        curr.setNext(prev);
        return curr;
    }

    /**
     * Given a Binary Tree, determine whether it is symmetric about the root.
     * For this assignment, symmetry is defined as a mirroring of the nodes to
     * the left and right of the root with regards to shape and data. A singular
     * or null node is symmetric. For example, the following tree is considered
     * to be symmetric.
     *
     *                          a
     *                        /   \
     *                       b     b
     *                     /  \  /  \
     *                    c   d d    c
     *
     * Your implementation should run in O(n) time and use O(1) extra space, not
     * including the recursive stack if utilized. Only make one traversal
     * through the tree when solving this problem.
     *
     * Do not modify the given tree.
     *
     * @param root the root of the tree to check
     * @param <T> data type
     * @return true if the tree is symmetric, false otherwise
     */
    public static <T> boolean isSymmetric(BinaryNode<T> root) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return true;
        }
        return isSymmetric(root.getLeft(), root.getRight());
    }

    /**
     * a helper method for is symmetric
     * @param left the left node
     * @param right the right node
     * @param <T> data type
     * @return boolean
     */
    private static <T> boolean isSymmetric(BinaryNode<T> left,
                                           BinaryNode<T> right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left.getData().equals(right.getData())) {
            return isSymmetric(left.getLeft(), right.getRight())
                    && isSymmetric(left.getRight(), right.getLeft());
        }
        return false;
    }

    /**
     * In this problem, you are given an array of comparable objects. You are
     * told to return a list of the k largest objects in ascending order.
     *
     * If k is not positive, return an empty array
     * If k > array length, return all contents of the array in ascending order.
     * The array you are given will never be null.
     *
     * This solution should run in average and worst case O(n log k) time and
     * use just O(k) space. Only make one pass through the array when solving
     * this problem.
     *
     * @param arr the input array of Comparable objects
     * @param k the number of elements to return
     * @param <T> a comparable object
     * @return an array of the k largest elements in arr in ascending order
     */
    public static <T extends Comparable<? super T>> T[]
                                                findKLargest(T[] arr, int k) {

        if (k <= 0 || arr.length == 0 || arr == null) {
            return (T[]) new Comparable[0];
        }
        if (k > arr.length) {
            k = arr.length;
        }
        T[] newArr = (T[]) (new Comparable[k]);
        PriorityQueue<T> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            T element = arr[i];
            if (element.compareTo(minHeap.peek()) > 0) {
                minHeap.remove();
                minHeap.add(element);
            }
        }
        for (int i = 0; i < k; i++) {
            T element = minHeap.remove();
            newArr[i] = element;
        }
        return newArr;
    }


    /**
     * In this problem you are given a string of characters. You must act
     * somewhat like a parser and determine if this string is valid based
     * on the brackets (parenthesis (), square brackets [], curly braces {}).
     *
     * It will return true if for every open bracket: (, [, {, there is a
     * corresponding closed bracket: ), ], }, and no two pairs of brackets
     * partially overlap.
     *
     * [()] is valid, but [(]) is not as the contents of the parenthesis
     * partially overlap with the contents of the square brackets.
     *
     * A string without brackets is also a valid string. You will never be
     * given a null string as input.
     *
     * This should run in O(n) time with O(n) extra space. Only make one pass
     * through the string when solving this problem.
     *
     * @param str input of characters that needs to be parsed
     * @return whether or not the string has a valid combination of brackets:
     *  {}, (), []
     */
    public static boolean matchingBrackets(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
            case ('('):
                s.push('(');
                break;
            case ('['):
                s.push('[');
                break;
            case ('{'):
                s.push('{');
                break;
            case (')'):
                if (s.isEmpty()) {
                    return false;
                }
                char c2 = s.peek();
                if (c2 == '(') {
                    s.pop();
                    break;
                } else {
                    return false;
                }
            case (']'):
                if (s.isEmpty()) {
                    return false;
                }
                char c3 = s.peek();
                if (c3 == '[') {
                    s.pop();
                    break;
                } else {
                    return false;
                }
            case ('}'):
                if (s.isEmpty()) {
                    return false;
                }
                char c4 = s.peek();
                if (c4 == '{') {
                    s.pop();
                    break;
                } else {
                    return false;
                }
            default:
            }
        }
        return s.isEmpty();
    }
}
