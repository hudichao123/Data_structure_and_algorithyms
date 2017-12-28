import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Your implementation of various different graph algorithms.
 *
 * @author YOUR NAME HERE
 * @userid YOUR USER ID HERE(i.e. gburdell3)
 * @GTID YOUR GT ID HERE (i.e. 900000000)
 * @version 1.0
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * {@code start} which represents the starting vertex.
     *
     * When exploring a vertex, make sure to explore in the order that the
     * adjacency list returns the neighbors to you. Failure to do so may cause
     * you to lose points.
     *
     * You may import/use {@code java.util.Set}, {@code java.util.List},
     * {@code java.util.Queue}, and any classes that implement the
     * aforementioned interfaces, as long as it is efficient.
     *
     * The only instance of {@code java.util.Map} that you may use is the
     * adjacency list from {@code graph}. DO NOT create new instances of Map
     * for BFS (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @throws IllegalArgumentException if any input
     *  is null, or if {@code start} doesn't exist in the graph
     * @param <T> the generic typing of the data
     * @param start the vertex to begin the bfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     */
    public static <T> List<Vertex<T>> breadthFirstSearch(Vertex<T> start,
                                            Graph<T> graph) {
        if (start == null || graph == null || !graph.getAdjList().keySet().contains(start)) {
            throw new IllegalArgumentException();
        }
        Queue<Vertex<T>> q = new LinkedBlockingQueue<>();
        List<Vertex<T>> l = new ArrayList<>();
        Set<Vertex<T>> s = new HashSet<>();
        q.add(start);
        while (!q.isEmpty()) {
            Vertex<T> v = q.remove();
            if (!s.contains(v)) {
                s.add(v);
                l.add(v);
            }
            for (Edge<T> e : graph.getAdjList().get(v)) {
                Vertex<T> temp = e.getV();
                q.add(temp);
            }
        }
        return l;
    }


    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * {@code start} which represents the starting vertex.
     *
     * When deciding which neighbors to visit next from a vertex, visit the
     * vertices in the order presented in that entry of the adjacency list.
     *
     * *NOTE* You MUST implement this method recursively, or else you will lose
     * most if not all points for this method.
     *
     * You may import/use {@code java.util.Set}, {@code java.util.List}, and
     * any classes that implement the aforementioned interfaces, as long as it
     * is efficient.
     *
     * The only instance of {@code java.util.Map} that you may use is the
     * adjacency list from {@code graph}. DO NOT create new instances of Map
     * for DFS (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @throws IllegalArgumentException if any input
     *  is null, or if {@code start} doesn't exist in the graph
     * @param <T> the generic typing of the data
     * @param start the vertex to begin the dfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     */
    public static <T> List<Vertex<T>> depthFirstSearch(Vertex<T> start,
                                            Graph<T> graph) {
        if (start == null || graph == null || !graph.getAdjList().keySet().contains(start)) {
            throw new IllegalArgumentException();
        }
        Stack<Vertex<T>> s = new Stack<>();
        List<Vertex<T>> l = new ArrayList<>();
        HashSet<Vertex<T>> h = new HashSet<>();
        s.push(start);
        while (!s.isEmpty() && l.size() < graph.getAdjList().keySet().size()) {
            Vertex<T> v = s.pop();
            if (!h.contains(v)) {
                h.add(v);
                l.add(v);
            }
            for (Edge<T> e : graph.getAdjList().get(v)) {
                Vertex<T> temp = e.getV();
               s.push(temp);
            }

        }
        return l;
    }


    /**
     * Finds the single-source shortest distance between the start vertex and
     * all vertices given a weighted graph (you may assume non-negative edge
     * weights).
     *
     * Return a map of the shortest distances such that the key of each entry
     * is a node in the graph and the value for the key is the shortest distance
     * to that node from start, or Integer.MAX_VALUE (representing infinity)
     * if no path exists.
     *
     * You may import/use {@code java.util.PriorityQueue},
     * {@code java.util.Map}, and {@code java.util.Set} and any class that
     * implements the aforementioned interfaces, as long as it's efficient.
     *
     * You should implement the version of Dijkstra's where you terminate the
     * algorithm once either all vertices have been visited or the PQ becomes
     * empty.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @throws IllegalArgumentException if any input is null, or if start
     *  doesn't exist in the graph.
     * @param <T> the generic typing of the data
     * @param start index representing which vertex to start at (source)
     * @param graph the graph we are applying Dijkstra's to
     * @return a map of the shortest distances from start to every other node
     *         in the graph
     */
    public static <T> Map<Vertex<T>, Integer> dijkstras(Vertex<T> start,
                                                      Graph<T> graph) {
        if (start == null || graph == null || !graph.getAdjList().keySet().contains(start)) {
            throw new IllegalArgumentException();
        }
        HashMap<Vertex<T>, Integer> m = new HashMap<>();
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>();
        HashSet<Vertex<T>> h = new HashSet<>();
        for (Vertex<T> v : graph.getAdjList().keySet()) {
            m.put(v, Integer.MAX_VALUE);
        }
        pq.add(new Edge<>(start, start, 0));
        m.put(start, 0);
        while (!pq.isEmpty() && h.size() < graph.getAdjList().keySet().size()) {
            Edge<T> e = pq.remove();
            int weight = e.getWeight();
            Vertex<T> v = e.getV();
            if (!h.contains(v)) {
                h.add(v);
                for (Edge<T> tempEdge : graph.getAdjList().get(v)) {
                    Vertex<T> endV = tempEdge.getV();
                    if (!h.contains(endV)) {
                        int tempWeight = m.get(endV);
                        int anotherWeight = tempEdge.getWeight();
                        if (tempWeight > anotherWeight + weight) {
                            m.put(endV, (anotherWeight + weight));
                            pq.add(new Edge<>(start, endV, anotherWeight + weight));
                        }
                    }
                }
            }
        }
        if (h.size() < graph.getAdjList().keySet().size()) {
            return null;
        }
        return m;
    }


    /**
     * Runs Kruskal's algorithm on the given graph and return the Minimal
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * opposite edge to the set as well. This is for testing purposes.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * Kruskal's will also require you to use a Disjoint Set which has been
     * provided for you. A Disjoint Set will keep track of which vertices are
     * connected given the edges in your current MST, allowing you to easily
     * figure out whether adding an edge will create a cycle. Refer
     * to the {@code DisjointSet} and {@code DisjointSetNode} classes that
     * have been provided to you for more information.
     *
     * You should NOT allow self-loops into the MST.
     *
     * You may import/use {@code java.util.PriorityQueue},
     * {@code java.util.Set}, and any class that implements the aforementioned
     * interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @throws IllegalArgumentException if any input is null
     * @param <T> the generic typing of the data
     * @param graph the graph we are applying Kruskals to
     * @return the MST of the graph or null if there is no valid MST
     */
    public static <T> Set<Edge<T>> kruskals(Graph<T> graph) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>();
        DisjointSet<Vertex<T>> s = new DisjointSet<>(graph.getAdjList().keySet());
        Set<Edge<T>> s2 = new HashSet<>();
        for (Edge<T> e : graph.getEdges()) {
            pq.add(e);
        }
        int count = 0;
        while (!pq.isEmpty() && count < graph.getAdjList().keySet().size() - 1) {
            Edge<T> e = pq.remove();
            Edge<T> newEdge= new Edge<>(e.getV(), e.getU(), e.getWeight());
            Vertex<T> u = e.getU();
            Vertex<T> v = e.getV();
            if (s.find(u) != s.find(v)) {
                s2.add(e);
                s2.add(newEdge);
                s.union(u, v);
                count++;
            }
        }
        if (pq.isEmpty()) {
            return new HashSet<>();
        }
        return s2;
    }
}