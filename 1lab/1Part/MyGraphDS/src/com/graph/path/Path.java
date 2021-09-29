package com.graph.path;

import com.graph.implementation.GraphAdjList;

public interface Path {
    void traverse(GraphAdjList G, int v);
    boolean hasPathTo(int v);
    Iterable<Integer> pathTo(int v);
}
