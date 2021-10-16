package com.graph.implementation;

import java.util.List;

public class DigraphAdjList<T>{
    GraphAdjList<T> graph;

    public DigraphAdjList() {
        graph = new GraphAdjList<>();
    }

    public DigraphAdjList(int V, List<T> elements) {
        graph = new GraphAdjList<>(V, elements);
    }

    public void addEdge(T v, T w) {
        graph.getVertices().get(v).add(w);
    }
}