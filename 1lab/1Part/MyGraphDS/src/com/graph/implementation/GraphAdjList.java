package com.graph.implementation;

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

public class GraphAdjList<T> implements Graph{
    private int V;
    private int E;
    private List<ArrayList<Integer>> adj;

    /**
     * Constructor without parameters for a Graph
     * data structure.
     */

    public GraphAdjList() {
        this.adj = new ArrayList<>();
    }

    /**
     * Constructor for a Graph data structure.
     *
     * @param V - initial number of vertices.
     */

    public GraphAdjList(int V) {
        this.V = V;
        this.adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>(1));
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

    public GraphAdjList(File f) throws FileNotFoundException {
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
        adj.add(new ArrayList<>());
        adj.get(++V).add(data);
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

    public int vertexDegree(int v) {
        //using iterator to go through the list.
        Iterator<Integer> i = adjacent(v);
        int degree = 0;
        //iterating through each vertex while counting
        //number of connected vertices.
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
     * Overridden toString method from the global superclass
     * Object that gives representation of a graph in a String.
     *
     * @return instance of a graph represented as a string.
     */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder((V + "Vertices and " + E + "Edges \n"));
        for(int v = 0; v < V; v++) {
            result.append(v).append(": ");
            Iterator<Integer> i = adjacent(v);
            while(i.hasNext()) {
                result.append(i).append(" ");
                i.next();
            }
            result.append("\n");
        }
        return (result.toString());
    }
}