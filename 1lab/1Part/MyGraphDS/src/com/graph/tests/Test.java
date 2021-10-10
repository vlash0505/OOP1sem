package com.graph.tests;

import com.graph.implementation.*;
import com.graph.path.*;
import com.graph.frame.*;

public class Test {
    public static void main(String[] args) {
        GraphAdjList<This> graphInstance = new GraphAdjList<>();

        This vertex1 = new This("bruh1");
        This vertex2 = new This("bruh2");
        This vertex3 = new This("bruh3");
        This vertex4 = new This("bruh4");

        graphInstance.addVertex(vertex1);
        graphInstance.addVertex(vertex2);
        graphInstance.addVertex(vertex3);
        graphInstance.addVertex(vertex4);

        graphInstance.addEdge(vertex1, vertex2);
        graphInstance.addEdge(vertex1, vertex3);

        System.out.println(graphInstance.toString());

        DepthFirstPath<This> testPath = new DepthFirstPath<>(graphInstance, vertex2);
        System.out.println(testPath.hasPathTo(graphInstance, vertex3));

        Iterable<This> tesssttt  = testPath.pathTo(graphInstance,vertex3);

        for(This bruh : tesssttt) {
            System.out.println(bruh);
        }

        //DepthFirstPath path = new DepthFirstPath(graphInstance, 1);
        //path.hasPathTo(2);
        //path.pathTo(2);

        //testing
        //yet to be implemented
    }
}
