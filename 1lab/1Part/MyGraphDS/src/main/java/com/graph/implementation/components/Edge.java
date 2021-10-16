package com.graph.implementation.components;

/**
 * Class that represents Edge in the Edge-weighted graph.
 *
 * @param <T> data that will be stored in two connected
 *            vertices.
 */

public class Edge<T> implements Comparable<Edge<T>>{
    private final T v;
    private final T w;
    private final double weight;

    /**
     * Constructor for EW graph's edge
     *
     * @param v first vertex
     * @param w second vertex
     * @param weight edge's weight
     */

    public Edge(T v, T w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * Method that returns edge's weight.
     *
     * @return weight of the edge.
     */

    public double getWeight() {
        return this.weight;
    }

    /**
     * Method that is called when the client requests any of the
     * vertices that are connected with the edge.
     *
     * @return one of the edge's connected vertices.
     */

    public T either() {
        return v;
    }

    /**
     * Method that returns vertex that's connected to the
     * given by the user.
     *
     * @param value given vertex
     *
     * @return      vertex connected to the passed parameter.
     */

    public T other(T value) {
        return (value.equals(v) ? w : this.v);
    }

    /**
     * Method that compares weight of two edges.
     *
     * @param that passed edge.
     *
     * @return   1 if edge's weight to which method is called is higher that
     *           parameter's passed.
     *           -1 if edge's weight to which method is called is less that
     *           parameter's passed.
     *           0 if they are equal.
     */

    @Override
    public int compareTo(Edge<T> that) {
        return (Double.compare(this.weight, that.weight));
    }

    /**
     * Method that returns edge represented as String.
     *
     * @return String representation of the EW graph's edge.
     */

    @Override
    public String toString() {
        return (this.v.toString() + " - " + this.w.toString() + " weight: " + weight);
    }
}