package Maxprogramm;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.math.BigInteger;
import javax.swing.*;
/*
 * Dieses Klasse erstellt den Spieler mit seinen Funktionen und Methoden für das Spiel.
 * 
 * @version 1.5, 15 April 2021
 * 
 * @author Pascal Knie, Marvin Voss , Pascal Brostean, Robin Eberle
 */

@SuppressWarnings("serial")
public class Player implements ActionListener, Serializable {
	Player nextPlayer;
	boolean spielt = true;
	int spielerNr;
	int xcoord;
	int ycoord;
	int prevY;
	int prevX;
	boolean amZug = false;
	Fraction count = new Fraction(new BigInteger("0"), new BigInteger("1"));
	JPanel sPfeiltasten = new JPanel();
	JTextField ausgabe = new JTextField(8);
	Spielfeld spielerSpielfeld;

	/**
	 * Konstruktor für Spieler object Pfeiltasten Butoons und Textfeld werden
	 * erstellt und einem Label hinzugefügt.
	 * 
	 * @param nr     spieler nummer
	 * @param xcoord x-koordinate für spieler
	 * @param ycoord y-koordinate für spieler
	 */

	public Player(int nr, int xcoord, int ycoord) {

		spielerNr = nr;
		this.xcoord = xcoord;
		this.ycoord = ycoord;

		// Pfeiltasten werden erstellt
		JButton up = new JButton("^");
		JButton down = new JButton("v");
		JButton left = new JButton("<");
		JButton right = new JButton(">");
		right.addActionListener(this);
		left.addActionListener(this);
		up.addActionListener(this);
		down.addActionListener(this);
		right.setActionCommand("d");
		up.setActionCommand("w");
		left.setActionCommand("a");
		down.setActionCommand("s");

		// Spieler Nummer Label wird erstellt
		JLabel spieler = new JLabel("Spieler " + spielerNr);

		// Pfeiltasten und ausgabe werden in Panel zusammengefügt

		sPfeiltasten.add(spieler);
		sPfeiltasten.add(ausgabe);
		sPfeiltasten.add(up);
		sPfeiltasten.add(left);
		sPfeiltasten.add(down);
		sPfeiltasten.add(right);
		sPfeiltasten.setLayout(new FlowLayout());

		ausgabe.setBackground(Color.yellow);
		ausgabe.setText("");
		ausgabe.setEditable(false);

	}

	/**
	 * Das Spieler Label wird zurückgegeben
	 * 
	 * @return sPfeiltasten eines Spielers
	 */
	public JPanel getPfeiltatsen() {
		return sPfeiltasten;
	}

	/**
	 * Setzt ein Spielfeld für den Spieler fest
	 * 
	 * @param spielfeld
	 */
	public void setSpielfeld(Spielfeld spielfeld) {
		spielerSpielfeld = spielfeld;
	}

	/**
	 * @return xcoord von spieler
	 */
	public int getxcoord() {
		return xcoord;
	}

	public void changeAusgabe(String ausgegeben) {
		ausgabe.setText(ausgegeben);
	}

	/**
	 * @return ycoord von spieler
	 */
	public int getycoord() {
		return ycoord;
	}

	/**
	 * @return spielerNr Spieler nummer
	 */
	public int getSpielerNr() {
		return spielerNr;
	}

	/**
	 * Methode um Spieler ziehen zu lassen oder nicht.
	 * 
	 * @param amZug Zugreihenfolge
	 */
	public void setamZug(boolean amZug) {
		this.amZug = amZug;
	}

	/**
	 * methode um spieler auf dem Spielfeld zu bewegen.
	 * 
	 * @param bewegung w,a,s,d um richtung vorzugeben.
	 */
	public void move(String bewegung) {
		switch (bewegung) {

		case "a": // nach links
			if (xcoord > 1) { // Abfrage ob das Feld existiert.

				// Vorherige Position des Spielers wird gespeichert.
				prevY = ycoord;
				prevX = xcoord;

				xcoord--; // Spieler wird nach Links bewegt

				break;
			} else { // Spieler befindet sich am Rand des Spielfelds.

				nextPlayer.setamZug(false);
				nextPlayer.ausgabe.setBackground(Color.yellow);

				setamZug(true);
				ausgabe.setBackground(Color.green);

				break;
			}
		case "s": // nach unten
			if (ycoord < 10) {
				prevY = ycoord;
				prevX = xcoord;
				ycoord++;

				break;
			} else {
				nextPlayer.setamZug(false);
				nextPlayer.ausgabe.setBackground(Color.yellow);

				setamZug(true);
				ausgabe.setBackground(Color.green);

				break;
			}

		case "w": // nach oben
			if (ycoord > 1) {
				prevY = ycoord;
				prevX = xcoord;

				ycoord--;

				break;
			} else {
				nextPlayer.setamZug(false);
				nextPlayer.ausgabe.setBackground(Color.yellow);

				setamZug(true);
				ausgabe.setBackground(Color.green);

				break;
			}
		case "d": // nach rechts
			if (xcoord < 10) {
				prevY = ycoord;
				prevX = xcoord;
				xcoord++;
				break;
			} else {
				nextPlayer.setamZug(false);
				nextPlayer.ausgabe.setBackground(Color.yellow);

				setamZug(true);
				ausgabe.setBackground(Color.green);

				break;
			}
		default:
			ausgabe.setText("Falsche Eingabe");
			setamZug(true);
			break;
		}
	}

