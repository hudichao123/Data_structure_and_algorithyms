import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * These tests cover some edge cases, but don't really
 * expect these to cover ALL bases or guarantee any kind of grade.
 *
 * @author Simola Nayak
 * @version 1.0
 */
public class SupplementalTestsConceptApplications {

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
    
    @Test (timeout = TIMEOUT)
    public void testFindNoPairs() {
        int[] arr = {1, 2, 5, 3, 4};

        int actual = ConceptApplication.countAllPairs(arr, 10);

        assertEquals("The lists differed for findAllPairs()", 0, actual);
    }
    
    @Test(timeout = TIMEOUT)
    public void testEmptyArr() {
        int[] arr = {};
        
        int actual = ConceptApplication.countAllPairs(arr, 0);

        assertEquals("The lists differed for findAllPairs()", 0, actual);
    }
    
    @Test(timeout = TIMEOUT)
    public void testOneEntryArr() {
        int[] arr = {1};
        
        int actual = ConceptApplication.countAllPairs(arr, 1);

        assertEquals("The lists differed for findAllPairs()", 0, actual);
    }
    
    @Test(timeout = TIMEOUT)
    public void testDuplicates() {
        int[] arr = {1, 1, 2, 4, 4, 2, 5};
       
        int actual = ConceptApplication.countAllPairs(arr, 3);

        assertEquals("The lists differed for findAllPairs()", 2, actual);
    }
    
