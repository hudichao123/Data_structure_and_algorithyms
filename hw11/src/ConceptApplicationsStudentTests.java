import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Basic student tests to check ConceptApplications. These tests are in
 * no way comprehensive nor do they guarantee any kind of grade.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class ConceptApplicationsStudentTests {

    public static final int TIMEOUT = 200;

    //----------------------------------------
    //            countAllPairs
    //----------------------------------------

    @Test (timeout = TIMEOUT)
    public void testFindAllPairs() {
        int[] arr = {0, 4, 2, 6, 5, 9, 10};

        int actual = ConceptApplication.countAllPairs(arr, 10);

        assertEquals("The lists differed for findAllPairs()", 2, actual);
    }

    //----------------------------------------
    //              reverse
    //----------------------------------------

    @Test (timeout = TIMEOUT)
    public void testReverse() {
        LinkedListNode<String> head = new LinkedListNode<String>("Raymond",
            new LinkedListNode<String>("Chad",
                new LinkedListNode<String>("Ashley",
                    new LinkedListNode<String>("Cliff",
                        new LinkedListNode<String>("Joey",
                            new LinkedListNode<String>("Maya"))))));

        LinkedListNode<String> expected = new LinkedListNode<String>("Maya",
            new LinkedListNode<String>("Joey",
                new LinkedListNode<String>("Cliff",
                    new LinkedListNode<String>("Ashley",
                        new LinkedListNode<String>("Chad",
                            new LinkedListNode<String>("Raymond"))))));

        LinkedListNode<String> actual = ConceptApplication.reverse(head);

        while (expected != null) {
            assertEquals("The following node was not correctly reversed",
                    expected.getData(), actual.getData());
            if (expected.getNext() == null) {
                assertNull("Last node did not point to null", actual.getNext());
            } else {
                assertEquals("The following pointer was not correctly reversed",
                    expected.getNext().getData(), actual.getNext().getData());
            }
            expected = expected.getNext();
            actual = actual.getNext();
        }
    }

    //----------------------------------------
    //             isSymmetric
    //----------------------------------------

    @Test (timeout = TIMEOUT)
    public void testIsSymmetricTrue() {
        BinaryNode<String> root = new BinaryNode<>("Alex");
        root.setLeft(new BinaryNode<>("Kevin"));
        root.setRight(new BinaryNode<>("Kevin"));
        root.getRight().setLeft(new BinaryNode<>("Sam"));
        root.getRight().setRight(new BinaryNode<>("Shaurye"));
        root.getLeft().setRight(new BinaryNode<>("Sam"));
        root.getLeft().setLeft(new BinaryNode<>("Shaurye"));

        assertTrue("The symmetric tree was not identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }

    @Test (timeout = TIMEOUT)
    public void testIsSymmetricFalse() {
        BinaryNode<String> root = new BinaryNode<>("Alok");
        root.setLeft(new BinaryNode<>("Stephanie"));
        root.setRight(new BinaryNode<>("Stephanie"));
        root.getRight().setLeft(new BinaryNode<>("Andrew S"));
        root.getLeft().setRight(new BinaryNode<>("Andrew B"));

        assertFalse("The non-symmetric tree was found to be symmetric",
                ConceptApplication.isSymmetric(root));
    }

    //----------------------------------------
    //             findKLargest
    //----------------------------------------

    @Test (timeout = TIMEOUT)
    public void testFindKLargest() {
        Comparable[] arr = new Integer[] {10, 0, 3, 35, 20, 6, 2, 40};
        Comparable[] expected = new Integer[] {20, 35, 40};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 3);

        assertArrayEquals("The top three elements were not correctly"
                        + " found or sorted", expected, actual);
    }

    //----------------------------------------
    //           matchingBrackets
    //----------------------------------------

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsTrue() {
        String str = "{[(I)(match!)]}";
        assertTrue(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsFalse() {
        String str = "{([( ))}";
        assertFalse(ConceptApplication.matchingBrackets(str));
    }
}
