package com.graph.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GraphAdjListTest {

    @Test
    @DisplayName("Should initialize and add vertex to the graph")
    void shouldAddVertex() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);

        Assertions.assertEquals(1,graph.V());
        Assertions.assertEquals(0,graph.E());
        Assertions.assertTrue(graph.getIndexedVertices().contains(1));
        Assertions.assertTrue(graph.getVertices().containsKey(1));
    }

    @Test
    @DisplayName("Should remove vertex from the graph")
    void shouldRemoveVertex() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        Assertions.assertEquals(1,graph.V());

        graph.removeVertex(1);
        Assertions.assertEquals(0,graph.V());
        Assertions.assertFalse(graph.getIndexedVertices().contains(1));
        Assertions.assertFalse(graph.getVertices().containsKey(1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> graph.removeVertex(1));
    }

    @Test
    @DisplayName("Should initialize and add edge to the graph")
    void shouldAddEdge() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1, 2);

        Assertions.assertEquals(2,graph.V());
        Assertions.assertEquals(1,graph.E());
        Assertions.assertTrue(graph.getVertices().get(1).contains(2));
        Assertions.assertTrue(graph.getVertices().get(2).contains(1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            graph.addEdge(1, 3);
            graph.addEdge(4, 3);
            graph.addEdge(3, 1);
        });
    }

    @Test
    @DisplayName("Should remove edge from the graph")
    void shouldRemoveEdge() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1,2);
        Assertions.assertEquals(1,graph.E());
        Assertions.assertTrue(graph.getVertices().get(1).contains(2));
        Assertions.assertTrue(graph.getVertices().get(2).contains(1));

        graph.removeEdge(1,2);
        Assertions.assertEquals(0,graph.E());
        Assertions.assertFalse(graph.getVertices().get(1).contains(2));
        Assertions.assertFalse(graph.getVertices().get(2).contains(1));
    }

    @Test
    @DisplayName("Should remove edge from the graph")
    void shouldReturnAllAdjacentVertices() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1,2);
        Assertions.assertEquals(1,graph.E());

        graph.removeEdge(1,2);
        Assertions.assertEquals(0,graph.E());
        Assertions.assertFalse(graph.getVertices().get(1).contains(2));
        Assertions.assertFalse(graph.getVertices().get(2).contains(1));
    }

    @Test
    @DisplayName("Should ensure vertex degree")
    void shouldEnsureVertexDegree() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        Assertions.assertEquals(0,graph.vertexDegree(1));
        graph.addEdge(1, 2);
        Assertions.assertEquals(1,graph.vertexDegree(1));
        graph.addEdge(1, 3);
        Assertions.assertEquals(2,graph.vertexDegree(1));

        graph.removeEdge(1,3);
        Assertions.assertEquals(1,graph.vertexDegree(1));
    }

    @Test
    @DisplayName("Should check whether graph is connected")
    void shouldCheckConnection() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        Assertions.assertFalse(graph.isConnected(graph));

        graph.addEdge(1,2);
        Assertions.assertFalse(graph.isConnected(graph));
        graph.addEdge(2,3);
        Assertions.assertFalse(graph.isConnected(graph));
        graph.addEdge(3,4);
        Assertions.assertTrue(graph.isConnected(graph));

        graph.removeEdge(2,3);
        Assertions.assertFalse(graph.isConnected(graph));
    }
}