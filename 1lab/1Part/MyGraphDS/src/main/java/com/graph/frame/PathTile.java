package com.graph.frame;

public class PathTile {
    private Tile baseTile;
    private boolean isVisible;

    public PathTile(Tile baseTile) {
        this.baseTile = baseTile;
    }

    public Tile getBaseTile() {
        return baseTile;
    }

    public void setBaseTile(Tile baseTile) {
        this.baseTile = baseTile;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
