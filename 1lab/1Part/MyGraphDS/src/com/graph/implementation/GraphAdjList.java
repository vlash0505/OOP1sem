package com.graph.implementation;
import java.util.*;

/**
 * Class that creates an instance of a graph
 * and implements basic operations on graph
 * data structure.
 * Class uses generic data types.
 *
 * @param <T>   Elements to be stored in the
 *              graph's edges.
 */

public class GraphAdjList<T> {
    //using map to store information about vertices
    //therefore graph cannot contain duplicate objects.
    private Map<T, List<T>> vertices;
    private int V;
    private int E;

    /**
     * Constructor without parameters for a Graph
     * data structure.
     */

    public GraphAdjList() { this.vertices = new HashMap<>(); }

    /**
     * Constructor for a Graph data structure.
     *
     * @param V - initial number of vertices.
     */

    public GraphAdjList(int V, List<T> elements) {
        //checking parameters for validity.
        if(V <= 0 || elements.size() != V) {
            System.out.println("Input values aren't validated, Graph is not initialized.\n");
            return;
        }
        this.V = V;
        this.vertices = new HashMap<>(V);
        for(int i = 0; i < V; i++) {
            vertices.put(elements.get(i), new ArrayList<>());
        }
    }

    public Map<T, List<T>> getVertices() {
        return vertices;
    }

    /**
     * Method that returns number of vertices in an
     * instance of a graph.
     *
     * @return number of vertices in a Graph.
     */

    public int V() { return V; }

    /**
     * Method that returns number of edges in an
     * instance of a graph.
     *
     * @return number of edges in a graph instance.
     */

    public int E() { return E; }

    /**
     * Method that adds vertex to the graph.
     *
     * @param data - data to be stored in a new vertex.
     */

    public void addVertex(T data) {
        //checking parameters for validity.
        if(!vertices.containsKey(data)) {
            System.out.println("Graph already contains element you are trying to add.");
            return;
        }
        vertices.put(data, new ArrayList<>());
        V++;
    }

    /**
     * Method that removes vertex from the graph.
     *
     * @param w - vertex to be removed.
     */

    public void removeVertex(T w) {
        //parameter validation
        if(!vertices.containsKey(w)) {
            System.out.println("No such vertex found in the graph.\n");
            return;
        }
        //removing the actual vertex.
        vertices.remove(w);
        //iterating throw each vertex and deleting w vertex from
        //the list of connected vertices of other vertices
        for (Map.Entry<T, List<T>> entry : vertices.entrySet()) {
            entry.getValue().remove(w);
        }
        V--;
    }

    /**
     * Method that adds edge to a graph (connects
     * two vertices).
     *
     * @param v - first vertex.
     * @param w - second vertex.
     */

    public void addEdge(T v, T w) {
        //checking parameters for validity.
        if(!vertices.containsKey(v) || !vertices.containsKey(w)) {
            System.out.println("Can't add edge because one of the vertices or both of them do not exist.");
            return;
        }
        vertices.get(v).add(w);
        vertices.get(w).add(v);
        E++;
    }

    /**
     * Method that deletes an edge in a graph.(deletes
     * connection between two vertices)
     *
     * @param v - first vertex.
     * @param w - second vertex.
     */

    public void removeEdge(T v, T w) {
        //checking parameters for validity.
        if(!vertices.containsKey(v) || !vertices.containsKey(w)) {
            System.out.println("Can't add edge because one of the vertices or both of them do not exist.");
            return;
        }
        vertices.get(v).remove(w);
        vertices.get(w).remove(v);
        E--;
    }

    /**
     * Method that calculates the degree of a vertex.
     *
     * @param v - vertex to be inspected.
     *
     * @return degree of a given vertex.
     */

    public int vertexDegree(T v) {
        //validating the input
        if(!vertices.containsKey(v)) {
            System.out.println("No such vertex found in the graph.\n");
            return -1;
        }
        return (vertices.get(v).size());
    }

    /**
     * Method that collects and returns all the
     * adjacent vertices to the given one.
     *
     * @param v - vertex to be inspected.
     * @return all the adjacent vertices to v.
     */

    public List<T> adjacent(T v) {
        //validating parameters
        if(!vertices.containsKey(v)) {
            System.out.println("No such vertex found.");
            //returning empty List.
            return new ArrayList<>();
        }
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