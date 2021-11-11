package com.graph.implementation;

import com.graph.frame.Tile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class that represent graph on a grid.
 */

public class GraphOnGridBuilder<T extends Tile> {
    private final int rowsNum;
    private final int columnsNum;
    private final T[][] gridMatrix;

    /**
     * Constructor for a tile graph.
     *
     * @param rowsNum number of rows in a grid.
     * @param columnsNum number of columns in a grid.
     * @param gridMatrix matrix that represents a grid.
     */

    public GraphOnGridBuilder(int rowsNum, int columnsNum, T[][] gridMatrix) {
        this.rowsNum = rowsNum;
        this.columnsNum = columnsNum;
        this.gridMatrix = gridMatrix;
    }

    /**
     * Method that initializes graph that will
     * be used when operating pathfinding actions.
     *
     * @return adjacency list graph that is represented
     *         as grid and corresponding with matrix grid.
     */

    public GraphAdjList<T> graphInit() {
        int V = (rowsNum * columnsNum);
        //converting 2d matrix to list to initialize graph with
        //its values.
        List<T> values = Stream.of(gridMatrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        GraphAdjList<T> graph = new GraphAdjList<>(V, values);
        // vectors for exploring neighbour vertices
        // north/south/east/west
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for(Map.Entry<T, List<T>> entry : graph.getVertices().entrySet()) {
            for(int i = 0; i < 4; i++) {
                if(entry.getKey().isWall()) { continue; }

                int rr = entry.getKey().getX() + dr[i];
                int cc = entry.getKey().getY() + dc[i];

                //validate coordinates
                if(rr < 0 || cc < 0) { continue; }
                if(rr > rowsNum - 1 || cc > columnsNum - 1) { continue; }
                if(gridMatrix[rr][cc].isWall()) { continue; }

                graph.addEdge(entry.getKey(), gridMatrix[rr][cc]);
            }
        }
        return graph;
    }
}
