import java.util.Comparator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Dichao Hu
 * @userid dhu64 (i.e. gburdell3)
 * @GTID 903253306 (i.e. 900000000)
 * @version 1.0
 */
public class Sorting {

    /**
     * Implement cocktail sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable).
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void cocktailSort(T[] arr,
                                        Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("array"
                    + "or comparator can not be null");
        }
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        boolean sorted = false;
        while (leftIndex < rightIndex && !sorted) {
            sorted = true;
            int tempRightIndex = rightIndex;
            int tempLeftIndex = leftIndex;
            for (int i = leftIndex; i < rightIndex; i++) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                    tempRightIndex = i;
                }

            }
            rightIndex = tempRightIndex;
            if (!sorted) {
                sorted = true;
                for (int i = rightIndex; i > leftIndex; i--) {
                    if (comparator.compare(arr[i], arr[i - 1]) < 0) {
                        T temp = arr[i];
                        arr[i] = arr[i - 1];
                        arr[i - 1] = temp;
                        sorted = false;
                        tempLeftIndex = i;
                    }

                }
                leftIndex = tempLeftIndex;
            }
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable).
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void insertionSort(T[] arr,
                                         Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("array"
                    + "or comparator can not be null");
        }
        int startIndex = 1;
        if (arr.length == 1) {
            return;
        } else {
            while (startIndex < arr.length) {
                T element = arr[startIndex];
                int i = startIndex;
                while (i > 0 && comparator.compare(arr[i - 1], arr[i]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    i--;
                }
                startIndex++;
            }
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n^2)
     *
     * Note that there may be duplicates in the array, but they may not
     * necessarily stay in the same relative order.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void selectionSort(T[] arr,
                                         Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("array"
                    + "or comparator can not be null");
        }
        int endIndex = arr.length - 1;
        while (endIndex > 0) {
            int maxIndex = 0;
            T max = arr[0];
            for (int i = 1; i <= endIndex; i++) {
                if (comparator.compare(arr[i], arr[maxIndex]) > 0) {
                    maxIndex = i;
                    max = arr[i];
                }
            }
            T temp = arr[endIndex];
            arr[endIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
            endIndex--;
        }
    }

    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots.
     * For example if you need a pivot between a (inclusive)
     * and b (exclusive) where b > a, use the following code:
     *
     * int pivotIndex = r.nextInt(b - a) + a;
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * Note that there may be duplicates in the array.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not use the one we have taught you!
     *
     * @throws IllegalArgumentException if the array or comparator or rand is
     * null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                     Random rand) {
        if (arr == null || comparator == null || rand == null) {
            throw new IllegalArgumentException("array"
                    + "or comparator can not be null");
        }
        quickSort2(arr, 0,
                arr.length - 1, comparator, rand);
    }

    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots.
     * For example if you need a pivot between a (inclusive)
     * and b (exclusive) where b > a, use the following code:
     *
     * int pivotIndex = r.nextInt(b - a) + a;
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * Note that there may be duplicates in the array.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not use the one we have taught you!
     *
     * @throws IllegalArgumentException if the array or comparator or rand is
     * null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     * @param startIndex the start index
     * @param endIndex the end index
     */
    private static <T> void quickSort2(T[] arr, int startIndex, int endIndex,
                                       Comparator<T> comparator, Random rand) {
        if (startIndex > endIndex - 1) {
            return;
        }
        /* if (startIndex == endIndex - 1) {
            if (comparator.compare(arr[startIndex], arr[endIndex]) > 0) {
                T temp = arr[startIndex];
                arr[startIndex] = arr[endIndex];
                arr[endIndex] = temp;
            }
            return;
        }*/
        int pivotIndex = rand.nextInt(endIndex - startIndex + 1) + startIndex;
        T temp = arr[startIndex];
        arr[startIndex] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        int i = startIndex + 1;
        int j = endIndex;
        while (i <= j) {
            while (i <= j && comparator.compare(arr[i],
                    arr[startIndex]) < 0) {
                i++;
            }
            while (j >= i && comparator.compare(arr[j],
                    arr[startIndex]) > 0) {
                j--;
            }
            if (i <= j) {
                T temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
                i++;
                j--;
            }
        }
        temp = arr[startIndex];
        arr[startIndex] = arr[j];
        arr[j] = temp;
        quickSort2(arr, startIndex, j - 1, comparator, rand);
        quickSort2(arr, j + 1, endIndex, comparator, rand);
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(n log n)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You can create more arrays to run mergesort, but at the end,
     * everything should be merged back into the original T[]
     * which was passed in.
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("array"
                    + "or comparator can not be null");
        }
        T[] newArr = mergeSort2(arr, comparator);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(n log n)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You can create more arrays to run mergesort, but at the end,
     * everything should be merged back into the original T[]
     * which was passed in.
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     * @return the sorted array
     */
    private static  <T> T[] mergeSort2(T[] arr, Comparator<T> comparator) {
        if (arr.length <= 1) {
            return arr;
        }
        int midIndex = arr.length / 2;
        T[] newArr1 = (T[]) new Object[midIndex];
        T[] newArr2 = (T[]) new Object[arr.length - midIndex];
        for (int i = 0; i < midIndex; i++) {
            newArr1[i] = arr[i];
        }
        for (int i = 0; i < arr.length - midIndex; i++) {
            newArr2[i] = arr[i + midIndex];
        }
        newArr1 = mergeSort2(newArr1, comparator);
        newArr2 = mergeSort2(newArr2, comparator);
        arr = merge(newArr1, newArr2, comparator);
        return arr;
    }

