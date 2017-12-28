import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

/**
 * This is a basic set of unit tests for Recursion. Passing these does
 * NOT guarantee any grade on this assignment. This is only a sanity check to
 * help you get started on the homework and writing JUnits in general.
 *
 * @author The 1332 TAs
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecursionStudentTests {
    public static final int TIMEOUT = 200;

    @Test(timeout = TIMEOUT)
    public void testPalindromeIsPalindrome() {
        assertTrue(Recursion.isPalindrome("abcdcba"));
    }

    @Test(timeout = TIMEOUT)
    public void testPalindromeIsNotPalindrome() {
        assertFalse(Recursion.isPalindrome("abcdefg"));
    }

    @Test(timeout = TIMEOUT)
    public void testGCDDifferentValues() {
        assertEquals(7, Recursion.gcd(21, 14));
    }

    @Test(timeout = TIMEOUT)
    public void testGCDSameValues() {
        assertEquals(6, Recursion.gcd(6, 6));
    }

    @Test(timeout = TIMEOUT)
    public void testGCDZeroValue() {
        assertEquals(19, Recursion.gcd(19, 0));
    }
}
