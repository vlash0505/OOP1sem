package com.graph.implementation;

public class DigraphAdjList<T>{
    GraphAdjList<T> graph;

    public DigraphAdjList() {
        graph = new GraphAdjList<>();
    }

    public void addEdge(T v, T w) {
        graph.getVertices().get(v).add(w);
    }
}