    @Test(timeout = TIMEOUT)
    public void testNegatives() {
        int[] arr = {1, -2, 3, 2, -5, 10, -11, -9, 8};
        
        int actual = ConceptApplication.countAllPairs(arr, -1);

        assertEquals("The lists differed for findAllPairs()", 3, actual);
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

    @Test (timeout = TIMEOUT)
    public void testReverseTwoNodes() {
        LinkedListNode<String> head = new LinkedListNode<>("flip",
                new LinkedListNode<String>("flop"));

        LinkedListNode<String> expected = new LinkedListNode<>("flop",
                new LinkedListNode<String>("flip"));

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
    public void testReverseThreeNodes() {
        //heh heh heh...
        LinkedListNode<String> head = new LinkedListNode<>("vim",
                new LinkedListNode<String>("is better than",
                        new LinkedListNode<String>("emacs")));

        LinkedListNode<String> expected = new LinkedListNode<>("emacs",
                new LinkedListNode<String>("is better than",
                        new LinkedListNode<String>("vim")));

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
    public void testOneNode() {
        LinkedListNode<String> head = new LinkedListNode<>("WHO"
                 + " TOUCHED THE 'RECK?!");

        LinkedListNode<String> expected = new LinkedListNode<>("WHO"
                 + " TOUCHED THE 'RECK?!");

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
    public void blatantAsymmetryTestL() {
        BinaryNode<String> root = new BinaryNode<>("C");
        BinaryNode<String> left = new BinaryNode<>("C#");
        root.setLeft(left);
        
        assertFalse("The asymmetric tree was identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }
    
    @Test (timeout = TIMEOUT)
    public void practicallyALeftLinkedList() {
        BinaryNode<String> root = new BinaryNode<>("C");
        BinaryNode<String> a = new BinaryNode<>("C#");
        BinaryNode<String> b = new BinaryNode<>("D");
        BinaryNode<String> c = new BinaryNode<>("D#");
        BinaryNode<String> d = new BinaryNode<>("E");
        BinaryNode<String> e = new BinaryNode<>("F");
        BinaryNode<String> f = new BinaryNode<>("F#");
        BinaryNode<String> g = new BinaryNode<>("G");
        BinaryNode<String> h = new BinaryNode<>("G#");
        BinaryNode<String> i = new BinaryNode<>("A");
        BinaryNode<String> j = new BinaryNode<>("A#");
        BinaryNode<String> k = new BinaryNode<>("B");
        BinaryNode<String> l = new BinaryNode<>("C");

        root.setLeft(a);
        a.setLeft(b);
        b.setLeft(c);
        c.setLeft(d);
        d.setLeft(e);
        e.setLeft(f);
        f.setLeft(g);
        g.setLeft(h);
        h.setLeft(i);
        i.setLeft(j);
        j.setLeft(k);
        k.setLeft(l);
        
        assertFalse("The asymmetric tree was identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }
    
    @Test (timeout = TIMEOUT)
    public void practicallyARightLinkedList() {
        BinaryNode<String> root = new BinaryNode<>("C");
        BinaryNode<String> a = new BinaryNode<>("C#");
        BinaryNode<String> b = new BinaryNode<>("D");
        BinaryNode<String> c = new BinaryNode<>("D#");
        BinaryNode<String> d = new BinaryNode<>("E");
        BinaryNode<String> e = new BinaryNode<>("F");
        BinaryNode<String> f = new BinaryNode<>("F#");
        BinaryNode<String> g = new BinaryNode<>("G");
        BinaryNode<String> h = new BinaryNode<>("G#");
        BinaryNode<String> i = new BinaryNode<>("A");
        BinaryNode<String> j = new BinaryNode<>("A#");
        BinaryNode<String> k = new BinaryNode<>("B");
        BinaryNode<String> l = new BinaryNode<>("C");

        root.setRight(a);
        a.setRight(b);
        b.setRight(c);
        c.setRight(d);
        d.setRight(e);
        e.setRight(f);
        f.setRight(g);
        g.setRight(h);
        h.setRight(i);
        i.setRight(j);
        j.setRight(k);
        k.setRight(l);
        
        assertFalse("The asymmetric tree was identified as symmetric",
                ConceptApplication.isSymmetric(root));
        
    }
    
    @Test (timeout = TIMEOUT)
    public void blatantAsymmetryTestR() {
        BinaryNode<String> root = new BinaryNode<>("C");
        BinaryNode<String> right = new BinaryNode<>("C++");
        root.setRight(right);
        
        assertFalse("The asymmetric tree was identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }
    
    @Test (timeout = TIMEOUT)
    public void rightShapeWrongData() {
        BinaryNode<String> root = new BinaryNode<>("Ha");
        BinaryNode<String> a1 = new BinaryNode<>("He");
        BinaryNode<String> a2 = new BinaryNode<>("Hee");
        root.setLeft(a1);
        root.setRight(a2);
        
        assertFalse("The asymmetric tree was identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }
    
    @Test (timeout = TIMEOUT)
    public void sixLevelTreeTrue() {
        String emptyString = ""; //this is just testing for shape
        BinaryNode<String> root = new BinaryNode<>(emptyString);
        BinaryNode<String> a1 = new BinaryNode<>(emptyString);
        BinaryNode<String> a2 = new BinaryNode<>(emptyString);
        BinaryNode<String> b1 = new BinaryNode<>(emptyString);
        BinaryNode<String> b2 = new BinaryNode<>(emptyString);
        BinaryNode<String> b3 = new BinaryNode<>(emptyString);
        BinaryNode<String> b4 = new BinaryNode<>(emptyString);
        BinaryNode<String> c1 = new BinaryNode<>(emptyString);
        BinaryNode<String> c2 = new BinaryNode<>(emptyString);
        BinaryNode<String> c3 = new BinaryNode<>(emptyString);
        BinaryNode<String> c4 = new BinaryNode<>(emptyString);
        BinaryNode<String> d1 = new BinaryNode<>(emptyString);
        BinaryNode<String> d2 = new BinaryNode<>(emptyString);
        BinaryNode<String> e1 = new BinaryNode<>(emptyString);
        BinaryNode<String> e2 = new BinaryNode<>(emptyString);

        root.setLeft(a1);
        root.setRight(a2);
        a1.setLeft(b1);
        a1.setRight(b2);
        a2.setLeft(b3);
        a2.setRight(b4);
        b1.setLeft(c1);
        b1.setRight(c2);
        b4.setLeft(c3);
        b4.setRight(c4);
        c2.setRight(d1);
        c3.setLeft(d2);
        d1.setLeft(e1);
        d2.setRight(e2);
        
        assertTrue("The symmetric tree was not identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }
    
    @Test (timeout = TIMEOUT)
    public void sixLevelTreeFalse() {
        String emptyString = ""; //this is just testing for shape
        BinaryNode<String> root = new BinaryNode<>(emptyString);
        BinaryNode<String> a1 = new BinaryNode<>(emptyString);
        BinaryNode<String> a2 = new BinaryNode<>(emptyString);
        BinaryNode<String> b1 = new BinaryNode<>(emptyString);
        BinaryNode<String> b2 = new BinaryNode<>(emptyString);
        BinaryNode<String> b3 = new BinaryNode<>(emptyString);
        BinaryNode<String> b4 = new BinaryNode<>(emptyString);
        BinaryNode<String> c1 = new BinaryNode<>(emptyString);
        BinaryNode<String> c2 = new BinaryNode<>(emptyString);
        BinaryNode<String> c3 = new BinaryNode<>(emptyString);
        BinaryNode<String> c4 = new BinaryNode<>(emptyString);
        BinaryNode<String> d1 = new BinaryNode<>(emptyString);
        BinaryNode<String> d2 = new BinaryNode<>(emptyString);
        BinaryNode<String> e1 = new BinaryNode<>(emptyString);
        BinaryNode<String> e2 = new BinaryNode<>(emptyString);

        root.setLeft(a1);
        root.setRight(a2);
        a1.setLeft(b1);
        a1.setRight(b2);
        a2.setLeft(b3);
        a2.setRight(b4);
        b1.setLeft(c1);
        b1.setRight(c2);
        b4.setLeft(c3);
        b4.setRight(c4);
        c2.setLeft(d1);
        c3.setLeft(d2);
        d1.setLeft(e1);
        d2.setRight(e2);
        
        assertFalse("This asymmetric tree was identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }
    
    @Test (timeout = TIMEOUT)
    public void saltboxRoof() {
        BinaryNode<String> root = new BinaryNode<>("C");
        BinaryNode<String> a1 = new BinaryNode<>("g");
        BinaryNode<String> a2 = new BinaryNode<>("g");
        BinaryNode<String> b1 = new BinaryNode<>("e");
        BinaryNode<String> b2 = new BinaryNode<>("e");
        BinaryNode<String> c1 = new BinaryNode<>("c");
        
        root.setLeft(a1);
        root.setRight(a2);
        a1.setLeft(b1);
        a2.setRight(b2);
        b1.setLeft(c1);
        
        assertFalse("This asymmetric tree was identified as symmetric",
                ConceptApplication.isSymmetric(root));
    }
    
    @Test (timeout = TIMEOUT)
    public void symmetricRoof() {
        BinaryNode<String> root = new BinaryNode<>("C");
        BinaryNode<String> a1 = new BinaryNode<>("g");
        BinaryNode<String> a2 = new BinaryNode<>("g");
        BinaryNode<String> b1 = new BinaryNode<>("e");
        BinaryNode<String> b2 = new BinaryNode<>("e");
        BinaryNode<String> c1 = new BinaryNode<>("c");
        BinaryNode<String> c2 = new BinaryNode<>("c");
        
        root.setLeft(a1);
        root.setRight(a2);
        a1.setLeft(b1);
        a2.setRight(b2);
        b1.setLeft(c1);
        b2.setRight(c2);
        
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
    
    @Test (timeout = TIMEOUT)
    public void kGreaterThanArrLen() {
        Comparable[] arr = new Integer[] {10, 0, 3, 35, 20, 6, 2, 40};
        Comparable[] expected = new Integer[] {0, 2, 3, 6, 10, 20, 35, 40};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 9);

        assertArrayEquals("All the elements were not correctly"
                        + " found or sorted", expected, actual);
    }
    
    @Test (timeout = TIMEOUT)
    public void kEqualsZero() {
        Comparable[] arr = new Integer[] {10, 0, 3, 35, 20, 6, 2, 40};
        Comparable[] expected = new Integer[] {};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 0);

        assertArrayEquals("This was supposed to return "
                        + "an empty array", expected, actual);
    }
    
    @Test (timeout = TIMEOUT)
    public void kLessThanZero() {
        Comparable[] arr = new Integer[] {10, 0, 3, 35, 20, 6, 2, 40};
        Comparable[] expected = new Integer[] {};

        Comparable[] actual = ConceptApplication.findKLargest(arr, -10);

        assertArrayEquals("This was supposed to return "
                        + "an empty array", expected, actual);
    }
    
    @Test (timeout = TIMEOUT)
    public void allDuplicatesOneOddball() {
        Comparable[] arr = new Integer[] {10, 10, 10, 10, 10, 10, 10, 10, 9};
        Comparable[] expected = new Integer[] {10, 10, 10, 10, 10};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 5);

        assertArrayEquals("All the elements were not correctly"
                        + " found or sorted", expected, actual);
    }
    
    @Test (timeout = TIMEOUT)
    public void emptyArray() {
        Comparable[] arr = new Integer[] {};
        Comparable[] expected = new Integer[] {};

        Comparable[] actual = ConceptApplication.findKLargest(arr, 5);

        assertArrayEquals("This was supposed to return "
                        + "an empty array", expected, actual);
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
    public void testEmptyStringExample() {
        String str = "";
        assertTrue(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void test1CharExample() {
        String str = "(";
        assertFalse(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testOverFlow() {
        String str = "{{}";
        assertFalse(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void birbs() {
        String str = "(ºvº) <(・) ({^v^})";
        assertTrue(ConceptApplication.matchingBrackets(str));
    }
    
    @Test (timeout = TIMEOUT)
    public void birbsRightClosureWrongTime() {
        String str = "(ºvº) <(・) ({^v^)}";
        assertFalse(ConceptApplication.matchingBrackets(str));
    }

    @Test (timeout = TIMEOUT)
    public void testMatchingBracketsFalse() {
        String str = "{([( ))}";
        assertFalse(ConceptApplication.matchingBrackets(str));
    }
}