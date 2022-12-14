package second;

import java.awt.*;
import java.awt.event.*;

/*
 * Dieses Programm erzeugt ein Fenster, dessen Hintergrundfarbe manuell geändert werden kann. 
 * 
 * Die Eingabe erfolgt über 11 unterschiedliche Buttons deren Action commands weiter gegeben werden.
 * 
 * @version 1.0, 18 Mär 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 */

public class ElevenColors extends Frame implements ActionListener {
    Button blackButton = new Button("Schwarz");
    Button blueButton = new Button("Blau");
    Button cyanButton = new Button("Cyan");
    Button grayButton = new Button("Grau");
    Button greenButton = new Button("Grün");
    Button magentaButton = new Button("Magenta");
    Button orangeButton = new Button("Orange");
    Button pinkButton = new Button("Pink");
    Button redButton = new Button("Rot");
    Button whiteButton = new Button("Weiß");
    Button yellowButton = new Button("Gelb");

    //Konstruktor für Eleven colours Frame
    
    ElevenColors() {
        setLayout( new FlowLayout() );
        blackButton.addActionListener( this );
        blueButton.addActionListener( this );
        cyanButton.addActionListener( this );
        grayButton.addActionListener( this );
        greenButton.addActionListener( this );
        magentaButton.addActionListener( this );
        orangeButton.addActionListener( this );
        pinkButton.addActionListener( this );
        redButton.addActionListener( this );
        whiteButton.addActionListener( this );
        yellowButton.addActionListener( this );
        blackButton.setActionCommand( "schwarz" ); // Kommando für schwarzen Knopf
        blueButton.setActionCommand( "blau" ); // Kommando für blauen Knopf
        cyanButton.setActionCommand( "cyan"); // Kommando für cyan Knopf
        grayButton.setActionCommand( "grau" ); // Kommando für grauen Knopf
        greenButton.setActionCommand( "grün" ); // Kommando für grünen Knopf
        magentaButton.setActionCommand( "magenta" ); // Kommando für magenta Knopf
        orangeButton.setActionCommand( "orange" ); // Kommando für orangenen Knopf
        pinkButton.setActionCommand( "pink" ); // Kommando für pinken Knopf
        redButton.setActionCommand( "rot" ); // Kommando für roten Knopf
        whiteButton.setActionCommand( "weiß" ); // Kommando für weißen Knopf
        yellowButton.setActionCommand( "gelb" ); // Kommando für gelben Knopf
        add( blackButton );
        add( blueButton );
        add( cyanButton );
        add( grayButton );
        add( greenButton );
        add( magentaButton );
        add( orangeButton );
        add( pinkButton );
        add( redButton );
        add( whiteButton );
        add( yellowButton );
    }
    
/*Vergleich der Eingabe für unterschiedliche Befehle
 * 
 * @param ActionEvent 
 * @return void
 */
    public void actionPerformed( ActionEvent evt) {
    	
        if ( evt.getActionCommand().equals( "schwarz" ) ) // Kommando abfragen
            setBackground( Color.black ); // schwarz Farbe setzen
        else if ( evt.getActionCommand().equals( "blau" ) )
            setBackground( Color.blue ); // blaue Farbe setzen
        else if ( evt.getActionCommand().equals( "cyan" ) )
            setBackground( Color.cyan ); // cyan Farbe setzen
        else if ( evt.getActionCommand().equals( "grau" ) )
            setBackground( Color.gray ); // graue Farbe setzen
        else if ( evt.getActionCommand().equals( "grün" ) )
            setBackground( Color.green ); // grüne Farbe setzen
        else if ( evt.getActionCommand().equals( "magenta" ) )
            setBackground( Color.magenta ); // magenta Farbe setzen
        else if ( evt.getActionCommand().equals( "orange" ) )
            setBackground( Color.orange ); // orangene Farbe setzen
        else if ( evt.getActionCommand().equals( "pink" ) )
            setBackground( Color.pink ); // pinke Farbe setzen
        else if ( evt.getActionCommand().equals( "rot" ) )
            setBackground( Color.red ); // rote Farbe setzen
        else if ( evt.getActionCommand().equals( "weiß" ) )
            setBackground( Color.white ); // weiße Farbe setzen
        else if ( evt.getActionCommand().equals( "gelb" ) )
            setBackground( Color.yellow ); // gelbe Farbe setzen
        repaint(); // neu zeichnen
    }
 // Funktion um das Fenster manuell zu schließen.
    
    static class WindowQuitter extends WindowAdapter { // Listener für WindowEvents
        public void windowClosing(WindowEvent e) {
            System.exit(0); // Programm beenden
        }
    }

    public static void main ( String[] args ){
        ElevenColors demo = new ElevenColors();
        WindowQuitter wquit = new WindowQuitter(); // Listener erzeugen
        demo.addWindowListener( wquit ); // und registrieren
        demo.setSize( 200, 155 );
        demo.setVisible( true );
    }
}