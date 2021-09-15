import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Class that creates an instance of a graph
 * and implements basic operations on graph
 * data structure.
 * Class uses generic data types.
 *
 * @param <T> - any object that will be stored
 * in a graph's vertices.
 */

public class MyGraphDS<T> {
    private int V;
    private int E;
    private List<ArrayList<Integer>> adj;

    /**
     * Constructor for a Graph data structure.
     *
     * @param V - initial number of vertices.
     */

    public MyGraphDS(int V) {
        this.V = V;
        this.adj = new ArrayList<ArrayList<Integer>>(V);
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>(1));
        }
    }

    /**
     * Constructor for a graph instance that read information
     * from file.
     *
     * @param f - file with information about connected vertices.
     *
     * @throws FileNotFoundException if the file with data not
     * found.
     */

    public MyGraphDS(File f) throws FileNotFoundException {
        // to be implemented
        throw new FileNotFoundException("File not found.");
    }

    /**
     * Method that returns number of vertices in an
     * instance of a graph.
     *
     * @return number of vertices in a Graph.
     */

    public int V() {
        return V;
    }

    /**
     * Method that returns number vertices in an
     * instance of a graph.
     *
     * @return number of edges in a graph instance.
     */

    public int E() {
        return E;
    }

    /**
     * Method that adds vertex to the graph.
     *
     * @param data - data to be stored in a new vertex.
     */

    public void addVertex(int data) {
        adj.add(new ArrayList<Integer>(V++));
    }

    /**
     * Method that adds edge to a graph (e.g connects
     * two vertices).
     *
     * @param v - first vertex.
     * @param w - second vertex.
     */

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
        E++;
    }

    /**
     * Method that calculates the degree of a vertex.
     *
     * @param v - vertex to be inspected.
     * @return degree of a given vertex.
     */

    public int vertexDegree(int v) throws IllegalArgumentException {
        if(!adj.contains(v)) {
            throw new IllegalArgumentException("No such vertex in a graph.");
        }
        Iterator<Integer> i = adjacent(v);
        int degree = 0;
        while(i.hasNext()) {
            degree++;
            i.next();
        }
        return degree;
    }

    /**
     * Method that collects and returns all the
     * adjacent vertices to the given one.
     *
     * @param v - vertex to be inspected.
     * @return all the adjacent vertices to v.
     */

    public Iterator<Integer> adjacent(int v) {
        return adj.get(v).iterator();
    }

    /**
     * Method that implements Breadth First search on a
     * graph instance.
     *
     * @param s - starting vertex.
     * @throws IllegalArgumentException if the given vertex does not
     * exist.
     */

    public void BFS(int s) throws IllegalArgumentException {
        boolean[] marked = new boolean[V];
        marked[s] = true;

        Queue<Integer> inspect = new LinkedList<Integer>();
        inspect.offer(s);

        while(!inspect.isEmpty()) {
            Iterator<Integer> neighbours = adjacent(s);
            while(neighbours.hasNext()) {
                int inspectingNow = neighbours.next();
                if(!marked[inspectingNow]) {
                    marked[inspectingNow] = true;
                    inspect.offer(inspectingNow);
                }
            }
        }
    }

    /**
     * Method that implements Depth First Search.
     * Uses method DFSUtil as an utility method.
     *
     * @param s - starting vertex.
     */

    public void DFS(int s) {
        boolean[] visited = new boolean[V];
        DFSUtil(s, visited);
    }

    /**
     * Utility method for DFS.
     *
     * @param v - starting vertex.
     * @param visited - array of boolean values
     */

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        Iterator<Integer> i = adjacent(v);
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    /**
     * Method that checks whether 2 vertices are connected.
     *
     * @param v - first vertex.
     * @param w - second vertex.
     * @return true if there is a path, false - if not.
     */

    public boolean hasPathTo(int v, int w) {
        return adj.get(v).contains(w);
    }

    public void path(int v, int w) {
        //to be implemented.
    }

    /**
     * Overridden toString method from the global superclass
     * Object that gives representation of a graph in a String.
     *
     * @return instance of a graph represented as a string.
     */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder((V + "Vertices and " + E + "Edges"));
        for(int v = 0; v < V; v++) {
            result.append(v).append(": ");
            Iterator<Integer> i = adjacent(v);
            while(i.hasNext()) {
                result.append(i).append(" ");
            }
            result.append("\n");
        }
        return (result.toString());
    }
}