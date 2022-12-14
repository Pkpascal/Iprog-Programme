package first.a;

import java.util.ArrayList;
import first.*;
import second.MyIO;
/**
 * Dieses Programm liest eingaben von der Tastatur ein und gibt diese invertiert
 * und anders herum aus, nachdem der Nuter das Programm beendet hat.
 * 
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 * @version 1.0, 16 Nov 2020
 */

public class EsreverLister {

	public static String invert(String h) {
		return h.length() <= 1 ? h : invert(h.substring(1)) + h.substring(0, 1);
	}

	public static void main(String[] args) {

		ArrayList<String> eingaben = new ArrayList<String>();
		System.out.println("Dieses Programm invertiert ihren eingegeben Text und gibt ihn rückwärts aus");
		System.out.println("Eingabe beenden durch ´potS´ oder ´^z´");
		String ersteEingabe = MyIO.promptAndRead("Schreiben sie eine Zeile :");
		eingaben.add(ersteEingabe);

		while (true) {
			String eingabe = MyIO.promptAndRead("Nächste Zeile :");
			eingaben.add(eingabe);
			if (eingabe.equals("potS")) {
				System.out.println("Programm beendet.");
				break;
			} else if (eingabe.equals("^z")) {
				System.out.println("Programm beendet.");
				break;
			} else if (eingabe.isEmpty()) {
				System.out.println("Programm beendet.");
				break;
			}
		}

		for (int i = eingaben.size(); --i >= 0;) {
			System.out.println(invert(eingaben.get(i)));
		}
	}

}
