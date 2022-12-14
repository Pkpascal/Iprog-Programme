package second;

import java.awt.*;
import java.awt.event.*;
/*
 * Dieses Programm erzeugt ein Fenster, dass das kombinationsfeld eines Safes simuliert. 
 * 
 * Die Eingabe erfolgt über Buttons welche mit einen String Array, in dem die kombination ist, verglichen werden.
 * 
 * Wird die richtige Eingabe "19032021" eingegeben endet das prograamm.
 * 
 * @version 1.0, 18 Mär 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 */

@SuppressWarnings("serial")
public class Safe extends Frame implements ActionListener {
	String[] kombination = new String[8];
	static Frame fmr = new Frame();
	int count = 0;

/* Konstruktor des Safes   
 * @param 
 * @return void
 */

	public Safe() {
		kombination[0] = "1";
		kombination[1] = "9";
		kombination[2] = "0";
		kombination[3] = "3";
		kombination[4] = "2";
		kombination[5] = "0";
		kombination[6] = "2";
		kombination[7] = "1";

		Button button1 = new Button("1");
		Button button2 = new Button("2");
		Button button3 = new Button("3");
		Button button4 = new Button("4");
		Button button5 = new Button("5");
		Button button6 = new Button("6");
		Button button7 = new Button("7");
		Button button8 = new Button("8");
		Button button9 = new Button("9");
		Button button0 = new Button("0");

		button1.setActionCommand("1");
		button2.setActionCommand("2");
		button3.setActionCommand("3");
		button4.setActionCommand("4");
		button5.setActionCommand("5");
		button6.setActionCommand("6");
		button7.setActionCommand("7");
		button8.setActionCommand("8");
		button9.setActionCommand("9");
		button0.setActionCommand("0");

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);

		fmr.add(button1);
		fmr.add(button2);
		fmr.add(button3);
		fmr.add(button4);
		fmr.add(button5);
		fmr.add(button6);
		fmr.add(button7);
		fmr.add(button8);
		fmr.add(button9);
		fmr.add(button0);
		fmr.setLayout(new FlowLayout(1,10,175));

	}

	public static void main(String[] args) {
		Safe safe = new Safe();
		WindowQuitter wquit = new WindowQuitter();
		fmr.addWindowListener(wquit);
		fmr.setSize(600, 450);
		fmr.setVisible(true);
	}

	/*Abgleich von eingabe und kombination.
	 * 
	 * @param ActionEvent zahl
	 * @return void
	 */

	public void actionPerformed(ActionEvent zahl) {

		if (count == 7) {
			System.out.println("Safe geöffnet!");
			System.exit(0);
		}
		if (zahl.getActionCommand().equals(kombination[count])) {
			fmr.setBackground(Color.green);
			count++;
		} else {
			fmr.setBackground(Color.red);
			count = 0;

		}

	}

}

// Funktion um das Fenster manuell zu schließen.
class WindowQuitter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
