package com.graph.path;

import com.graph.implementation.GraphAdjList;
import java.util.Stack;

/**
 * Class that finds a path(if it exists) between two vertices
 * in a graph using DFS.
 */

public class DepthFirstPath implements Path{
    private boolean[] isVisited;
    private int[] edgeTo;
    private final int s;

    /**
     * Constructor for pathfinding using DFS.
     *
     * @param G - given graph.
     * @param s - starting point
     */

    public DepthFirstPath(GraphAdjList G, int s) {
        this.isVisited = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        traverse(G, s);
    }

    /**
     * Recursive DFS method to traverse the graph.
     *
     * @param G - given graph
     * @param v - vertex that is being inspected.
     */

    public void traverse(GraphAdjList G, int v) {
        isVisited[v] = true;
        for (int w : G.adj.get(v))
            if (!isVisited[w]) {
                edgeTo[w] = v;
                traverse(G, w);
            }
    }

    /**
     * Method that checks whether the path to the given
     * vertex exists.
     *
     * @param v - vertex to check
     *
     * @return true if the path exists, otherwise - false.
     */

    public boolean hasPathTo(int v) { return isVisited[v]; }

    /**
     * Method that researches traversed graph and
     * builds a path to the given vertex(if it exists).
     *
     * @param v - vertex to be reached.
     *
     * @return path to the vertex v from the source vertex
     * as the Iterable.
     */

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) { return null; }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) { path.push(x); }
        path.push(s);
        return path;
    }
}
