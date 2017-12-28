import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * Aadarsh's tests to check GraphAlgorithms.
 * These tests are do they guarantee any kind of grade.
 *
 * @author Aadarsh Padiyath
 * @version 6.9
 */
public class GraphAlgoAadarshTests {

    private Graph<Integer> directedGraph;
    private Graph<Character> undirectedGraph;
    private Graph<Integer> oneVertexGraph;
    private Graph<Integer> oneEdgeGraph;
    private Graph<Integer> cyclicGraph;
    private Graph<Integer> pointToItselfGraph;
    private Graph<Character> oneVertexUndirectedGraph;
    private Graph<Character> oneEdgeUndirectedGraph;
    private Graph<Character> cyclicUndirectedGraph;
    private Graph<Character> disconnectedUndirectedGraph;
    private Graph<Character> nothingGraph;
    private Graph<Character> pointToItselfUndirectedGraph;
    private Graph<Character> fridayLectureGraph;
    private Graph<Character> saikrishnaGraph;

    private static final int TIMEOUT = 200;

    @Before
    public void init() {
        directedGraph = createDirectedGraph();
        undirectedGraph = createUndirectedGraph();
        oneVertexGraph = createOneVertexGraph();
        oneEdgeGraph = createOneEdgeGraph();
        cyclicGraph = createCyclicGraph();
        oneVertexUndirectedGraph = createDijkOneVertexUndirectedGraph();
        oneEdgeUndirectedGraph = createDijkOneEdgeUndirectedGraph();
        cyclicUndirectedGraph = createCyclicUndirectedGraph();
        disconnectedUndirectedGraph = createDisconnectedUndirectedGraph();
        nothingGraph = createNothingGraph();
        pointToItselfGraph = createPointsToItselfGraph();
        pointToItselfUndirectedGraph = createPointsToItselfUndirectedGraph();
        fridayLectureGraph = createFridayLectureGraph();
        saikrishnaGraph = createSaikrishnaDijkstraGraph();
    }

