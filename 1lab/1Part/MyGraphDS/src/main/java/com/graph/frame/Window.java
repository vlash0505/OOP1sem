package com.graph.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.graph.implementation.*;

/**
 * Class that represents panel and functionality
 * to visualise
 */

public class Window extends JPanel implements ActionListener, MouseListener {
    private static final int size = 30;
    private Tile spawnPosition;
    private Tile endPosition;
    private final Tile[][] gridMatrix;
    private int tileMode;

    private TestPath<Tile> path;

    public Window() {
        this.setPreferredSize(new Dimension(690,420));
        addMouseListener(this);

        this.gridMatrix = new Tile[getWidth()/size][getHeight()/size];
        this.initMatrixGrid(gridMatrix);
    }

    public void initMatrixGrid(Tile[][] array) {
        IntStream.range(0, array.length)
                 .forEach(x -> IntStream.range(0, array[x].length)
                                        .forEach(y -> array[x][y] = new Tile(x, y)));
    }

    @Override
    public void paintComponents(Graphics g) { super.paintComponent(g); }

    public GraphAdjList<Tile> graphInitialise() {
        int rowsNum = this.getWidth()/size;
        int columnsNum = this.getHeight()/size;
        int V = (rowsNum * columnsNum);
        //converting 2d matrix to list to initialize graph with
        //its values.
        List<Tile> values = Stream.of(gridMatrix)
                                  .flatMap(Arrays::stream)
                                  .collect(Collectors.toList());
        GraphAdjList<Tile> graph = new GraphAdjList<>(V, values);
        // vectors for exploring neighbour vertices
        // north/south/east/west
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for(Map.Entry<Tile, List<Tile>> entry : graph.getVertices().entrySet()) {
            for(int i = 0; i < 4; i++) {
                int rr = entry.getKey().getX() + dr[i];
                int cc = entry.getKey().getY() + dc[i];

                if(rr < 0 || cc < 0) { continue; }
                if(rr > rowsNum || cc > columnsNum) { continue; }

                graph.addEdge(entry.getKey(), gridMatrix[rr][cc]);
            }
        }
        return graph;
    }

    public void startSearch() {
        GraphAdjList<Tile> G = graphInitialise();
        path = new TestPath<>(G, gridMatrix[0][0]);
    }

    public void setTileMode(int mode) { this.tileMode = mode; }

    public boolean emptyTile(Tile t) { return t == null; }

    public void paintGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int j = 0; j < this.getHeight(); j += size) {
            for (int i = 0; i < this.getWidth(); i += size) {
                g.drawRect(i, j, size, size);
            }
        }
    }

    //public void paintWalls(Graphics g) {
    //    Set<Tile> wallList = path.getWalls();
    //    g.setColor(Color.BLACK);
    //    for(Tile tile : wallList) {
    //        int x = tile.getX();
    //        int y = tile.getY();
    //        g.fillRect(x, y, size , size);
    //    }
    //}

    //public void paintSpawnPoint(Graphics g) {
    //    if(emptyTile(spawnPoint)) return;
    //    g.setColor(Color.YELLOW);
    //    g.fillRect(spawnPoint.getX(), spawnPoint.getY(), size, size);
    //}

    //public void paintEndPoint(Graphics g) {
    //    if(emptyTile(endPoint)) return;
    //    g.setColor(Color.RED);
    //    g.fillRect(endPoint.getX(), endPoint.getY(), size, size);
    //}

    /**
     * Driver method for drawing the grid.
     *
     * @param g graphics used in this frame.
     */

    @Override
    public void paint(Graphics g) {
        paintGrid(g);
        //paintWalls(g);

        //paintSpawnPoint(g);
        //paintEndPoint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}