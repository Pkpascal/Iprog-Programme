package first.a;

import second.MyIO;

/**
 * Die 5. Wurzel aus x wird berechnet, Methode: Newton-Verfahren
 * 
 * @param x draus wird die 5. Wurzel berechnet
 * @return die berechnete 5. Wurzel
 * @version 1.0, 16 Nov 2020
 * @author Marvin Voss, Pascal Brostean, Robin Eberle, Pascal Knie
 *
 */
public class FifthRoot {
	public static void main(String[] arg) {
		double x = MyIO.readDouble("woraus soll ich die 5. Wurzel ziehen? ");
		double root = fifthRoot(x);
		System.out.println("Die 5. Wurzel aus " + x + " ist " + root);
		System.out.println("Test: " + root + "^5 = " + (root * root * root * root * root));
	}

	public static double fifthRoot(double x) {
		int n = 1;							
		int maxIterations = 10000;			
		double maxError = 1e-10; 			
		double xn = 2.0; 					
		double xnPlus1 = 1; 				
		while (Math.abs((xnPlus1 - xn)) >= maxError && n < maxIterations) {
			xn = xnPlus1;
			xnPlus1 = xn - (xn * xn * xn * xn * xn - x) / (5 * xn * xn * xn * xn);
			n = n + 1;
		}
		return xnPlus1;
	}
}