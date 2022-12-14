package second;

import java.util.*;

public class Umfulllisten {

	Behalter[] behalter;

	@SuppressWarnings("rawtypes")
	static ArrayList behalterfullung = new ArrayList();

	boolean changed = false;
	boolean first = true;
	int menge = 1;

	@SuppressWarnings("unchecked")
	public Umfulllisten() {

		behalter = new Behalter[5];

		for (int i = 0; i < 5; i++) {
			behalter[i] = new Behalter();
			behalter[i].setSize(MyIO.readInt("Füllmenge von Behälter " + (i + 1) + " = "));
		}

		System.out.println("\nKapazitäten sind ( " + behalter[0].size + " " + behalter[1].size + " " + behalter[2].size
				+ " " + behalter[3].size + " )");

		behalter[0].filledUpto = behalter[0].size;
		behalterfullung.add(toString()); // menge = 1
	}

	@SuppressWarnings("unchecked")
	public Umfulllisten(int size1, int size2, int size3, int size4, int size5) {

		behalter = new Behalter[5];

		behalter[0] = new Behalter();
		behalter[0].setSize(size1);
		behalter[1] = new Behalter();
		behalter[1].setSize(size2);
		behalter[2] = new Behalter();
		behalter[2].setSize(size3);
		behalter[3] = new Behalter();
		behalter[3].setSize(size4);
		behalter[4] = new Behalter();
		behalter[4].setSize(size5);

		System.out.println("\nKapazitäten sind ( " + behalter[0].size + " " + behalter[1].size + " " + behalter[2].size
				+ " " + behalter[3].size + " " + behalter[4].size + " )");

		behalter[0].filledUpto = behalter[0].size;
		behalterfullung.add(toString());
	}

	@SuppressWarnings("unchecked")
	public void fill(Behalter von, Behalter in) {

		if (von.filledUpto > in.size - in.filledUpto) {
			von.filledUpto = von.filledUpto - (in.size - in.filledUpto);
			in.filledUpto = in.size;
		} else {
			in.filledUpto = von.filledUpto + in.filledUpto;
			von.filledUpto = 0;

		}
		if (!behalterfullung.contains(toString())) {
			changed = true;
			behalterfullung.add(toString());
			//umfullen(behalter[0].filledUpto, behalter[1].filledUpto, behalter[2].filledUpto, behalter[3].filledUpto,
			//		behalter[4].filledUpto);

			menge += 1;
		}

	}

	public void umfullen() {

		// if (changed == true) {
		// do {

		changed = false;

		fill(behalter[0], behalter[2]);
		fill(behalter[0], behalter[1]);

		fill(behalter[1], behalter[2]);
		fill(behalter[1], behalter[3]);

		fill(behalter[2], behalter[4]);
		fill(behalter[2], behalter[3]);

		fill(behalter[3], behalter[0]);
		fill(behalter[3], behalter[4]);

		// } while (changed == true);
		// }
	}

	public void umfullen(int a, int b, int c, int d, int e) {

		Behalter a1 = new Behalter();
		Behalter b1 = new Behalter();
		Behalter c1 = new Behalter();
		Behalter d1 = new Behalter();
		Behalter e1 = new Behalter();
		a1.filledUpto = a;
		b1.filledUpto = b;
		c1.filledUpto = c;
		d1.filledUpto = d;
		e1.filledUpto = e;

		// if (changed == true) {
		// do {

		changed = false;

		fill(a1, c1);
		umfullen(a1.filledUpto,b1.filledUpto,c1.filledUpto,d1.filledUpto,e1.filledUpto);
		fill(a1, b1);
		umfullen(a1.filledUpto,b1.filledUpto,c1.filledUpto,d1.filledUpto,e1.filledUpto);
		
		fill(b1, c1);
		umfullen(a1.filledUpto,b1.filledUpto,c1.filledUpto,d1.filledUpto,e1.filledUpto);
		fill(b1, d1);
		umfullen(a1.filledUpto,b1.filledUpto,c1.filledUpto,d1.filledUpto,e1.filledUpto);
		
		fill(c1, e1);
		umfullen(a1.filledUpto,b1.filledUpto,c1.filledUpto,d1.filledUpto,e1.filledUpto);
		fill(c1, d1);
		umfullen(a1.filledUpto,b1.filledUpto,c1.filledUpto,d1.filledUpto,e1.filledUpto);
		
		fill(d1, a1);
		umfullen(a1.filledUpto,b1.filledUpto,c1.filledUpto,d1.filledUpto,e1.filledUpto);
		fill(d1, e1);
		umfullen(a1.filledUpto,b1.filledUpto,c1.filledUpto,d1.filledUpto,e1.filledUpto);

		// } while (changed == true);
		// }
	}

	public String toString() {
		String gefullt = "(";
		for (Behalter behalter : behalter) {
			gefullt += " " + behalter.filledUpto;
		}
		gefullt += " )\n";
		return gefullt;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Umfulllisten umfullliste = new Umfulllisten(3, 2, 1, 2, 1);

		umfullliste.umfullen(3,0,0,0,0);

		behalterfullung.sort(new StringComparator());
		System.out.println(behalterfullung);
		System.out.println("Menge der 5er Toupel: " + umfullliste.menge);
	}

}

class Behalter {
	// int nummer;
	int filledUpto = 0;
	int size;

	public Behalter() {
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setFullmenge(int menge) {
		filledUpto = menge;
	}

}

/*
 * class Fullmenge { int i1; int i2; int i3; int i4; int i5;
 * 
 * public Fullmenge(int a,int b,int c,int d,int e) { i1 = a; i2 = b; i3 = c; i4
 * = d; i5 = e; }
 * 
 * public void fullen() {
 * 
 * } }
 */

class StringComparator implements Comparator<String> { // Eigener Vergleicher
	public int compare(String s1, String s2) {
		return s2.compareTo(s1); // Invertiere uebliche String-Sortierung
	}

}
