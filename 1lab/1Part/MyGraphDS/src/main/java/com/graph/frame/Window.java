package com.graph.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.util.List;
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

    private Tile[][] gridMatrix;
    private int tileMode;
    private Set<Tile> walls;

    private TestPath<Tile> path;

    public Window() {
        this.setPreferredSize(new Dimension(690,420));

        this.gridMatrix = new Tile[23][14];
        System.out.println(gridMatrix.length);
        this.fillMatrixGrid(gridMatrix);
        this.walls = new HashSet<>();

        addMouseListener(this);
    }

    public void fillMatrixGrid(Tile[][] array) {
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
        path = new TestPath<>(G, spawnPosition);
    }

    public void setTileMode(int mode) { this.tileMode = mode; }

    public boolean emptyTile(Tile t) { return t == null; }

    public void paintGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < this.getHeight(); i += size) {
            for (int j = 0; j < this.getWidth(); j += size) {
                g.setColor(Color.WHITE);
                g.fillRect(j, i, size, size);
                g.setColor(Color.BLACK);
                g.drawRect(j, i, size, size);
            }
        }
    }

    public void paintg(Graphics g) {
        for (int i = 0; i < this.getWidth() / 30; i++) {
            for (int j = 0; j < this.getHeight() / 30; j++) {
                int x1 = gridMatrix[i][j].getX() * 30;
                int y1 = gridMatrix[i][j].getY() * 30;

                g.setColor((gridMatrix[i][j].isWall()) ? (Color.BLACK) : (Color.WHITE));
                if(gridMatrix[i][j].isSource()) { g.setColor(Color.YELLOW); }
                if(gridMatrix[i][j].isGate())   { g.setColor(Color.RED); }

                g.fillRect(x1, y1, size, size);
                g.setColor(Color.BLACK);
                g.drawRect(x1, y1, size, size);
            }
        }
    }

    public void paintWalls(Graphics g) {
        //Set<Tile> wallList = path.getWalls();
        g.setColor(Color.BLACK);
        for(Tile tile : walls) {
            int x = tile.getX() * 30;
            int y = tile.getY() * 30;
            g.fillRect(x, y, size , size);
        }
    }

    /**
     * Driver method for drawing the grid.
     *
     * @param g graphics used in this frame.
     */

    @Override
    public void paint(Graphics g) {
        paintg(g);
        paintWalls(g);

        //paintSpawnPoint(g);
        //paintEndPoint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (e.getX() - (e.getX() % size)) / size;
        int y = (e.getY() - (e.getY() % size)) / size;
        switch (tileMode) {
            case (0) -> gridMatrix[x][y].setSource(true);
            case (1) -> gridMatrix[x][y].setGate(true);
            case (2) -> gridMatrix[x][y].setWall(true);
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}