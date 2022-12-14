package second;

import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;

/*
 * Dieses Programm erzeugt ein Fenster, das einem zeigt welches Idealgewicht für eine bestimmte Größe und Geschlecht gilt.
 * 
 * 
 * @version 1.1, 25 Mär 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 */

public class IdealWeight extends JFrame implements ActionListener{
    JRadioButton genderM, genderF; // Knöpfe für Geschlecht
    ButtonGroup genderGroup; // ... dazu Knopfgruppe
    JPanel genderPanel; // ... dazu Panel
    JRadioButton heightA, heightB, heightC, heightD, heightE; // Kn. Grösse
    ButtonGroup heightGroup; // ... Gruppe
    JPanel heightPanel; // ... Panel
    JTextField resultText; // Textfeld für Ergebnis
    JLabel resultLabl; // ... dazu Label
    JPanel resultPanel; // ... dazu Panel
    
    
 // Konstruktor
    public IdealWeight() { 
        setTitle( "Your Ideal Weight" ); // Fenstertitel
        setDefaultCloseOperation( EXIT_ON_CLOSE ); // zum Fensterschliessen

        // Geschlechts-Gruppe
        genderM = new JRadioButton("Male", true ); // Knopf M. selekt.
        genderF = new JRadioButton("Female", false ); // Knopf F. nicht s.
        genderM.addActionListener(this); // ActionListener hinzufügen
        genderF.addActionListener(this); // ...
        genderGroup = new ButtonGroup(); // Gruppe def.
        genderGroup.add( genderM ); genderGroup.add( genderF ); // Kn. hinzufuegen
        genderPanel = new JPanel(); // G.-Panel
        genderPanel.setLayout( // Layout
                new BoxLayout( genderPanel, BoxLayout.Y_AXIS ) ); // ... vertikal
        genderPanel.add( new JLabel("Your Gender") ); // Label &
        genderPanel.add( genderM ); genderPanel.add( genderF ); // Knoepfe hinzuf.

        // Hoehen-Gruppe
        heightA = new JRadioButton("60 to 64 inches", true ); // ... selektiert
        heightB = new JRadioButton("64 to 68 inches", false ); // nicht selektiert
        heightC = new JRadioButton("68 to 72 inches", false ); // ...
        heightD = new JRadioButton("72 to 76 inches", false ); // ...
        heightE = new JRadioButton("76 to 80 inches", false ); // ...
        heightA.addActionListener(this); // ActionListener hinzufügen
        heightB.addActionListener(this); // ...
        heightC.addActionListener(this); // ...
        heightD.addActionListener(this); // ...
        heightE.addActionListener(this); // ...
        heightGroup = new ButtonGroup(); // Gruppe def.
        heightGroup.add( heightA ); heightGroup.add( heightB ); // Kn.
        heightGroup.add( heightC ); heightGroup.add( heightD ); // ... hinzufuegen
        heightGroup.add( heightE ); // ..
        heightPanel = new JPanel(); // H-Panel
        heightPanel.setLayout( // Layout
                new BoxLayout( heightPanel, BoxLayout.Y_AXIS ) ); // ... vertikal
        heightPanel.add( new JLabel("Your Height") ); // Label &
        heightPanel.add( heightA ); heightPanel.add( heightB ); // Kn. hinzufuegen
        heightPanel.add( heightC ); heightPanel.add( heightD ); // ...
        heightPanel.add( heightE ); // ...

        // Ergebnis-Panel
        resultText = new JTextField(7); // Textfeld
        resultText.setEditable( false ); // ... nur Ausgabe
        resultLabl = new JLabel("Ideal Weight"); // Label def.
        resultPanel = new JPanel(); // Panel def.
        resultPanel.add( resultLabl ); // Label hinzufuegen
        resultPanel.add( resultText ); // Textfeld ...

        // Gesamt-Fenster
        getContentPane().setLayout( new BorderLayout() ); // Layout: Border
        getContentPane().add( genderPanel, BorderLayout.WEST ); // G-Panel hinzuf.
        getContentPane().add( heightPanel, BorderLayout.EAST ); // H-Panel ...
        getContentPane().add( resultPanel, BorderLayout.SOUTH ); // Ergebnis-Panel ..

    }

    /**
     * Berechnung Idealgewicht Mann
     * @param a  "von-Größe"
     * @param b  "bis-Größe"
     * @return c Ergebnis
     */
    public String IdealWeightMale(int a, int b){ // Größenspanne
        int c; // Variable zum speichern des Ergebnisses
        int d; // ...
        c = (a*a)/30; // Berechnung Größe zu Idealgewicht
        d = (b*b)/30; // ...
        return c + " - " + d + " Pfd "; // Returned String mit Spanne des Idealgewichtes
    }

