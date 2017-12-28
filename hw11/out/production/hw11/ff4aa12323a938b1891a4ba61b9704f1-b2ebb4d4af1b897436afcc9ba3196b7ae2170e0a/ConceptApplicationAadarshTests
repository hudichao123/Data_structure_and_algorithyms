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
 * Don't forget to check for space and time complexities by yourself.
 * These tests do not check for them.
 *
 * @author Aadarsh Padiyath
 * @version 42.0
 */
public class ConceptApplicationAadarshTests {

    public static final int TIMEOUT = 200;

    //----------------------------------------
    //            countAllPairs
    //----------------------------------------

    @Test (timeout = TIMEOUT)
    public void testFindAllPairs() {
        int[] arr = {0, 4, 2, 6, 5, 9, 10};

        int actual = ConceptApplication.countAllPairs(arr, 10);

        assertEquals("The lists differed for countAllPairs()", 2, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindAllPairsDoubleNumber() {
        int[] arr = {2, 2, 1, 3};

        int actual = ConceptApplication.countAllPairs(arr, 4);

        assertEquals("Your algo did not account for duplicates", 2, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindAllPairsDontDoubleCountNumber() {
        int[] arr = {2};

        int actual = ConceptApplication.countAllPairs(arr, 4);

        assertEquals("Your list accidentally thinks there's two 2's", 0, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindAllPairsTripleNumber() {
        int[] arr = {2, 2, 2};

        int actual = ConceptApplication.countAllPairs(arr, 4);

        assertEquals("Your algo did not account for multiple duplicates", 1, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindAllPairsNull() {
        int[] arr = null;

        int actual = ConceptApplication.countAllPairs(arr, 4);

        assertEquals("Null arrays should have zero pairs", 0, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindAllPairsEmpty() {
        int[] arr = {};

        int actual = ConceptApplication.countAllPairs(arr, 4);

        assertEquals("Empty arrays should have zero pairs", 0, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindAllPairsNegNumbers() {
        int[] arr = {-2, -1, -2, -1, 0};

        int actual = ConceptApplication.countAllPairs(arr, -2);

        assertEquals("Negative numbers should be counted properly", 2, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindAllPairsNoPairs() {
        int[] arr = {-2, -1, 1, 2};

        int actual = ConceptApplication.countAllPairs(arr, 2);

        assertEquals(0, actual);
    }

    //----------------------------------------
    //              reverse
    //----------------------------------------

    @Test(timeout = TIMEOUT)
    public void testReverseNull() {
        assertNull(ConceptApplication.reverse(null));
    }

    @Test(timeout = TIMEOUT)
    public void testReverseOnlyHead() {
        LinkedListNode<String> head = new LinkedListNode<>("Honey?", null);
        LinkedListNode<String> expected = new LinkedListNode<>("Honey?", null);

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

    @Test(timeout = TIMEOUT)
    public void testReverseTwoNodes() {
        LinkedListNode<String> head = new LinkedListNode<>("Honey?",
                new LinkedListNode<>("What?", null));
        LinkedListNode<String> expected = new LinkedListNode<>("What?",
                new LinkedListNode<>("Honey?"));

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

    @Test(timeout = TIMEOUT)
    public void testReverseThreeNodes() {
        LinkedListNode<String> head = new LinkedListNode<>("Honey?",
                new LinkedListNode<>("What?", new LinkedListNode<>("Where's my Supersuit?")));
        LinkedListNode<String> expected = new LinkedListNode<String>("Where's my Supersuit?",
                new LinkedListNode<>("What?",
                new LinkedListNode<>("Honey?")));

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

    @Test (timeout = TIMEOUT)
    public void testReverseMultipleNodes() {
        LinkedListNode<String> head =
                new LinkedListNode<String>("Honey?",
                new LinkedListNode<String>("What?",
                new LinkedListNode<String>("Where's my Supersuit?",
                new LinkedListNode<String>("Whaaat?",
                new LinkedListNode<String>("WHERE.",
                new LinkedListNode<String>("IS.",
                new LinkedListNode<String>("MY.",
                new LinkedListNode<String>("SUPERSUIT.",
                new LinkedListNode<String>("I uh, I put it away",
                new LinkedListNode<String>("WHERE?",
                new LinkedListNode<String>("WHYYY do you NEED to KNOW",
                new LinkedListNode<String>("THE PUBLIC IS IN DANGER",
                new LinkedListNode<String>("MY EVENINGS IN DANGER",
                new LinkedListNode<String>("We are talking about the greater good here!",
                new LinkedListNode<String>("I.",
                new LinkedListNode<String>("AM.",
                new LinkedListNode<String>("YOUR.",
                new LinkedListNode<String>("WIFE.",
                new LinkedListNode<String>("I AM THE GREATEST GOOD YOU ARE EVER GONNA GET.")))))))))))))))))));

        LinkedListNode<String> expected =
                new LinkedListNode<String>("I AM THE GREATEST GOOD YOU ARE EVER GONNA GET.",
                new LinkedListNode<String>("WIFE.",
                new LinkedListNode<String>("YOUR.",
                new LinkedListNode<String>("AM.",
                new LinkedListNode<String>("I.",
                new LinkedListNode<String>("We are talking about the greater good here!",
                new LinkedListNode<String>("MY EVENINGS IN DANGER",
                new LinkedListNode<String>("THE PUBLIC IS IN DANGER",
                new LinkedListNode<String>("WHYYY do you NEED to KNOW",
                new LinkedListNode<String>("WHERE?",
                new LinkedListNode<String>("I uh, I put it away",
                new LinkedListNode<String>("SUPERSUIT.",
                new LinkedListNode<String>("MY.",
                new LinkedListNode<String>("IS.",
                new LinkedListNode<String>("WHERE.",
                new LinkedListNode<String>("Whaaat?",
                new LinkedListNode<String>("Where's my Supersuit?",
                new LinkedListNode<String>("What?",
                new LinkedListNode<String>("Honey?")))))))))))))))))));

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
    public void testIsSymmetricNull() {
        BinaryNode<String> root = null;

        assertTrue("Null tree is supposed to be symmetric",
                ConceptApplication.isSymmetric(root));
    }

    @Test (timeout = TIMEOUT)
    public void testIsSymmetricOnlyRoot() {
        BinaryNode<String> root = new BinaryNode<>("Will Smith can eat chikke nuggs");

        assertTrue("Tree with only a root is supposed to be symmetric",
                ConceptApplication.isSymmetric(root));
    }

    @Test (timeout = TIMEOUT)
    public void testIsSymmetricTrue() {
        BinaryNode<String> root = new BinaryNode<>("Two");
        root.setLeft(new BinaryNode<>("Plus"));
        root.setRight(new BinaryNode<>("Plus"));
        root.getLeft().setLeft(new BinaryNode<>("Two"));
        root.getRight().setRight(new BinaryNode<>("Two"));
        root.getLeft().getLeft().setLeft(new BinaryNode<>("is Four"));
        root.getRight().getRight().setRight(new BinaryNode<>("is Four"));
        root.getLeft().getLeft().getLeft().setLeft(new BinaryNode<>("minus One"));
        root.getRight().getRight().getRight().setRight(new BinaryNode<>("minus One"));
        root.getLeft().getLeft().getLeft().getLeft().setLeft(new BinaryNode<>("that's Three"));
        root.getRight().getRight().getRight().getRight().setRight(new BinaryNode<>("that's Three"));
        root.getLeft().getLeft().getLeft().getLeft().getLeft().setLeft(new BinaryNode<>("quick mafs"));
        root.getRight().getRight().getRight().getRight().getRight().setRight(new BinaryNode<>("quick mafs"));

        assertTrue("The symmetric tree was not identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }

    @Test (timeout = TIMEOUT)
    public void testIsSymmetricFalse() {
        BinaryNode<String> root = new BinaryNode<>("Two");
        root.setLeft(new BinaryNode<>("Plus"));
        root.setRight(new BinaryNode<>("Plus"));
        root.getLeft().setLeft(new BinaryNode<>("Two"));
        root.getRight().setRight(new BinaryNode<>("Two"));
        root.getLeft().getLeft().setLeft(new BinaryNode<>("is Four"));
        root.getRight().getRight().setRight(new BinaryNode<>("is Four"));
        root.getLeft().getLeft().getLeft().setLeft(new BinaryNode<>("minus One"));
        root.getRight().getRight().getRight().setRight(new BinaryNode<>("minus One"));
        root.getLeft().getLeft().getLeft().getLeft().setLeft(new BinaryNode<>("that's Three"));
        root.getRight().getRight().getRight().getRight().setRight(new BinaryNode<>("that's Three"));
        root.getLeft().getLeft().getLeft().getLeft().getLeft().setLeft(new BinaryNode<>("quick mafs"));
        root.getRight().getRight().getRight().getRight().getRight().setRight(new BinaryNode<>("quick mafs"));
        root.getRight().getRight().getRight().getRight().getRight().setLeft(new BinaryNode<>("-Abert Eistenin"));

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

        assertArrayEquals(expected, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindKLessThanZero() {
        Comparable[] arr = new Integer[] {1, 2, 3, 4, 5};
        Comparable[] expected = new Integer[0];

        Comparable[] actual = ConceptApplication.findKLargest(arr, -420);

        assertArrayEquals(expected, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindKGreaterThanArrLength() {
        Comparable[] arr = new Integer[] {1, 2, 3, 4, 5};
        Comparable[] expected = new Integer[] {1, 2, 3, 4, 5};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 69);

        assertArrayEquals(expected, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindKArrLengthZero() {
        Comparable[] arr = new Integer[] {};
        Comparable[] expected = new Integer[] {};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 666);

        assertArrayEquals(expected, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindKNegativeEntries() {
        Comparable[] arr = new Integer[] {-3, -1, 0, 1, 3};
        Comparable[] expected = new Integer[] {-1, 0, 1, 3};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 4);

        assertArrayEquals(expected, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testFindKDuplicates() {
        Comparable[] arr = new Integer[] {69, 69, 69, 420, 666, 420, 69};
        Comparable[] expected = new Integer[] {69, 69, 69, 420, 420, 666};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 6);

        assertArrayEquals(expected, actual);
    }

    //----------------------------------------
    //           matchingBrackets
    //----------------------------------------

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsEmptyString() {
        String str = "";
        assertTrue(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsParensTrue() {
        String str = "()";
        assertTrue(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsSquareParensTrue() {
        String str = "[]";
        assertTrue(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsCurlyParensTrue() {
        String str = "{}";
        assertTrue(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsParensFalse() {
        String str = ")";
        assertFalse(ConceptApplication.matchingBrackets(str));
        str = "())";
        assertFalse(ConceptApplication.matchingBrackets(str));
        str = "(()";
        assertFalse(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsSquareParensFalse() {
        String str = "]";
        assertFalse(ConceptApplication.matchingBrackets(str));
        str = "[]]";
        assertFalse(ConceptApplication.matchingBrackets(str));
        str = "[[]";
        assertFalse(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsCurlyParensFalse() {
        String str = "}";
        assertFalse(ConceptApplication.matchingBrackets(str));
        str = "{}}";
        assertFalse(ConceptApplication.matchingBrackets(str));
        str = "{{}";
        assertFalse(ConceptApplication.matchingBrackets(str));
    }

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
