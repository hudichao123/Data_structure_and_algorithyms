import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * A class representing a directed graph, with an edge list and adjacency list.
 *
 * DO NOT EDIT THIS CLASS!!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class Graph<T> {

    private Set<Edge<T>> edges;
    private Map<Vertex<T>, List<Edge<T>>> adjList;

    /**
     * Builds the graph from a set of vertices and an edge list. All edges in
     * the edge set are assumed to be directed, so if you want to create an
     * undirected edge, the edge set must contain both the forward and backwards
     * edges.
     *
     * @param vertices the vertex set
     * @param edges the edge set
     * @throws IllegalArgumentException if any of the arguments are null or if
     * the vertex set doesn't contain all of the vertices.
     */
    public Graph(Set<Vertex<T>> vertices, Set<Edge<T>> edges) {
        if (vertices == null || edges == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }

        this.edges = new HashSet<>(edges);
        adjList = new HashMap<>();
        for (Vertex<T> v : vertices) {
            adjList.put(v, new ArrayList<>());
        }

        for (Edge<T> e : edges) {
            if (adjList.containsKey(e.getU())) {
                adjList.get(e.getU()).add(e);
            } else {
                throw new IllegalArgumentException("Vertex set must contain all"
                    + "vertices of the graph.");
            }
        }
    }

    /**
     * Gets the edge set of this graph.
     *
     * @return the edge set of this graph
     */
    public Set<Edge<T>> getEdges() {
        return edges;
    }

    /**
     * Gets the adjacency list of this graph.
     *
     * @return the adjacency list of this graph
     */
    public Map<Vertex<T>, List<Edge<T>>> getAdjList() {
        return adjList;
    }

}