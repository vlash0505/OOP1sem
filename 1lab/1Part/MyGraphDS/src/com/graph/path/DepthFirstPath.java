package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.Stack;

/**
 * Class that finds a path between two vertices in a
 * graph using DFS.
 */

public class DepthFirstPath {
    private boolean[] marked; // Has dfs() been called for this vertex?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source

    public DepthFirstPath(GraphAdjList G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        //dfs(G, s);
    }

    /**private void dfs(MyGraphDS G, int v)
    {
        marked[v] = true;
        for (int w : G.adj.get(v))
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
    }
     **/

    public boolean hasPathTo(int v)
    { return marked[v]; }

    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
