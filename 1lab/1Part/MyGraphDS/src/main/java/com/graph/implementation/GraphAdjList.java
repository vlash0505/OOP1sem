package com.graph.implementation;

import com.graph.path.DepthFirstPath;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Class that creates an instance of a graph
 * and implements basic operations on graph
 * data structure.
 * Class uses generic data types.
 *
 * @param <T>   Elements to be stored in the
 *              graph's edges.
 */

public class GraphAdjList<T> extends BaseGraph<T> {

    protected final Map<T, List<T>> vertices;

    /**
     * Constructor without parameters for a Graph
     * data structure.
     */

    public GraphAdjList() {
        super();
        this.vertices = new HashMap<>();
    }

    /**
     * Constructor for a Graph data structure.
     *
     * @param V  initial number of vertices.
     */

    public GraphAdjList(int V, List<T> elements) {
        super(V, elements);
        this.vertices = new HashMap<>(V);
        for(int i = 0; i < V; i++) { vertices.put(elements.get(i), new ArrayList<>()); }
    }

    /**
     * Method that gets all the graph's vertices(and adjacent
     * to each of them)
     *
     * @return graph as adjacency list.(in that case - HashMap)
     */

    public Map<T, List<T>> getVertices() { return vertices; }

    /**
     * Method that adds vertex to the graph.
     *
     * @param data  data to be stored in a new vertex.
     */

    public void addVertex(T data) {
        if(data == null) {return;}
        if(vertices.containsKey(data)) {
            System.out.println("Graph already contains element you are trying to add.");
            return;
        }
        vertices.put(data, new ArrayList<>());
        indexedVertices.add(data);
        V++;
    }

    /**
     * Method that removes vertex from the graph.
     *
     * @param w  vertex to be removed.
     */

    public void removeVertex(T w) {
        validateVertex(w);
        //removing the actual vertex.
        vertices.remove(w);
        //iterating throw each vertex and deleting w vertex from
        //the list of connected vertices of other vertices if
        //there is such.
        for (Map.Entry<T, List<T>> entry : vertices.entrySet()) {
            entry.getValue().remove(w);
        }
        indexedVertices.remove(w);
        V--;
    }

    /**
     * Utility method that checks whether edge between two
     * vertices exist.
     *
     * @param v first vertex
     * @param w second vertex
     *
     * @return true if there is an edge, otherwise - false.
     */

    public boolean hasEdge(T v, T w) {
        validateVertex(v);
        validateVertex(w);
        return (vertices.get(v).contains(w));
    }

    /**
     * Method that adds edge to a graph (connects
     * two vertices).
     *
     * @param v  first vertex.
     * @param w  second vertex.
     */

    public void addEdge(T v, T w) {
        validateVertex(v);
        validateVertex(w);
        if(hasEdge(v, w)) { return; }
        vertices.get(v).add(w);
        vertices.get(w).add(v);
        E++;
    }

    /**
     * Method that deletes an edge in a graph.(deletes
     * connection between two vertices)
     *
     * @param v  first vertex.
     * @param w  second vertex.
     */

    public void removeEdge(T v, T w) {
        validateVertex(v);
        validateVertex(w);
        if(!hasEdge(v, w)) { return; }
        vertices.get(v).remove(w);
        vertices.get(w).remove(v);
        E--;
    }

    /**
     * Method that calculates the degree of a vertex.
     *
     * @param v  vertex to be inspected.
     *
     * @return degree of a given vertex.
     */

    public int vertexDegree(T v) {
        validateVertex(v);
        return (vertices.get(v).size());
    }

    /**
     * Method that checks whether the given graph is connected.
     *
     * @return true if the graph is connected, otherwise - false.
     */

    public boolean isConnected() {
        DepthFirstPath<T> traverse = new DepthFirstPath<>(this, this.getIndexedVertices().get(0));
        boolean[] arr = traverse.getConnection();

        return (IntStream.range(0, arr.length).allMatch(i -> arr[i]));
    }

    /**
     * Method that collects and returns all the
     * adjacent vertices to the given one.
     *
     * @param v  vertex to be inspected.
     *
     * @return list of all the adjacent vertices to v.
     */

    public List<T> adjacent(T v) {
        validateVertex(v);
        return vertices.get(v);
    }

    /**
     * Overridden toString method from the global superclass
     * Object that gives representation of a graph in a String.
     *
     * @return instance of a graph represented as a string.
     */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder((V + "Vertices and " + E + "Edges \n"));
        //iterating through the map and appending each entry
        //to the resulting graph string representation.
        for (Map.Entry<T, List<T>> entry : vertices.entrySet()) {
            result.append(entry.getKey().toString());
            result.append(": ");
            result.append(entry.getValue().toString());
            result.append("\n");
        }
        return (result.toString());
    }
}