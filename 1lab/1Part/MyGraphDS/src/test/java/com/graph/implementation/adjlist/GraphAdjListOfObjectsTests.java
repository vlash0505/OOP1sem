package com.graph.implementation.adjlist;

public class GraphAdjListOfObjectsTests extends GraphAdjListReferenceTests<Object> {
    private static final Object sample = new Object();

    public static Object getSample() {
        return sample;
    }

    @Override
    protected Object createSampleValue() {
        return sample;
    }

    @Override
    protected Object createDifferentValue() {
        return new Object();
    }
}
