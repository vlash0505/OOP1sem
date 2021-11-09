package com.graph.path;

import com.graph.implementation.GraphAdjList;

import java.util.*;

public class ShortestPath<T> extends BaseGraphPath<T> {
    private final T destination;

    private int[] dist;
    private final Map<Integer, T> predecessors;

    /**
     * Constructor for a GraphPath.
     *
     * @param G      given graph.
     * @param source starting vertex(source).
     */
    public ShortestPath(GraphAdjList<T> G, T source, T destination) {
        super(G, source);
        this.dist = new int[G.V()];
        this.predecessors = new HashMap<>();
        this.destination = destination;
    }

    public boolean traverse() {
        int currentIndex = G.getIndexedVertices().indexOf(source);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < G.V(); i++) { dist[i] = Integer.MAX_VALUE; }
        isVisited[currentIndex] = true;
        dist[currentIndex] = 0;
        queue.offer(currentIndex);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            T toInspect = G.getIndexedVertices().get(v);
            int indexOfInspecting = G.getIndexedVertices().indexOf(toInspect);

            for (T w : G.adjacent(toInspect)) {

                int index = G.getIndexedVertices().indexOf(w);
                if (!isVisited[index]) {
                    isVisited[index] = true;
                    dist[index] = (dist[indexOfInspecting] + 1);
                    predecessors.put(index, toInspect);
                    queue.offer(index);
                    if(w.equals(destination)) {
                        return true;
                    }
                    edgeTo.add(w);
                }
            }
        }
        return false;
    }

    public Stack<T> getShortestPath() {
        if(!traverse()) { return new Stack<>(); }
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
