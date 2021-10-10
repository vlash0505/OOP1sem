package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Base class for BFS and DFS.
 *
 * @param <T> data that is stored in a graph's vertex.
 */

public class GraphPath<T> {
    protected boolean[] isVisited;
    protected List<T> edgeTo;
    private final T s;

    /**
     * Constructor for a GraphPath.
     *
     * @param G    given graph.
     * @param s    starting vertex(source).
     */

    public GraphPath(GraphAdjList<T> G, T s) {
        this.isVisited = new boolean[G.V()];
        this.edgeTo = new ArrayList<>();
        this.s = s;
    }

    /**
     * Method that returns boolean array that to each
     * index of the vertex respectfully assigns 1 if
     * the vertex has path to the source, 0 - if not.
     *
     * @return  boolean array that contains information
     *          about reachable vertices from the source.
     */

    public boolean[] getConnection() {
        return this.isVisited;
    }

    /**
     * Method that checks whether the path to the given
     * vertex exists.
     *
     * @param G       Given graph.
     * @param element Vertex that we want to check the path exists
     *                to from the source vertex.
     *
     * @return true if the path exists, otherwise - false.
     */

    public boolean hasPathTo(GraphAdjList<T> G, T element) {
        return isVisited[G.getIndexedVertices().indexOf(element)];
    }

    /**
     * Method that researches traversed graph and
     * builds a path to the given vertex(if it exists).
     *
     * @param G       Given graph.
     * @param element Vertex that we want to get path to
     *                from the source vertex.
     *
     * @return path to the vertex v from the source vertex
     * as the Iterable.
     */

    public Iterable<T> pathTo(GraphAdjList<T> G, T element) {
        if(!hasPathTo(G, element)) { return null; }
        Stack<T> path = new Stack<>();
        path.push(s);
        for (T x : edgeTo) { path.push(x); }
        //path.push(s);
        return path;
    }
}