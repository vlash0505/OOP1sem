package com.graph.implementation.adjlist;

public class GraphAdjListComparableTests extends GraphAdjListReferenceTests<GraphAdjListComparableTests.ComparableElement> {

    public static class ComparableElement implements Comparable<ComparableElement> {
        private final int id;

        public int getId() {
            return id;
        }

        public ComparableElement(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(ComparableElement other) {
            return (other == null) ? 1 : Integer.compare(this.id, other.getId());
        }
    }

    @Override
    protected ComparableElement createSampleValue() {
        return new ComparableElement(1);
    }

    @Override
    protected ComparableElement createDifferentValue() {
        return new ComparableElement(2);
    }
}
