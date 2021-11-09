package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.*;

/**
 * Class that finds a path between two vertices in a
 * graph using BFS.
 */

public class BreadthFirstPath<T>  extends BaseGraphPath<T> {
    /**
     * Constructor for pathfinding using BFS.
     *
     * @param G        given graph.
     * @param source   starting point.
     */

    public BreadthFirstPath(GraphAdjList<T> G, T source) {
        super(G, source);
        traverse(G, source);
    }

    /**
     * Iterative BFS method to traverse the graph.
     *
     * @param G   given graph.
     * @param s   starting vertex.
     */

    public void traverse(GraphAdjList<T> G, T s) {
        int currentIndex = G.getIndexedVertices().indexOf(s);
        Queue<Integer> queue = new LinkedList<>();

        isVisited[currentIndex] = true;
        queue.offer(currentIndex);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            T toInspect = G.getIndexedVertices().get(v);

            for (T w : G.adjacent(toInspect)) {

                int index = G.getIndexedVertices().indexOf(w);
                if (!isVisited[index]) {
                    edgeTo.add(w);
                    isVisited[index] = true;
                    queue.offer(index);
                }
            }

        }
    }
}