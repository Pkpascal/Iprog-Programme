package second;

import java.awt.*;
import java.awt.event.*;

/*
 * Dieses Programm erzeugt ein Fenster, dessen Hintergrundfarbe manuell ge�ndert werden kann. 
 * 
 * Die Eingabe erfolgt �ber 11 unterschiedliche Buttons deren Action commands weiter gegeben werden.
 * 
 * @version 1.0, 18 M�r 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 */

public class ElevenColors extends Frame implements ActionListener {
    Button blackButton = new Button("Schwarz");
    Button blueButton = new Button("Blau");
    Button cyanButton = new Button("Cyan");
    Button grayButton = new Button("Grau");
    Button greenButton = new Button("Gr�n");
    Button magentaButton = new Button("Magenta");
    Button orangeButton = new Button("Orange");
    Button pinkButton = new Button("Pink");
    Button redButton = new Button("Rot");
    Button whiteButton = new Button("Wei�");
    Button yellowButton = new Button("Gelb");

    //Konstruktor f�r Eleven colours Frame
    
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
        blackButton.setActionCommand( "schwarz" ); // Kommando f�r schwarzen Knopf
        blueButton.setActionCommand( "blau" ); // Kommando f�r blauen Knopf
        cyanButton.setActionCommand( "cyan"); // Kommando f�r cyan Knopf
        grayButton.setActionCommand( "grau" ); // Kommando f�r grauen Knopf
        greenButton.setActionCommand( "gr�n" ); // Kommando f�r gr�nen Knopf
        magentaButton.setActionCommand( "magenta" ); // Kommando f�r magenta Knopf
        orangeButton.setActionCommand( "orange" ); // Kommando f�r orangenen Knopf
        pinkButton.setActionCommand( "pink" ); // Kommando f�r pinken Knopf
        redButton.setActionCommand( "rot" ); // Kommando f�r roten Knopf
        whiteButton.setActionCommand( "wei�" ); // Kommando f�r wei�en Knopf
        yellowButton.setActionCommand( "gelb" ); // Kommando f�r gelben Knopf
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
    
/*Vergleich der Eingabe f�r unterschiedliche Befehle
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
        else if ( evt.getActionCommand().equals( "gr�n" ) )
            setBackground( Color.green ); // gr�ne Farbe setzen
        else if ( evt.getActionCommand().equals( "magenta" ) )
            setBackground( Color.magenta ); // magenta Farbe setzen
        else if ( evt.getActionCommand().equals( "orange" ) )
            setBackground( Color.orange ); // orangene Farbe setzen
        else if ( evt.getActionCommand().equals( "pink" ) )
            setBackground( Color.pink ); // pinke Farbe setzen
        else if ( evt.getActionCommand().equals( "rot" ) )
            setBackground( Color.red ); // rote Farbe setzen
        else if ( evt.getActionCommand().equals( "wei�" ) )
            setBackground( Color.white ); // wei�e Farbe setzen
        else if ( evt.getActionCommand().equals( "gelb" ) )
            setBackground( Color.yellow ); // gelbe Farbe setzen
        repaint(); // neu zeichnen
    }
 // Funktion um das Fenster manuell zu schlie�en.
    
    static class WindowQuitter extends WindowAdapter { // Listener f�r WindowEvents
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