    private Graph<Character> createSaikrishnaDijkstraGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 69; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 10));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 3));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 1));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 4));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 7));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 9));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 8));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('E'), 2));


        return new Graph<>(vertices, edges);
    }



    private Graph<Character> createNothingGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        Set<Edge<Character>> edges = new HashSet<>();
        return new Graph<>(vertices, edges);
    }

    private Graph<Character> createFridayLectureGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 75; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 13)); //A - B
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 13));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('D'), 3));  //B - D
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('B'), 3));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('A'), 7));  //C - A
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 7));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 4));  //C - D
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 4));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('F'), 2));  //C - F
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('C'), 2));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('E'), 5));  //A - E
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 5));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('G'), 8));  //E - G
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('E'), 8));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('H'), 14)); //G - H
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('G'), 14));
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('K'), 10)); //H - K
        edges.add(new Edge<>(new Vertex<>('K'), new Vertex<>('H'), 10));
        edges.add(new Edge<>(new Vertex<>('K'), new Vertex<>('J'), 11)); //K - J
        edges.add(new Edge<>(new Vertex<>('J'), new Vertex<>('K'), 11));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('J'), 16)); //D - J
        edges.add(new Edge<>(new Vertex<>('J'), new Vertex<>('D'), 16));
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('J'), 9));  //H - J
        edges.add(new Edge<>(new Vertex<>('J'), new Vertex<>('H'), 9));
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('I'), 6));  //H - I
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('H'), 6));
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('J'), 15)); //I - J
        edges.add(new Edge<>(new Vertex<>('J'), new Vertex<>('I'), 15));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('I'), 17)); //F - I
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('F'), 17));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('H'), 12)); //F - H
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('F'), 12));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 1));  //E - F
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('E'), 1));

        return new Graph<>(vertices, edges);
    }

    private Graph<Character> createDisconnectedUndirectedGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 70; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 1));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 3));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 3));

        return new Graph<>(vertices, edges);
    }


    private Graph<Integer> createCyclicGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        for (int i = 1; i <= 4; i++) {
            vertices.add(new Vertex<>(i));
        }

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(1), 0));

        return new Graph<>(vertices, edges);
    }

    private Graph<Integer> createPointsToItselfGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        for (int i = 1; i <= 1; i++) {
            vertices.add(new Vertex<>(i));
        }

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(1), 0));

        return new Graph<>(vertices, edges);
    }

    private Graph<Integer> createOneVertexGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        for (int i = 1; i <= 1; i++) {
            vertices.add(new Vertex<>(i));
        }

        Set<Edge<Integer>> edges = new HashSet<>();

        return new Graph<>(vertices, edges);
    }

    private Graph<Integer> createOneEdgeGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        for (int i = 1; i <= 2; i++) {
            vertices.add(new Vertex<>(i));
        }

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));

        return new Graph<>(vertices, edges);
    }

    /**
     * Creates a directed graph.
     * The graph is depicted in the pdf.
     *
     * @return the completed graph
     */
    private Graph<Integer> createDirectedGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        for (int i = 1; i <= 7; i++) {
            vertices.add(new Vertex<>(i));
        }

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(6), 0));

        return new Graph<>(vertices, edges);
    }

    private Graph<Character> createPointsToItselfUndirectedGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 65; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('A'), 2));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('A'), 2));

        return new Graph<>(vertices, edges);
    }

    private Graph<Character> createDijkOneVertexUndirectedGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 65; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();

        return new Graph<>(vertices, edges);
    }

    private Graph<Character> createDijkOneEdgeUndirectedGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 66; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 69));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 69));

        return new Graph<>(vertices, edges);
    }

    private Graph<Character> createCyclicUndirectedGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 68; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 69));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 69));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 70));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 70));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 71));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 71));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('A'), 72));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('D'), 72));

        return new Graph<>(vertices, edges);
    }

    /**
     * Creates an undirected graph.
     * The graph is depicted in the pdf.
     *
     * @return the completed graph
     */
    private Graph<Character> createUndirectedGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 70; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 7));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 7));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('A'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 2));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('D'), 4));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('A'), 4));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 1));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('E'), 3));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('B'), 3));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('F'), 8));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('B'), 8));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 6));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('E'), 6));

        return new Graph<>(vertices, edges);
    }

    @Test(timeout = TIMEOUT)
    public void testBreadthFirstSearchExceptions() {
        Integer count = 0;
        try {
            GraphAlgorithms.breadthFirstSearch(null, directedGraph);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            GraphAlgorithms.breadthFirstSearch(new Vertex<>(5), null);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            GraphAlgorithms.breadthFirstSearch(new Vertex<>(69), directedGraph);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        Integer correctCount = 3;
        assertEquals(correctCount, count);
    }

    @Test(timeout = TIMEOUT)
    public void testBreadthFirstOneVertexSearch() {
        Graph<Integer> oneVertexGraphBefore = oneVertexGraph;
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(1), oneVertexGraph);

        List<Vertex<Integer>> bfsExpected = new LinkedList<>();
        bfsExpected.add(new Vertex<>(1));

        assertEquals(bfsExpected, bfsActual);
        assertEquals("Your code modifies the graph", oneVertexGraphBefore, oneVertexGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testBreadthFirstOneEdgeSearch() {
        Graph<Integer> oneEdgeGraphBefore = oneEdgeGraph;
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(1), oneEdgeGraph);

        List<Vertex<Integer>> bfsExpected = new LinkedList<>();
        bfsExpected.add(new Vertex<>(1));
        bfsExpected.add(new Vertex<>(2));

        assertEquals(bfsExpected, bfsActual);
        assertEquals("Your code modifies the graph", oneEdgeGraphBefore, oneEdgeGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testBreadthCyclicGraphSearch() {
        Graph<Integer> cyclicGraphBefore = cyclicGraph;
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(1), cyclicGraph);

        List<Vertex<Integer>> bfsExpected = new LinkedList<>();
        bfsExpected.add(new Vertex<>(1));
        bfsExpected.add(new Vertex<>(2));
        bfsExpected.add(new Vertex<>(3));
        bfsExpected.add(new Vertex<>(4));

        assertEquals(bfsExpected, bfsActual);
        assertEquals("Your code modifies the graph", cyclicGraphBefore, cyclicGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testBreadthPointToItselfSearch() {
        Graph<Integer> pointsToItselfGraphBefore = pointToItselfGraph;
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(1), pointToItselfGraph);

        List<Vertex<Integer>> bfsExpected = new LinkedList<>();
        bfsExpected.add(new Vertex<>(1));

        assertEquals(bfsExpected, bfsActual);
        assertEquals("Your code modifies the graph", pointsToItselfGraphBefore, pointToItselfGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testBreadthFirstSearch() {
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(5), directedGraph);

        List<Vertex<Integer>> bfsExpected = new LinkedList<>();
        bfsExpected.add(new Vertex<>(5));
        bfsExpected.add(new Vertex<>(4));
        bfsExpected.add(new Vertex<>(7));
        bfsExpected.add(new Vertex<>(6));

        assertEquals(bfsExpected, bfsActual);
    }

    @Test(timeout = TIMEOUT)
    public void testBreadthFirstDisconnected() {
        List<Vertex<Character>> bfsActual = GraphAlgorithms.breadthFirstSearch(
                new Vertex<>('A'), disconnectedUndirectedGraph);

        List<Vertex<Character>> bfsExpected = new LinkedList<>();
        bfsExpected.add(new Vertex<>('A'));
        bfsExpected.add(new Vertex<>('B'));

        assertEquals(bfsExpected, bfsActual);
    }

    @Test(timeout = TIMEOUT)
    public void testDepthFirstDisconnected() {
        List<Vertex<Character>> dfsActual = GraphAlgorithms.depthFirstSearch(
                new Vertex<>('A'), disconnectedUndirectedGraph);

        List<Vertex<Character>> dfsExpected = new LinkedList<>();
        dfsExpected.add(new Vertex<>('A'));
        dfsExpected.add(new Vertex<>('B'));

        assertEquals(dfsExpected, dfsActual);
    }

    @Test(timeout = TIMEOUT)
    public void testDepthFirstSearchExceptions() {
        Integer count = 0;
        try {
            GraphAlgorithms.depthFirstSearch(null, directedGraph);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            GraphAlgorithms.depthFirstSearch(new Vertex<>(5), null);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            GraphAlgorithms.depthFirstSearch(new Vertex<>(69), directedGraph);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        Integer correctCount = 3;
        assertEquals(correctCount, count);
    }

    @Test(timeout = TIMEOUT)
    public void testDepthFirstOneVertexSearch() {
        Graph<Integer> oneVertexGraphBefore = oneVertexGraph;
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.depthFirstSearch(
                new Vertex<>(1), oneVertexGraph);

        List<Vertex<Integer>> dfsExpected = new LinkedList<>();
        dfsExpected.add(new Vertex<>(1));

        assertEquals(dfsExpected, dfsActual);
        assertEquals("Your code modifies the graph", oneVertexGraphBefore, oneVertexGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDepthFirstOneEdgeSearch() {
        Graph<Integer> oneEdgeGraphBefore = oneEdgeGraph;
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.depthFirstSearch(
                new Vertex<>(1), oneEdgeGraph);

        List<Vertex<Integer>> dfsExpected = new LinkedList<>();
        dfsExpected.add(new Vertex<>(1));
        dfsExpected.add(new Vertex<>(2));

        assertEquals(dfsExpected, dfsActual);
        assertEquals("Your code modifies the graph", oneEdgeGraphBefore, oneEdgeGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDepthPointToItselfGraphSearch() {
        Graph<Integer> pointToItselfGraphBefore = pointToItselfGraph;
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.depthFirstSearch(
                new Vertex<>(1), pointToItselfGraph);

        List<Vertex<Integer>> dfsExpected = new LinkedList<>();
        dfsExpected.add(new Vertex<>(1));

        assertEquals(dfsExpected, dfsActual);
        assertEquals("Your code modifies the graph", pointToItselfGraphBefore, pointToItselfGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDepthCyclicGraphSearch() {
        Graph<Integer> cyclicGraphBefore = cyclicGraph;
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.depthFirstSearch(
                new Vertex<>(1), cyclicGraph);

        List<Vertex<Integer>> dfsExpected = new LinkedList<>();
        dfsExpected.add(new Vertex<>(1));
        dfsExpected.add(new Vertex<>(2));
        dfsExpected.add(new Vertex<>(3));
        dfsExpected.add(new Vertex<>(4));

        assertEquals(dfsExpected, dfsActual);
        assertEquals("Your code modifies the graph", cyclicGraphBefore, cyclicGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDepthFirstSearch() {
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.depthFirstSearch(
                new Vertex<>(5), directedGraph);

        List<Vertex<Integer>> dfsExpected = new LinkedList<>();
        dfsExpected.add(new Vertex<>(5));
        dfsExpected.add(new Vertex<>(4));
        dfsExpected.add(new Vertex<>(6));
        dfsExpected.add(new Vertex<>(7));

        assertEquals(dfsExpected, dfsActual);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstrasExceptions() {
        Integer count = 0;
        try {
            GraphAlgorithms.dijkstras(null, undirectedGraph);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            GraphAlgorithms.dijkstras(new Vertex<>('A'), null);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        try {
            GraphAlgorithms.dijkstras(new Vertex<>(' '), undirectedGraph);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        Integer correctCount = 3;
        assertEquals(correctCount, count);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstrasDisconnected() {
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('A'), disconnectedUndirectedGraph);

        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('A'), 0);
        dijkExpected.put(new Vertex<>('B'), 1);
        dijkExpected.put(new Vertex<>('C'), Integer.MAX_VALUE);
        dijkExpected.put(new Vertex<>('D'), Integer.MAX_VALUE);
        dijkExpected.put(new Vertex<>('E'), Integer.MAX_VALUE);
        dijkExpected.put(new Vertex<>('F'), Integer.MAX_VALUE);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstrasOneVertexSearch() {
        Graph<Character> oneVertexGraphBefore = oneVertexUndirectedGraph;
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('A'), oneVertexUndirectedGraph);
        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('A'), 0);

        assertEquals(dijkExpected, dijkActual);
        assertEquals("Your code modifies the graph", oneVertexGraphBefore, oneVertexUndirectedGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstrasOneVertexDirectedSearch() {
        Graph<Integer> oneVertexGraphBefore = oneVertexGraph;
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>(1), oneVertexGraph);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(1), 0);

        assertEquals(dijkExpected, dijkActual);
        assertEquals("Your code modifies the graph", oneVertexGraphBefore, oneVertexGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstrasPointsToItselfSearch() {
        Graph<Character> pointToItselfUndirectedGraphBefore = pointToItselfUndirectedGraph;
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('A'), pointToItselfUndirectedGraph);
        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('A'), 0);

        assertEquals(dijkExpected, dijkActual);
        assertEquals("Your code modifies the graph", pointToItselfUndirectedGraphBefore, pointToItselfUndirectedGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkOneEdgeSearch() {
        Graph<Character> oneEdgeUndirectedGraphBefore = oneEdgeUndirectedGraph;
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('A'), oneEdgeUndirectedGraph);
        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('A'), 0);
        dijkExpected.put(new Vertex<>('B'), 69);

        assertEquals(dijkExpected, dijkActual);
        assertEquals("Your code modifies the graph", oneEdgeUndirectedGraphBefore, oneEdgeUndirectedGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkOneEdgeDirectedSearch() {
        Graph<Integer> oneEdgeGraphBefore = oneEdgeGraph;
        Map<Vertex<Integer>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>(1), oneEdgeGraph);
        Map<Vertex<Integer>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>(1), 0);
        dijkExpected.put(new Vertex<>(2), 0);

        assertEquals(dijkExpected, dijkActual);
        assertEquals("Your code modifies the graph", oneEdgeGraphBefore, oneEdgeGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkCyclicGraphSearch() {
        Graph<Character> cyclicUndirectedGraphBefore = cyclicUndirectedGraph;
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('A'), cyclicUndirectedGraph);
        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('A'), 0);
        dijkExpected.put(new Vertex<>('B'), 69);
        dijkExpected.put(new Vertex<>('C'), 69 + 70);
        dijkExpected.put(new Vertex<>('D'), 72);

        assertEquals(dijkExpected, dijkActual);
        assertEquals("Your code modifies the graph", cyclicUndirectedGraphBefore, cyclicUndirectedGraph);
    }

    @Test
    public void testDijkstrasSaikrishnaGraph() {
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('A'), saikrishnaGraph);
        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('A'), 0);
        dijkExpected.put(new Vertex<>('B'), 7);
        dijkExpected.put(new Vertex<>('C'), 3);
        dijkExpected.put(new Vertex<>('D'), 9);
        dijkExpected.put(new Vertex<>('E'), 5);


        assertEquals(dijkExpected, dijkActual);
    }

    @Test
    public void testDijkstrasFridayLectureGraph() {
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('K'), fridayLectureGraph);
        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('K'), 0);
        dijkExpected.put(new Vertex<>('H'), 10);
        dijkExpected.put(new Vertex<>('J'), 11);
        dijkExpected.put(new Vertex<>('I'), 16);
        dijkExpected.put(new Vertex<>('F'), 22);
        dijkExpected.put(new Vertex<>('E'), 23);
        dijkExpected.put(new Vertex<>('C'), 24);
        dijkExpected.put(new Vertex<>('G'), 24);
        dijkExpected.put(new Vertex<>('D'), 27);
        dijkExpected.put(new Vertex<>('A'), 28);
        dijkExpected.put(new Vertex<>('B'), 30);


        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstras() {
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('D'), undirectedGraph);
        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('A'), 4);
        dijkExpected.put(new Vertex<>('B'), 4);
        dijkExpected.put(new Vertex<>('C'), 2);
        dijkExpected.put(new Vertex<>('D'), 0);
        dijkExpected.put(new Vertex<>('E'), 1);
        dijkExpected.put(new Vertex<>('F'), 7);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testKruskalExceptions() {
        Integer count = 0;
        try {
            GraphAlgorithms.kruskals(null);
            fail();
        } catch (IllegalArgumentException e) {
            count++;
        }
        Integer correctCount = 1;
        assertEquals(correctCount, count);
    }

    @Test(timeout = TIMEOUT)
    public void testKruskalDisconnectedGraph() {
        Set<Edge<Character>> dijkActual = GraphAlgorithms.kruskals(disconnectedUndirectedGraph);

        assertNull("If the graph is"
                + " disconnected and therefore not a valid MST, return null.\n", dijkActual);
    }

    @Test(timeout = TIMEOUT)
    public void testKruskalOneVertexSearch() {
        Graph<Character> oneVertexGraphBefore = oneVertexUndirectedGraph;
        Set<Edge<Character>> kruskalActual = GraphAlgorithms.kruskals(
                oneVertexUndirectedGraph);
        Set<Edge<Character>> kruskalExpected = new HashSet<>();

        assertEquals(kruskalExpected, kruskalActual);
        assertEquals("Your code modifies the graph", oneVertexGraphBefore, oneVertexUndirectedGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testKruskalOneEdgeSearch() {
        Graph<Character> oneEdgeUndirectedGraphBefore = oneEdgeUndirectedGraph;
        Set<Edge<Character>> kruskalsActual = GraphAlgorithms.kruskals(
                oneEdgeUndirectedGraph);
        Set<Edge<Character>> kruskalsExpected = new HashSet<>();
        kruskalsExpected.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 69));
        kruskalsExpected.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 69));

        assertEquals(kruskalsExpected, kruskalsActual);
        assertEquals("Your code modifies the graph", oneEdgeUndirectedGraphBefore, oneEdgeUndirectedGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testKruskalPointToItselfSearch() {
        Graph<Character> pointsToItselfBefore = pointToItselfUndirectedGraph;
        Set<Edge<Character>> kruskalsActual = GraphAlgorithms.kruskals(
                pointToItselfUndirectedGraph);
        Set<Edge<Character>> kruskalsExpected = new HashSet<>();

        assertEquals(kruskalsExpected, kruskalsActual);
        assertEquals("Your code modifies the graph", pointsToItselfBefore, pointToItselfUndirectedGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testKruskalNothingSearch() {
        Graph<Character> nothingGraphBefore = nothingGraph;
        Set<Edge<Character>> kruskalsActual = GraphAlgorithms.kruskals(nothingGraph);

        assertEquals(null, kruskalsActual);
        assertEquals("Your code modifies the graph", nothingGraphBefore, nothingGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testKruskalCyclicGraphSearch() {
        Graph<Character> cyclicUndirectedGraphBefore = cyclicUndirectedGraph;
        Set<Edge<Character>> kruskalsActual = GraphAlgorithms.kruskals(
                cyclicUndirectedGraph);
        Set<Edge<Character>> kruskalsExpected = new HashSet<>();
        kruskalsExpected.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 71));
        kruskalsExpected.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 71));
        kruskalsExpected.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 69));
        kruskalsExpected.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 69));
        kruskalsExpected.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 70));
        kruskalsExpected.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 70));

        assertEquals(kruskalsExpected, kruskalsActual);
        assertEquals("Your code modifies the graph", cyclicUndirectedGraphBefore, cyclicUndirectedGraph);
    }

    @Test(timeout = TIMEOUT)
    public void testKruskals() {
        Set<Edge<Character>> mstActual = GraphAlgorithms.kruskals(
                undirectedGraph);
        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 2));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('D'), 4));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('A'), 4));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 1));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('E'), 3));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('B'), 3));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 6));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('E'), 6));

        assertEquals(edges, mstActual);
    }
}