    /**
     * merge two arrs
     * @param arr1 the first array
     * @param arr2 the second array
     * @param comparator the comparator to use
     * @param <T> data type to sort
     * @return the merged arr
     */
    private static <T> T[] merge(T[] arr1, T[] arr2, Comparator<T> comparator) {
        T[] newArr = (T[]) new Object[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (comparator.compare(arr1[i], arr2[j]) <= 0) {
                newArr[k] = arr1[i];
                i++;
            } else {
                newArr[k] = arr2[j];
                j++;
            }
            k++;
        }
        if (i >= arr1.length) {
            while (j < arr2.length) {
                newArr[k] = arr2[j];
                j++;
                k++;
            }
        } else {
            while (i < arr1.length) {
                newArr[k] = arr1[i];
                i++;
                k++;
            }
        }
        return newArr;
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(kn)
     *
     * And a best case running time of:
     *  O(kn)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable)
     *
     * Do NOT use {@code Math.pow()} in your sort.
     *
     * You may use {@code java.util.ArrayList} or {@code java.util.LinkedList}
     * if you wish, but it may only be used inside radix sort and any radix sort
     * helpers. Do NOT use these classes with other sorts.
     *
     * @throws IllegalArgumentException if the array is null
     * @param arr the array to be sorted
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("array"
                    + "can not be null");
        }
        if (arr.length == 0) {
            return;
        }
        Queue<Integer>[] qArr = new Queue[19];
        for (int i = 0; i < 19; i++) {
            qArr[i] = new LinkedBlockingQueue<>();
        }
        int count = getCount(arr);
        for (int c = 0; c < count; c++) {
            for (int index = 0; index < arr.length; index++) {
                int number = arr[index];
                int bucketIndex = getDigit(number, c) + 9;
                qArr[bucketIndex].add(number);
            }
            int indexOfArr = 0;
            int temp;
            for (int i = 0; i < 19;) {
                if (qArr[i].size() != 0) {
                    temp = qArr[i].remove();
                    arr[indexOfArr] = temp;
                    indexOfArr++;
                } else {
                    i++;
                }
            }
        }
    }

    /**
     * get the number of times to loop
     * @param arr the arr to sort
     * @return number of count
     */
    private static int getCount(int[] arr) {
        int maxIndex = 0;
        int max = Math.abs(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > max) {
                maxIndex = i;
                max = Math.abs(arr[i]);
            }
        }
        int count = 0;
        while (max != 0) {
            max = max / 10;
            count++;
        }
        return count;
    }

    /**
     * return the number of digits of a number
     * @param number the number to examine
     * @param count the number of digits
     * @return number of digits
     */
    private static int getDigit(int number, int count) {
        int remainder = 0;
        int temp = number;
        if (temp < 0) {
            number = -number;
        }
        while (count >= 0) {
            remainder = number % 10;
            number = number / 10;
            count--;
        }
        if (temp > 0) {
            return remainder;
        }
        return -remainder;
    }
}
