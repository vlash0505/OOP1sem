package com.graph.implementation;

import java.util.List;

/**
 * Class that represents directed graph
 * using adjacency list.
 * Is extended from GraphAdjList class(as it's
 * extended from Base Graph accordingly).
 *
 * @param <T> data to be stored in a vertex.
 */

public class DigraphAdjList<T> extends GraphAdjList<T>{

    /**
     * Constructor for directed graph instance
     * without parameters.
     */

    public DigraphAdjList() {
        super();
    }

    /**
     * Constructor for a directed graph instance.
     *
     * @param V         number of vertices.
     * @param elements  data to be stored in a vertices.
     */

    public DigraphAdjList(int V, List<T> elements) {
        super(V, elements);
    }

    /**
     * Method that implements edge addition.
     *
     * @param v  first vertex(direction from it).
     * @param w  second vertex(direction to it).
     */

    @Override
    public void addEdge(T v, T w) {
        this.getVertices().get(v).add(w);
    }
}