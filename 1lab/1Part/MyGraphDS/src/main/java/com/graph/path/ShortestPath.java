package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class ShortestPath<T> extends BaseGraphPath<T> {
    private final T destination;
    private final Map<Integer, T> predecessors;

    /**
     * Constructor for a GraphPath.
     *
     * @param G      given graph.
     * @param source starting vertex(source).
     */
    public ShortestPath(GraphAdjList<T> G, T source, T destination) {
        super(G, source);
        //this.dist = new int[G.V()];
        this.predecessors = new HashMap<>();
        this.destination = destination;
        traverseForPath();
    }

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
