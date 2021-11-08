package com.graph.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for the graph data structure representation.
 *
 * @param <T> type of data that is stored in a graph's vertex.
 */

public class BaseGraph<T> {
    protected List<T> indexedVertices;
    protected int V;
    protected int E;

    /**
     * Constructor for a base graph DS without parameters.
     */

    public BaseGraph() {
        this.V = 0;
        this.E = 0;
        this.indexedVertices = new ArrayList<>();
    }

    /**
     * Constructor for a base graph DS.
     *
     * @param V               initial number of vertices.
     * @param indexedVertices data that will be stored in vertices.
     */

    public BaseGraph(int V, List<T> indexedVertices) {
        this.V = V;
        this.E = 0;
        this.indexedVertices = new ArrayList<>();
        this.indexedVertices.addAll(indexedVertices);
    }

    /**
     * Utility method that validates user input
     * and checks whether the vertex is present in a
     * graph.
     *
     * @param t vertex to be checked.
     * @throws IllegalArgumentException if the vertex is not
     * present in a graph.
     */

    public void validateVertex(T t) throws IllegalArgumentException{
        if(!indexedVertices.contains(t)) { throw new IllegalArgumentException("No such vertex found."); }
    }

    /**
     * Method that returns graph's vertices as List.
     *
     * @return Graph's vertices as List.
     */

    public List<T> getIndexedVertices() {
        return indexedVertices;
    }

    /**
     * Method that returns number of vertices in an
     * instance of a graph.
     *
     * @return number of vertices in a Graph.
     */

    public int V() { return V; }

    /**
     * Method that returns number of edges in an
     * instance of a graph.
     *
     * @return number of edges in a graph instance.
     */

    public int E() { return E; }

    public boolean hasVertex(T v) {
        return this.getIndexedVertices().contains(v);
    }
}