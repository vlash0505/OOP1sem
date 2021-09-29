package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class that finds a path between two vertices in a
 * graph using BFS.
 */

public class BreadthFirstPath {
    private boolean[] isVisited;
    private int[] edgeTo;
    private final int s;

    /**
     * Constructor for pathfinding using BFS.
     *
     * @param G - given graph.
     * @param s - starting point
     */

    public BreadthFirstPath(GraphAdjList G, int s) {
        isVisited = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    /**
     * Iterative BFS method to traverse the graph.
     *
     * @param G - given graph.
     * @param s - starting vertex.
     */

    private void bfs(GraphAdjList G, int s) {
        //Using Queue interface and Linked List class
        //to implement queue.
        Queue<Integer> queue = new LinkedList<>();
        isVisited[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj.get(v))
                if (!isVisited[w]) {
                    edgeTo[w] = v;
                    isVisited[w] = true;
                    queue.offer(w);
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
