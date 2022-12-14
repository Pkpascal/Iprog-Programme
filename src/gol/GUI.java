package gol;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class containing GUI: board + buttons
 */

public class GUI extends JInternalFrame implements ActionListener, ChangeListener {
    static int nr = -1, xpos = 30, ypos = 30;
    Program myprogram;
    private static final long serialVersionUID = 1L;
    private Timer     timer;
    private Board     board;
    private JComboBox modus;
    private JButton   start;
    private JButton   clear;
    private JButton   add;
    private JSlider   pred;
    private JComboBox figures;
    private JButton newWindow;
    String[] modi = {"Laufen", "Setzen", "Malen"};
    private       int     iterNum   = 0;
    private final int     maxDelay  = 500;
    private final int     initDelay = 100;
    private       boolean running   = false;

    public GUI(Program p) {
        super("Fenster" + (++nr), true, true);
        myprogram = p;
        timer = new Timer(initDelay, this);
        timer.stop();
        setLayout(new BorderLayout());
        setSize(new Dimension(1024, 768));

        JPanel buttonPanel = new JPanel();

        start = new JButton("Start");
        start.setActionCommand("Start");
        start.setToolTipText("Starts clock");
        start.addActionListener(this);

        modus = new JComboBox(modi);
        modus.setToolTipText("Choose your mode");
        modus.addActionListener(this);

        clear = new JButton("Clear");
        clear.setActionCommand("clear");
        clear.setToolTipText("Clears the board");
        clear.addActionListener(this);

        add = new JButton("Add");
        add.setActionCommand("add");
        add.setToolTipText("Adds predefined pattern");
        add.addActionListener(this);

        figures = new JComboBox(Pattern.setPattern());
        figures.setToolTipText("Pattern choice");

        pred = new JSlider();
        pred.setMinimum(0);
        pred.setMaximum(maxDelay);
        pred.setToolTipText("Time speed");
        pred.addChangeListener(this);
        pred.setValue(maxDelay - timer.getDelay());

        newWindow = new JButton("New Window");
        newWindow.setActionCommand("newWindow");
        newWindow.setToolTipText("Opens a new Window");
        newWindow.addActionListener(this);

        buttonPanel.add(modus);
        buttonPanel.add(start);
        buttonPanel.add(clear);
        buttonPanel.add(figures);
        buttonPanel.add(add);
        buttonPanel.add(pred);
        buttonPanel.add(newWindow);

        board = new Board(1024, 768 - buttonPanel.getHeight());
        add(board, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * handles clicking on each button
     *
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) modus.getSelectedItem();
        if (e.getSource().equals(timer)) {
            iterNum++;
            board.iteration();
        } else {
            String command = e.getActionCommand();
            if (command.equals("Start")) {
                if (!running) {
                    timer.start();
                    start.setText("Pause");
                } else {
                    timer.stop();
                    start.setText("Start");
                }
                running = !running;
                clear.setEnabled(true);

            } else if (command.equals("clear")) {
                iterNum = 0;
                timer.stop();
                start.setEnabled(true);
                board.clear();
            } else if (command.equals("add")) {
                board.loadPattern((Pattern) figures.getSelectedItem());
            } else if (command.equals("newWindow")) {
                myprogram.addChild(new GUI(myprogram), xpos, ypos);
                xpos += 20; ypos += 20;
            } else if (selectedItem.equals("Malen")){
                System.out.println("Malen");
            }

        }
    }

    /**
     * slider to control simulation speed
     *
     * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
     */
    public void stateChanged(ChangeEvent e) {
        timer.setDelay(maxDelay - pred.getValue());
    }
}
