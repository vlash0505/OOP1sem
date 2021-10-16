package com.graph.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GraphAdjListTest {

    @Test
    @DisplayName("Bruh")
    void shouldInitializeGraph() {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        GraphAdjList<Integer> graph = new GraphAdjList<>(3,values);
        Assertions.assertEquals(3,graph.V());
    }

    @Test
    void testGetIndexedVertices() {

    }

    @Test
    void v() {
    }

    @Test
    void e() {
    }

    @Test
    void validateVertex() {
    }

    @Test
    void getVertices() {
    }

    @Test
    void addVertex() {
    }

    @Test
    void removeVertex() {
    }

    @Test
    @DisplayName("Should add edge to graph.")
    void addEdge() {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        GraphAdjList<Integer> graph = new GraphAdjList<>(3,values);
        graph.addEdge(1, 2);


    }

    @Test
    void removeEdge() {
    }

    @Test
    void vertexDegree() {
    }

    @Test
    void isConnected() {
    }

    @Test
    void adjacent() {
    }

    @Test
    void testToString() {
    }
}