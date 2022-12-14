package Maxprogramm;

import java.util.Random;

import javax.swing.*;
import java.awt.GridLayout;
import java.io.Serializable;

/*
 * Dieses Klasse erstellt das Spielfeld auf dem der Spieler sich bewegen kann und f�llt die Felder mit werten.
 * 
 * @version 1.4, 11 April 2021
 * 
 * @author Pascal Knie, Marvin Voss , Pascal Brostean, Robin Eberle
 */

@SuppressWarnings("serial")
public class Spielfeld extends JFrame implements Serializable  {

	JLabel[][] label = new JLabel[11][11];
	Random zufallszahl = new Random();
	Fraction[][] feld = new Fraction[11][11];
	JPanel spielfeld = new JPanel();
/**
 * konstruktor f�r Spielfeld
 * Spielfeld Panel wird erstellt und die Fractions als text gesetzt.
 * Matrix wird erstellt und mit Fractions gef�llt.
 */
	public Spielfeld() {
		
		for (int y = 1; y < feld.length; y++) { 
			for (int x = 1; x < feld.length; x++) { // jede koordinate des Spielfelds wird mit TextLabel und wert gef�llt
				
				if (y == 5 && x >= 5 && x <= 6 || y == 6 && x >= 5 && x <= 6  ) { // die vier mittleren Felder werden mit 0 erstellt.
					feld[y][x] = new Fraction(0, 1); // wert des feldes XY
					
					label[y][x] = new JLabel(feld[y][x].toString(), 0); // text des feldes XY
					
					spielfeld.add(label[y][x]); // label wird dem Spielfeld hinzugef�gt
			
				} else {
					
					long z�hler = Math.round(Math.random() * 500 + 1); //Zufallszahl f�r z�hler
					
					long nenner = Math.round(Math.random() * 400 + 5); //Zufallszahl f�r nener
					
					feld[y][x] = new Fraction(z�hler, nenner); //neue Fraction wird erstellt
					
					label[y][x] = new JLabel(feld[y][x].toString(), 0); // Label mit der Fraction als text wird erstellt 
					
					spielfeld.add(label[y][x]); // Label hinzuf�gen
				}
			}
			spielfeld.setLayout(new GridLayout(10, 1));
		}
	}
/**
 * methode um Fraction-wert an Position x y zur�ck zu geben.
 * 
 * Spielernummer wird auf das aktuelle feld des Spielers ausgegeben.
 * vorherige Position des Spielers wird auf Null gesetzt.
 * 
 * @param x  xcoord des Spielers der zieht
 * @param y  ycoord ...
 * @param spielernr ...
 * @param prevX  vorherige x-coordinate des Spielers
 * @param prevY  vorherige y-coordinate des Spielers
 * 
 * @return essen Fraction-wert 
 */
	public Fraction essen(int x, int y,int spielernr,int prevX,int prevY) {

		
		Fraction essen = feld[y][x]; // wert von feld XY wird gespeichert   // X und y getauscht
		
		feld[y][x] = new Fraction(0, 1); // wert von feld XY wird auf 0 gesetzt   // X und y getauscht
		if(prevY != 0 && prevX != 0) {	
		label[prevY][prevX].setText("[0/1]");  // Text auf voheriger Spielerposition wird zu 0 ge�ndert
		}
		
 		label[y][x].setText(""+ spielernr); // momentane position des Spielers wird zu Spieler Nummer ge�ndert.

		return essen; 
	}
/**
 * 
 * @return spielfeld des Spielfeld objekts.
 */
	public JPanel getFeld() {
		return spielfeld;
	}
}


// alte Methoden


/**
 * Methode um Fenster zu Schlie�en
 */
	/*class WindowQuitter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}*/
	
	/*public void add(JPanel panel) {
		frm.add(panel);
	}*/