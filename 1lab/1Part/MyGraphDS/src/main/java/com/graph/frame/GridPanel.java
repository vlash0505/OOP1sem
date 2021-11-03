package com.graph.frame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

import java.util.stream.IntStream;

import com.graph.implementation.*;

/**
 * Class that represents panel and functionality
 * to visualise.
 */

public class GridPanel extends JPanel implements MouseListener {
    private static final int size = 30;
    private int tileMode;

    private final Tile[][] gridMatrix;
    private Tile spawnPosition;
    private Tile endPosition;

    private final Timer timerForVisited;
    private final Timer timerForPath;

    private TestShortPath<Tile> pathShort;

    private boolean pathfindingIsDone;
    private int i;

    private final Stack<Tile> visitedTiles;
    private final Stack<Tile> finalPath;

    private boolean searchIsPrinted;

    public GridPanel() {
        this.setPreferredSize(new Dimension(690,420));
        addMouseListener(this);

        this.gridMatrix = new Tile[23][14];
        this.fillGridMatrix();

        this.i = 0;

        this.visitedTiles = new Stack<>();
        this.finalPath = new Stack<>();

        //delayed animation for all visited tiles.
        this.timerForVisited = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitedTiles.add(pathShort.getVisited().get(i++));
                if(i == pathShort.getVisited().size()) {
                    timerForVisited.stop();
                    searchIsPrinted = true;
                    i = 0;
                    timerForPath.start();
                }
                repaint();
            }
        });

        //delayed animation for final path
        this.timerForPath = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalPath.add(pathShort.getT().get(i++));
                if(i == pathShort.getT().size()) { timerForPath.stop(); }
                repaint();
            }
        });
    }

    /**
     * Method that fills the grid matrix such as each tile corresponds
     * with matrix's indexes.
     */

    public void fillGridMatrix() {
        IntStream.range(0, gridMatrix.length)
                 .forEach(x -> IntStream.range(0, gridMatrix[x].length)
                                        .forEach(y -> gridMatrix[x][y] = new Tile(x, y)));
    }

    /**
     * Method that does pathfinding and collects information
     * on visited tiles.
     * Called from NewWindow when user presses the start button.
     */

    public void startSearch() {
        if(spawnPosition == null || endPosition == null) { return; }
        int x = this.getWidth() / size;
        int y = this.getHeight() / size;

        GraphOnGrid G = new GraphOnGrid(x, y, gridMatrix);
        GraphAdjList<Tile> graph = G.graphInit();

        pathShort = new TestShortPath<>(graph, spawnPosition, endPosition);
        pathShort.setT();
        pathfindingIsDone = true;
        timerForVisited.start();
    }

    /**
     * Method that completely resets the
     */

    public void resetFrame() {
        pathfindingIsDone = false;
    }

    /**
     * Core painting method, does all painting.
     *
     * @param g program's graphics.
     */

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
        if(pathfindingIsDone) { paintVisited(g); }
        if(searchIsPrinted) { paintPath(g); }
    }

    /**
     * Paints specific tile on a grid.
     *
     * @param g program's graphics.
     * @param t tile to be painted.
     */

    public void paintTile(Graphics g, Tile t) {
        int x = t.getX() * size;
        int y = t.getY() * size;
        g.fillRect(x, y, size, size);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    /**
     * Paints the grid that will represent a graph.
     *
     * @param g program's graphics.
     */

    public void paintGrid(Graphics g) {
        for (int i = 0; i < this.getWidth() / size; i++) {
            for (int j = 0; j < this.getHeight() / size; j++) {

                g.setColor((gridMatrix[i][j].isWall()) ? (Color.BLACK) : (Color.WHITE));
                if(gridMatrix[i][j].equals(spawnPosition)) { g.setColor(Color.YELLOW); }
                if(gridMatrix[i][j].equals(endPosition))   { g.setColor(Color.RED); }

                paintTile(g, gridMatrix[i][j]);
            }
        }
    }

    /**
     * Paints all tiles that have been visited during
     * pathfinding.
     *
     * @param g program's graphics.
     */

    public void paintVisited(Graphics g) {
        for(Tile t : visitedTiles) {
            g.setColor(Color.CYAN);
            paintTile(g, t);
        }
    }

    /**
     * Paints the shortest path.
     *
     * @param g program's graphics.
     */

    public void paintPath(Graphics g) {
        for(Tile t : finalPath) {
            g.setColor(Color.ORANGE);
            paintTile(g, t);
        }
    }

    /**
     * Sets the type of tile user is going to put on the grid.
     *
     * @param mode type of the tile user is going
     *             to put on the grid.
     *
     *             0 - spawn position,
     *             1 - end position,
     *             2 - wall.
     */

    public void setTileMode(int mode)    { this.tileMode = mode; }

    /**
     * Edits and paints the grid according to the mode
     * of the tile the user has chosen on mouse click.
     *
     * @param e MouseEvent.
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (e.getX() - (e.getX() % size)) / size;
        int y = (e.getY() - (e.getY() % size)) / size;
        switch (tileMode) {
            case (0) -> {
                if(gridMatrix[x][y].equals(endPosition) || gridMatrix[x][y].isWall()) { break; }
                spawnPosition = gridMatrix[x][y];
            }
            case (1) -> {
                if(gridMatrix[x][y].equals(spawnPosition) || gridMatrix[x][y].isWall()) { break; }
                endPosition = gridMatrix[x][y];
            }
            case (2) -> {
                if(gridMatrix[x][y].equals(spawnPosition) || gridMatrix[x][y].equals(endPosition)) { break; }
                if(gridMatrix[x][y].isWall()) { gridMatrix[x][y].setWall(false); break; }
                gridMatrix[x][y].setWall(true);
            }
        }
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