package gol;
import javax.swing.*;

public class Program extends JFrame {

    private JDesktopPane desk;

    public Program() {
        desk = new JDesktopPane();
        desk.setDesktopManager(new DefaultDesktopManager());
        setContentPane(desk);
        setSize(1000,700);
        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addChild (GUI gui, int x, int y){
        gui.setLocation(x, y);
        gui.setSize(800, 500);
        desk.add(gui);
        gui.setVisible(true);
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.addChild(new GUI(program), 10, 10);

    }

}