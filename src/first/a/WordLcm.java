package first.a;
import first.*;
import second.MyIO;

import java.util.ArrayList;

/**
 * Dieses Programm berechnet das kleinste gemeinsame Vielfache von mehreren
 * Zahlen und gibt es aus. Die zahlen müssen als Strings eingeben werden und
 * werden in Integer Werte umgewandelt
 * 
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 * @version 1.0, 16 Nov 2020
 */
public class WordLcm {

	public static int kgv(int x, int y) {
		int z = 0;
		z = (x * y) / ggt(x, y);
		return z;
	}

	public static int ggt(int x, int y) {
		int z = 0;
		if (y == 0) {
			z = x;
		} else {
			z = ggt(y, x % y);
		}
		return z;
	}

	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		int kgv = 1;
		System.out.println(
				"Dieses Programm lässt sie aus mehreren Zahlen zwischen 1 und 29 das kleinste gemeinsame vielfache berechnen");
		System.out
				.println("Zahlen müssen ausgeschrieben werden (zb. eins,zwei,...)\nZum beenden leere eingabe tätigen");
		while (true) {
			String n = MyIO.promptAndRead("Bitte Zahl Schreiben: ");

			if (n.equals("")) {
				break;
			} else if (n.equals("eins")) {
				x.add(1);
			} else if (n.equals("zwei")) {
				x.add(2);
			} else if (n.equals("drei")) {
				x.add(3);
			} else if (n.equals("vier")) {
				x.add(4);
			} else if (n.equals("fünf")) {
				x.add(5);
			} else if (n.equals("sechs")) {
				x.add(6);
			} else if (n.equals("sieben")) {
				x.add(7);
			} else if (n.equals("acht")) {
				x.add(8);
			} else if (n.equals("neun")) {
				x.add(9);
			} else if (n.equals("zehn")) {
				x.add(10);
			} else if (n.equals("elf")) {
				x.add(11);
			} else if (n.equals("zwölf")) {
				x.add(12);
			} else if (n.equals("dreizehn")) {
				x.add(13);
			} else if (n.equals("vierzehn")) {
				x.add(14);
			} else if (n.equals("fünfzehn")) {
				x.add(15);
			} else if (n.equals("sechszehn")) {
				x.add(16);
			} else if (n.equals("siebzehn")) {
				x.add(17);
			} else if (n.equals("achtzehn")) {
				x.add(18);
			} else if (n.equals("neunzehn")) {
				x.add(19);
			} else if (n.equals("zwanzig")) {
				x.add(20);
			} else if (n.equals("einundzwanzig")) {
				x.add(21);
			} else if (n.equals("zweiundzwanzig")) {
				x.add(22);
			} else if (n.equals("dreiundzwanzig")) {
				x.add(23);
			} else if (n.equals("vierundzwanzig")) {
				x.add(24);
			} else if (n.equals("fünfundzwanzig")) {
				x.add(25);
			} else if (n.equals("sechsundzwanzig")) {
				x.add(26);
			} else if (n.equals("siebenundzwanzig")) {
				x.add(27);
			} else if (n.equals("achtundzwanzig")) {
				x.add(28);
			} else if (n.equals("neunundzwanzig")) {
				x.add(29);
			} else {
				System.out.println("zahl zu groß oder verschrieben ");
			}
		}

		for (int y : x) {

			kgv = kgv(kgv, y);
		}
		System.out.println(kgv);
	}

}
