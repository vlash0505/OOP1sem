package com.graph.path;

import com.graph.implementation.GraphAdjList;

/**
 * Class that finds a path(if it exists) between two vertices
 * in a graph using DFS.
 */

public class DepthFirstPath<T> extends BaseGraphPath<T> {

    /**
     * Constructor for pathfinding using DFS.
     *
     * @param G given graph.
     * @param s starting point
     */

    public DepthFirstPath(GraphAdjList<T> G, T s) {
        super(G, s);
        traverse(G, G.getIndexedVertices().indexOf(s));
    }

    /**
     * Recursive DFS method to traverse the graph.
     *
     * @param G given graph.
     * @param v index of a vertex that is being inspected.
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
}