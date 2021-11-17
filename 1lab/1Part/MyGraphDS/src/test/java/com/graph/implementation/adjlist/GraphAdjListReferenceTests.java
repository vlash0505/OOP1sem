package com.graph.implementation.adjlist;

import com.graph.implementation.GraphAdjList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public abstract class GraphAdjListReferenceTests<T> extends GraphAdjListGenericTests<T> {

    @Test
    @DisplayName("Adding non null value and validating null presence in it(should return false)")
    public void nonNullValueAddedToEmptyGraph_HasVertexInvokedWithNull() {
        T valueToAdd = this.createSampleValue();
        GraphAdjList<T> G = new GraphAdjList<>();
        G.addVertex(valueToAdd);

        Assertions.assertFalse(G.hasVertex(null));
    }

    @Test
    @DisplayName("Adding null value and validating non null presence in it(should return false)")
    public void nullValueAddedToEmptyGraph_HasVertexInvokedWithNonNull() {
        T valueToAdd = this.createSampleValue();
        GraphAdjList<T> G = new GraphAdjList<>();
        G.addVertex(null);

        Assertions.assertFalse(G.hasVertex(valueToAdd));
    }

    @Test
    @DisplayName("Creating edge with one null value(should throw IllegalArgumentException)")
    public void edgeCreationInvokedWithOneNullValue() {
        T valueToAdd = this.createSampleValue();
        GraphAdjList<T> G = new GraphAdjList<>();

        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.addEdge(valueToAdd, null));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.hasEdge(valueToAdd, null));
    }

    @Test
    @DisplayName("Creating edge with two null value(should throw IllegalArgumentException)")
    public void edgeCreationInvokedWithTwoNullValues() {
        GraphAdjList<T> G = new GraphAdjList<>();

        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.addEdge(null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.hasEdge(null, null));
    }

    @Test
    @DisplayName("Deleting edge where one of vertices is a null value and another has edge(should throw IllegalArgumentException)")
    public void edgeDeletionInvokedWithOneNullValue_WithEdgeExisting() {
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        GraphAdjList<T> G = new GraphAdjList<>();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);

        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.removeEdge(valueToAdd, null));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.hasEdge(anotherValueToAdd, null));
    }

    @Test
    @DisplayName("Deleting edge where one of vertices is a null value and another doesnt has edge(should throw IllegalArgumentException)")
    public void edgeDeletionInvokedWithOneNullValue_WithoutEdgeExisting() {
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        GraphAdjList<T> G = new GraphAdjList<>();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);

        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.removeEdge(valueToAdd, null));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.removeEdge(null, valueToAdd));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.removeEdge(anotherValueToAdd, null));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.removeEdge(null, anotherValueToAdd));
    }

    @Test
    @DisplayName("Creating edge with two null values(there is edge in a graph) (should throw IllegalArgumentException)")
    public void edgeDeletionInvokedWithTwoNullValues_WithEdgeExisting() {
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        GraphAdjList<T> G = new GraphAdjList<>();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);
        G.addEdge(valueToAdd, anotherValueToAdd);

        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.removeEdge(null, null));
    }

    @Test
    @DisplayName("Deleting edge two null values(there is no edge in a graph) (should throw IllegalArgumentException)")
    public void edgeDeletionInvokedWithTwoNullValue_WithoutEdgeExisting() {
        GraphAdjList<T> G = new GraphAdjList<>();

        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.removeEdge(null, null));
    }

    @Test
    @DisplayName("Get all adjacent vertices to the null value(should throw IllegalArgumentException)")
    public void getAdjacentInvokedWithNullValue_NoVerticesInGraph() {
        GraphAdjList<T> G = new GraphAdjList<>();

        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.adjacent(null));
    }

    @Test
    @DisplayName("Get all adjacent vertices to the null value(should throw IllegalArgumentException)")
    public void getAdjacentInvokedWithNullValue_TwoVerticesInGraph() {
        T valueToAdd = this.createSampleValue();
        T anotherValueToAdd = this.createDifferentValue();
        GraphAdjList<T> G = new GraphAdjList<>();
        G.addVertex(valueToAdd);
        G.addVertex(anotherValueToAdd);

        Assertions.assertThrows(IllegalArgumentException.class, () ->  G.adjacent(null));
    }
}
