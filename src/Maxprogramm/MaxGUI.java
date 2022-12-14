package Maxprogramm;

import java.awt.BorderLayout;
import javax.swing.*;
import java.io.*;

/*
 * Dieses Programm erzeugt die oberfläche auf der die Spieler und das Spielfeld zu sehen sind.
 *
 *
 * @version 1.2, 16 April 2021
 * @author Pascal Knie, Marvin Voss , Pascal Brostean, Robin Eberle
 */


    @SuppressWarnings("serial")
	public class MaxGUI implements Serializable{

	static JFileChooser choose = new JFileChooser(new File("c://aabb")); // Start-Directory
    JFrame maxFrame;
	/**
	 * Konstruktor für neue MaxGUI
	 *
	 * Die Pfeiltasten aller Spieler im Array werden hier über eine for schleife
	 * hinzugefügt. Das Spielfeld wird hier dem GUI hinzugefügt.
	 *
	 * @param players   Spieler array
	 * @param spielfeld des Max Spiels
	 */

	public MaxGUI(Player[] players, Spielfeld spielfeld) {

		choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sel.-Modus

		// Neuer Frame wird erstellt
		maxFrame = new JFrame();
		maxFrame.setTitle("Max Spiel der Gruppe V{}llgas");

		JMenuBar menu = new JMenuBar();
		JMenu datei = new JMenu("Datei");
		JMenuItem speichern = new JMenuItem("Datei speichern");
		JMenuItem laden = new JMenuItem("Datei Laden");
		datei.add(speichern);
		datei.add(laden);
		menu.add(datei);

		speichern.addActionListener(new SaveL());
		laden.addActionListener(new OpenL());
		// Legt die Fenstergröße je nach Spieleranzahl fest
		switch (players.length) {
		case 1: // Ein Spieler
			maxFrame.setSize(700, 500);
			break;
		case 2: // Zwei Spieler
			maxFrame.setSize(900, 500);
			break;
		case 3: // Drei Spieler
			maxFrame.setSize(1100, 500);
			break;
		case 4: // Vier Spieler
			maxFrame.setSize(1400, 500);
			break;

		}
		maxFrame.setLayout(new BorderLayout());

		// Panel für alle Pfeiltasten der Spieler
		JPanel aPfeiltasten = new JPanel();
		for (Player player : players) {
			aPfeiltasten.add(player.getPfeiltatsen());
		}
		// Alle Panels werden zusammengefügt und sichtbar geschaltet.
		maxFrame.add(spielfeld.getFeld(), BorderLayout.CENTER);
		maxFrame.add(aPfeiltasten, BorderLayout.SOUTH);
		maxFrame.add(menu, BorderLayout.NORTH);
		maxFrame.setVisible(true);
	}

	public MaxGUI(MaxGUI saveGame) { // neuer Konstruktor für abgespeicherte spiele
		
		MaxGUI game =  saveGame;
		game.maxFrame = saveGame.maxFrame;
		
		game.maxFrame.setVisible(true);
	}

}
