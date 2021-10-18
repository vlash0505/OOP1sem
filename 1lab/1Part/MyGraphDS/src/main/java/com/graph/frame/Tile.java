package com.graph.frame;

public class Tile {
    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) { return false; }
        if(o.getClass() != this.getClass()) { return false; }

        final Tile that = (Tile) o;
        return (this.x == that.x && this.y == that.y);
    }
}
