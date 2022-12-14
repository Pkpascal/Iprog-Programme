package second;

import java.math.BigInteger;
import java.util.Scanner;

import Maxprogramm.Fraction;

public final class MyIO {

	private MyIO() {
	}

	static Scanner sc = new Scanner(System.in);

	public static String promptAndRead(String prompt) {
		System.out.print(prompt);
		return sc.nextLine();
	}

	public static int readInt(String prompt) {

		System.out.print(prompt);
		return Integer.parseInt(sc.nextLine().trim());
	}

	public static float readFloat(String prompt) {

		System.out.print(prompt);
		return Float.parseFloat(sc.nextLine().trim());
	}

	public static long readLong(String prompt) {
		while (true) {
			try {
				System.out.println(prompt);
				return Long.parseLong(sc.nextLine().trim());
			} catch (Exception e) {
				System.out.println("error... try again");
			}
		}
	}

	public static double readDouble(String prompt) {
		while (true) {
			try {
				System.out.println(prompt);
				return Double.parseDouble(sc.nextLine().trim());
			} catch (Exception e) {
				System.out.println("error... try again");
			}
		}
	}

	public static BigInteger readBigInt(String prompt) {
		while (true) {
			try {
				System.out.println(prompt);
				BigInteger x = new BigInteger(sc.nextLine().trim());
				return x;
			} catch (Exception e) {
				System.out.println("error... try again");
			}
		}
	}
	public static Fraction readFraction(String prompt ) {
		while (true) {
			try {
				System.out.println(prompt);
				System.out.println("Zähler: ");
				BigInteger x = new BigInteger(sc.nextLine().trim());
				System.out.println("Nenner: ");
				BigInteger y = new BigInteger(sc.nextLine().trim());
				BigInteger fehlertest = x.divide(y);
				return new Fraction(x,y);
			} catch (Exception e) {
				System.out.println("error... try again");
			}
		}
	}

	public static void write(String s) {
		System.out.println(s);
	}

	public static void writeln(String string) {
		System.out.println(string);
		
	}
}