    /**
     * Berechnung Idealgewicht Frau
     * @param a  "von-Größe"
     * @param b  "bis-Größe"
     * @return c Ergebnis
     */
    public String IdealWeightFemale(int a, int b){ //Größenspanne
        int c;  // Variable zum speichern des Ergebnisses
        int d;  // ...
        c = (a*a)/28; // Berechnung Größe zu Idealgewicht
        d = (b*b)/28; // ...
        return c + " - " + d + " Pfd "; // Returned String mit Spanne des Idealgewichtes
    }

    /**
     * wie auf ein ActionEvent reagiert werden soll
     * 
     * @param ActionEvent e Eingabe durch "Radio Buttons"
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == heightA){
            if(genderM.isSelected() == true) {
                int a = 60;
                int b = 64;
                resultText.setText(IdealWeightMale(a, b));
            }
            else if(genderF.isSelected() == true) {
                    int a = 60;
                    int b = 64;
                    resultText.setText(IdealWeightFemale(a, b));
            }
        }
        else if (e.getSource() == heightB){
            if(genderM.isSelected() == true) {
                int a = 64;
                int b = 68;
                resultText.setText(IdealWeightMale(a, b));
            }
            else if(genderF.isSelected() == true) {
                    int a = 64;
                    int b = 68;
                    resultText.setText(IdealWeightFemale(a, b));
            }
        }
        else if (e.getSource() == heightC){
            if(genderM.isSelected() == true) {
                int a = 68;
                int b = 72;
                resultText.setText(IdealWeightMale(a, b));
            }
            else if(genderF.isSelected() == true) {
                    int a = 68;
                    int b = 72;
                    resultText.setText(IdealWeightFemale(a, b));
            }
        }
        else if (e.getSource() == heightD){
            if(genderM.isSelected() == true) {
                int a = 72;
                int b = 76;
                resultText.setText(IdealWeightMale(a, b));
            }
            else if(genderF.isSelected() == true) {
                    int a = 72;
                    int b = 76;
                    resultText.setText(IdealWeightFemale(a, b));
            }
        }
        else if (e.getSource() == heightE){
            if(genderM.isSelected() == true) {
                int a = 76;
                int b = 80;
                resultText.setText(IdealWeightMale(a, b));
            }
            else if(genderF.isSelected() == true) {
                    int a = 76;
                    int b = 80;
                    resultText.setText(IdealWeightFemale(a, b));
            }
        }
        else if (e.getSource() == genderF){
            if(heightA.isSelected() == true){
                int a = 60;
                int b = 64;
                resultText.setText(IdealWeightFemale(a, b));
            }
            else if(heightB.isSelected() == true){
                    int a = 64;
                    int b = 68;
                    resultText.setText(IdealWeightFemale(a, b));
            }
            else if(heightC.isSelected() == true){
                    int a = 68;
                    int b = 72;
                    resultText.setText(IdealWeightFemale(a, b));
            }
            else if(heightD.isSelected() == true){
                    int a = 72;
                    int b = 76;
                    resultText.setText(IdealWeightFemale(a, b));
            }
            else if(heightE.isSelected() == true){
                    int a = 76;
                    int b = 80;
                    resultText.setText(IdealWeightFemale(a, b));
            }
        }
        else if (e.getSource() == genderM){
            if(heightA.isSelected() == true){
                int a = 60;
                int b = 64;
                resultText.setText(IdealWeightMale(a, b));
            }
            else if(heightB.isSelected() == true){
                    int a = 64;
                    int b = 68;
                    resultText.setText(IdealWeightMale(a, b));
            }
            else if(heightC.isSelected() == true){
                    int a = 68;
                    int b = 72;
                    resultText.setText(IdealWeightMale(a, b));
            }
            else if(heightD.isSelected() == true){
                    int a = 72;
                    int b = 76;
                    resultText.setText(IdealWeightMale(a, b));
            }
            else if(heightE.isSelected() == true){
                    int a = 76;
                    int b = 80;
                    resultText.setText(IdealWeightMale(a, b));
            }
        }
    }


   
    public static void main ( String[] args ) { // main ...
        IdealWeight weightApp = new IdealWeight() ;
        weightApp.resultText.setText("120 - 136 Pfd");
        weightApp.setSize( 250, 225 );
        weightApp.setVisible( true );
    }
}