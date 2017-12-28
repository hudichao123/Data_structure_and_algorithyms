import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * String searching student tests.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class StringSearchingStudentTests {
    private List<Integer> sellAnswer;
    private List<Integer> emptyList;
    private String sell;
    private String sellNotThere;
    private String sellText;

    private List<Integer> kmpAnswer;
    private String kmpPattern;
    private String kmpText;
    private String kmpNotThere;

    private CharacterComparator comparator;

    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        sell = "sell";
        sellNotThere = "sea lions trains cardinal boardwalk";
        sellText = "She sells seashells by the seashore.";

        sellAnswer = new ArrayList<>();
        sellAnswer.add(4);

        emptyList = new ArrayList<>();

        kmpPattern = "ababa";
        kmpText = "ababaaababa";
        kmpNotThere = "ababbaba";

        kmpAnswer = new ArrayList<>();
        kmpAnswer.add(0);
        kmpAnswer.add(6);

        comparator = new CharacterComparator();
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTable() {
        int[] failureTable = StringSearching
                .buildFailureTable(kmpPattern, comparator);
        int[] expected = {0, 0, 1, 2, 3};
        assertArrayEquals(expected, failureTable);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 4.", comparator.getCount() == 4);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPThere() {
        assertEquals(kmpAnswer,
                StringSearching.kmp(kmpPattern, kmpText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 18.", comparator.getCount() == 18);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPNotThere() {
        assertEquals(emptyList,
                StringSearching.kmp(kmpPattern, kmpNotThere, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 10.", comparator.getCount() == 10);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildLastTable() {
        Map<Character, Integer> lastTable = StringSearching
            .buildLastTable(sell);
        Map<Character, Integer> expectedLastTable = new HashMap<>();
        expectedLastTable.put('s', 0);
        expectedLastTable.put('e', 1);
        expectedLastTable.put('l', 3);
        assertEquals(expectedLastTable, lastTable);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreThere() {
        assertEquals(sellAnswer,
                StringSearching.boyerMoore(sell, sellText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 20.", comparator.getCount() == 20);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreNotThere() {
        assertEquals(emptyList,
                StringSearching.boyerMoore(sell, sellNotThere, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 9.", comparator.getCount() == 9);
    }

    @Test(timeout = TIMEOUT)
    public void testGenerateHash() {
        assertEquals(649540698, StringSearching.generateHash(
                    "matt is my friend", 4));
    }

    @Test(timeout = TIMEOUT)
    public void testUpdateHash() {
        assertEquals(-809062424, StringSearching
                .updateHash(99342732, 5, 'a', 'q'));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpThere() {
        assertEquals(sellAnswer,
                StringSearching.rabinKarp(sell, sellText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 4.", comparator.getCount() == 4);
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpNotThere() {
        assertEquals(emptyList,
                StringSearching.rabinKarp(sell, sellNotThere, comparator));
        assertEquals(0, comparator.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreLongerText() {
        assertEquals(emptyList,
                StringSearching.boyerMoore(sellNotThere, sell, comparator));
        assertEquals(0, comparator.getCount());
    }
}
