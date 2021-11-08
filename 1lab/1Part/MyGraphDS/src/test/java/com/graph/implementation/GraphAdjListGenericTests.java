package com.graph.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public abstract class GraphAdjListGenericTests<T> {

    @Test
    @DisplayName("Should add vertex to the graph")
    void shouldAddVertex() {
        GraphAdjList<T> G = new GraphAdjList<>();
        Assertions.assertEquals(0, G.V());
        T valueToAdd = this.createSampleValue();
        G.addVertex(valueToAdd);

        Assertions.assertEquals(1, G.V());
        Assertions.assertTrue(G.hasVertex(valueToAdd));
    }

    @Test
    @DisplayName("Should remove vertex from the graph")
    void shouldRemoveVertex() {
        GraphAdjList<T> G = new GraphAdjList<>();
        T valueToAdd = this.createSampleValue();
        G.addVertex(valueToAdd);
        G.removeVertex(valueToAdd);

        Assertions.assertEquals(0, G.V());
        Assertions.assertFalse(G.hasVertex(valueToAdd));
    }

    @Test
    @DisplayName("Should add edge to the graph")
    void shouldAddEdge() {
        GraphAdjList<T> G = new GraphAdjList<>();
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);

        Assertions.assertEquals(1, G.E());
        Assertions.assertTrue(G.hasEdge(valueToAdd, anotherValueToAdd));
    }

    @Test
    @DisplayName("Should remove edge from the graph")
    void shouldRemoveEdge() {
        GraphAdjList<T> G = new GraphAdjList<>();
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);
        G.removeEdge(valueToAdd, anotherValueToAdd);

        Assertions.assertEquals(0, G.E());
        Assertions.assertFalse(G.hasEdge(valueToAdd, anotherValueToAdd));
    }

    @Test
    @DisplayName("Should check whether graph is connected (graph is connected)")
    void shouldEnsureConnection() {
        GraphAdjList<T> G = new GraphAdjList<>();
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        T andAnotherValueToAdd = this.createDifferentValue();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addVertex(andAnotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);
        G.addEdge(valueToAdd, andAnotherValueToAdd);

        Assertions.assertEquals(2, G.E());
        Assertions.assertTrue(G.isConnected());
    }

    @Test
    @DisplayName("Should check whether graph is connected (graph is not connected)")
    void shouldRefuteConnection() {
        GraphAdjList<T> G = new GraphAdjList<>();
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        T andAnotherValueToAdd = this.createDifferentValue();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addVertex(andAnotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);

        Assertions.assertEquals(1, G.E());
        Assertions.assertFalse(G.isConnected());
    }

    protected abstract T createSampleValue();

    protected abstract T createDifferentValue();
}
