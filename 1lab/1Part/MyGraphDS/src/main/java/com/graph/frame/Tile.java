package com.graph.frame;

public class Tile {
    private int x;
    private int y;

    private boolean isWall;
    private boolean isSource;
    private boolean isGate;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isWall() { return isWall; }

    public void setWall(boolean wall) { isWall = wall; }

    public boolean isSource() { return isSource; }

    public void setSource(boolean source) { isSource = source; }

    public boolean isGate() {
        return isGate;
    }

    public void setGate(boolean gate) {
        isGate = gate;
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

    @Override
    public String toString() {
        return (this.x + " " + this.y);
    }
}
