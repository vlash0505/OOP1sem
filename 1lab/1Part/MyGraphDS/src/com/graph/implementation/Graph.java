package com.graph.implementation;

import java.util.Iterator;

public interface Graph {
    int V();
    int E();
    void addVertex(int data);
    void addEdge(int v, int w);
    int vertexDegree(int v);
    Iterator<Integer> adjacent(int v);
}
