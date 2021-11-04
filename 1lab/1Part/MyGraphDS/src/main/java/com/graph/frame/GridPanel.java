package com.graph.frame;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.util.stream.IntStream;

import com.graph.implementation.*;

/**
 * Class that represents graph data structure
 * as grid on the panel.
 */

public class GridPanel extends JPanel implements MouseListener {
    private static final int TILE_SIZE = 30;
    private static final int FRAME_WIDTH = 690;
    private static final int FRAME_HEIGHT = 420;

    private final Tile[][] gridMatrix;
    private Tile sourcePosition;
    private Tile destinationPosition;
    //defines type of the tile user wants to set on the grid.
    private int tileMode;

    private final Timer timerForVisited;
    private final Timer timerForPath;
    private boolean pathfindingIsDone;

    private Iterator<Tile> visitedTiles;
    private final Stack<PathTile> finalPath;

    /**
     * Constructor for the grid panel.
     */

    public GridPanel() {
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        addMouseListener(this);

        this.gridMatrix = new Tile[FRAME_WIDTH / TILE_SIZE][FRAME_HEIGHT / TILE_SIZE];
        this.fillGridMatrix();

        this.finalPath = new Stack<>();

        //delayed animation for all visited tiles.
        this.timerForVisited = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tile current = visitedTiles.next();
                gridMatrix[current.getX()][current.getY()].setVisited(true);
                repaint();
                if(!visitedTiles.hasNext()) {
                    timerForVisited.stop();
                    timerForPath.start();
                }
            }
        });

        //delayed animation for final path
        this.timerForPath = new Timer(50, new ActionListener() {
            int currentTileIndex = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                finalPath.get(finalPath.size() - 1 - currentTileIndex++).setVisible(true);
                repaint();
                if(currentTileIndex == finalPath.size()) {
                    pathfindingIsDone = true;
                    currentTileIndex = 0;
                    timerForPath.stop();
                }
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
     * Called from Frame when user presses the start button.
     */

    public void startSearch() {
        if(sourcePosition == null || destinationPosition == null) { return; }
        if(pathfindingIsDone) { return; }
        int rowsNum = FRAME_WIDTH / TILE_SIZE;
        int columnsNum = FRAME_HEIGHT / TILE_SIZE;

        GraphOnGrid G = new GraphOnGrid(rowsNum, columnsNum, gridMatrix);
        GraphAdjList<Tile> graph = G.graphInit();

        TestShortPath<Tile> pathShort = new TestShortPath<>(graph, sourcePosition, destinationPosition);
        pathShort.setT();
        visitedTiles = pathShort.getVisited().iterator();
        for(Tile t : pathShort.getT()) {
            finalPath.push(new PathTile(t));
        }
        timerForVisited.start();
    }

    /**
     * Method that completely resets the grid panel so that user
     * can repeat the pathfinding process on the new configuration.
     */

    public void resetFrame() {
        if(!pathfindingIsDone)    { return; }
        finalPath.clear();
        IntStream.range(0, gridMatrix.length)
                 .forEach(x -> IntStream.range(0, gridMatrix[x].length)
                                        .forEach(y -> { gridMatrix[x][y].setVisited(false);
                                                        gridMatrix[x][y].setWall(false); }));
        pathfindingIsDone = false;
        sourcePosition = null;
        destinationPosition = null;
        repaint();
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
        paintPath(g);
    }

    /**
     * Paints specific tile on a grid.
     *
     * @param g program's graphics.
     * @param t tile to be painted.
     */

    public void paintTile(Graphics g, Tile t) {
        int x = t.getX() * TILE_SIZE;
        int y = t.getY() * TILE_SIZE;
        g.fillRect(x, y, TILE_SIZE, TILE_SIZE);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, TILE_SIZE, TILE_SIZE);
    }

    /**
     * Paints the grid that will represent a graph.
     *
     * @param g program's graphics.
     */

    public void paintGrid(Graphics g) {
        for (int i = 0; i < FRAME_WIDTH / TILE_SIZE; i++) {
            for (int j = 0; j < FRAME_HEIGHT / TILE_SIZE; j++) {

                g.setColor((gridMatrix[i][j].isWall()) ? (Color.BLACK) : (Color.WHITE));
                if(gridMatrix[i][j].isVisited()) { g.setColor(Color.CYAN); }
                if(gridMatrix[i][j].equals(sourcePosition)) { g.setColor(Color.YELLOW); }
                if(gridMatrix[i][j].equals(destinationPosition))   { g.setColor(Color.RED); }

                paintTile(g, gridMatrix[i][j]);
            }
        }
    }

    /**
     * Paints the shortest path.
     *
     * @param g program's graphics.
     */

    public void paintPath(Graphics g) {
        for(PathTile t : finalPath) {
            if(!t.isVisible)    { continue; }
            g.setColor(Color.ORANGE);
            paintTile(g, t.getBaseTile());
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
     * @param e mouse clicked.
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        if(pathfindingIsDone)   { return; }
        int x = (e.getX() - (e.getX() % TILE_SIZE)) / TILE_SIZE;
        int y = (e.getY() - (e.getY() % TILE_SIZE)) / TILE_SIZE;
        switch (tileMode) {
            case (0) -> {
                if(gridMatrix[x][y].equals(destinationPosition) || gridMatrix[x][y].isWall()) { break; }
                sourcePosition = gridMatrix[x][y];
            }
            case (1) -> {
                if(gridMatrix[x][y].equals(sourcePosition) || gridMatrix[x][y].isWall()) { break; }
                destinationPosition = gridMatrix[x][y];
            }
            case (2) -> {
                if(gridMatrix[x][y].equals(sourcePosition) || gridMatrix[x][y].equals(destinationPosition)) { break; }
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