	/**
	 * methode um count mit der Fraction vom Spielfeld an Position X Y
	 * aufzuaddieren.
	 */
	public void eat() {
		count = count.add(spielerSpielfeld.essen(xcoord, ycoord, spielerNr, prevX, prevY));
	}

	/**
	 * Methode die nach gewonnenem spiel abfragt und die gesammelten Punkte des
	 * Spielers ausgibt
	 */
	public void ziehen() {

		eat();

			if (count.intValue() >= 49) { // abfrage auf gewonnen
				spielt = false; // spiel wird beendet
				nextPlayer.spielt = false;
				nextPlayer.nextPlayer.spielt = false;
				nextPlayer.nextPlayer.nextPlayer.spielt = false;
				ausgabe.setText("Spieler " + spielerNr + " hat gewonnen");
			}

			else {

					String wert = "" + count.doubleValue() + "     "; // String zum kürzen des double wertes. Leerzeichen für Fehlervermeidung.

					ausgabe.setText("~" + wert.substring(0, 5)); // Ausgabe des werts auf ausgabe TextFeld.

				}
			
		}

	

	/**
	 * methode um Spielerobjekte und Spielfeld je nach Spielermenge zu erstellen
	 * Spieler werden dem spieler array hinzugefügt.
	 * 
	 * @param spieleranzahl Menge der Mitspieler
	 */
	public static Player[] play(int spieleranzahl, Spielfeld spielfeld) {
		Player[] players = new Player[spieleranzahl];
		switch (spieleranzahl) {

		case 1:
			Player first1 = new Player(1, 5, 5); // Erstellen der Spieler.

			first1.nextPlayer = first1;

			players[0] = first1; // Spieler werden in Array hinzugefügt.

			spielfeld.label[5][5].setText("1"); // Startposition der Spieler werden neu gelabelt.

			first1.setamZug(true); // Zug des ersten Spielers wird freigeschaltet.
			first1.ausgabe.setBackground(Color.green);

			break;

		case 2:
			Player first2 = new Player(1, 5, 5);
			Player second2 = new Player(2, 6, 6);

			first2.nextPlayer = second2;
			second2.nextPlayer = first2;

			players[0] = first2;
			players[1] = second2;

			spielfeld.label[5][5].setText("1");
			spielfeld.label[6][6].setText("2");

			first2.setamZug(true);
			first2.ausgabe.setBackground(Color.green);
			break;

		case 3:
			Player first3 = new Player(1, 5, 5);
			Player second3 = new Player(2, 6, 6);
			Player third3 = new Player(3, 5, 6);

			first3.nextPlayer = second3;
			second3.nextPlayer = third3;
			third3.nextPlayer = first3;

			players[0] = first3;
			players[1] = second3;
			players[2] = third3;

			spielfeld.label[5][5].setText("1");
			spielfeld.label[6][6].setText("2");
			spielfeld.label[6][5].setText("3");

			first3.setamZug(true);
			first3.ausgabe.setBackground(Color.green);

			break;
		case 4:

			Player first4 = new Player(1, 5, 5);
			Player second4 = new Player(2, 6, 6);
			Player third4 = new Player(3, 5, 6);
			Player forth4 = new Player(4, 6, 5);

			first4.nextPlayer = second4;
			second4.nextPlayer = third4;
			third4.nextPlayer = forth4;
			forth4.nextPlayer = first4;

			players[0] = first4;
			players[1] = second4;
			players[2] = third4;
			players[3] = forth4;

			spielfeld.label[5][5].setText("1");
			spielfeld.label[6][6].setText("2");
			spielfeld.label[6][5].setText("3");
			spielfeld.label[5][6].setText("4");

			first4.setamZug(true);
			first4.ausgabe.setBackground(Color.green);

			break;

		}
		return players;
	}

