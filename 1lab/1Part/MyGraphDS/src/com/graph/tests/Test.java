package com.graph.tests;

import com.graph.implementation.*;
import com.graph.path.*;
import com.graph.frame.*;

public class Test {
    public static void main(String[] args) {
        GraphAdjList graphInstance = new GraphAdjList();
        graphInstance.addVertex(1);
        graphInstance.addVertex(2);
        graphInstance.addVertex(3);
        graphInstance.addVertex(4);

        graphInstance.addEdge(1,3);
        graphInstance.addEdge(2,3);

        DepthFirstPath path = new DepthFirstPath(graphInstance, 1);
        path.hasPathTo(2);
        //path.pathTo(2);

        //testing
        //yet to be implemented
    }
}
