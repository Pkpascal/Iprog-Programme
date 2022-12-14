package second;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Dieses Programm erzeugt ein Fenster, dass das kombinationsfeld eines Safes simuliert. 
 * Das Eingabefeld rotiert seine buttons alle 3  sekunden gegen den Uhrzeigersinn alle neun Schritte wechselt die Rotationsrichtung. 
 * Die Eingabe erfolgt über Buttons welche mit einen String Array, in dem die kombination ist, verglichen werden.
 * 
 * Wird eine Falsche eingabe gemacht wird ein neues Safe fenster geöffnet, welches 33% schneller rotiert.
 * 
 * Wird die richtige Eingabe 8-5-2-9-6-3-0-7-4-1 eingegeben endet der Thread und das Fenster Schließt sich.
 * 
 * Werden alle Fenster geschlossen ist der Safe geöffnet und das Programm schließt.
 * 
 * 
 * @version 1.2, 25 Mär 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 */

@SuppressWarnings("serial")
public class ToggleSafe extends JFrame implements ActionListener, Runnable {
	String[] kombination = new String[10];
	int count = 0;
	JButton[] button;
	boolean rechts = false;
	long sleeptime = 3000;
	static int fenster = 0;
	int d = 9;
	JFrame frm = new JFrame();

	/*
	 * Konstruktor des Safes Kombinationscode wird festgelegt, Frame, Panels und
	 * Buttons werden erstellt und zugeordnet und die methode zum ändern der Ziffern
	 * wird aufgerufen.
	 */

	public ToggleSafe() {
		fenster++;
		
		frm.setSize(300, 300);
		frm.setLocation(230, 222);
		frm.setTitle("Safe");
		frm.setLayout(new GridLayout(4, 3));
		button = new JButton[10];

		for (int i = 0; i < 10; i++) {
			button[i] = new JButton("" + i);
			button[i].setActionCommand("" + i);
			button[i].addActionListener(this);
		}
		// KombinationsArray wird gefüllt
		kombination[0] = "8";
		kombination[1] = "5";
		kombination[2] = "2";
		kombination[3] = "9";
		kombination[4] = "6";
		kombination[5] = "3";
		kombination[6] = "0";
		kombination[7] = "7";
		kombination[8] = "4";
		kombination[9] = "1";
		

		//Buttons werden erstellt und richtig angeordnet
		frm.add(button[0]);
		frm.add(button[9]);
		frm.add(button[8]);
		frm.add(button[1]);
		frm.add(new JPanel());
		frm.add(button[7]);
		frm.add(button[2]);
		frm.add(new JPanel());
		frm.add(button[6]);
		frm.add(button[3]);
		frm.add(button[4]);
		frm.add(button[5]);
		
		//Sleeptime wird mit jedem neuen Fenster verringert
	 for(int i = 0; i<fenster;i++) {
		 sleeptime *=2/3F;
		 }

		frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frm.setVisible(true);
		new Thread(this).start();

	}

	public static void main(String[] args) {

		new ToggleSafe();
	}

	/*Abgleich von eingabe und kombination.
	 *
	 * @param ActionEvent zahl   Gedrückter Button
	 */
	public void actionPerformed(ActionEvent zahl) {

		if (count == kombination.length-1) { // Volle Kombination eingegeben?
			
			fenster--;
			frm.setVisible(false); // fenster wird geschlossen 

		}
		if (fenster <= 0) { // Alle Safe-Fenster geöffnet?
			System.out.println("Safe geöffnet!");
			System.exit(0);
		}
		if (zahl.getActionCommand().equals(kombination[count])) { //Eingabe richtig
			for (int i = 0; i < 10; i++) {
				button[i].setBackground(Color.GREEN);

			}
			count++;
		} else {
			for (int i = 0; i < 10; i++) { // Eingabe falsch
				button[i].setBackground(Color.RED);

			}
			count = 0;
			new ToggleSafe(); // neuer Safe bei fehlversuch
		}

	}
	/*
	 * Methode zum rotieren der Safe-Ziffern
	 * Alle neun durchgänge wird die rotationsrichtung geändert
	 */

	@Override
	public void run() {
		while (true) {
			
			for (int step = 0; step<9; step++) { // neun durchgänge
				
			for (int i = 0; i < 10; i++) { // buttons werden auf oder abgezählt
				String s = "" + ((Integer.parseInt(button[i].getText()) + d) % 10);
				button[i].setText(s);
				button[i].setActionCommand(s);
			}
			try {
				Thread.sleep(sleeptime);
			} catch (Exception e) {
				;
			}
			} d = 10 - d; // richtungsänderung

		}
	}

}
