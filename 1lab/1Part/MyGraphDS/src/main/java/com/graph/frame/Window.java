package com.graph.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

import com.graph.implementation.*;

public class Window extends JPanel implements ActionListener, MouseListener, KeyListener, MouseMotionListener {
    private final JPanel panel;
    private final JFrame frame;

    private char keyPressed;

    private static final int size = 30;

    private Tile spawnPoint;
    private Tile endPoint;

    private final TestPath<Integer> path;

    public Window() {
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setFocusable(false);

        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);


        this.frame = new JFrame();
        this.frame.setContentPane(this);
        this.frame.setLayout(new BorderLayout());
        this.frame.setTitle("Dungeon Master");
        this.frame.setSize(630,420);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);

        GraphAdjList<Integer> graph = new GraphAdjList<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1,2);

        path = new TestPath<>(graph, 1);

        repaint();
    }

    @Override
    public void paintComponents(Graphics g) { super.paintComponent(g); }

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

    public void paintSpawnPoint(Graphics g) {
        if(emptyTile(spawnPoint)) return;
        g.setColor(Color.YELLOW);
        g.fillRect(spawnPoint.getX(), spawnPoint.getY(), size, size);
    }

    public void paintEndPoint(Graphics g) {
        if(emptyTile(endPoint)) return;
        g.setColor(Color.RED);
        g.fillRect(endPoint.getX(), endPoint.getY(), size, size);
    }

    @Override
    public void paint(Graphics g) {
        paintGrid(g);
        paintWalls(g);

        paintSpawnPoint(g);
        paintEndPoint(g);
    }

    public void frameLogic(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            int xOver = e.getX() % size;
            int yOver = e.getY() % size;

            if (keyPressed == 's') {
                spawnPoint = new Tile(e.getX() - xOver, e.getY() - yOver);
                repaint();
            } else if (keyPressed == 'e') {
                endPoint = new Tile(e.getX() - xOver, e.getY() - yOver);
                repaint();
            } else {
                path.addWall(new Tile(e.getX() - xOver, e.getY() - yOver));
                repaint();
            }

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) { frameLogic(e); }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) { this.keyPressed = e.getKeyChar(); }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
