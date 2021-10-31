package com.graph.frame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

import com.graph.implementation.*;

/**
 * Class that represents panel and functionality
 * to visualise.
 */

public class Window extends JPanel implements ActionListener, MouseListener {
    private static final int size = 30;

    private Tile spawnPosition;
    private Tile endPosition;

    private final Tile[][] gridMatrix;
    private int tileMode;

    private NewTestPath<Tile> path;

    private boolean pathIsDone;
    private int i;

    private Stack<Tile> f;

    private Tile currentPathTile;

    public Window() {
        this.setPreferredSize(new Dimension(690,420));

        this.gridMatrix = new Tile[23][14];
        System.out.println(gridMatrix.length);
        this.fillMatrixGrid(gridMatrix);

        this.spawnPosition = new Tile(0, 0);
        this.endPosition = new Tile(1, 1);

        this.i = 0;


        addMouseListener(this);
    }

    public void fillMatrixGrid(Tile[][] array) {
        IntStream.range(0, array.length)
                 .forEach(x -> IntStream.range(0, array[x].length)
                                        .forEach(y -> array[x][y] = new Tile(x, y)));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
        //if(pathIsDone) { paintTrack(g); }
        if(pathIsDone) { paintTile(g ,path.getTrack().get(i).getX() * size, path.getTrack().get(i).getY() * size); }
    }

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
                if(entry.getKey().isWall()) { continue; }

                int rr = entry.getKey().getX() + dr[i];
                int cc = entry.getKey().getY() + dc[i];


                if(rr < 0 || cc < 0) { continue; }
                if(rr > rowsNum - 1 || cc > columnsNum - 1) { continue; }
                if(gridMatrix[rr][cc].isWall()) { continue; }

                graph.addEdge(entry.getKey(), gridMatrix[rr][cc]);
            }
        }
        return graph;
    }

    public void startSearch() {
        if(spawnPosition == null || endPosition == null) { return; }

        GraphAdjList<Tile> G = graphInitialise();
        path = new NewTestPath<>(G, spawnPosition, endPosition);
        pathIsDone = true;
        Timer timer = new Timer(500, this);
        timer.start();
        repaint();
    }

    public void paintGrid(Graphics g) {
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

    public void paintTile(Graphics g, int x1, int y1) {
        g.setColor(Color.CYAN);
        g.fillRect(x1, y1, size, size);

        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, size, size);
    }


    public void paintTrack(Graphics g) {
        Stack<Tile> toPaint = path.getTrack();
        final Iterator<Tile> tiles = toPaint.iterator();
        //Timer timer = new Timer(500, this);
        //timer.start();
        //for(Tile t : toPaint) {

        //    int x1 = t.getX() * size;
        //    int y1 = t.getY() * size;
        //    g.setColor(Color.CYAN);
        //    //timer.start();
        //    paintTile(g, x1, y1);
        //}
    }

    /**
     * Driver method for drawing the grid.
     *
     //* @param g graphics used in this frame.
     */

    //@Override
    //public void paint(Graphics g) {
   //     paintGrid(g);
    //    if(pathIsDone) { paintTrack(g); }
    //}

    public void setTileMode(int mode) { this.tileMode = mode; }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (e.getX() - (e.getX() % size)) / size;
        int y = (e.getY() - (e.getY() % size)) / size;
        switch (tileMode) {
            case (0) -> {
                if(gridMatrix[x][y].isGate() || gridMatrix[x][y].isWall()) { break; }

                spawnPosition.setSource(false);
                gridMatrix[x][y].setSource(true);
                spawnPosition = gridMatrix[x][y];
            }
            case (1) -> {
                if(gridMatrix[x][y].isSource() || gridMatrix[x][y].isWall()) { break; }

                endPosition.setGate(false);
                gridMatrix[x][y].setGate(true);
                endPosition = gridMatrix[x][y];
            }
            case (2) -> {
                if(gridMatrix[x][y].isSource() || gridMatrix[x][y].isGate()) { break; }
                if(gridMatrix[x][y].isWall()) {
                    gridMatrix[x][y].setWall(false);
                    break;
                }
                gridMatrix[x][y].setWall(true);
            }
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        i++;
        System.out.println("Text");
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}