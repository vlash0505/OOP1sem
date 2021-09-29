package com.graph.implementation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Class that creates an instance of a graph
 * and implements basic operations on graph
 * data structure that is represented as
 * adjacency matrix.
 */

public class GraphAdjMatrix {
    private int[][] adj;
    private int V;
    private int E;

    /**
     * Constructor without parameters for a Graph
     * data structure represented as adjacency matrix.
     */

    public GraphAdjMatrix() { adj = new int[1][1]; }

    /**
     * Constructor without parameters for a Graph
     * data structure represented as adjacency matrix.
     *
     * @param V - initial number of vertices
     */

    public GraphAdjMatrix(int V) { adj = new int[V][V]; }

    /**
     * Constructor for a graph instance that read information
     * from file.
     *
     * @param f - file with information about connected vertices.
     *
     * @throws FileNotFoundException if the file with data not
     * found.
     */

    public GraphAdjMatrix(File f) throws FileNotFoundException {
        // to be implemented
        //throw new FileNotFoundException("File not found.");
    }

    /**
     * Resizing the adjacency matrix.
     * (Old size) * 2 when we are exceeding the initial array.
     * (Old size) / 2 when we are using only 1/4 of initial array.
     *
     * @param newSize - size of the new 2D array.
     */

    public void resize(int newSize) {
        int[][] newArr = new int[newSize][newSize];
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < adj.length; j++) {
                newArr[i][j] = adj[i][j];
            }
        }
        adj = newArr;
    }

    /**
     * Method that returns number of vertices in an
     * instance of a graph.
     *
     * @return number of vertices in a Graph.
     */

    public int V()  { return V; }

    /**
     * Method that returns number vertices in an
     * instance of a graph.
     *
     * @return number of edges in a graph instance.
     */

    public int E()  { return E; }

    /**
     * Method that adds vertex to the graph.
     */

    public void addVertex() {
        if(V == adj.length) { resize(V * 2); }
        V++;
    }

    /**
     * Method that removes vertex the graph.
     */

    public void removeVertex(int toBeRemoved) {
        if(V == (adj.length / 4)) { resize(V / 2); }
        for(int i = 0; i < V; i++) {
            adj[toBeRemoved][i] = 0;
            adj[i][toBeRemoved] = 0;
        }
        V--;
    }

    /**
     * Method that adds edge to a graph (connects
     * two vertices).
     *
     * @param v - first vertex.
     * @param w - second vertex.
     */

    public void addEdge(int v, int w) {
        adj[v][w] = 1;
        adj[w][v] = 1;
        E++;
    }

    /**
     * Method that deletes an edge in a graph.(deletes
     * connection between two vertices)
     *
     * @param v - first vertex.
     * @param w - second vertex.
     */

    public void removeEdge(int v, int w) {
        adj[v][w] = 0;
        adj[w][v] = 0;
        E--;
    }

    /**
     * Method that calculates the degree of a vertex.
     *
     * @param v - vertex to be inspected.
     * @return degree of a given vertex.
     */

    public int vertexDegree(int v) {
        int degree = 0;
        for(int i = 0; i < V; i++) {
            if(adj[v][i] == 1)  { degree++; }
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

    public int[] adjacent(int v) {
        int[] result = new int[V];
        int countAdj = 0;
        for(int i = 0; i < V; i++) {
            if(adj[v][i] == 1) {
                result[countAdj++] = i;
            }
        }
        return Arrays.copyOf(result, countAdj);
    }

    /**
     * Overridden toString method from the global superclass
     * Object that gives representation of a graph in a String.
     *
     * @return instance of a graph represented as a string.
     */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder((V + "Vertices and " + E + "Edges \n"));
        for(int i = 0; i < V; i++) {
            int[] traverse = adjacent(i);
            result.append(i).append(" : ");
            for(int j : traverse) {
                result.append(j).append(" ");
            }
            result.append("\n");
        }
        return (result.toString());
    }
}