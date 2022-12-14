package first;

import second.MyIO;

/**
 * Dieses Programm gibt alle Ganzen Zahlen von 0 bis n aus und ersetzt zahlen
 * die durch 3 teilbar sind mit "Tra",durch 5 teilbar mit "Tri" und durch 7
 * teilbar mit "Lala" wenn 2 bedingungen zutreffen wird die zahl durch "Corona"
 * ersetzt wenn alle bedingungen zutreffen wird sie durch "Covid" ersetzt
 * 
 * @version 1.0, 14 Dez 2020
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 *
 */

public class Corona {
	public static void main(String[] args) {
		int n;
		do {
		 n = MyIO.readInt("Bitte Zahl eingeben: ");
		
		if (n<0) {
			System.out.println("Error, nur Positive Zahlen");
		}
		}
		while(n<0);

		for (int i = 0; n >= i; i++) {
			boolean t1 = i % 3 == 0;
			boolean t2 = i % 5 == 0;
			boolean t3 = i % 7 == 0;
			if (t1 || t2 || t3) {
				if (t1 && t2 && t3) {
					System.out.print("Covid, ");
				} else {
					if (t1 && t2 || t1 && t3 || t2 && t3) {
						System.out.print("Corona, ");
					} else {
						if (t3) {
							System.out.print("Lala, ");
						}
						if (t2) {
							System.out.print("Tri, ");
						}
						if (t1) {
							System.out.print("Tra, ");
						}
					}

				}
			} else {
				System.out.print(i + ", ");
			}
			if (i % 10 == 0) {
				System.out.println("");
			}
		}

	}

}
