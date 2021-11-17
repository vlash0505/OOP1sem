package com.graph.frame;

/**
 * Class that represents tile that
 * is a part of the shortest path.
 */

public class PathTile {
    private Tile baseTile;
    private boolean isVisible;

    /**
     * Constructor for a path tile.
     *
     * @param baseTile tile that was marked
     *                 as path.
     */

    public PathTile(Tile baseTile) {
        this.baseTile = baseTile;
    }

    /**
     * Getter for base tile.
     *
     * @return base tile od a path
     *         tile.
     */

    public Tile getBaseTile() {
        return baseTile;
    }

    /**
     * Setter for a base tile of a path tile.
     *
     * @param baseTile tile to be set as base.
     */

    public void setBaseTile(Tile baseTile) {
        this.baseTile = baseTile;
    }

    /**
     * Method that returns whether the tile
     * is visible.
     *
     * @return true if the tile is visible
     *         otherwise - false.
     */

    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Method that sets the current state
     * of the tile (visible\ not visible)
     *
     * @param visible value to assign to the
     *                state of a tile (true -
     *                visited, false - not).
     */

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