	/**
	 * Abfrage auf Tastendruck und bestimmen der Zugreihenfolge
	 */
	int x = 0;
	@Override
	public void actionPerformed(ActionEvent movement) {

		if (spielt == true) { // Abfrage ob Spiel noch aktiv

			if (amZug == true) { // Abfrage ob Spieler am Zug ist.

				setamZug(false); // Zug des Spielers wird beendet

				nextPlayer.setamZug(true); // nächster Spieler darf ziehen

				ausgabe.setBackground(Color.yellow); // ausgabe wird geld gefärbt

				nextPlayer.ausgabe.setBackground(Color.green); // ausgabe des nächsten Spielers wird grün gefärbt

				move(movement.getActionCommand()); // Spieler wird bewegt

				ziehen(); // Spieler führt aktion auf dem feld aus.

			} else { // Spieler ist nicht am Zug Textfeld wird für 1000ms Rot und gibt "Nicht am Zug" aus.
					while(x == 0) {	
						x++;
				String oldText = ausgabe.getText();
				
				ausgabe.setText("Nicht am Zug");
				ausgabe.setBackground(Color.red);
				Timer timer = new Timer(1000, event -> {
					ausgabe.setText(oldText);
					ausgabe.setBackground(Color.yellow);
					x--;
				});
				timer.setRepeats(false);
				timer.start();
					}
			}

		} 
	}

}

// Alte Methoden

/*
 * public static JPanel getPfeiltasten() { JPanel aPfeiltasten = new JPanel();
 * for(int i = 0;i<players.length-1;i++) {
 * aPfeiltasten.add(players[i].sPfeiltasten); } return aPfeiltasten; }
 */

/*
 * public void nextMove() { player.setamZug(false);
 * player.nextPlayer.setamZug(true); }
 */

/*
 * if (zugreihenfolge[spielerNr] != null) {
 * zugreihenfolge[spielerNr].setamZug(true); // Zug des nächsten Spielers
 * freischalten. } else { zugreihenfolge[0].setamZug(true); // der letze Spieler
 * sschaltet spieler 1 wieder frei: }
 */

/*
 * Spielfeld.getFrame().add(first3.pfeiltasten, BorderLayout.SOUTH);
 * Spielfeld.getFrame().add(second3.pfeiltasten, BorderLayout.SOUTH);
 * Spielfeld.getFrame().add(third3.pfeiltasten, BorderLayout.SOUTH);
 */
/*
 * public static void addMovement() { for (int i = 0; i < players.length; i++) {
 * Spielfeld.getFrame().add(players[i].pfeiltasten, BorderLayout.SOUTH); } }
 */

/**
 * Setzt den Text von den anfangs Positionen der Spieler auf die Spieler Nummer.
 */
/*
 * public static void positionen() { if (players[0] != null) { for (int i = 0; i
 * < Player.players.length; i++) {
 * Spielfeld.label[players[i].getycoord()][players[i].getxcoord()].setText("" +
 * players[i].getSpielerNr()); // Anfangsposition
 * Spielfeld.feld[players[i].getycoord()][players[i].getxcoord()] = new
 * Fraction(0, 1); } } }
 */

/**
 * Methode für Pfeiltasten und das Layout jedes Spielers
 */
/*
 * public void addMovement() { JPanel pfeiltasten = new JPanel(); JPanel
 * untenpfeiltasten = new JPanel(); JButton up = new JButton("^"); JButton down
 * = new JButton("v"); JButton left = new JButton("<"); JButton right = new
 * JButton(">"); right.addActionListener(this); left.addActionListener(this);
 * up.addActionListener(this); down.addActionListener(this);
 * right.setActionCommand("d"); up.setActionCommand("w");
 * left.setActionCommand("a"); down.setActionCommand("s");
 * pfeiltasten.setLayout(new BoxLayout(pfeiltasten, BoxLayout.Y_AXIS));
 * untenpfeiltasten.setLayout(new BoxLayout(pfeiltasten, BoxLayout.X_AXIS));
 * untenpfeiltasten.add(left); untenpfeiltasten.add(down);
 * untenpfeiltasten.add(right);
 *
 * pfeiltasten.add(up); pfeiltasten.add(untenpfeiltasten); }
 */