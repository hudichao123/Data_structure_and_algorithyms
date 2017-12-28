import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * AVL tests.
 * @author Alexander Fache
 * @version 1.0
 */
public class AVLTests {

    private static final int TIMEOUT = 200;
    private AVLInterface<Integer> avlTree;
    private Integer[] dataArray1 = {10, 6, 7, 4, 12, 5, 1, 13, 11, 15, 17, 19, 22, 24, 14};
    private Integer[] dataArray2 = {20, 5, 7, 10, 14, 17, 18, 19, 3, 4, 1, 2, 6, 13, 23};

    //I'm using levelOrder to check the elements in the tree so make sure you have this method working.

    @Before
    public void setup() {
        avlTree = new AVL<>();
    }

    //---------- Constructor ----------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException() {
        avlTree = new AVL<>(null);
    }

    @Test(timeout = TIMEOUT)
    public void testConstructor() {
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray1));
        avlTree = new AVL<>(dataColl);

        Integer[] comparisonArray = {7, 5, 15, 4, 6, 12, 19, 1, 10, 13, 17, 22, 11, 14, 24};
        List<Integer> comparisonList = new LinkedList<>(Arrays.asList(comparisonArray));

        assertEquals(comparisonList, avlTree.levelorder());
    }

    //---------- Add ----------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddIllegalArgumentException() {
        avlTree.add(null);
    }

    @Test(timeout = TIMEOUT)
    public void testAddLeftRotation() {
        avlTree.add(5);
        avlTree.add(6);
        avlTree.add(7);

        assertEquals(3, avlTree.size());

        AVLNode<Integer> root = avlTree.getRoot();
        assertEquals((Integer) 6, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());

        assertEquals((Integer) 5, root.getLeft().getData());
        assertEquals(0, root.getLeft().getHeight());
        assertEquals(0, root.getLeft().getBalanceFactor());

        assertEquals((Integer) 7, root.getRight().getData());
        assertEquals(0, root.getRight().getHeight());
        assertEquals(0, root.getRight().getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testAddRightRotation() {
        avlTree.add(7);
        avlTree.add(6);
        avlTree.add(5);

        assertEquals(3, avlTree.size());

        AVLNode<Integer> root = avlTree.getRoot();
        assertEquals((Integer) 6, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());

        assertEquals((Integer) 5, root.getLeft().getData());
        assertEquals(0, root.getLeft().getHeight());
        assertEquals(0, root.getLeft().getBalanceFactor());

        assertEquals((Integer) 7, root.getRight().getData());
        assertEquals(0, root.getRight().getHeight());
        assertEquals(0, root.getRight().getBalanceFactor());

    }

    @Test(timeout = TIMEOUT)
    public void testAddLeftRightRotation() {
        avlTree.add(7);
        avlTree.add(5);
        avlTree.add(6);

        assertEquals(3, avlTree.size());

        AVLNode<Integer> root = avlTree.getRoot();
        assertEquals((Integer) 6, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());

        assertEquals((Integer) 5, root.getLeft().getData());
        assertEquals(0, root.getLeft().getHeight());
        assertEquals(0, root.getLeft().getBalanceFactor());

        assertEquals((Integer) 7, root.getRight().getData());
        assertEquals(0, root.getRight().getHeight());
        assertEquals(0, root.getRight().getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testAddRightLeftRotation() {
        avlTree.add(5);
        avlTree.add(7);
        avlTree.add(6);

        assertEquals(3, avlTree.size());

        AVLNode<Integer> root = avlTree.getRoot();
        assertEquals((Integer) 6, root.getData());
        assertEquals(1, root.getHeight());
        assertEquals(0, root.getBalanceFactor());

        assertEquals((Integer) 5, root.getLeft().getData());
        assertEquals(0, root.getLeft().getHeight());
        assertEquals(0, root.getLeft().getBalanceFactor());

        assertEquals((Integer) 7, root.getRight().getData());
        assertEquals(0, root.getRight().getHeight());
        assertEquals(0, root.getRight().getBalanceFactor());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        assertEquals(0, avlTree.size());

        //reference: dataArray2 = {20, 5, 7, 10, 14, 17, 18, 19, 3, 4, 1, 2, 6, 13, 23};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray2));
        avlTree = new AVL<>(dataColl);

        Integer[] comparisonArr1 = {14, 4, 18, 2, 7, 17, 20, 1, 3, 5, 10, 19, 23, 6, 13};
        List<Integer> comparisonList = new LinkedList<>(Arrays.asList(comparisonArr1));
        assertEquals(15, avlTree.size());
        assertEquals(comparisonList, avlTree.levelorder());

        //add duplicate
        avlTree.add(14);
        Integer[] comparisonArr2 = {14, 4, 18, 2, 7, 17, 20, 1, 3, 5, 10, 19, 23, 6, 13};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr2));
        assertEquals(15, avlTree.size());
        assertEquals(comparisonList, avlTree.levelorder());

        //add duplicate
        avlTree.add(4);
        Integer[] comparisonArr3 = {14, 4, 18, 2, 7, 17, 20, 1, 3, 5, 10, 19, 23, 6, 13};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr3));
        assertEquals(15, avlTree.size());
        assertEquals(comparisonList, avlTree.levelorder());

        //add
        avlTree.add(11);
        Integer[] comparisonArr4 = {14, 4, 18, 2, 7, 17, 20, 1, 3, 5, 11, 19, 23, 6, 10, 13};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr4));
        assertEquals(16, avlTree.size());
        assertEquals(comparisonList, avlTree.levelorder());

        //add
        avlTree.add(25);
        Integer[] comparisonArr5 = {14, 4, 20, 2, 7, 18, 23, 1, 3, 5, 11, 17, 19, 25, 6, 10, 13};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr5));
        assertEquals(17, avlTree.size());
        assertEquals(comparisonList, avlTree.levelorder());

        avlTree.add(15);
        Integer[] comparisonArr6 = {14, 4, 20, 2, 7, 18, 23, 1, 3, 5, 11, 17, 19, 25, 6, 10, 13, 15};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr6));
        assertEquals(18, avlTree.size());
        assertEquals(comparisonList, avlTree.levelorder());
    }

    //---------- Remove ----------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveIllegalArgumentException() {
        avlTree.remove(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementException() {
        //reference: dataArray1 = {10, 6, 7, 4, 12, 5, 1, 13, 11, 15, 17, 19, 22, 24, 14};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray1));
        avlTree = new AVL<>(dataColl);

        avlTree.remove(8);
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        assertEquals(0, avlTree.size());

        //reference: dataArray1 = {10, 6, 7, 4, 12, 5, 1, 13, 11, 15, 17, 19, 22, 24, 14};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray1));
        avlTree = new AVL<>(dataColl);

        Integer[] comparisonArr1 = {7, 5, 15, 4, 6, 12, 19, 1, 10, 13, 17, 22, 11, 14, 24};
        List<Integer> comparisonList = new LinkedList<>(Arrays.asList(comparisonArr1));
        assertEquals(15, avlTree.size());
        assertEquals(comparisonList, avlTree.levelorder());

        //Remove node with 0 children
        assertEquals((Integer) 11, avlTree.remove(11));
        assertEquals(14, avlTree.size());
        Integer[] comparisonArr2 = {7, 5, 15, 4, 6, 12, 19, 1, 10, 13, 17, 22, 14, 24};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr2));
        assertEquals(comparisonList, avlTree.levelorder());

        //Remove node with 0 children
        assertEquals((Integer) 24, avlTree.remove(24));
        assertEquals(13, avlTree.size());
        Integer[] comparisonArr3 = {7, 5, 15, 4, 6, 12, 19, 1, 10, 13, 17, 22, 14};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr3));
        assertEquals(comparisonList, avlTree.levelorder());

        //Remove node with 1 child
        assertEquals((Integer) 13, avlTree.remove(13));
        assertEquals(12, avlTree.size());
        Integer[] comparisonArr4 = {7, 5, 15, 4, 6, 12, 19, 1, 10, 14, 17, 22};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr4));
        assertEquals(comparisonList, avlTree.levelorder());

        //Remove node with 1 child
        assertEquals((Integer) 4, avlTree.remove(4));
        assertEquals(11, avlTree.size());
        Integer[] comparisonArr5 = {7, 5, 15, 1, 6, 12, 19, 10, 14, 17, 22};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr5));
        assertEquals(comparisonList, avlTree.levelorder());

        //Remove node with 2 children
        assertEquals((Integer) 7, avlTree.remove(7));
        assertEquals(10, avlTree.size());
        Integer[] comparisonArr6 = {6, 5, 15, 1, 12, 19, 10, 14, 17, 22};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr6));
        assertEquals(comparisonList, avlTree.levelorder());

        //Remove node with 2 children
        assertEquals((Integer) 19, avlTree.remove(19));
        assertEquals(9, avlTree.size());
        Integer[] comparisonArr7 = {6, 5, 15, 1, 12, 17, 10, 14, 22};
        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr7));
        assertEquals(comparisonList, avlTree.levelorder());
    }

    //---------- Get ----------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGetIllegalArgumentException() {
        avlTree.get(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetNoSuchElementException() {
        //reference: dataArray2 = {20, 5, 7, 10, 14, 17, 18, 19, 3, 4, 1, 2, 6, 13, 23};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray2));
        avlTree = new AVL<>(dataColl);
        avlTree.get(15);
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        //reference: dataArray2 = {20, 5, 7, 10, 14, 17, 18, 19, 3, 4, 1, 2, 6, 13, 23};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray2));
        avlTree = new AVL<>(dataColl);

        assertEquals((Integer) 13, avlTree.get(13));
        assertEquals((Integer) 1, avlTree.get(1));
        assertEquals((Integer) 20, avlTree.get(20));
        assertEquals((Integer) 7, avlTree.get(7));
    }

    //---------- Contains ----------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testContainsIllegalArgumentException() {
        //reference: dataArray2 = {20, 5, 7, 10, 14, 17, 18, 19, 3, 4, 1, 2, 6, 13, 23};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray2));
        avlTree = new AVL<>(dataColl);
        avlTree.contains(null);
    }

    @Test(timeout = TIMEOUT)
    public void testContains() {
        //reference: dataArray2 = {20, 5, 7, 10, 14, 17, 18, 19, 3, 4, 1, 2, 6, 13, 23};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray2));
        avlTree = new AVL<>(dataColl);

        assertTrue(avlTree.contains(5));
        assertTrue(avlTree.contains(20));
        assertTrue(avlTree.contains(18));
        assertTrue(avlTree.contains(13));
        assertFalse(avlTree.contains(0));
        assertFalse(avlTree.contains(21));
        assertFalse(avlTree.contains(12));
        assertFalse(avlTree.contains(9));
    }

    //---------- Clear ----------

    @Test(timeout = TIMEOUT)
    public void testClear() {
        //reference: dataArray2 = {20, 5, 7, 10, 14, 17, 18, 19, 3, 4, 1, 2, 6, 13, 23};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray2));
        avlTree = new AVL<>(dataColl);

        avlTree.clear();

        assertEquals(0, avlTree.size());
        assertEquals(null, avlTree.getRoot());
    }

    //---------- Height ----------

    @Test(timeout = TIMEOUT)
    public void testHeight() {
        //reference: dataArray1 = {10, 6, 7, 4, 12, 5, 1, 13, 11, 15, 17, 19, 22, 24, 14};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(dataArray1));
        avlTree = new AVL<>(dataColl);

        assertEquals(4, avlTree.height());

        //reference: dataArray2 = {20, 5, 7, 10, 14, 17, 18, 19, 3, 4, 1, 2, 6, 13, 23};
        dataColl = new ArrayList<>(Arrays.asList(dataArray2));
        avlTree = new AVL<>(dataColl);

        assertEquals(4, avlTree.height());
    }

}