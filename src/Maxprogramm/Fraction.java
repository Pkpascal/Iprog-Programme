package Maxprogramm;

import java.math.BigInteger;

import Maxprogramm.Fraction;

/**
 * Dieses Programm erstellt Br�che von Typ BigInteger, Ergebnisse werden
 * weitgehend gek�rzt und normalisiert. Das Programm kann Br�che addieren, subtrahieren, 
 * dividieren, multiplizieren, vergleichen mit equals und compareTo, den Hashcode bestimmen,
 * den Wert als double, float, int oder long ausgeben und Br�che mit einer toString Methode darstellen.
 * 
 * @version 1.3, 11 Mar 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 *
 */


@SuppressWarnings("serial")
public class Fraction extends Number implements Comparable<Fraction> {
	
	/**
	 * Not a Number: spezieller Wert ... nach division durch 0
	 */
	final static Fraction NaN = new Fraction(BigInteger.valueOf(0),BigInteger.valueOf(0));

	protected BigInteger z�hler, nenner;
	
	/**
	 * @return z�hler
	 */
	public BigInteger getZ�hler() {
		return z�hler;
	}
	/**
	 * @return nenner
	 */
	public BigInteger getNenner() {
		return nenner;
	}
	/**
	 * Diese Methode k�rzt den Bruch so weit wie m�glich
	 * 
	 * @param x z�hler
	 * @param y nenner
	 */
	public void k�rzen(BigInteger x, BigInteger y) {
		BigInteger ggt = x.gcd(y);

		if (ggt.compareTo(BigInteger.valueOf(0)) == 1) {
			this.z�hler = x.divide(ggt);
			this.nenner = y.divide(ggt);
		}
	}
	/**
	 * Diese Methode k�rzt den Bruch so weit wie m�glich
	 * 
	 * @param z Fraction
	 * 
	 */
	public Fraction k�rzen(Fraction z) {
		BigInteger x = z.z�hler;
		BigInteger y = z.nenner;
		BigInteger ggt = x.gcd(y);

		if (ggt.compareTo(BigInteger.valueOf(0)) == 1) {
			z.z�hler = x.divide(ggt);
			z.nenner = y.divide(ggt);
		}
		return z;
	}

	public static BigInteger kgv(BigInteger x, BigInteger y) {

		BigInteger ggt = x.gcd(y);

		BigInteger z = new BigInteger("0");
		z = (x.multiply(y)).divide(ggt);
		return z;
	}
	/**
	 * Konstruiert einen Bruch aus BigInteger
	 * und gibt diesen in normalisierter Form aus.
	 * @param x z�hler
	 * @param y nenner
	 */
	public Fraction(BigInteger x, BigInteger y) {
		
		
		this.z�hler = x;
		this.nenner = y;

		if (y.compareTo(BigInteger.valueOf(0)) == -1) {

			this.z�hler = x.multiply(BigInteger.valueOf(-1));
			this.nenner = y.multiply(BigInteger.valueOf(-1));
		}
		k�rzen(z�hler, nenner);
	}
	/**
	 * Konstruktor mit long Parametern
	 * @param z�hler
	 * @param nenner
	 */
	public Fraction(long z�hler, long nenner) {
		this(BigInteger.valueOf(z�hler),BigInteger.valueOf(nenner));
	}
	

