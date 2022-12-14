package gol;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;

// Board mit Zellen die mit dem Fenster skalieren, mit MouseListener
public class Board extends JComponent implements MouseInputListener, ComponentListener {
    private Cell[][] cells;
    private int xsize = this.getWidth()/50;
    private int ysize = this.getHeight()/50;
    private int length = 52;
    private int height = 52;
    public Color colorLC = Color.BLACK;
    public Color colorDC = Color.WHITE;
    public String modus = "Malen";

    // Konstruktor Board
    public Board(int length, int height) {
        addMouseListener(this);
        addComponentListener(this);
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
        initialize(this.length,this.height);
    }

    // einzelne Iteration
    public void iteration() {
        for (Cell[] cell : cells) {
            for (Cell aCell : cell) {
                aCell.calculateNewState();
            }
        }
        for (Cell[] cell : cells) {
            for (Cell aCell : cell) {
                aCell.changeState();
            }
        }
        this.repaint();
    }

    // Leeren des Boards
    public void clear() {
        for (Cell[] cell : cells) {
            for (Cell aCell : cell) {
                aCell.setState(0);
            }
        }
        this.repaint();
    }

    // Initialisierung des Boards
    private void initialize(int length, int height) {
        cells = new Cell[length][height];
        for (int x = 0; x < cells.length; ++x) {
            for (int y = 0; y < cells[x].length; ++y) {
                cells[x][y] = new Cell();
            }
        }
        for (int x = 0; x < cells.length; ++x) {
            for (int y = 0; y < cells[x].length; ++y) {
                int max = 51;
                int min = 0;
                if(x >= max) {
                    tryToAdd(cells[x][y],min,y);
                    tryToAdd(cells[x][y],min,y-1);
                    tryToAdd(cells[x][y],min,y+1);
                }
                if( x <= min) {
                    tryToAdd(cells[x][y], max, y);
                    tryToAdd(cells[x][y], max, y-1);
                    tryToAdd(cells[x][y], max, y+1);
                }
                if(y <= min) {
                    tryToAdd(cells[x][y], x, max);
                    tryToAdd(cells[x][y], x-1, max);
                    tryToAdd(cells[x][y], x+1, max);
                }
                if(y >= max) {
                    tryToAdd(cells[x][y], x, min);
                    tryToAdd(cells[x][y], x-1, min);
                    tryToAdd(cells[x][y], x+1, min);
                }
                tryToAdd(cells[x][y],x-1,y+1); tryToAdd(cells[x][y],x,y+1); tryToAdd(cells[x][y],x+1,y+1);
                tryToAdd(cells[x][y],x-1,y);/*                            */tryToAdd(cells[x][y], x+1, y);
                tryToAdd(cells[x][y],x-1,y-1); tryToAdd(cells[x][y],x, y-1); tryToAdd(cells[x][y], x+1, y-1);
            }
        }
    }

    // Versuche Nachbarn hinzuzufuegen
    private void tryToAdd(Cell addTo, int x, int y){
        try{
            addTo.addNeighbor(cells[x][y]);
        }catch(ArrayIndexOutOfBoundsException ignore){
        }
    }

    // Lade vorgefertigte Konfiguarationen
    public void loadPattern(Pattern shape) {

        String[] lines = shape.getPattern();
        int x0 = 0;
        int y0 = 0;
        if (shape.getName() == "Gleiter") {
            x0 = 20;
            y0 = 20;
        } else if (shape.getName() == "Gleiter-Kanone"){
            x0 = 7;
            y0 = 18;
        } else if (shape.getName() == "Raumschiff"){
            x0 = 15;
            y0 = 15;
        }
        for (int i = 0; i < lines.length; ++i) {
            for (int j = 0; j < lines[i].length(); ++j) {
                if (((x0 + j) < cells.length) && ((x0 + j) > 0) && ((y0 + i) < cells[(x0 + j)].length) && ((y0 + i) > 0)) {
                    if (lines[i].charAt(j) == '#') {
                        cells[x0 + j][y0 + i].setState(1);
                    } else {
                        cells[x0 + j][y0 + i].setState(0);
                    }
                }
            }
        }
        this.repaint();
    }

    // Setze Farbe für lebendige Zellen
    public void setColorLC (Color color){
        colorLC = color;
    }

    // Zeichnet den Hintergrund und die Trennzeichen zwischen Zellen
    protected void paintComponent(Graphics g) {
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        g.setColor(Color.GRAY);
        drawNetting(g, xsize,ysize);
    }

    // Zeichnet das Hintergrundraster
    public void drawNetting(Graphics g, int breite,int länge) {

        Insets insets = getInsets();
        int firstX = 0;
        int firstY = 0;
        int lastX =  this.length*xsize - insets.right;
        int lastY =  this.height*ysize - insets.bottom;

        int x = firstX;
        while (x < lastX) {
            g.drawLine(x, firstY, x, lastY);
            x += xsize;
        }

        int y = firstY;
        while (y < lastY) {
            g.drawLine(firstX, y, lastX, y);
            y += ysize;
        }

        try{
            for (x = 0; x < cells.length; ++x) {
                for (y = 0; y < cells[x].length; ++y) {
                    if (cells[x][y].getState() != 0) {
                        switch (cells[x][y].getState()) {
                            case 0:
                                g.setColor(colorDC);
                            case 1:
                                g.setColor(colorLC);
                                break;
                        }
                        g.fillRect((x * xsize) + 1, (y * ysize) + 1, (xsize - 1), (ysize - 1));
                    }
                }
            }
        }catch (NullPointerException ignore) {}
    }

    // Gibt den aktuellen Modus zurueck
    public String getModus (){
        return modus;
    }

    // Setzt den aktuellen Modus
    public void setModus (String m){
        modus = m;
    }

    // Ereignisse die bei Mausaktionen ausgefuehrt werden sollen
    public void mouseClicked(MouseEvent e) {
        if (getModus() == "Setzen" || getModus() == "Laufen"){
        int x = e.getX() / xsize;
        int y = e.getY() / ysize;
        if ((x < cells.length) && (x > 0) && (y < cells[x].length) && (y > 0)) {
            cells[x][y].clicked();
            this.repaint();
        }
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (getModus() == "Malen"){
        int x = e.getX() / xsize;
        int y = e.getY() / ysize;
        if ((x < cells.length) && (x > 0) && (y < cells[x].length) && (y > 0)) {
            cells[x][y].setState(1);
            this.repaint();
        }
        }
    }

    public void componentResized(ComponentEvent e) {
        xsize = this.getWidth()/50;
        ysize = this.getHeight()/50;
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }
}