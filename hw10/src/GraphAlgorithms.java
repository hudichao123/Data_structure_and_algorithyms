import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Your implementation of various different graph algorithms.
 *
 * @author Dichao Hu
 * @userid dhu64
 * @GTID 903253306
 * @version 1.0
 */
public class     GraphAlgorithms {

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
     *  is null, or if {@code start} doesn't exist in the graphn
     * @param <T> the generic typing of the data
     * @param start the vertex to begin the bfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     */
    public static <T> List<Vertex<T>> breadthFirstSearch(Vertex<T> start,
                                            Graph<T> graph) {
        if (start == null || graph == null
                || graph.getAdjList().get(start) == null) {
            throw new IllegalArgumentException("start"
                    + "or graph cannot be null and "
                    + "start must be in the graph");
        }
        Queue<Vertex<T>> q = new LinkedBlockingQueue<>();
        List<Vertex<T>> visitedList = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Vertex<T> current = q.remove();
            if (!visitedList.contains(current)) {
                visitedList.add(current);
            }
            for (Edge e: graph.getAdjList().get(current)) {
                Vertex<T> endV = e.getV();
                if (!visitedList.contains(endV)) {
                    q.add(endV);
                }
            }
        }
        return visitedList;

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
        if (start == null || graph == null
                || graph.getAdjList().get(start) == null) {
            throw new IllegalArgumentException("start"
                    + "or graph cannot be null and "
                    + "start must be in the graph");
        }
        List<Vertex<T>> visitedList = new LinkedList<>();
        depthFirstSearch2(start, graph, visitedList);
        return visitedList;
    }

    /**
     * a helper method for dps
     * @param v the start vertex
     * @param g the graph
     * @param visitedList the visited list
     * @param <T> the generic type T
     */
    private static <T> void depthFirstSearch2(
            Vertex<T> v, Graph<T> g, List<Vertex<T>> visitedList) {
        visitedList.add(v);
        for (Edge e : g.getAdjList().get(v)) {
            Vertex<T> endV = e.getV();
            if (!visitedList.contains(endV)) {
                depthFirstSearch2(endV, g, visitedList);
            }

        }
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
        if (start == null || graph == null
                || graph.getAdjList().get(start) == null) {
            throw new IllegalArgumentException("start or graph"
                    + "cannot be null and"
                    + "start must be in the graph");
        }
        Map<Vertex<T>, Integer> map = new HashMap<>();
        List<Vertex<T>> visited = new LinkedList<>();
        for (Vertex<T> v : graph.getAdjList().keySet()) {
            map.put(v, Integer.MAX_VALUE);
        }
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>();
        pq.add(new Edge<>(start, start, 0));
        while (!pq.isEmpty()) {
            Edge<T> e = pq.remove();
            Vertex<T> v2 = e.getV();
            if (!visited.contains(v2)) {
                visited.add(v2);
                map.put(v2, e.getWeight());
                for (Edge<T> edge : graph.getAdjList().get(v2)) {
                    Vertex<T> endV = edge.getV();
                    if (!visited.contains(endV)) {
                        int w = edge.getWeight();
                        int lengthV2 = map.get(endV);
                        int lengthV1 = map.get(v2);
                        if (lengthV2 >= lengthV1 + w) {
                            pq.add(new Edge<T>(start, endV, lengthV1 + w));
                        }
                    }
                }
            }

        }
        return map;
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
            throw new IllegalArgumentException("graph cannot be null and ");
        }
        Set<Vertex<T>> vSet = graph.getAdjList().keySet();
        DisjointSet<Vertex<T>> d = new DisjointSet<>(vSet);
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>();
        Set<Edge<T>> setToReturn = new HashSet<>();
        if (vSet.size() == 1) {
            return setToReturn;
        }
        for (Edge e : graph.getEdges()) {
            pq.add(e);
        }

        int count =  0;
        while (count < graph.getAdjList().keySet().size() - 1
                && !pq.isEmpty()) {
            Edge<T> e = pq.remove();
            Vertex<T> startV = e.getU();
            Vertex<T> endV = e.getV();
            if (!d.find(startV).equals(d.find(endV))) {
                d.union(startV, endV);
                setToReturn.add(e);
                setToReturn.add(new Edge<T>(e.getV(), e.getU(),
                        e.getWeight()));
                count++;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        return setToReturn;
    }
}