	/**
	 * berechnet, k�rzt und returnt die Summe von this und Fraction r
	 * @param r
	 * @return new Fraction = this + Fraction r
	 */
	public Fraction add(Fraction r) {
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("0");
		Fraction fractionsumme = new Fraction(x, y);
		if (this.nenner.equals(r.nenner)) {
			fractionsumme.z�hler = this.z�hler.add(r.z�hler);
			fractionsumme.nenner = this.nenner;
		} else {
			fractionsumme.nenner = kgv(this.nenner, r.nenner);
			fractionsumme.z�hler = ((fractionsumme.nenner.divide(this.nenner)).multiply(this.z�hler))
					.add((fractionsumme.nenner.divide(r.nenner)).multiply(r.z�hler));
		}
		k�rzen(fractionsumme);
		return fractionsumme;
	}
	/**
	 * berechnet, k�rzt und returnt die Differenz von this und Fraction r
	 * @param Fraction r
	 * @return new Fraction = this - r
	 */
	public Fraction subtract(Fraction r) {
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("0");
		Fraction fractiondifferenz = new Fraction(x, y);
		if (this.nenner.equals(r.nenner)) {
			fractiondifferenz.z�hler = this.z�hler.subtract(r.z�hler);
			fractiondifferenz.nenner = this.nenner;
		} else {
			fractiondifferenz.nenner = kgv(this.nenner, r.nenner);
			fractiondifferenz.z�hler = ((fractiondifferenz.nenner.divide(this.nenner)).multiply(this.z�hler))
					.subtract((fractiondifferenz.nenner.divide(r.nenner)).multiply(r.z�hler));
		}
		k�rzen(fractiondifferenz);
		return fractiondifferenz;
	}
	/**
	 * berechnet und returnt das Produkt von this & Fraction r
	 * @param Fraction r
	 * @return new Fraction = Produkt von this und Fraction r
	 */
	public Fraction multiply(Fraction r) {
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("0");
		Fraction fractionprodukt = new Fraction(x, y);
		fractionprodukt.z�hler = this.z�hler.multiply(r.z�hler);
		fractionprodukt.nenner = this.nenner.multiply(r.nenner);

		k�rzen(fractionprodukt);
		return fractionprodukt;
	}
	/**
	 * berechnet und returnt Quotient von this dividiert durch Fraction r
	 * @param Fraction r
	 * @return new Fraction = this dividiert durch Fraction r
	 */
	public Fraction divide(Fraction r) {
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("0");
		Fraction fractionquotient = new Fraction(x, y);
		fractionquotient.z�hler = this.z�hler.multiply(r.nenner);
		fractionquotient.nenner = this.nenner.multiply(r.z�hler);

		k�rzen(fractionquotient);
		return fractionquotient;
	}

	public String toString() {
		if (this.nenner == BigInteger.valueOf(0)) {
			return "NaN";
		}
		return "[" + this.z�hler + "/" + this.nenner + "]";
	}
	/**
	 * vergleicht ob es sich um einen integer handelt, falls nenner = 1
	 * @return true falls integer, andernfalls false 
	 */
	public boolean isInteger() {
		int x = this.z�hler.compareTo(this.nenner);
		if (x >= 0 && (this.z�hler.remainder(this.nenner).equals(BigInteger.valueOf(0)))) {
			return true;
		}
		return false;
	}

	@Override
	public double doubleValue() {
		double x = this.z�hler.doubleValue();
		double y = this.nenner.doubleValue();
		return x / y;
	}

	@Override
	public float floatValue() {
		return (float) doubleValue();
	}

	@Override
	public int intValue() {
		return (int) doubleValue();
	}

	@Override
	public long longValue() {
		return (long) doubleValue();
	}

