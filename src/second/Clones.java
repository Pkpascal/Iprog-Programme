package second;

import java.awt.*;
import java.awt.event.*;

/*
 * Dieses Programm erzeugt ein Fenster, dessen Hintergrundfarbe manuell geändert werden kann und eine neue Instanz von sich erstellen kann. 
 * 
 * Die Eingabe erfolgt über 2 unterschiedliche Buttons deren Action commands weiter gegeben werden.
 * @version 1.0, 18 Mär 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 */

public class Clones extends Frame implements ActionListener {
    private int Zustand;
    private Color color;
    Button cycleButton = new Button("Farbwechsel");
    Button cloneButton = new Button("Neues Fenster");
    
// Konstruktor von Clones Frame.
    
    Clones() {
        setLayout(new FlowLayout(1, 10, 20));
        cycleButton.addActionListener(this);
        cloneButton.addActionListener(this);
        cycleButton.setActionCommand("cycle");
        cloneButton.setActionCommand("clone");
        add(cycleButton);
        add(cloneButton);
    }
    
    
    /*Methode für Farbwechsel über switchcase
     * 
     * @param 
     * @return Color color
     */

    public Color colorCycle () {
        switch (Zustand) {
            case 0:
                Zustand += 1;
                color = Color.black;
                break;
            case 1:
                Zustand += 1;
                color = Color.blue;
                break;
            case 2:
                Zustand += 1;
                color = Color.cyan;
                break;
            case 3:
                Zustand += 1;
                color = Color.gray;
                break;
            case 4:
                Zustand += 1;
                color = Color.green;
                break;
            case 5:
                Zustand += 1;
                color = Color.magenta;
                break;
            case 6:
                Zustand += 1;
                color = Color.orange;
                break;
            case 7:
                Zustand += 1;
                color = Color.pink;
                break;
            case 8:
                Zustand += 1;
                color = Color.red;
                break;
            case 9:
                Zustand += 1;
                color = Color.white;
                break;
            case 10:
                Zustand = 0;
                color = Color.yellow;
                break;
        }
        return color;
    }
 // Funktion um das Fenster manuell zu schließen.
    
    static class WindowQuitter extends WindowAdapter { // Listener für WindowEvents
        public void windowClosing(WindowEvent e) {
            System.exit(0); // Programm beenden
        }
    }
/* Abfrage zur Farbwechsel und klonen methode.
 * 
 * @param ActionEvent evt
 * @return void
 */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("cycle")) // Kommando abfragen
            setBackground(colorCycle()); // schwarz Farbe setzen
        else if (evt.getActionCommand().equals("clone")) {
            Clones demo = new Clones();
            Clones.WindowQuitter wquit = new Clones.WindowQuitter(); // Listener erzeugen
            demo.addWindowListener( wquit ); // und registrieren
            demo.setSize( 200, 155 );
            demo.setVisible( true );
        }
    }

    public static void main ( String[] args ){
        Clones demo = new Clones();
        Clones.WindowQuitter wquit = new Clones.WindowQuitter(); // Listener erzeugen
        demo.addWindowListener( wquit ); // und registrieren
        demo.setSize( 200, 155 );
        demo.setVisible( true );
    }
}