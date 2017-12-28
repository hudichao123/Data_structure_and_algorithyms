import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Your implementation of a binary search tree.
 *
 * @author Dichao Hu
 * @userid dhu64
 * @GTID 903253306
 * @version 1.0
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no-argument constructor that should initialize an empty BST.
     * DO NOT IMPLEMENT THIS CONSTRUCTOR!
     */
    public BST() {
    }

    /**
     * Initializes the BST with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public BST(Collection<T> data) {
        this();
        for  (T element : data) {
            add(element);
        }
    }

    /**
     * Add the data as a leaf in the BST.  Should traverse the tree to find the
     * appropriate location.
     * @throws IllegalArgumentException if the data is null
     * @param data the data to be added
     */
    @Override
    public void add(T data) {
        addData(root, data);
    }

    /**
     *  Add the data as a leaf in the BST.
     * @param n the node to be inspected
     * @param data The data to be added
     */
    private void addData(BSTNode<T> n, T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data"
                    + "can not be null");
        }
        if (size() == 0) {
            root = new BSTNode<T>(data);
            root.setLeft(null);
            root.setRight(null);
            size++;
        } else {
            if (data.compareTo(n.getData()) == 0) {
                return;
            } else if (data.compareTo(n.getData()) < 0) {
                if (hasLeft(n)) {
                    BSTNode<T> leftOfN = n.getLeft();
                    addData(leftOfN, data);
                } else {
                    n.setLeft(new BSTNode<T>(data));
                    size++;
                }
            } else {
                if (hasRight(n)) {
                    BSTNode<T> rightOfN = n.getRight();
                    addData(rightOfN, data);
                } else {
                    n.setRight(new BSTNode<T>(data));
                    size++;
                }
            }
        }
    }

    /**
     * Removes the data from the tree.
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to remove from the tree.
     * @return the data removed from the tree.  Do not return the same data
     * that was passed in.  Return the data that was stored in the tree.
     */
    @Override
    public T remove(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data"
                    + "can not be null");
        }
        if (!contains(data)) {
            throw new java.util.NoSuchElementException("Element"
                    + "not found");
        }
        if (root.getData() != data) {
            if (size == 1) {
                size--;
                BSTNode<T> n = root;
                root = null;
                return data;
            } else {
                BSTNode<T> toBeRemoved = locate(root, data);
                BSTNode<T> parentOfRemoved = findParent(root, data);
                if (isExternal(toBeRemoved)) {
                    if (isLeftChild(parentOfRemoved, toBeRemoved)) {

                        parentOfRemoved.setLeft(null);
                        size--;

                    } else {
                        parentOfRemoved.setRight(null);
                        size--;
                    }
                } else if (numChildren(toBeRemoved) == 1) {
                    if (isLeftChild(parentOfRemoved, toBeRemoved)) {
                        if (toBeRemoved.getLeft() != null) {
                            parentOfRemoved.setLeft(toBeRemoved.getLeft());
                        } else {
                            parentOfRemoved.setLeft(toBeRemoved.getRight());
                        }

                    } else {
                        if (toBeRemoved.getLeft() != null) {
                            parentOfRemoved.setRight(toBeRemoved.getLeft());
                        } else {
                            parentOfRemoved.setRight(toBeRemoved.getRight());
                        }

                    }
                    size--;
                } else {
                    BSTNode<T> n1 = toBeRemoved.getLeft();
                    BSTNode<T> n2 = locatePredecessor(n1);
                    T temp = n2.getData();
                    remove(temp);
                    toBeRemoved.setData(temp);
                }
            }
            return data;
        } else {
            if (size == 1) {
                size--;
                BSTNode<T> n = root;
                root = null;
                return data;
            } else if (numChildren(root) == 1) {
                if (root.getRight() == null) {
                    root = root.getLeft();
                } else {
                    root = root.getRight();
                }
                size--;
            } else {
                BSTNode<T> n1 = root.getLeft();
                BSTNode<T> n2 = locatePredecessor(n1);
                T temp = n2.getData();
                remove(temp);
                root.setData(temp);
            }
        }
        return data;
    }

    /**
     *  Determine whether the given node is a left child of its parent
     * @param parent the parent of the child
     * @param child the child to be inspected
     * @return a boolean
     */
    private boolean isLeftChild(BSTNode<T> parent, BSTNode<T> child) {
        if (numChildren(parent) == 2) {
            return parent.getLeft().getData().compareTo(child.getData()) == 0;
        } else if (numChildren(parent) == 1) {
            return parent.getRight() == null;
        } else {
            return false;
        }
    }

    /**
     *  Determine whether the node is external
     * @param n the node to be inspected
     * @return a boolean
     */
    private boolean isExternal(BSTNode<T> n) {
        return (n.getLeft() == null) && (n.getRight() == null);
    }

    private BSTNode<T> locate(BSTNode<T> n, T data) {
        if (data.compareTo(n.getData()) == 0) {
            return n;
        } else if (data.compareTo(n.getData()) < 0) {
            return locate(n.getLeft(), data);
        } else {
            return locate(n.getRight(), data);
        }
    }

    /**
     *  find the parent of a given node
     * @param n the node to be inspected
     * @param data the data to be passed
     * @return the parent of n
     */
    private BSTNode<T> findParent(BSTNode<T> n, T data) {
        if (n == null) {
            return null;
        }
        if ((n.getData().compareTo(data) > 0)) {
            if (n.getLeft().getData().compareTo(data) == 0) {
                return n;
            } else {
                return findParent(n.getLeft(), data);
            }
        } else if (n.getData().compareTo(data)  < 0) {
            if (n.getRight().getData().compareTo(data) == 0) {
                return n;
            } else {
                return findParent(n.getRight(), data);
            }
        }
        return null;
    }

    /**
     *  find the number of the children of the node
     * @param n the node to be inspected
     * @return an int that represents the number of children
     */
    private int numChildren(BSTNode<T> n) {
        int sum = 0;
        if (hasLeft(n)) {
            sum++;
        }
        if (hasRight(n)) {
            sum++;
        }
        return sum;
    }

    /**
     *  locate the predecessor of a node
     * @param n the node to be inspected
     * @return the predecessor of the node
     */
    private BSTNode<T> locatePredecessor(BSTNode<T> n) {
        if (n.getRight() == null) {
            return n;
        } else {
            return locatePredecessor(n.getRight());
        }
    }

    /**
     * Returns the data in the tree matching the parameter passed in
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to search for in the tree.
     * @return the data in the tree equal to the parameter. Do not return the
     * same data that was passed in.  Return the data that was stored in the
     * tree.
     */
    @Override
    public T get(T data) {
        return getData(root, data);
    }

    /**
     * Returns the data in the tree matching the parameter passed in
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to search for in the tree.
     * @param n the node to be inspected
     * @return the data in the tree equal to the parameter. Do not return the
     * same data that was passed in.  Return the data that was stored in the
     * tree.
     */
    private T getData(BSTNode<T> n, T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data"
                    + "can not be null");
        }
        if (!contains(data)) {
            throw new java.util.NoSuchElementException("Element"
                    + "not found");
        } else {
            if (data.compareTo(n.getData()) == 0) {
                return n.getData();
            } else if (data.compareTo(n.getData()) < 0) {
                if (hasLeft(n)) {
                    BSTNode<T> leftOfN = n.getLeft();
                    return getData(leftOfN, data);
                }
            } else {
                if (hasRight(n)) {
                    BSTNode<T> rightOfN = n.getRight();
                    return getData(rightOfN, data);
                }
            }
        }
        return null;
    }

    /**
     * Returns whether or not data equivalent to the given parameter
     * is contained within the tree.
     * @throws IllegalArgumentException if the data is null
     * @param data the data to search for in the tree.
     * @return whether or not the parameter is contained within the tree.
     */
    @Override
    public boolean contains(T data) {
        return containsData(root, data);
    }

    /**
     * Returns whether or not data equivalent to the given parameter
     * is contained within the tree.
     * @throws IllegalArgumentException if the data is null
     * @param data the data to search for in the tree.
     * @param n the node to be inspected
     * @return whether or not the parameter is contained within the tree.
     */
    private boolean containsData(BSTNode<T> n, T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data"
                    + "can not be null");
        }
        if (size == 0) {
            return false;
        } else {
            if (data.compareTo(n.getData()) == 0) {
                return true;
            } else if (data.compareTo(n.getData()) < 0) {
                if (hasLeft(n)) {
                    BSTNode<T> leftOfN = n.getLeft();
                    return containsData(leftOfN, data);
                } else {
                    return false;
                }
            } else {
                if (hasRight(n)) {
                    BSTNode<T> rightOfN = n.getRight();
                    return containsData(rightOfN, data);
                } else {
                    return false;
                }
            }
        }
    }

    /**
     *  the size of BST
     * @return the size
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD
        return size;
    }

    /**
     * a preorder traversal of the tree
     * @return a preorder traversal of the tree
     */
    @Override
    public List<T> preorder() {
        ArrayList<T> l = new ArrayList<>();
        if (size == 0) {
            return l;
        }
        doPreOrder(root, l);
        return l;
    }

    /**
     * a preorder traversal of the tree
     * @param n the node to be inspected
     * @param l the list to return
     */
    private void doPreOrder(BSTNode<T> n, List<T> l) {
        l.add(n.getData());
        if (hasLeft(n)) {
            doPreOrder(n.getLeft(), l);
        }
        if (hasRight(n)) {
            doPreOrder(n.getRight(), l);
        }
    }

    /**
     * a postorder traversal of the tree
     * @return a postorder traversal of the tree
     */
    @Override
    public List<T> postorder() {

        ArrayList<T> l = new ArrayList<>();
        if (size == 0) {
            return l;
        }
        doPostOrder(root, l);
        return l;
    }

    public List<T> preorder2() {
        List<T> l = new ArrayList<>();
        preorder2(root, l);
        return l;
    }

    public void preorder2(BSTNode<T> n, List<T> l) {
        if (n == null) {
            return;
        }
        preorder2(n.getLeft(), l);
        l.add(n.getData());
        preorder2(n.getRight(),l);
    }
    /**
     * a postorder traversal of the tree
     * @param n the node to be inspected
     * @param l the list to return
     */
    private void doPostOrder(BSTNode<T> n, List<T> l) {
        if (hasLeft(n)) {
            doPostOrder(n.getLeft(), l);
        }
        if (hasRight(n)) {
            doPostOrder(n.getRight(), l);
        }
        l.add(n.getData());
    }

    /**
     * a inorder traversal of the tree
     * @return a inorder traversal of the tree
     */
    @Override
    public List<T> inorder() {
        ArrayList<T> l = new ArrayList<>();
        if (size == 0) {
            return l;
        }
        doInOrder(root, l);
        return l;
    }

    /**
     * a inorder traversal of the tree
     * @param n the node to be inspected
     * @param l the list to return
     */
    private void doInOrder(BSTNode<T> n, List<T> l) {
        if (hasLeft(n)) {
            doInOrder(n.getLeft(), l);
        }
        l.add(n.getData());
        if (hasRight(n)) {
            doInOrder(n.getRight(), l);
        }

    }

    /**
     * a levelorder traversal of the tree
     * @return a levelorder traversal of the tree
     */
    @Override
    public List<T> levelorder() {
        ArrayList<T> l = new ArrayList<>();
        Queue<BSTNode<T>> q = new ArrayDeque<>();
        if (size == 0) {
            return l;
        }
        q.add(root);
        while (!q.isEmpty()) {
            BSTNode<T> n = q.remove();
            l.add(n.getData());
            for (BSTNode<T> e: children(n)) {
                q.add(e);
            }
        }
        return l;
    }

    /**
     * a levelorder traversal of the tree
     * @param n the node to be inspected
     * @return the list to return
     */
    private List<BSTNode<T>> children(BSTNode<T> n) {
        ArrayList<BSTNode<T>> l = new ArrayList<>();
        if (hasLeft(n)) {
            l.add(n.getLeft());
        }
        if (hasRight(n)) {
            l.add(n.getRight());
        }
        return l;
    }

    /**
     * Creates a list of all leaf nodes present in the tree in
     * descending order.
     * @return a list of all leaf nodes in descending order
     */
    @Override
    public List<T> listLeavesDescending() {
        ArrayList<T> l = new ArrayList<>();
        if (size == 0) {
            return l;
        }
        doListLeavesDescending(root, l);
        return l;
    }

    /**
     * Creates a list of all leaf nodes present in the tree in
     * descending order.
     * @param n the node to be inspected
     * @param l the list to return
     */
    private void doListLeavesDescending(BSTNode<T> n, List<T> l) {
        if (hasRight(n)) {
            doListLeavesDescending(n.getRight(), l);
        }
        if (hasLeft(n)) {
            doListLeavesDescending(n.getLeft(), l);
        }
        if (isExternal(n)) {
            l.add(n.getData());
        }
    }

    /**
     * Clear the tree.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Calculate and return the height of the root of the tree.  A node's
     * height is defined as {@code max(left.height, right.height) + 1}.
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    @Override
    public int height() {
        return height(root);
    }

    /**
     * Calculate and return the height of the root of the tree.  A node's
     * height is defined as {@code max(left.height, right.height) + 1}.
     * @param n the node to be inspected
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    private int height(BSTNode<T> n) {
        if (n == null) {
            return -1;
        } else if (isExternal(n)) {
            return 0;
        } else {
            if (height(n.getLeft()) > height(n.getRight())) {
                return 1 + height(n.getLeft());
            } else {
                return 1 + height(n.getRight());
            }
        }
    }

    /**
     *  get the root of the BST
     * @return root
     */
    @Override
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     *  Determine whether the node has a left child
     * @param n the node to be inspected
     * @return a boolean
     */
    private boolean hasLeft(BSTNode<T> n) {
        return n.getLeft() != null;
    }

    /**
     *  Determine whether the node has a right child
     * @param n the node to be inspected
     * @return a boolean
     */
    private boolean hasRight(BSTNode<T> n) {
        return n.getRight() != null;
    }

    public static void main(String[] args) {
        BST<Integer> b = new BST<>();
        b.add(2);
        b.add(4);
        b.add(6);
        b.add(1);
        b.add(0);
        ArrayList<Integer> l = (ArrayList)b.preorder2();
        for (Integer i : l) {
            System.out.println(i);
        }
    }
}