	@Override
	public int compareTo(Fraction r) {
		if (this.equals(NaN) && r.equals(NaN)) {
			return 0;
		} 
		if (this.equals(NaN)) {
			return 1;
		}
		if (r.equals(NaN)) {
			return -1;
		}
		return z�hler.multiply(r.nenner).compareTo(r.z�hler.multiply(nenner));
	}
	/**
	 * wird f�r viele Operationen verwendet
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.z�hler == null ? 0 : z�hler.hashCode());
		result = prime * result + (this.nenner == null ? 0 : nenner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (nenner == null) {
			if (other.nenner != null)
				return false;
		}
		if (z�hler == null) {
			if (other.z�hler != null)
				return false;
		} else if (!z�hler.equals(other.z�hler))
			return false;
		return true;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Fraction(z�hler, nenner);
	}
	public static void main(String[] args)throws CloneNotSupportedException {

		Fraction fraction1 = new Fraction(BigInteger.valueOf(8), BigInteger.valueOf(16));
		BigInteger z = new BigInteger("2");
		BigInteger c = new BigInteger("3");
		Fraction fraction2 = new Fraction(z, c);
		Fraction fr3 = new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(6));
		Fraction fr4 = new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(6));

		System.out.println(fraction1);
		System.out.println(fraction2);

		Fraction a = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(0));
		Fraction b = new Fraction(BigInteger.valueOf(654), BigInteger.valueOf(0));

		System.out.println(a + " " + b);

		System.out.println("Equals :");
		System.out.println(fraction1.equals(fraction2));

		System.out.println("Hashcode :");
		System.out.println(fraction1.hashCode());
		System.out.println(fraction2.hashCode());

		System.out.println("CompareTo :");
		System.out.println(fraction1.compareTo(fraction2));
		System.out.println(fraction2.compareTo(fraction1));
		System.out.println(fr3.compareTo(fr4));

		System.out.println("Addition :");
		System.out.println(fraction1.add(fraction2));

		System.out.println("Substraktion :");
		System.out.println(fraction1.subtract(fraction2));

		System.out.println("Multiplizieren :");
		System.out.println(fraction1.multiply(fraction2));

		System.out.println("Dividieren :");
		System.out.println(fraction1.divide(fraction2));

		System.out.println("Addition :");
		System.out.println(fraction2.add(fraction1));

		System.out.println("Substraktion :");
		System.out.println(fraction2.subtract(fraction1));

		System.out.println("Multiplizieren :");
		System.out.println(fraction2.multiply(fraction1));

		System.out.println("Dividieren :");
		System.out.println(fraction2.divide(fraction1));

		System.out.println("Is Integer? :");
		System.out.println(fraction1.isInteger());

		System.out.println("toString : ");
		System.out.println(fraction1.toString());

		System.out.println("doubleValue : ");
		System.out.println(fraction1.doubleValue());

		System.out.println("floatValue : ");
		System.out.println(fraction1.floatValue());

		System.out.println("intValue  : ");
		System.out.println(fraction1.intValue());

		System.out.println("longValue : ");
		System.out.println(fraction1.longValue());
		
		Fraction f = new Fraction(3,7);
		Fraction fclone = (Fraction) f.clone();
		System.out.println("fclone: " + fclone);
		System.out.println(" "+f.equals(fclone)+ " " + (f == fclone) + " "
				+ f.compareTo(fclone));

		Fraction[] P = { new Fraction(BigInteger.valueOf(8), BigInteger.valueOf(6)),
				new Fraction(BigInteger.valueOf(0), BigInteger.valueOf(0)),
				new Fraction(BigInteger.valueOf(32), BigInteger.valueOf(54)),
				new Fraction(BigInteger.valueOf(13), BigInteger.valueOf(6)),
				new Fraction(BigInteger.valueOf(17), BigInteger.valueOf(2)),
				new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(7)),
				new Fraction(BigInteger.valueOf(365), BigInteger.valueOf(24)),
				new Fraction(BigInteger.valueOf(-4), BigInteger.valueOf(8)),
				new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(8)),
				new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(-8)),
				new Fraction(BigInteger.valueOf(-4), BigInteger.valueOf(-8)) };

		for (Fraction pp : P) {
			System.out.print(pp + "");
		}
		System.out.println();
		for (Fraction pp : P) {
			System.out.print(pp.floatValue() + " ");
		}
		System.out.println();
		for (Fraction pp : P) {
			System.out.print(pp.doubleValue() + " ");
		}
		System.out.println();
		for (Fraction pp : P) {
			System.out.print(pp.intValue() + " ");
		}
		System.out.println();
		for (Fraction pp : P) {
			System.out.print(pp.longValue() + " ");
		}
	}
}