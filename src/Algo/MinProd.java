package Algo;

import java.util.ArrayList;

/**
 * Dieses Programm nimmt die Konsoleneigabe des Nutzers und f�llt damit eine
 * Double ArrayList, aus dieser wird die kleinste Produkt das man in einer reihe
 * erreichen kann ermittelt.
 * 
 * @version 1.0, 7 Oct 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 *
 */
public class MinProd {

	public static void main(String[] args) {

		ArrayList<Double> zahlen = new ArrayList<Double>();

		String[] eingabe = args;

		for (int i = 0; i < eingabe.length; i++) {
			zahlen.add(Double.parseDouble(eingabe[i]));
		}

		System.out.println(zahlen);

		System.out.println(scan(zahlen));

	}

	/**
	 * in dieser Methode wird das kleinste produkt aus dem Array ermittelt
	 * 
	 * @param liste die Liste aus der das Produkt ermittelt werden soll
	 * @return das kleinste m�gliche Produkt als double.
	 */
	public static double scan(ArrayList<Double> liste) {

		double scanMin = 1;
		double bisMin = 0;

		int lztneg = 0;

		int sEnd = liste.size();

		int negCount = 0;

		for (int i = 0; i < liste.size(); i++) {

			if (liste.get(i) < 0) {
				negCount++;
				lztneg = i + 1;

			}
		}

		if (negCount % 2 == 0) {
			sEnd = lztneg - 1;
		} else {
			sEnd = lztneg;
		}

		for (int i = 0; i < sEnd; i++) {
			if (bisMin > scanMin) {
				bisMin = scanMin;
			}
			if (scanMin == 0) {
				scanMin = 1;
			}
			scanMin *= liste.get(i);
		}

		if (scanMin == 1) {
			scanMin = 0;
		}
		return scanMin;

	}
}
