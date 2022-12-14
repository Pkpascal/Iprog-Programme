package first;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import Maxprogramm.Fraction;

class FractionStreams {
	
	public static void bubblesrt(ArrayList<Fraction> list)
	{
	    Fraction temp;
	    if (list.size()>1) 
	    {
	        for (int x=0; x<list.size(); x++) 
	        {
	            for (int i=0; i < list.size()-i; i++) {
	                if (list.get(i).compareTo(list.get(i+1)) > 0)
	                {
	                    temp = list.get(i);
	                    list.set(i,list.get(i+1) );
	                    list.set(i+1, temp);
	                }
	            }
	        }
	    }

	}

	public static void main(String[] args) {

		ArrayList<Fraction> fractionstream = new ArrayList<>();

		BigInteger plus = new BigInteger("1");
		BigInteger vergleich = new BigInteger("15");
		boolean neu = true;
		for (BigInteger z = new BigInteger("-14"); z.compareTo(vergleich) == -1; z = z.add(plus)) {

			for (BigInteger n = new BigInteger("-14"); n.compareTo(vergleich) == -1; n = n.add(plus)) {
				if (n.compareTo(BigInteger.ZERO) == 0) {
					break;
				}
				Fraction g = new Fraction(z, n);

				for (Fraction x : fractionstream) {
					neu = true;
					if (x.compareTo(g) == 0) {
						neu = false;
						break;
					}
				}
				if (neu) {
					System.out.println(g);
					fractionstream.add(g);
				}
			}

		}
		bubblesrt(fractionstream);
		
	/*	Stream<Fraction> lambstream = Arrays.asList();
		lambstream = fractionstream;
		
		
		System.out.println("Werte als Floats: ");
		lambstream.forEach(y-> System.out.println(y.floatValue()));
		
	
		System.out.println("Werte Quadriert: ");
		lambstream.forEach(y-> System.out.println(y.multiply(y)));
		
		System.out.println("Zähler und Nenner sind Primzahlen: ");
		lambstream.parallelStream().forEach(y-> {if (MyMath.isPrime(y.nenner) && MyMath.isPrime(y.zähler)) {
			System.out.println(y); }});
		
		System.out.println("ganze Zahlen: ");
		lambstream.forEach(y-> {if (y.isInteger()) {
			System.out.println(y);}
		});
		
		System.out.println("Sinus Werte aller Elemente: ");
		lambstream.sorted().forEach(y-> System.out.println(Math.sin(y.doubleValue())));

*/
		System.out.println("Werte als Floats: ");
		for (Fraction x : fractionstream) {
			System.out.println(x.floatValue());
		}
		System.out.println("Werte Quadriert: ");
		for (Fraction x : fractionstream) {
			System.out.println(x.multiply(x));
		}
		System.out.println("Zähler und Nenner sind Primzahlen: ");
		for (Fraction x : fractionstream) {
			if (MyMath.isPrime(x.nenner) && MyMath.isPrime(x.zähler)) {
				System.out.println(x);
			}
		}
		System.out.println("ganze Zahlen: ");
		for (Fraction x : fractionstream) {
			if (x.isInteger()) {
				System.out.println(x);
			}
		}
		System.out.println("Sinus Werte aller Elemente: ");
		for (Fraction x : fractionstream) {
			double ergebnis = Math.sin(x.floatValue());
			System.out.println(ergebnis);
		}

	}

}
