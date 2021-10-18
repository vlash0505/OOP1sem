package com.graph.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Set;

import com.graph.implementation.*;

public class Window extends JPanel implements ActionListener, MouseListener {
    private static final int size = 30;
    private Tile spawnPosition;
    private Tile endPosition;
    private int tileMode;

    private TestPath<Integer> path;

    public Window() {
        this.setPreferredSize(new Dimension(690,420));
        addMouseListener(this);
    }

    @Override
    public void paintComponents(Graphics g) { super.paintComponent(g); }

    public void graphInitialise() {

    }

    public void startSearch() {
        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1,2);
        path = new TestPath<>(graph, 1);
    }

    public void setTileMod(int mode) {

    }

    public boolean emptyTile(Tile t) { return t == null; }

    public void paintGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int j = 0; j < this.getHeight(); j += size) {
            for (int i = 0; i < this.getWidth(); i += size) {
                g.drawRect(i, j, size, size);
            }
        }
    }

    public void paintWalls(Graphics g) {
        Set<Tile> wallList = path.getWalls();
        g.setColor(Color.BLACK);
        for(Tile tile : wallList) {
            int x = tile.getX();
            int y = tile.getY();
            g.fillRect(x, y, size , size);
        }
    }

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

    @Override
    public void paint(Graphics g) {
        paintGrid(g);
        paintWalls(g);

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