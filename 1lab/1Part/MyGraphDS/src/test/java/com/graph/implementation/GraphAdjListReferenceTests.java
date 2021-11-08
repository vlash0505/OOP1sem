package com.graph.implementation;

import org.junit.jupiter.api.Assertions;

public abstract class GraphAdjListReferenceTests<T> extends GraphAdjListGenericTests<T> {
    public void ValueAddedToEmptyList_ContainsInvokedWithNull_ReturnsFalse() {
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createSampleValue();
        GraphAdjList<T> G = new GraphAdjList<>();

        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);

        Assertions.assertTrue(G.hasEdge(valueToAdd, anotherValueToAdd));
    }

    public void NullAddedToEmptyList_ContainsInvokedWithNonNull_ReturnsFalse() {
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createSampleValue();
        GraphAdjList<T> G = new GraphAdjList<>();

        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);

        Assertions.assertTrue(G.hasEdge(valueToAdd, anotherValueToAdd));

        G.removeEdge(valueToAdd, anotherValueToAdd);

        Assertions.assertFalse(G.hasEdge(valueToAdd, anotherValueToAdd));
    }
}
