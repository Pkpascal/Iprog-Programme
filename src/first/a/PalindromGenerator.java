package first.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PalindromGenerator {
	static String vorschlag1 ;
	static String vorschlag2 ;
	static String vorschlag3 ;
	static String vorschlag4 ;
	static String vorschlag5 ;
	
	//invert Methode für Palindrome
	public static String invert(String h) {
		return h.length() <= 1 ? h : invert(h.substring(1)) + h.substring(0, 1);

	}

	//Input 1 und 2 von Usern
	public static void main(String[] args) throws IOException {
		System.out.println("Erster Text >");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader keyb = new BufferedReader(isr);
		String text1 = keyb.readLine().toLowerCase();
		System.out.println("Zweiter Text >");
		String text2 = keyb.readLine().toLowerCase();
		System.out.println("Das sind 5 Vorschläge für Palindrome aus " + text1 + " und " + text2 + " :");

		//Unterschiedliche Variationen für Palindrome
		String vorschlag1 =text1 + text2 + invert(text2) + invert(text1);
		String vorschlag2 =text2 + text1 + invert(text1) + invert(text2);
		String vorschlag3 =invert(text1) + invert(text2) + text2 + text1;
		String vorschlag4 =invert(text2) + invert(text1) + text1 + text2;
		String vorschlag5 =text1 + invert(text2) + text2 + invert(text1);
		
		
		System.out.println(vorschlag1);
		System.out.println(vorschlag2);
		System.out.println(vorschlag3);
		System.out.println(vorschlag4);
		System.out.println(vorschlag5);
	}

	//Datenbank für die 5 Vorschläge
	public static void String(String[] args) throws IOException {
		PrintStream target = new PrintStream(new FileOutputStream(new File("Vorschläge :")));
		
		target.println(vorschlag1);
		target.println(vorschlag2);
		target.println(vorschlag3);
		target.println(vorschlag4);
		target.println(vorschlag5);
	}

}
