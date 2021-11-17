package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Class that represents finding the shortest
 * path using simplified Dijkstra in its core
 * logic.
 *
 * @param <T> data that is stored in the graph's
 *            vertices.
 */

public class ShortestPath<T> extends BaseGraphPath<T> {
    private final T destination;
    //index of the element corresponding to its
    //element accordingly.
    private final Map<Integer, T> predecessors;

    /**
     * Constructor for a GraphPath.
     *
     * @param G      given graph.
     * @param source starting vertex(source).
     */

    public ShortestPath(GraphAdjList<T> G, T source, T destination) {
        super(G, source);
        this.predecessors = new HashMap<>();
        this.destination = destination;
        traverseForPath();
    }

    /**
     * Traversing the graph and filling the predecessors
     * field to form the shortest path in the future.
     */

    public void traverseForPath() {
        int currentIndex = G.getIndexedVertices().indexOf(source);
        Queue<Integer> queue = new LinkedList<>();

        isVisited[currentIndex] = true;
        queue.offer(currentIndex);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            T toInspect = G.getIndexedVertices().get(v);
            for (T w : G.adjacent(toInspect)) {

                int index = G.getIndexedVertices().indexOf(w);
                if (!isVisited[index]) {
                    isVisited[index] = true;
                    //adding the predecessor
                    predecessors.put(index, toInspect);
                    queue.offer(index);
                    if(w.equals(destination)) {
                        return;
                    }
                    edgeTo.add(w);
                }
            }
        }
    }

    /**
     * Method that collects the shortest path
     * based on information it got in traverseForPath
     * method.
     *
     * @return shortest path represented as stack.
     */

    public Stack<T> getShortestPath() {
        Stack<T> path = new Stack<>();

        int index = G.getIndexedVertices().indexOf(destination);
        while(predecessors.get(index) != null) {
            if(predecessors.get(index).equals(source)) { break; }
            path.push(predecessors.get(index));
            index = G.getIndexedVertices().indexOf(predecessors.get(index));
        }
        return path;
    }
}
