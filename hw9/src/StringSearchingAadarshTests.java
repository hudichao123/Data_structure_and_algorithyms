import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * String searching student tests.
 *
 * @author Aadarsh Padiyath and the CS1332 TAs
 * @version 1.0
 */
public class StringSearchingAadarshTests {
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

    private static final int TIMEOUT = 200;

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
    public void testKMPExceptions() {
        int count = 0;
        try {
            StringSearching.kmp(null, kmpText, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.kmp("", kmpText, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.kmp(kmpPattern, null, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.kmp(kmpPattern, kmpText, null);
        } catch (IllegalArgumentException e) {
            count++;
        }
        assertEquals("You are missing an exception", 4, count);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableExceptions() {
        int count = 0;
        try {
            StringSearching.buildFailureTable(null, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.buildFailureTable(kmpPattern, null);
        } catch (IllegalArgumentException e) {
            count++;
        }
        assertEquals("You are missing an exception", 2, count);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableLengthZero() {
        int[] failureTable = StringSearching
                .buildFailureTable("", comparator);
        int[] expected = new int[0];
        assertArrayEquals(expected, failureTable);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 0.", comparator.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableDiffThanFirstCharacter() {
        int[] failureTable = StringSearching
                .buildFailureTable("CHHHHhhhhhHHHHHhh", comparator);
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, failureTable);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 16.", comparator.getCount() == 16);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableSameCharacters() {
        int[] failureTable = StringSearching
                .buildFailureTable("FFFFFFFFFFFFFFF", comparator);
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        assertArrayEquals(expected, failureTable);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 16.", comparator.getCount() == 14);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableExampleFromClass() {
        int[] failureTable = StringSearching
                .buildFailureTable("babaababab", comparator);
        int[] expected = {0, 0, 1, 2, 0, 1, 2, 3, 4, 3};
        assertArrayEquals(expected, failureTable);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 11.", comparator.getCount() == 11);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableFromPDF() {
        int[] failureTable = StringSearching
                .buildFailureTable("abacab", comparator);
        int[] expected = {0, 0, 1, 0, 1, 2};
        assertArrayEquals(expected, failureTable);
        int[] failureTable1 = StringSearching
                .buildFailureTable("ababac", comparator);
        int[] expected1 = {0, 0, 1, 2, 3, 0};
        assertArrayEquals(expected1, failureTable1);
        int[] failureTable2 = StringSearching
                .buildFailureTable("abaababa", comparator);
        int[] expected2 = {0, 0, 1, 1, 2, 3, 2, 3};
        assertArrayEquals(expected2, failureTable2);
        int[] failureTable3 = StringSearching
                .buildFailureTable("aaaaaa", comparator);
        int[] expected3 = {0, 1, 2, 3, 4, 5};
        assertArrayEquals(expected3, failureTable3);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableDiffButNotFirstCharacter() {
        int[] failureTable = StringSearching
                .buildFailureTable("senselessnesses", comparator);
        int[] expected = {0, 0, 0, 1, 2, 0, 0, 1, 1, 0, 0, 1, 1, 2, 1};
        assertArrayEquals(failureTable, expected);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 19.", comparator.getCount() == 19);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPTextLengthSmallerThanPattern() {
        comparator = new CharacterComparator();
        String newkmpPattern = "Idiot Hookers";
        String newkmpText = "Potatoe";
        assertEquals(emptyList,
                StringSearching.kmp(newkmpPattern, newkmpText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 0.", comparator.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPEmptyText() {
        String newkmpPattern = "Idiot Hookers";
        String newkmpText = "";
        assertEquals(emptyList,
                StringSearching.kmp(newkmpPattern, newkmpText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 0.", comparator.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPOneCharacterThere() {
        List<Integer> newkmpAnswer = new ArrayList<>();
        newkmpAnswer.add(0);
        String newkmpPattern = "a";
        String newkmpText = "a";
        assertEquals(newkmpAnswer,
                StringSearching.kmp(newkmpPattern, newkmpText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 1.", comparator.getCount() == 1);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPOneCharacterNotThere() {
        List<Integer> newkmpAnswer = new ArrayList<>();
        String newkmpPattern = "a";
        String newkmpText = "b";
        assertEquals(newkmpAnswer,
                StringSearching.kmp(newkmpPattern, newkmpText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 1.", comparator.getCount() == 1);
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
    public void testKMPRepeated() {
        List<Integer> newkmpAnswer = new ArrayList<>();
        newkmpAnswer.add(0);
        newkmpAnswer.add(1);
        newkmpAnswer.add(2);
        String newkmpPattern = "aaa";
        String newkmpText = "aaaaa";
        assertEquals(newkmpAnswer,
                StringSearching.kmp(newkmpPattern, newkmpText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 7.", comparator.getCount() == 7);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPAlmostRepeated() {
        List<Integer> newkmpAnswer = new ArrayList<>();
        String newkmpPattern = "aaabaaaaabaa";
        String newkmpText = "aaabaaaabaaabaaaaaaa";
        assertEquals(newkmpAnswer,
                StringSearching.kmp(newkmpPattern, newkmpText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 29.", comparator.getCount() == 29);
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
    public void testBuildLastTableLengthZero() {
        Map<Character, Integer> lastTable = StringSearching
                .buildLastTable("");
        Map<Character, Integer> expectedLastTable = new HashMap<>();
        assertEquals(expectedLastTable, lastTable);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildLastTableAllDiff() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Map<Character, Integer> lastTable = StringSearching
                .buildLastTable(alphabet);
        Map<Character, Integer> expectedLastTable = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            expectedLastTable.put(alphabet.charAt(i), i);
        }
        assertEquals(expectedLastTable, lastTable);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildLastTableAllSame() {
        String pattern = "AAAAAAAAA";
        Map<Character, Integer> lastTable = StringSearching
                .buildLastTable(pattern);
        Map<Character, Integer> expectedLastTable = new HashMap<>();
        expectedLastTable.put('A', 8);
        assertEquals(expectedLastTable, lastTable);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildLastTableDiffCharacters() {
        String pattern = "AaAaAaAa";
        Map<Character, Integer> lastTable = StringSearching
                .buildLastTable(pattern);
        Map<Character, Integer> expectedLastTable = new HashMap<>();
        expectedLastTable.put('A', 6);
        expectedLastTable.put('a', 7);
        assertEquals(expectedLastTable, lastTable);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildLastTableGetNull() {
        String pattern = "ABC";
        Map<Character, Integer> lastTable = StringSearching
                .buildLastTable(pattern);
        Map<Character, Integer> expectedLastTable = new HashMap<>();
        expectedLastTable.put('A', 0);
        expectedLastTable.put('B', 1);
        expectedLastTable.put('C', 2);
        assertEquals(expectedLastTable, lastTable);
        assertNull(lastTable.get('b'));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreExceptions() {
        int count = 0;
        try {
            StringSearching.boyerMoore(null, sellText, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.boyerMoore("", sellText, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.boyerMoore(sell, null, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.boyerMoore(sell, sellText, null);
        } catch (IllegalArgumentException e) {
            count++;
        }
        assertEquals("You are missing an exception", 4, count);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildLastTableExceptions() {
        int count = 0;
        try {
            StringSearching.buildLastTable(null);
        } catch (IllegalArgumentException e){
            count++;
        }
        assertEquals("You are missing an exception", 1, count);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreTextSmallerThanPattern() {
        comparator = new CharacterComparator();
        String newPattern = "Idiot Hookers";
        String newText = "Potatoe";
        assertEquals(emptyList,
                StringSearching.boyerMoore(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 0.", comparator.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreEmptyText() {
        String newPattern = "Idiot Hookers";
        String newText = "";
        assertEquals(emptyList,
                StringSearching.boyerMoore(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 0.", comparator.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreOneCharacterThere() {
        List<Integer> newAnswer = new ArrayList<>();
        newAnswer.add(0);
        String newPattern = "a";
        String newText = "a";
        assertEquals(newAnswer,
                StringSearching.boyerMoore(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 1.", comparator.getCount() == 1);
    }
    @Test
    public void testKMPThere2() {
        List<Integer> newAnswer = new ArrayList<>();
        newAnswer.add(0);
        String newPattern = "bcabbca";
        String newText = "abcbcabbacbcabbca";
                StringSearching.kmp(newPattern, newText, comparator);
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 15.", comparator.getCount() == 15);
    }
    @Test(timeout = TIMEOUT)
    public void testBoyerMooreOneCharacterNotThere() {
        List<Integer> newAnswer = new ArrayList<>();
        String newPattern = "a";
        String newText = "b";
        assertEquals(newAnswer,
                StringSearching.boyerMoore(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 1.", comparator.getCount() == 1);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreRepeated() {
        List<Integer> newAnswer = new ArrayList<>();
        newAnswer.add(0);
        newAnswer.add(1);
        newAnswer.add(2);
        String newPattern = "aaa";
        String newText = "aaaaa";
        assertEquals(newAnswer,
                StringSearching.boyerMoore(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 9.", comparator.getCount() == 9);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreAlmostRepeated() {
        List<Integer> newAnswer = new ArrayList<>();
        String newPattern = "aaabaaaaabaa";
        String newText = "aaabaaaabaaabaaaaaaa";
        assertEquals(newAnswer,
                StringSearching.boyerMoore(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 26.", comparator.getCount() == 26);
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
    public void testRabinKarpExceptions() {
        int count = 0;
        try {
            StringSearching.rabinKarp(null, sellText, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.rabinKarp("", sellText, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.rabinKarp(sell, null, comparator);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.rabinKarp(sell, sellText, null);
        } catch (IllegalArgumentException e) {
            count++;
        }
        assertEquals("You are missing an exception", 4, count);
    }

    @Test(timeout = TIMEOUT)
    public void testGenerateHashExceptions() {
        int count = 0;
        try {
            StringSearching.generateHash(null, sell.length());
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.generateHash("Rigatoni Mad Max", -1);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.generateHash("", 0);
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.generateHash("Rigatoni Mad Max", 420);
        } catch (IllegalArgumentException e) {
            count++;
        }
        assertEquals("You are missing an exception", 4, count);
    }

    @Test(timeout = TIMEOUT)
    public void testGenerateHash() {
        assertEquals(649540698, StringSearching.generateHash(
                "matt is my friend", 4));
    }

    @Test(timeout = TIMEOUT)
    public void testGenerateHashBunny() {
        assertEquals(584967675, StringSearching.generateHash(
                "bunny", 4));
    }

    @Test(timeout = TIMEOUT)
    public void testGenerateHashLengthOne() {
        assertEquals(97, StringSearching.generateHash(
                "a", 1));
    }

    @Test(timeout = TIMEOUT)
    public void testUpdateHashExceptions() {
        int count = 0;
        try {
            StringSearching.updateHash(420, 0, 'M', 'K');
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            StringSearching.updateHash(69, -666, 'M', 'K');
        } catch (IllegalArgumentException e) {
            count++;
        }
        assertEquals("You are missing an exception", 2, count);
    }

    @Test(timeout = TIMEOUT)
    public void testUpdateHash() {
        assertEquals(-809062424, StringSearching
                .updateHash(99342732, 5, 'a', 'q'));
    }

    @Test(timeout = TIMEOUT)
    public void testUpdateHashBunny() {
        assertEquals(697403438, StringSearching
                .updateHash(584967675, 4, 'b', 'y'));
    }

    @Test(timeout = TIMEOUT)
    public void testUpdateHashLengthOne() {
        assertEquals(98, StringSearching
                .updateHash(97, 1, 'a', 'b'));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpOneCharacterThere() {
        List<Integer> newAnswer = new ArrayList<>();
        newAnswer.add(0);
        String newPattern = "a";
        String newText = "a";
        assertEquals(newAnswer,
                StringSearching.rabinKarp(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 1.", comparator.getCount() == 1);
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpOneCharacterNotThere() {
        List<Integer> newAnswer = new ArrayList<>();
        String newPattern = "a";
        String newText = "b";
        assertEquals(newAnswer,
                StringSearching.rabinKarp(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 0.", comparator.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpRepeated() {
        List<Integer> newAnswer = new ArrayList<>();
        newAnswer.add(0);
        newAnswer.add(1);
        newAnswer.add(2);
        String newPattern = "aaa";
        String newText = "aaaaa";
        assertEquals(newAnswer,
                StringSearching.rabinKarp(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 9.", comparator.getCount() == 9);
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpAlmostRepeated() {
        List<Integer> newAnswer = new ArrayList<>();
        String newPattern = "aaabaaaaabaa";
        String newText = "aaabaaaabaaabaaaaaaa";
        assertEquals(newAnswer,
                StringSearching.rabinKarp(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 0.", comparator.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpSameHash() {
        List<Integer> newAnswer = new ArrayList<>();
        char[] pattern = {181, 181};
        char[] text = {182, 0};
        String newPattern = String.copyValueOf(pattern);
        String newText = String.copyValueOf(text);
        assertEquals(newAnswer,
                StringSearching.rabinKarp(newPattern, newText, comparator));
        assertTrue("Comparison count was " + comparator.getCount()
                + ". Should be 1.", comparator.getCount() == 1);
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