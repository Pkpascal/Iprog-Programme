package Maxprogramm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

/*
 * Dieses Programm erzeugt ein Fenster, mit dem man ein Spiel statren kann
 * hier kann die Spieler menge bestimmt werden 
 * @version 1.3, 16 April 2021
 * 
 * @author Pascal Knie, Marvin Voss , Pascal Brostean, Robin Eberle
 */

@SuppressWarnings("serial")
public class Max extends JFrame implements ActionListener {

	static JFileChooser choose = new JFileChooser(new File("c://aabb")); // Start-Directory

	JFrame main = new JFrame();
	JPanel contentPane = new JPanel();
	static MaxGUI maxGUIsave;

	/**
	 * kontruktor für Neues Fenster bei dem Spieleranzahl ausgewählt werden kann.
	 * Auswahl startet das Spiel
	 */
	public Max() {

		choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sel.-Modus

		// Menü zum aufrufen alter spielstände wird erstellt
		JMenuBar menu = new JMenuBar();
		JMenu datei = new JMenu("Datei");
		JMenuItem laden = new JMenuItem("Datei Laden");

		datei.add(laden);
		menu.add(datei);

		laden.addActionListener(new OpenL());

		// Content pane wird bearbeitet
		contentPane.setOpaque(true);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(null);

		// Buttons für spieleranzahl werden erstellt
		JButton a = new JButton("1");
		a.setSize(100, 100);
		a.setLocation(100, 200);
		a.setActionCommand("1");
		a.addActionListener(this);

		JButton b = new JButton("2");
		b.setSize(100, 100);
		b.setLocation(250, 200);
		b.setActionCommand("2");
		b.addActionListener(this);

		JButton c = new JButton("3");
		c.setSize(100, 100);
		c.setLocation(400, 200);
		c.setActionCommand("3");
		c.addActionListener(this);

		JButton d = new JButton("4");
		d.setSize(100, 100);
		d.setLocation(550, 200);
		d.setActionCommand("4");
		d.addActionListener(this);

		// Text Spieleranzahl wird erstellt
		JLabel text = new JLabel("Spieler Anzahl:");
		text.setFont(text.getFont().deriveFont(32.0f));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setVerticalAlignment(SwingConstants.BOTTOM);
		text.setSize(750, 150);

		// Buttons und Text wird dem Pane hinzugefügt
		contentPane.add(menu);
		contentPane.add(text);
		contentPane.add(a);
		contentPane.add(b);
		contentPane.add(c);
		contentPane.add(d);

		// Main bekommt borderLayout bei dem menu im norden hinzugefügt wird
		main.setLayout(new BorderLayout());
		main.add(menu, BorderLayout.NORTH);
		
		// Pane wird auf den Frame gesetzt und skaliert.
		WindowQuitter wqt = new WindowQuitter();
		main.add(contentPane, BorderLayout.CENTER);
		main.setSize(750, 400);
		main.setLocationByPlatform(true);
		main.addWindowListener(wqt);
		main.setVisible(true);

	}
	// Main Methode des Max Spiels

	public static void main(String[] args) {
		// Anfangs Fenster wird erstellt
		new Max();

	}

	/**
	 * abfrage auf Tastendruck Spiel-methode wird aufgerufen und dort alle Spieler
	 * und deren Funktionen erstellt eine neue GUI wird erstellt und das
	 * Spieler-array und spielfeld werden mitgegeben.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		switch (arg0.getActionCommand()) { // abfrage auf eingabe

		case "1":
			// Neues Spielfeld
			Spielfeld spielfeld = new Spielfeld();

			// Neues Spieler Array
			Player[] players = Player.play(1, spielfeld);

			// Spielfeld für alle Spieler im Array wird festgelegt
			for (Player player : players) {
				player.setSpielfeld(spielfeld);
			}
			// Neue MaxGUI wird erstellt.
			MaxGUI max1 = new MaxGUI(players, spielfeld);
			setMaxGUISave(max1);

			break;
		case "2":
			Spielfeld spielfeld2 = new Spielfeld();

			Player[] players2 = Player.play(2, spielfeld2);

			for (Player player : players2) {
				player.setSpielfeld(spielfeld2);
			}
			MaxGUI max2 = new MaxGUI(players2, spielfeld2);

			setMaxGUISave(max2);

			break;
		case "3":
			Spielfeld spielfeld3 = new Spielfeld();

			Player[] players3 = Player.play(3, spielfeld3);

			for (Player player : players3) {
				player.setSpielfeld(spielfeld3);
			}

			MaxGUI max3 = new MaxGUI(players3, spielfeld3);
			setMaxGUISave(max3);
			break;
		case "4":
			Spielfeld spielfeld4 = new Spielfeld();

			Player[] players4 = Player.play(4, spielfeld4);

			for (Player player : players4) {
				player.setSpielfeld(spielfeld4);
			}

			MaxGUI max4 = new MaxGUI(players4, spielfeld4);
			setMaxGUISave(max4);

			break;

		}
	}

	public void setMaxGUISave(MaxGUI save) {
		maxGUIsave = save;
	}

}

class OpenL implements ActionListener { // AL fuer Oeffne-Knopf
	public void actionPerformed(ActionEvent ae) {
		int rVal = MaxGUI.choose.showOpenDialog(null); // Oeffne-Dialog oeffnen
		if (rVal == JFileChooser.APPROVE_OPTION) { // falls bestaetigt:
			try {
				FileInputStream fs = new FileInputStream(MaxGUI.choose.getSelectedFile().getPath());
				ObjectInputStream is = new ObjectInputStream(fs);

				new MaxGUI((MaxGUI) is.readObject()); // Objekt lesen
				// und ausgeben
				is.close();
			} catch (IOException | ClassNotFoundException e) {
				System.err.println(e);
			}
		}
		if (rVal == JFileChooser.CANCEL_OPTION) { // falls abgebrochen:
			System.out.println("cancel");
		}
	}
}

class SaveL implements ActionListener { // AL fuer Speichern-Knopf
	public void actionPerformed(ActionEvent ae) {
		int rVal = MaxGUI.choose.showSaveDialog(null); // Speichern-Dialog oeffnen
		if (rVal == JFileChooser.APPROVE_OPTION) { // falls bestaetigt:
			try {
				FileOutputStream fs = new FileOutputStream(MaxGUI.choose.getSelectedFile().getPath() + ".class");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				os.writeObject(Max.maxGUIsave);  //das aktuellste Spiel wird gespeichert
				System.out.println("gespeichert");
				os.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		if (rVal == JFileChooser.CANCEL_OPTION) { // falls abgebrochen:
			System.out.println("cancel");
		}
	}

}

//Funktion um das Fenster manuell zu schließen.
class WindowQuitter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}