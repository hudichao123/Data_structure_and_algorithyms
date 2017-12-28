/**
 * Class to store a DisjointSetNode.  This class is used ONLY for the
 * DisjointSet class. DO NOT use this class for your implementation and DO NOT
 * edit this class.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class DisjointSetNode<T> {
    private DisjointSetNode<T> parent;
    private T data;
    private int rank;

    /**
     * Creates a DisjointSetNode to be used with DisjointSet.
     * @param data the data to be stored
     */
    public DisjointSetNode(T data) {
        this.parent = this;
        this.data = data;
        this.rank = 0;
    }

    /**
     * Parent getter method.
     * @return Direct parent of this node.
     */
    public DisjointSetNode<T> getParent() {
        return parent;
    }

    /**
     * Parent setter method.
     * @param parent The new parent.
     */
    public void setParent(DisjointSetNode<T> parent) {
        this.parent = parent;
    }

    /**
     * Data getter method.
     * @return Data in node.
     */
    public T getData() {
        return data;
    }

    /**
     * Data setter method.
     * @param data The new data.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Rank getter method.
     * @return the rank of this node.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Rank setter method.
     * @param rank The new rank.
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Rank: " + rank + ", Parent: "
            + parent.getData();
    }
}