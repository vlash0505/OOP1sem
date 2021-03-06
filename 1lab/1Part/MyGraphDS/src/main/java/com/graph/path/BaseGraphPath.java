package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Base class for graph traversals.
 * Can be extended.
 *
 * @param <T> data that is stored in a graph's vertex.
 */

public abstract class BaseGraphPath<T> {
    protected boolean[] isVisited;
    protected List<T> edgeTo;
    protected GraphAdjList<T> G;
    protected final T source;

    /**
     * Constructor for a GraphPath.
     *
     * @param G         given graph.
     * @param source    starting vertex(source).
     */

    public BaseGraphPath(GraphAdjList<T> G, T source) {
        this.isVisited = new boolean[G.V()];
        this.edgeTo = new ArrayList<>();
        this.G = G;
        this.source = source;
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
     * @param destination Vertex that we want to check the path exists
     *                    to from the source vertex.
     *
     * @return true if the path exists, otherwise - false.
     */

    public boolean hasPathTo(T destination) {
        return isVisited[G.getIndexedVertices().indexOf(destination)];
    }

    /**
     * Method that researches traversed graph and
     * builds a path to the given vertex(if it exists).
     *
     * @param destination Vertex that we want to get path to
     *                    from the source vertex.
     *
     * @return path to the vertex v from the source vertex
     * as the Iterable.
     */

    public Stack<T> pathTo(T destination) {
        if(!hasPathTo(destination)) { return new Stack<>(); }
        Stack<T> path = new Stack<>();
        path.push(source);
        for (T x : edgeTo) { path.push(x); }
        return path;
    }
}