package second;

import java.awt.*;
import java.awt.event.*;

/*
 * Dieses Programm erzeugt ein Fenster, mit dessen "start" knopf neue Fenster erstellt werden können.
 * Die neuen Fenster änder durch eigene Threads zyklisch ihre Hintergrundfarbe nach den farben eines Regenbogens. 
 * Die Eingabe erfolgt über 1  Button dessen Action commands weiter gegeben werden.
 * 
 * @version 1.0, 18 Mär 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 */
public class Rainbow extends Frame implements ActionListener, Runnable {
    Color Indigo = new Color(79, 105, 198);
    Color Violett = new Color(153, 62, 255);
    Button startButton = new Button("Start");

    // Konstruktor den Start Frame der Rainbow Klasse
    
    Rainbow() {
        setLayout(new FlowLayout(1, 10, 45));
        startButton.addActionListener(this);
        startButton.setActionCommand("start");
        add(startButton);
        setBackground(Color.black);
    }

    // Konstruktor für die Regenbogen Frames
     
    Rainbow(String a) {
        setLayout(new FlowLayout(1, 10, 20));

    }
    
    /*Methode für den zyklischen Farbwechsel
     * @param
     * @return void
     */

    @Override
    public void run() {
        while (true){
            setBackground(Color.red);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBackground(Color.orange);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBackground(Color.yellow);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBackground(Color.green);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBackground(Color.blue);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBackground(Indigo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBackground(Violett);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 // Funktion um das Fenster manuell zu schließen.
    
    static class WindowQuitter extends WindowAdapter { // Listener für WindowEvents
        public void windowClosing(WindowEvent e) {
            System.exit(0); // Programm beenden
        }
    }

    /* Abfrage zur manuellen Erzeugung der Regenbogen Frames und zuordnung zu "wquit"
     * 
     * @param ActionEvent evt
     * @return void
     */
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("start")) { // Kommando abfragen
            Rainbow demo = new Rainbow("test");
            demo.remove(startButton);
            Rainbow.WindowQuitter wquit = new Rainbow.WindowQuitter(); // Listener erzeugen
            demo.addWindowListener(wquit); // und registrieren
            demo.setSize(200, 155);
            demo.setVisible(true);
            Thread t1 = new Thread(demo);
            t1.start();
        }
    }

    public static void main ( String[] args ){
        Rainbow demo = new Rainbow();
        Rainbow.WindowQuitter wquit = new Rainbow.WindowQuitter(); // Listener erzeugen
        demo.addWindowListener( wquit ); // und registrieren
        demo.setSize( 200, 155 );
        demo.setVisible( true );
    }
}