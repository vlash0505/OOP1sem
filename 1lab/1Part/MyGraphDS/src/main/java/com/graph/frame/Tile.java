package com.graph.frame;

/**
 * Class that represents tile of a grid in GUI model.
 */

public class Tile {
    private final int x;
    private final int y;

    private boolean isWall;
    private boolean isVisited;

    /**
     * Constructor for a Tile instance that takes two
     * parameters.
     *
     * @param x x coordinate on the grid.
     * @param y y coordinate on the grid.
     */

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method that returns x coordinate of a Tile on the grid.
     *
     * @return x coordinate.
     */

    public int getX() {
        return x;
    }

    /**
     * Method that returns y coordinate of a Tile on the grid.
     *
     * @return y coordinate.
     */

    public int getY() {
        return y;
    }

    /**
     * Method that checks whether given tile is a wall.
     *
     * @return true if the tile is wall, otherwise - false.
     */

    public boolean isWall() { return isWall; }

    /**
     * Method that sets the tile as a wall or otherwise
     * according to the passed parameter.
     *
     * @param isWall if true - sets the tile as wall, otherwise - not a wall.
     */

    public void setWall(boolean isWall) { this.isWall = isWall; }

    /**
     * Method that checks whether given tile was visited
     * during pathfinding.
     *
     * @return true if the tile was visited, otherwise - false.
     */

    public boolean isVisited() { return isVisited; }

    /**
     * Method that sets the tile as visited or otherwise
     * according to the passed parameter.
     *
     * @param isVisited if true - sets the tile as visited,
     *                  otherwise - not visited.
     */

    public void setVisited(boolean isVisited) {
        if(this.isWall)    { return; }
        this.isVisited = isVisited;
    }

    /**
     * Method that checks whether instance of a tile is
     * equal to the passed as a parameter object.
     *
     * @param o Object with which the tile will be compared.
     * @return true if instances are equal, otherwise - false.
     */

    @Override
    public boolean equals(Object o) {
        if(o == null) { return false; }
        if(o.getClass() != this.getClass()) { return false; }

        final Tile that = (Tile) o;
        return (this.x == that.x && this.y == that.y);
    }

    /**
     * Method that returns String representation of
     * a tile.
     *
     * @return tile instance represented as string.
     */

    @Override
    public String toString() {
        return (this.x + " " + this.y);
    }
}
