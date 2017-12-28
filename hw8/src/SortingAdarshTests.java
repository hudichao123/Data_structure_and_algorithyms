import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * If you aren't watching RuPaul's Drag Race what are you even doing hunty?
 * https://www.youtube.com/watch?v=CmK3ghfsSVM
 *
 * @author Aadarsh "Alcoholique" Padiyath
 * @version 6.9
 */
public class SortingAdarshTests {
    private Shangela[] sugaDaddie;
    private Shangela[] throwsDrink;
    private ComparatorPlus<Shangela> comp;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        sugaDaddie = new Shangela[10];
        sugaDaddie[0] = new Shangela("I DON'T HAVE A SUGAR DADDY.", 0);
        sugaDaddie[1] = new Shangela("I'VE NEVER HAD A SUGAR DADDY", 1);
        sugaDaddie[2] = new Shangela("IF I WANTED A SUGAR DADDY, "
                + "YES I PROBABLY COULD GO OUT AND GET ONE,", 2);
        sugaDaddie[3] = new Shangela("BECAUSE I AM WHAT?", 3);
        sugaDaddie[4] = new Shangela("SICKENING!", 4);
        sugaDaddie[5] = new Shangela("YOU COULD NEVER HAVE A SUGAR DADDY", 5);
        sugaDaddie[6] = new Shangela("BECAUSE YOU ARE "
                + "NOT. THAT. KIND. OF. GIRL.", 6);
        sugaDaddie[7] = new Shangela("BABY, EVERYTHING I HAVE, "
                + "I'VE WORKED FOR AND GOTTEN MYSELF.", 7);
        sugaDaddie[8] = new Shangela("I HAVE BUILT MYSELF "
                + "FROM THE GROUND UP,", 8);
        sugaDaddie[9] = new Shangela("YOU F*CKING B*TCH!", 9);

