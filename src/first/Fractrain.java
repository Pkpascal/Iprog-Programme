package first;

import java.math.BigInteger;

import Maxprogramm.Fraction;

/**
 * Dieses Programm Berrechnet Integer anhand von einem Fraction Array.
 * 
 * @version 1.0, 8 Dez 2020
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 *
 */

public class Fractrain {

	

	public static void main(String[] args) {

		Fraction vergleich = new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(1));
	    int vcount = 0;
		int count = 1;

		
		Fraction bruch1  = new Fraction(BigInteger.valueOf(17), BigInteger.valueOf(91));
		Fraction bruch2  = new Fraction(BigInteger.valueOf(78), BigInteger.valueOf(85));
		Fraction bruch3  = new Fraction(BigInteger.valueOf(19), BigInteger.valueOf(51));
		Fraction bruch4  = new Fraction(BigInteger.valueOf(23), BigInteger.valueOf(38));
		Fraction bruch5  = new Fraction(BigInteger.valueOf(29), BigInteger.valueOf(33));
		Fraction bruch6  = new Fraction(BigInteger.valueOf(77), BigInteger.valueOf(29));
		Fraction bruch7  = new Fraction(BigInteger.valueOf(95), BigInteger.valueOf(23));
		Fraction bruch8  = new Fraction(BigInteger.valueOf(77), BigInteger.valueOf(19));
		Fraction bruch9  = new Fraction(BigInteger.valueOf( 1), BigInteger.valueOf(17));
		Fraction bruch10 = new Fraction(BigInteger.valueOf(11), BigInteger.valueOf(13));
		Fraction bruch11 = new Fraction(BigInteger.valueOf(13), BigInteger.valueOf(11));
		Fraction bruch12 = new Fraction(BigInteger.valueOf(15), BigInteger.valueOf( 2));
		Fraction bruch13 = new Fraction(BigInteger.valueOf( 1), BigInteger.valueOf( 7));
		Fraction bruch14 = new Fraction(BigInteger.valueOf(55), BigInteger.valueOf( 1));

		Fraction b = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(1));

		Fraction[] L = { bruch1, bruch2, bruch3, bruch4, bruch5, bruch6, bruch7, bruch8, bruch9, bruch10, bruch11,
				bruch12, bruch13, bruch14 };

		System.out.println(b);
		
		while(true) {
		if (count > 23065) {
			break;
		}
			for (Fraction x : L) {
				
				Fraction test = x.multiply(b);

				if (test.isInteger()) {

					if (count <= 2375) {
						System.out.println(test);
					}
					if (count <= 11362) {

						if (test.zähler.compareTo(vergleich.zähler) == 1) {
							vergleich = test;
							vcount = count;
						}
					}
					if (count == 11362) {
						System.out.println("Die 11362 Zahl :");
						System.out.println(test);
					}
					if (count == 23065) {
						System.out.println("Die 23065 Zahl :");
						System.out.println(test);
					}
					b = test;
					count++;
					break;

				}

			}

		}
		System.out.println("Die Gröste Zahl von 1 bis 11362 :");
		System.out.println(vergleich + "\nAn der stelle :   \n " + vcount);
	}
}
