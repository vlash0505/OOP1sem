package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class that finds a path(if it exists) between two vertices
 * in a graph using DFS.
 */

public class DepthFirstPath<T> {
    private boolean[] isVisited;
    private List<T> edgeTo;
    private final int s;

    /**
     * Constructor for pathfinding using DFS.
     *
     * @param G  given graph.
     * @param s  starting point
     */

    public DepthFirstPath(GraphAdjList<T> G, int s) {
        this.isVisited = new boolean[G.V()];
        this.edgeTo = new ArrayList<>();
        this.s = s;
        traverse(G, s);
    }

    /**
     * Recursive DFS method to traverse the graph.
     *
     * @param G  given graph
     * @param v  index of a vertex that is being inspected.
     */

    public void traverse(GraphAdjList<T> G, int v) {
        isVisited[v] = true;
        T toInspect = G.getIndexedVertices().get(v);
        //going through adjacent vertices to the vertex
        //we are currently inspecting.
        for (T w : G.getVertices().get(toInspect)) {
            int index = G.getIndexedVertices().indexOf(w);
            if (!isVisited[index]) {
                edgeTo.add(w);
                traverse(G, index);
            }
        }
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
        for (T x : edgeTo) { path.push(x); }
        return path;
    }
}