        comp = Shangela.getOrderComparator();
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailOneElement() {
        throwsDrink = new Shangela[1];
        throwsDrink[0] = sugaDaddie[9];
        Sorting.cocktailSort(throwsDrink, comp);
        assertEquals(sugaDaddie[9], throwsDrink[0]);
        assertTrue("Number of comparisons: " + comp.getCount(), comp.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailSortReversed() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[9];
        throwsDrink[1] = sugaDaddie[8];
        throwsDrink[2] = sugaDaddie[7];
        throwsDrink[3] = sugaDaddie[6];
        throwsDrink[4] = sugaDaddie[5];
        throwsDrink[5] = sugaDaddie[4];
        throwsDrink[6] = sugaDaddie[3];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[1];
        throwsDrink[9] = sugaDaddie[0];
        Sorting.cocktailSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailZero() {
        throwsDrink = new Shangela[0];
        sugaDaddie = new Shangela[0];
        Sorting.cocktailSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 0);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailPreSorted() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[2];
        throwsDrink[3] = sugaDaddie[3];
        throwsDrink[4] = sugaDaddie[4];
        throwsDrink[5] = sugaDaddie[5];
        throwsDrink[6] = sugaDaddie[6];
        throwsDrink[7] = sugaDaddie[7];
        throwsDrink[8] = sugaDaddie[8];
        throwsDrink[9] = sugaDaddie[9];
        Sorting.cocktailSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() == 9);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailAlmostSorted() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[2];
        throwsDrink[3] = sugaDaddie[5];
        throwsDrink[4] = sugaDaddie[4];
        throwsDrink[5] = sugaDaddie[3];
        throwsDrink[6] = sugaDaddie[6];
        throwsDrink[7] = sugaDaddie[7];
        throwsDrink[8] = sugaDaddie[8];
        throwsDrink[9] = sugaDaddie[9];
        Sorting.cocktailSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 13);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailSortOddNumberOfElements() {
        throwsDrink = new Shangela[9];
        Shangela[] sickening = new Shangela[9];
        sickening[0] = sugaDaddie[0];
        sickening[1] = sugaDaddie[1];
        sickening[2] = sugaDaddie[2];
        sickening[3] = sugaDaddie[3];
        sickening[4] = sugaDaddie[4];
        sickening[5] = sugaDaddie[5];
        sickening[6] = sugaDaddie[6];
        sickening[7] = sugaDaddie[7];
        sickening[8] = sugaDaddie[8];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[4];
        throwsDrink[3] = sugaDaddie[5];
        throwsDrink[4] = sugaDaddie[6];
        throwsDrink[5] = sugaDaddie[8];
        throwsDrink[6] = sugaDaddie[7];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[3];
        Sorting.cocktailSort(throwsDrink, comp);
        assertArrayEquals(sickening, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 24);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailStability() {
        throwsDrink = new Shangela[4];
        throwsDrink[0] = sugaDaddie[3];
        throwsDrink[1] = sugaDaddie[4];
        throwsDrink[2] = new Shangela("Haleloo", 4);
        throwsDrink[3] = sugaDaddie[5];
        Sorting.cocktailSort(throwsDrink, comp);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() == 3);
        assertEquals(throwsDrink[1].getName(), "SICKENING!");
        assertEquals(throwsDrink[2].getName(), "Haleloo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCocktailArrException() {
        Sorting.cocktailSort(null, comp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCocktailCompException() {
        Sorting.cocktailSort(sugaDaddie, null);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSortReversed() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[9];
        throwsDrink[1] = sugaDaddie[8];
        throwsDrink[2] = sugaDaddie[7];
        throwsDrink[3] = sugaDaddie[6];
        throwsDrink[4] = sugaDaddie[5];
        throwsDrink[5] = sugaDaddie[4];
        throwsDrink[6] = sugaDaddie[3];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[1];
        throwsDrink[9] = sugaDaddie[0];
        Sorting.insertionSort(throwsDrink, comp);
        assertArrayEquals(throwsDrink, sugaDaddie);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionPreSorted() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[2];
        throwsDrink[3] = sugaDaddie[3];
        throwsDrink[4] = sugaDaddie[4];
        throwsDrink[5] = sugaDaddie[5];
        throwsDrink[6] = sugaDaddie[6];
        throwsDrink[7] = sugaDaddie[7];
        throwsDrink[8] = sugaDaddie[8];
        throwsDrink[9] = sugaDaddie[9];
        Sorting.insertionSort(throwsDrink, comp);
        assertArrayEquals(throwsDrink, sugaDaddie);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 9 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSortOddNumberOfElements() {
        throwsDrink = new Shangela[9];
        Shangela[] sickening = new Shangela[9];
        sickening[0] = sugaDaddie[0];
        sickening[1] = sugaDaddie[1];
        sickening[2] = sugaDaddie[2];
        sickening[3] = sugaDaddie[3];
        sickening[4] = sugaDaddie[4];
        sickening[5] = sugaDaddie[5];
        sickening[6] = sugaDaddie[6];
        sickening[7] = sugaDaddie[7];
        sickening[8] = sugaDaddie[8];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[4];
        throwsDrink[3] = sugaDaddie[5];
        throwsDrink[4] = sugaDaddie[6];
        throwsDrink[5] = sugaDaddie[8];
        throwsDrink[6] = sugaDaddie[7];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[3];
        Sorting.insertionSort(throwsDrink, comp);
        assertArrayEquals(sickening, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 19);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionZero() {
        throwsDrink = new Shangela[0];
        sugaDaddie = new Shangela[0];
        Sorting.insertionSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionStability() {
        throwsDrink = new Shangela[4];
        throwsDrink[0] = sugaDaddie[3];
        throwsDrink[1] = sugaDaddie[4];
        throwsDrink[2] = sugaDaddie[5];
        throwsDrink[3] = new Shangela("Haleloo", 4);
        Sorting.insertionSort(throwsDrink, comp);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 4);
        assertEquals(throwsDrink[1].getName(), "SICKENING!");
        assertEquals(throwsDrink[2].getName(), "Haleloo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertionArrException() {
        Sorting.insertionSort(null, comp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertionCompException() {
        Sorting.insertionSort(sugaDaddie, null);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionOneElement() {
        throwsDrink = new Shangela[1];
        throwsDrink[0] = sugaDaddie[9];
        Sorting.insertionSort(throwsDrink, comp);
        assertEquals(sugaDaddie[9], throwsDrink[0]);
        assertTrue("Number of comparisons: " + comp.getCount(), comp.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickSortReversed() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[9];
        throwsDrink[1] = sugaDaddie[8];
        throwsDrink[2] = sugaDaddie[7];
        throwsDrink[3] = sugaDaddie[6];
        throwsDrink[4] = sugaDaddie[5];
        throwsDrink[5] = sugaDaddie[4];
        throwsDrink[6] = sugaDaddie[3];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[1];
        throwsDrink[9] = sugaDaddie[0];
        Sorting.quickSort(throwsDrink, comp, new Random(0x600dc0de));
        assertArrayEquals(throwsDrink, sugaDaddie);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 24 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickPreSorted() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[2];
        throwsDrink[3] = sugaDaddie[3];
        throwsDrink[4] = sugaDaddie[4];
        throwsDrink[5] = sugaDaddie[5];
        throwsDrink[6] = sugaDaddie[6];
        throwsDrink[7] = sugaDaddie[7];
        throwsDrink[8] = sugaDaddie[8];
        throwsDrink[9] = sugaDaddie[9];
        Sorting.quickSort(throwsDrink, comp, new Random(0x600dc0de));
        assertArrayEquals(throwsDrink, sugaDaddie);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 24 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickSortOddNumberOfElements() {
        throwsDrink = new Shangela[9];
        Shangela[] sickening = new Shangela[9];
        sickening[0] = sugaDaddie[0];
        sickening[1] = sugaDaddie[1];
        sickening[2] = sugaDaddie[2];
        sickening[3] = sugaDaddie[3];
        sickening[4] = sugaDaddie[4];
        sickening[5] = sugaDaddie[5];
        sickening[6] = sugaDaddie[6];
        sickening[7] = sugaDaddie[7];
        sickening[8] = sugaDaddie[8];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[4];
        throwsDrink[3] = sugaDaddie[5];
        throwsDrink[4] = sugaDaddie[6];
        throwsDrink[5] = sugaDaddie[8];
        throwsDrink[6] = sugaDaddie[7];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[3];
        Sorting.quickSort(throwsDrink, comp, new Random(0xdeadbeef));
        assertArrayEquals(sickening, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 20);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickZero() {
        throwsDrink = new Shangela[0];
        sugaDaddie = new Shangela[0];
        Sorting.quickSort(throwsDrink, comp, new Random(0x69696969));
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuickArrException() {
        Sorting.quickSort(null, comp, new Random(0x600dc0de));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuickCompException() {
        Sorting.quickSort(sugaDaddie, null, new Random(0x600dc0de));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuickRandException() {
        Sorting.quickSort(sugaDaddie, comp, null);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickSortOneElement() {
        throwsDrink = new Shangela[1];
        throwsDrink[0] = sugaDaddie[9];
        Sorting.quickSort(throwsDrink, comp, new Random(0x600dc0de));
        assertEquals(sugaDaddie[9], throwsDrink[0]);
        assertTrue("Number of comparisons: " + comp.getCount(), comp.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionSortReversed() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[9];
        throwsDrink[1] = sugaDaddie[8];
        throwsDrink[2] = sugaDaddie[7];
        throwsDrink[3] = sugaDaddie[6];
        throwsDrink[4] = sugaDaddie[5];
        throwsDrink[5] = sugaDaddie[4];
        throwsDrink[6] = sugaDaddie[3];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[1];
        throwsDrink[9] = sugaDaddie[0];
        Sorting.selectionSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionPreSorted() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[2];
        throwsDrink[3] = sugaDaddie[3];
        throwsDrink[4] = sugaDaddie[4];
        throwsDrink[5] = sugaDaddie[5];
        throwsDrink[6] = sugaDaddie[6];
        throwsDrink[7] = sugaDaddie[7];
        throwsDrink[8] = sugaDaddie[8];
        throwsDrink[9] = sugaDaddie[9];
        Sorting.selectionSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionSortOddNumberOfElements() {
        throwsDrink = new Shangela[9];
        Shangela[] sickening = new Shangela[9];
        sickening[0] = sugaDaddie[0];
        sickening[1] = sugaDaddie[1];
        sickening[2] = sugaDaddie[2];
        sickening[3] = sugaDaddie[3];
        sickening[4] = sugaDaddie[4];
        sickening[5] = sugaDaddie[5];
        sickening[6] = sugaDaddie[6];
        sickening[7] = sugaDaddie[7];
        sickening[8] = sugaDaddie[8];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[4];
        throwsDrink[3] = sugaDaddie[5];
        throwsDrink[4] = sugaDaddie[6];
        throwsDrink[5] = sugaDaddie[8];
        throwsDrink[6] = sugaDaddie[7];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[3];
        Sorting.selectionSort(throwsDrink, comp);
        assertArrayEquals(sickening, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 36);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionZero() {
        throwsDrink = new Shangela[0];
        sugaDaddie = new Shangela[0];
        Sorting.selectionSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectionArrException() {
        Sorting.selectionSort(null, comp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectionCompException() {
        Sorting.selectionSort(sugaDaddie, null);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionOneElement() {
        throwsDrink = new Shangela[1];
        throwsDrink[0] = sugaDaddie[9];
        Sorting.selectionSort(throwsDrink, comp);
        assertEquals(sugaDaddie[9], throwsDrink[0]);
        assertTrue("Number of comparisons: " + comp.getCount(), comp.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeSortReversed() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[9];
        throwsDrink[1] = sugaDaddie[8];
        throwsDrink[2] = sugaDaddie[7];
        throwsDrink[3] = sugaDaddie[6];
        throwsDrink[4] = sugaDaddie[5];
        throwsDrink[5] = sugaDaddie[4];
        throwsDrink[6] = sugaDaddie[3];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[1];
        throwsDrink[9] = sugaDaddie[0];
        Sorting.mergeSort(throwsDrink, comp);
        assertArrayEquals(throwsDrink, sugaDaddie);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 19 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergePreSorted() {
        throwsDrink = new Shangela[10];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[2];
        throwsDrink[3] = sugaDaddie[3];
        throwsDrink[4] = sugaDaddie[4];
        throwsDrink[5] = sugaDaddie[5];
        throwsDrink[6] = sugaDaddie[6];
        throwsDrink[7] = sugaDaddie[7];
        throwsDrink[8] = sugaDaddie[8];
        throwsDrink[9] = sugaDaddie[9];
        Sorting.mergeSort(throwsDrink, comp);
        assertArrayEquals(throwsDrink, sugaDaddie);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 19 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeSortOddNumberOfElements() {
        throwsDrink = new Shangela[9];
        Shangela[] sickening = new Shangela[9];
        sickening[0] = sugaDaddie[0];
        sickening[1] = sugaDaddie[1];
        sickening[2] = sugaDaddie[2];
        sickening[3] = sugaDaddie[3];
        sickening[4] = sugaDaddie[4];
        sickening[5] = sugaDaddie[5];
        sickening[6] = sugaDaddie[6];
        sickening[7] = sugaDaddie[7];
        sickening[8] = sugaDaddie[8];
        throwsDrink[0] = sugaDaddie[0];
        throwsDrink[1] = sugaDaddie[1];
        throwsDrink[2] = sugaDaddie[4];
        throwsDrink[3] = sugaDaddie[5];
        throwsDrink[4] = sugaDaddie[6];
        throwsDrink[5] = sugaDaddie[8];
        throwsDrink[6] = sugaDaddie[7];
        throwsDrink[7] = sugaDaddie[2];
        throwsDrink[8] = sugaDaddie[3];
        Sorting.mergeSort(throwsDrink, comp);
        assertArrayEquals(sickening, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 18);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeZero() {
        throwsDrink = new Shangela[0];
        sugaDaddie = new Shangela[0];
        Sorting.mergeSort(throwsDrink, comp);
        assertArrayEquals(sugaDaddie, throwsDrink);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergeArrException() {
        Sorting.mergeSort(null, comp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergeCompException() {
        Sorting.mergeSort(sugaDaddie, null);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeOneElement() {
        throwsDrink = new Shangela[1];
        throwsDrink[0] = sugaDaddie[9];
        Sorting.mergeSort(throwsDrink, comp);
        assertEquals(sugaDaddie[9], throwsDrink[0]);
        assertTrue("Number of comparisons: " + comp.getCount(), comp.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testLsdRadixSort() {
        int[] unsortedArray = new int[] {69, 69, 420, 69, 69, 69};
        int[] sortedArray = new int[] {69, 69, 69, 69, 69, 420};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test(timeout = TIMEOUT)
    public void testLsdRadixSortNegative() {
        int[] unsortedArray = new int[] {-3, 2, -1, 0, 1, -2};
        int[] sortedArray = new int[] {-3, -2, -1, 0, 1, 2};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test(timeout = TIMEOUT)
    public void testLsdRadixSortAllNegativeAndZeroes() {
        int[] unsortedArray = new int[] {-100, -200, -1000, -20};
        int[] sortedArray = new int[] {-1000, -200, -100, -20};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test(timeout = TIMEOUT)
    public void testRadixOneElement() {
        int[] unsortedArray = new int[] {1};
        int[] sortedArray = new int[] {1};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
        assertTrue("Number of comparisons: " + comp.getCount(), comp.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testRadixZero() {
        int[] unsortedArray = new int[] {};
        int[] sortedArray = new int[] {};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
        assertTrue("Number of comparisons: " + comp.getCount(), comp.getCount() == 0);
    }

    @Test(timeout = TIMEOUT)
    public void testLsdRadixStabilitySort() {
        Integer hehe = new Integer(69);
        Integer haha = hehe;
        int[] unsortedArray = new int[] {69, hehe};
        int[] sortedArray = new int[] {hehe, 69};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRadixArrException() {
        Sorting.lsdRadixSort(null);
    }

    /**
     * Class for testing proper sorting.
     */
    private static class Shangela {
        private String name;
        private Integer order;

        /**
         * Create a teaching assistant.
         *
         * @param name name of TA
         * @param order order of Shangela's monologue
         */
        Shangela(String name, Integer order) {
            this.name = name;
            this.order = order;
        }

        /**
         * Get the order of shangela's speech
         *
         * @return number regarding order
         */
        Integer getOrder() {
            return order;
        }

        /**
         * Getter for name
         * @return name
         */
        String getName() {
            return name;
        }

        @Override
        public String toString() {
            return order.toString();
        }

        /**
         * Create a comparator that compares the names of the teaching
         * assistants.
         *
         * @return comparator that compares the names of the teaching assistants
         */
        static ComparatorPlus<Shangela> getOrderComparator() {
            return new ComparatorPlus<Shangela>() {
                @Override
                public int compare(Shangela dq1,
                                   Shangela dq2) {
                    incrementCount();
                    return dq1.getOrder().compareTo(dq2.getOrder());
                }
            };
        }
    }

    /**
     * Inner class that allows counting how many comparisons were made.
     */
    private abstract static class ComparatorPlus<T> implements Comparator<T> {
        private int count;

        /**
         * Get the number of comparisons made.
         * @return number of comparisons made
         */
        int getCount() {
            return count;
        }

        /**
         * Increment the number of comparisons made by one. Call this method in
         * your compare() implementation.
         */
        void incrementCount() {
            count++;
        }
    }
}