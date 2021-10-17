package com.graph.path;

import com.graph.implementation.GraphAdjList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstPathTest {

    @Test
    void shouldDoSmth() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1,2);
        graph.addEdge(2,4);

        DepthFirstPath<Integer> path = new DepthFirstPath<>(graph,1);
        Assertions.assertTrue(path.hasPathTo(graph,4));
        Assertions.assertTrue(path.hasPathTo(graph,2));
        Assertions.assertFalse(path.hasPathTo(graph,3));
    }
}