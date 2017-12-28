import java.util.*;

/**
 * Your implementation of an AVL Tree.
 *
 * @author YOUR NAME HERE
 * @userid YOUR USER ID HERE dhu64
 * @GTID YOUR GT ID HERE 903253306
 * @version 1.0
 */
public class AVL<T extends Comparable<? super T>> implements AVLInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private AVLNode<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty AVL tree.
     * DO NOT IMPLEMENT THIS CONSTRUCTOR!
     */
    public AVL() {
        root = null;
        size = 0;
    }

    /**
     * Initializes the AVL tree with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public AVL(Collection<T> data) {
        this();
        if (data == null) {
            throw new IllegalArgumentException("data"
                    + "can not be null");
        }
        for (T e : data) {
            add(e);
        }
    }
    private void add2(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data"
                    + "can not be null");
        }
        root = add2(root , data);
    }


    /**
     * add a node to AVL
     * @param n the node to be examined
     * @param data the data to be added
     * @return the node added
     */
    private AVLNode<T> add2(AVLNode<T> n, T data) {
        if (n == null) {
            size++;
            AVLNode<T> node =  new AVLNode<T>(data);
            node.setHeight(0);
            node.setBalanceFactor(0);
            return node;
        } else if (n.getData().compareTo(data) > 0) {
            n.setLeft(add2(n.getLeft() , data));

        } else if (n.getData().compareTo(data) < 0) {
            n.setRight(add2(n.getRight() , data));
        }
        n.setHeight(height(n));
        n.setBalanceFactor((balanceFactor(n)));
        if (n.getBalanceFactor() == -2) {
            if (n.getRight().getBalanceFactor() == -1) {
                balanceInAdd4(n.getRight().getRight());
            } else {
                balanceInAdd3(n.getRight().getLeft());
            }

        } else if (n.getBalanceFactor() == 2) {
            if (n.getLeft().getBalanceFactor() == 1) {
                balanceInAdd1(n.getLeft().getLeft());
            } else {
                balanceInAdd2(n.getLeft().getRight());
            }
        }
        n.setHeight(height(n));
        n.setBalanceFactor((balanceFactor(n)));
        return n;
    }

    /**
     * add a node to AVL
     * @param data the data to be added
     * @throws IllegalArgumentException
     */
    @Override
    public void add(T data) throws IllegalArgumentException {
        add2(data);
    }

    /**
     * balance the left heavy subtree
     * @param n the node to be balanced
     */
    private void balanceInAdd1(AVLNode<T> n) {
        AVLNode<T> p = parent(n);
        AVLNode<T> pp = parent(p);
        T temp = pp.getData();
        T dataInP = p.getData();
        AVLNode<T> a = pp.getRight();
        AVLNode<T> b = p.getRight();
        pp.setData(dataInP);
        p.setData(temp);
        pp.setLeft(n);
        pp.setRight(p);
        p.setLeft(b);
        p.setRight(a);
        n.setHeight(height(n));
        n.setBalanceFactor((balanceFactor(n)));
        p.setHeight(height(p));
        p.setBalanceFactor((balanceFactor(p)));
        pp.setHeight(height(pp));
        pp.setBalanceFactor((balanceFactor(pp)));
    }

    /**
     * balance the left heavy subtree
     * @param n the node to be balanced
     */
    private void balanceInAdd2(AVLNode<T> n) {
        AVLNode<T> p = parent(n);
        AVLNode<T> pp = parent(p);
        AVLNode<T> c = n.getLeft();
        pp.setLeft(n);
        n.setLeft(p);
        p.setRight(c);
        AVLNode<T> temp = n;
        n = p;
        p = temp;
        balanceInAdd1(n);
    }

    /**
     * balance the right heavy subtree
     * @param n the node to be balanced
     */
    private void balanceInAdd3(AVLNode<T> n) {
        AVLNode<T> p = parent(n);
        AVLNode<T> pp = parent(p);
        AVLNode<T> d = n.getRight();
        pp.setRight(n);
        n.setRight(p);
        p.setLeft(d);
        AVLNode<T> temp = n;
        n = p;
        p = temp;
        balanceInAdd4(n);
    }

    /**
     * balance the right heavy subtree
     * @param n the node to be balanced
     */
    private void balanceInAdd4(AVLNode<T> n) {
        AVLNode<T> p = parent(n);
        AVLNode<T> pp = parent(p);
        AVLNode<T> a = pp.getLeft();
        AVLNode<T> b = p.getLeft();
        T temp = pp.getData();
        T dataInP = p.getData();
        pp.setData(dataInP);
        p.setData(temp);
        pp.setRight(n);
        pp.setLeft(p);
        p.setLeft(a);
        p.setRight(b);
        n.setHeight(height(n));
        n.setBalanceFactor((balanceFactor(n)));
        p.setHeight(height(p));
        p.setBalanceFactor((balanceFactor(p)));
        pp.setHeight(height(pp));
        pp.setBalanceFactor((balanceFactor(pp)));
    }

    /**
     * check if a node has left child
     * @param n the node to be examined
     * @return true if the node has a left child
     */
    private boolean hasLeft(AVLNode<T> n) {
        return n.getLeft() != null;
    }

    /**
     * check if a node has right child
     * @param n the node to be examined
     * @return true if the node has a right child
     */
    private boolean hasRight(AVLNode<T> n) {
        return n.getRight() != null;
    }

    /**
     * get the parent of a node
     * @param n the node to be examined
     * @return the parent of the node
     */
    private AVLNode<T> parent(AVLNode<T> n) {
        return findParent(root, n.getData());
    }

    /**
     *  get the parent of a node
     * @param n the node to be examined
     * @param data the data to be examined
     * @return the parent of the node
     */
    private AVLNode<T> findParent(AVLNode<T> n, T data) {
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
     * remove and return the node
     * @param data data to remove from the tree
     * @return the node to be removed
     * @throws IllegalArgumentException
     * @throws NoSuchElementException
     */
    @Override
    public T remove(T data)
            throws IllegalArgumentException, NoSuchElementException {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data"
                    + "can not be null");
        }
        AVLNode<T> node = locate(root, data);
        T t = node.getData();
        root = remove(root , data);
        return t;
    }

    /**
     * locate the node
     * @param n the node to be examined
     * @param data the data to be examined
     * @return the node
     * @throws NoSuchElementException
     */
    private AVLNode<T> locate(AVLNode<T> n, T data)
            throws NoSuchElementException {
        if (n == null) {
            throw new NoSuchElementException("data"
                    + "is not found");
        }
        if (n.getData().compareTo(data) == 0) {
            return n;
        } else if (n.getData().compareTo(data) > 0) {
            return locate(n.getLeft(), data);
        } else {
            return locate(n.getRight(), data);
        }
    }

    /**
     * remove and return a node
     * @param n the node to be examined
     * @param data the data to be examined
     * @return the node to be examined
     * @throws NoSuchElementException
     */
    private AVLNode<T> remove(AVLNode<T> n, T data)
            throws NoSuchElementException {
        AVLNode<T> newNode;
        if (n == null) {
            throw new NoSuchElementException("data is not found");
        }
        if (n.getData().compareTo(data) > 0) {
            n.setLeft(remove(n.getLeft(), data));
            newNode = n;
        } else if (n.getData().compareTo(data) < 0) {
            n.setRight(remove(n.getRight(), data));
            newNode = n;
        } else {
            if (isExternal(n)) {
                newNode = null;
                size--;
            } else if (numChildren(n) == 1) {
                if (hasLeft(n)) {
                    newNode = n.getLeft();
                } else {
                    newNode = n.getRight();
                }
                size--;
            } else {
                AVLNode<T> temp = locatePredecessor(n.getLeft());
                n.setData(temp.getData());
                n.setLeft(remove(n.getLeft(), temp.getData()));
                newNode = n;

            }
        }
        if (newNode != null) {
            newNode.setHeight(height(newNode));
            newNode.setBalanceFactor((balanceFactor(newNode)));
                // modification
            if (newNode.getBalanceFactor() == -2) {
                if (newNode.getRight().getBalanceFactor() == -1) {
                    balanceInAdd4(newNode.getRight().getRight());
                } else {
                    balanceInAdd3(newNode.getRight().getLeft());
                }
            } else if (newNode.getBalanceFactor() == 2) {
                if (newNode.getLeft().getBalanceFactor() == 1) {
                    balanceInAdd1(newNode.getLeft().getLeft());
                } else {
                    balanceInAdd2(newNode.getLeft().getRight());
                }
            }
            newNode.setHeight(height(newNode));
            newNode.setBalanceFactor((balanceFactor(newNode)));
        }
        return newNode;
    }

    /**
     * locate the predecessor
     * @param n the node to be examined
     * @return the predecessor
     */
    private AVLNode<T> locatePredecessor(AVLNode<T> n) {
        if (n.getRight() == null) {
            return n;
        } else {
            return locatePredecessor(n.getRight());
        }
    }

    /**
     *  find the number of the children of the node
     * @param n the node to be inspected
     * @return an int that represents the number of children
     */
    private int numChildren(AVLNode<T> n) {
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
     * get the data
     * @param data data to get in the AVL tree
     * @return the data to get
     */
    @Override
    public T get(T data) {
        return getData(root, data);
    }

    /**
     * get the data
     * @param data data to get in the AVL tree
     * @param n the node to be examined
     * @return the data to get
     */
    private T getData(AVLNode<T> n, T data) {
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
                    AVLNode<T> leftOfN = n.getLeft();
                    return getData(leftOfN, data);
                }
            } else {
                if (hasRight(n)) {
                    AVLNode<T> rightOfN = n.getRight();
                    return getData(rightOfN, data);
                }
            }
        }
        return null;
    }

    /**
     * check if AVL contains the data
     * @param data data to find in the AVL tree
     * @return true if AVL contains the data
     */
    @Override
    public boolean contains(T data) {
        return containsData(root, data);
    }

    /**
     * check if AVL contains the data
     * @param data data to find in the AVL tree
     * @param n the node to be examined
     * @return true if AVL contains the data
     */
    private boolean containsData(AVLNode<T> n, T data) {
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
                    AVLNode<T> leftOfN = n.getLeft();
                    return containsData(leftOfN, data);
                } else {
                    return false;
                }
            } else {
                if (hasRight(n)) {
                    AVLNode<T> rightOfN = n.getRight();
                    return containsData(rightOfN, data);
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * the size of the node
     * @return the size of the node
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * a preorder traversal of the tree
     * @return a list containing the nodes sorted in preorder
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
    private void doPreOrder(AVLNode<T> n, List<T> l) {
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

    /**
     * a postorder traversal of the tree
     * @param n the node to be inspected
     * @param l the list to return
     */
    private void doPostOrder(AVLNode<T> n, List<T> l) {
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
    private void doInOrder(AVLNode<T> n, List<T> l) {
        if (hasLeft(n)) {
            doInOrder(n.getLeft(), l);
        }
        l.add(n.getData());
        if (hasRight(n)) {
            doInOrder(n.getRight(), l);
        }
    }

    /**
     * a level order traversal of the nodes
     * @return level order
     */
    @Override
    public List<T> levelorder() {
        ArrayList<T> l = new ArrayList<>();
        Queue<AVLNode<T>> q = new ArrayDeque<>();
        if (size == 0) {
            return l;
        }
        q.add(root);
        while (!q.isEmpty()) {
            AVLNode<T> n = q.remove();
            l.add(n.getData());
            for (AVLNode<T> e: children(n)) {
                q.add(e);
            }
        }
        return l;
    }

    /**
     * return the children of a node
     * @param n the node to be examined
     * @return the list containing children
     */
    private List<AVLNode<T>> children(AVLNode<T> n) {
        ArrayList<AVLNode<T>> l = new ArrayList<>();
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
    private void doListLeavesDescending(AVLNode<T> n, List<T> l) {
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
     * clear the AVL
     */
    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    /**
     * return the height of the AVL
     * @return the height of the AVL
     */
    @Override
    public int height() {
        return height(root);
    }

    /**
     * return the height of the node
     * @param n the node to be examined
     * @return the height
     */
    private int height(AVLNode<T> n) {
        int num;
        if (n == null) {
            return -1;
        } else if (isExternal(n)) {
            return 0;
        } else {
            if (height(n.getLeft()) > height(n.getRight())) {
                num = 1 + height(n.getLeft());
            } else {
                num = 1 + height(n.getRight());
            }
            return num;
        }
    }

    /**
     * check whether the node is external
     * @param n the node to be examined
     * @return true if the node is external
     */
    private boolean isExternal(AVLNode<T> n) {
        if (n == null) {
            return false;
        }
        return (n.getLeft() == null) && (n.getRight() == null);
    }

    /**
     * get the balance factor of the node
     * @param n the node to be examined
     * @return the balance factor
     */
    private int balanceFactor(AVLNode<T> n) {
        if (n == null) {
            return 0;
        }
        int num = height(n.getLeft()) - height(n.getRight());
        return num;
    }

    /**
     * get the root of the node
     * @return the root of the node
     */
    @Override
    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    public static void main(String[] args) {
        System.out.println(3185%61);
        System.out.println(Math.pow(26,3) * 1000 - Math.pow(26,4) * 100);
    }
}