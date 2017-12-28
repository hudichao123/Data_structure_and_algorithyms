import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Student tests for sorting algorithms.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class SortingStudentTests {
    private TeachingAssistant[] tas;
    private TeachingAssistant[] tasByName;
    private ComparatorPlus<TeachingAssistant> comp;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        tas = new TeachingAssistant[10];
        tas[0] = new TeachingAssistant("Alok");
        tas[1] = new TeachingAssistant("Chad");
        tas[2] = new TeachingAssistant("Grayson");
        tas[3] = new TeachingAssistant("Neil");
        tas[4] = new TeachingAssistant("Ashley");
        tas[5] = new TeachingAssistant("Scott");
        tas[6] = new TeachingAssistant("Tim");
        tas[7] = new TeachingAssistant("Jackie");
        tas[8] = new TeachingAssistant("Raymond");
        tas[9] = new TeachingAssistant("Bartosz");
        tasByName = new TeachingAssistant[10];
        tasByName[0] = tas[0];
        tasByName[1] = tas[4];
        tasByName[2] = tas[9];
        tasByName[3] = tas[1];
        tasByName[4] = tas[2];
        tasByName[5] = tas[7];
        tasByName[6] = tas[3];
        tasByName[7] = tas[8];
        tasByName[8] = tas[5];
        tasByName[9] = tas[6];

        comp = TeachingAssistant.getNameComparator();
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailSort() {
        Sorting.cocktailSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 35 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSort() {
        Sorting.insertionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 30 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickSort() {
        Sorting.quickSort(tas, comp, new Random(0x600dc0de));
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeSort() {
        Sorting.mergeSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 48 && comp.getCount() != 0);
    }
    @Test(timeout = TIMEOUT)
    public void testSelectionSort() {
        Sorting.selectionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 60 && comp.getCount() != 0);
    }
    @Test(timeout = TIMEOUT)
    public void testLsdRadixSort() {
        int[] unsortedArray = new int[] {54, 28, 58, 84, 20, 122, 85, 3};
        int[] sortedArray = new int[] {3, 20, 28, 54, 58, 84, 85, 122};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    /**
     * Class for testing proper sorting.
     */
    private static class TeachingAssistant {
        private String name;

        /**
         * Create a teaching assistant.
         *
         * @param name name of TA
         */
        public TeachingAssistant(String name) {
            this.name = name;
        }

        /**
         * Get the name of the teaching assistant.
         *
         * @return name of teaching assistant
         */
        public String getName() {
            return name;
        }

        /**
         * Set the name of the teaching assistant.
         *
         * @param name name of the teaching assistant
         */
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name: " + name;
        }

        /**
         * Create a comparator that compares the names of the teaching
         * assistants.
         *
         * @return comparator that compares the names of the teaching assistants
         */
        public static ComparatorPlus<TeachingAssistant> getNameComparator() {
            return new ComparatorPlus<TeachingAssistant>() {
                @Override
                public int compare(TeachingAssistant ta1,
                        TeachingAssistant ta2) {
                    incrementCount();
                    return ta1.getName().compareTo(ta2.getName());
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
        public int getCount() {
            return count;
        }

        /**
         * Increment the number of comparisons made by one. Call this method in
         * your compare() implementation.
         */
        public void incrementCount() {
            count++;
        }
    }
}
