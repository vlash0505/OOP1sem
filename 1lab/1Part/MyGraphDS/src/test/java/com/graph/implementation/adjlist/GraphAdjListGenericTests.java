package com.graph.implementation.adjlist;

import com.graph.implementation.GraphAdjList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public abstract class GraphAdjListGenericTests<T> {

    @Test
    @DisplayName("Should initialize empty graph instance")
    void shouldInitEmptyGraph() {
        GraphAdjList<T> G = new GraphAdjList<>();

        Assertions.assertNotNull(G);
        Assertions.assertEquals(G.V(), 0);
        Assertions.assertEquals(G.E(), 0);
    }

    @Test
    @DisplayName("Should initialize graph instance and fill it with passed parameters")
    void shouldInitGraph() {
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();

        GraphAdjList<T> G = new GraphAdjList<>(2, List.of(valueToAdd, anotherValueToAdd));

        Assertions.assertNotNull(G);
        Assertions.assertEquals(G.V(), 2);
        Assertions.assertTrue(G.hasVertex(valueToAdd));
        Assertions.assertTrue(G.hasVertex(anotherValueToAdd));
    }

    @Test
    @DisplayName("Should add vertex to the graph")
    void shouldAddVertex() {
        GraphAdjList<T> G = new GraphAdjList<>();
        Assertions.assertEquals(0, G.V());
        T valueToAdd = this.createSampleValue();
        G.addVertex(valueToAdd);

        Assertions.assertEquals(1, G.V());
        Assertions.assertTrue(G.hasVertex(valueToAdd));
        Assertions.assertTrue(G.getVertices().containsKey(valueToAdd));
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
        Assertions.assertFalse(G.getVertices().containsKey(valueToAdd));
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

    @Test
    @DisplayName("Should get the vertex degree.")
    void shouldGetVertexDegree() {
        GraphAdjList<T> G = new GraphAdjList<>();
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        T andAnotherValueToAdd = this.createDifferentValue();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addVertex(andAnotherValueToAdd);

        Assertions.assertEquals(0, G.vertexDegree(valueToAdd));
        G.addEdge(valueToAdd, anotherValueToAdd);
        Assertions.assertEquals(1, G.vertexDegree(valueToAdd));
        G.addEdge(valueToAdd, andAnotherValueToAdd);
        Assertions.assertEquals(2, G.vertexDegree(valueToAdd));

        G.removeEdge(valueToAdd, anotherValueToAdd);
        Assertions.assertEquals(1, G.vertexDegree(valueToAdd));
    }

    @Test
    @DisplayName("Should get all the adjacent vertices to the given one.")
    void shouldGetAdjacentVertices() {
        GraphAdjList<T> G = new GraphAdjList<>();
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        T andAnotherValueToAdd = this.createDifferentValue();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addVertex(andAnotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);

        G.addEdge(valueToAdd, anotherValueToAdd);
        Assertions.assertEquals(1, G.adjacent(valueToAdd).size());
        Assertions.assertTrue(G.adjacent(valueToAdd).contains(anotherValueToAdd));
        Assertions.assertFalse(G.adjacent(valueToAdd).contains(andAnotherValueToAdd));

        G.addEdge(valueToAdd, andAnotherValueToAdd);
        Assertions.assertEquals(2, G.adjacent(valueToAdd).size());
        Assertions.assertTrue(G.adjacent(valueToAdd).contains(anotherValueToAdd));
        Assertions.assertTrue(G.adjacent(valueToAdd).contains(andAnotherValueToAdd));

        G.removeEdge(valueToAdd, anotherValueToAdd);
        Assertions.assertEquals(1, G.adjacent(valueToAdd).size());
        Assertions.assertFalse(G.adjacent(valueToAdd).contains(anotherValueToAdd));
        Assertions.assertTrue(G.adjacent(valueToAdd).contains(andAnotherValueToAdd));
    }

    protected abstract T createSampleValue();

    protected abstract T createDifferentValue();
}
