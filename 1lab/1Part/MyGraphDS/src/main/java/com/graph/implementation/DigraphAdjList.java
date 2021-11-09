package com.graph.implementation;

import java.util.List;

public class DigraphAdjList<T> extends GraphAdjList<T>{

    public DigraphAdjList() {
        super();
    }

    public DigraphAdjList(int V, List<T> elements) {
        super(V, elements);
    }

    @Override
    public void addEdge(T v, T w) {
        this.getVertices().get(v).add(w);
    }
}