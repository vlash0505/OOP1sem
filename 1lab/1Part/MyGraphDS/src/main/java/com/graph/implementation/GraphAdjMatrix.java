package com.graph.implementation;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Class that creates an instance of a graph
 * and implements basic operations on graph
 * data structure that is represented as
 * adjacency matrix.
 */

public class GraphAdjMatrix<T> extends  BaseGraph<T>{
    private int[][] adj;

    /**
     * Constructor without parameters for a Graph
     * data structure represented as adjacency matrix.
     */

    public GraphAdjMatrix() {
        super();
        this.adj = new int[1][1];
    }

    /**
     * Constructor without parameters for a Graph
     * data structure represented as adjacency matrix.
     *
     * @param V  initial number of vertices
     */

    public GraphAdjMatrix(int V, List<T> values) {
        super(V, values);
        this.adj = new int[V][V];
    }

    /**
     * Resizing the adjacency matrix.
     * (Old size) * 2 when we are exceeding the initial array.
     * (Old size) / 2 when we are going to use only 1/4 of initial
     *                array.
     *
     * @param newSize  size of the new 2D array.
     */

    public void resize(int newSize) {
        int[][] newArr = new int[newSize][newSize];
        for(int i = 0; i < V; i++) { newArr[i] = adj[i].clone(); }
        adj = newArr;
    }

    /**
     * Utility method that checks whether edge between two
     * vertices exist.
     *
     * @param v first vertex
     * @param w second vertex
     *
     * @return true if there is an edge, otherwise - false.
     */

    public boolean hasEdge(T v, T w) {
        return (adj[indexedVertices.indexOf(v)][indexedVertices.indexOf(w)] == 1);
    }

    /**
     * Method that adds vertex to the graph.
     *
     * @param data  data to be stored in a new
     *             vertex.
     */

    public void addVertex(T data) {
        if(indexedVertices.contains(data)) {
            System.out.println("Graph already contains element you are trying to add.");
            return;
        }
        if(V == adj.length) { resize(V * 2); }
        indexedVertices.add(data);
        V++;
    }

    /**
     * Method that removes vertex from the graph.
     */

    public void removeVertex(T toBeRemoved) {
        validateVertex(toBeRemoved);
        if(V == (adj.length / 4)) { resize(V / 2); }

        int shiftFrom = indexedVertices.indexOf(toBeRemoved);
        indexedVertices.remove(toBeRemoved);

        while(shiftFrom < V) {
            for(int i = 0; i < V; i++) {
                //shifting rows
                adj[i][shiftFrom] = adj[i][shiftFrom + 1];
                //shifting columns
                adj[shiftFrom][i] = adj[shiftFrom + 1][i];
            }
        }
    }

    /**
     * Method that adds edge to a graph (connects
     * two vertices).
     *
     * @param v  first vertex.
     * @param w  second vertex.
     */

    public void addEdge(T v, T w) {
        validateVertex(v);
        validateVertex(w);
        int firstIndex = indexedVertices.indexOf(v);
        int secondIndex = indexedVertices.indexOf(w);
        if(hasEdge(v, w)) { return; }

        adj[firstIndex][secondIndex] = 1;
        adj[secondIndex][firstIndex] = 1;
        E++;
    }

    /**
     * Method that deletes an edge in a graph.(deletes
     * connection between two vertices)
     *
     * @param v  first vertex.
     * @param w  second vertex.
     */

    public void removeEdge(T v, T w) {
        validateVertex(v);
        validateVertex(w);
        int firstIndex = indexedVertices.indexOf(v);
        int secondIndex = indexedVertices.indexOf(w);
        if(!hasEdge(v, w)) { return; }

        adj[firstIndex][secondIndex] = 0;
        adj[secondIndex][firstIndex] = 0;
        E--;
    }

    /**
     * Method that calculates the degree of a vertex.
     *
     * @param v  vertex to be inspected.
     * @return degree of a given vertex.
     */

    public int vertexDegree(T v) {
        validateVertex(v);
        int vertex = indexedVertices.indexOf(v);
        int degree = 0;
        for(int i = 0; i < V; i++) {
            if(adj[vertex][i] == 1) { degree++; }
        }
        return degree;
    }

    /**
     * Method that collects and returns all the
     * adjacent vertices to the given one.
     *
     * @param v  vertex to be inspected.
     * @return all the adjacent vertices to v.
     */

    public List<T> adjacent(T v) {
        validateVertex(v);
        int[] row = adj[indexedVertices.indexOf(v)];
        return indexedVertices.stream()
                              .filter(i -> row[indexedVertices.indexOf(i)] == 1)
                              .collect(Collectors.toList());
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
            result.append(indexedVertices.get(i));
            result.append(" : ");
            result.append(this.adjacent(indexedVertices.get(i)));
        }
        return (result.toString());
    }
}