package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.*;

/**
 * Class that finds a path between two vertices in a
 * graph using BFS.
 */

public class BreadthFirstPath<T> {
    private boolean[] isVisited;
    private List<T> edgeTo;
    //source vertex
    private final T s;

    /**
     * Constructor for pathfinding using BFS.
     *
     * @param G   given graph.
     * @param s   starting point.
     */

    public BreadthFirstPath(GraphAdjList<T> G, T s) {
        isVisited = new boolean[G.V()];
        edgeTo = new ArrayList<>();
        this.s = s;
        traverse(G, s);
    }

    /**
     * Iterative BFS method to traverse the graph.
     *
     * @param G   given graph.
     * @param s   starting vertex.
     */

    public void traverse(GraphAdjList<T> G, T s) {
        //Using Queue interface and Linked List class
        //to implement queue.
        int currentNodeIndex = G.getIndexedVertices().indexOf(s);
        Queue<Integer> queue = new LinkedList<>();
        isVisited[currentNodeIndex] = true;
        queue.offer(currentNodeIndex);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (T w : G.getVertices().get(s)) {
                int index = G.getIndexedVertices().indexOf(w);
                if (!isVisited[index]) {
                    edgeTo.add(w);
                    isVisited[index] = true;
                    queue.offer(index);
                }
            }
        }
    }

    /**
     * Method that checks whether the path to the given
     * vertex exists.
     *
     * @param v - vertex to check.
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
     * @param v - vertex to be reached.
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
