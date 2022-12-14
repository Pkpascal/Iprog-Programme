package first.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromTest {
	
	
	
	public static String invert (String h) {
		return h.length() <= 1 ? h :
			invert (h.substring(1)) + h.substring(0,1);
		
	}
		public static void main (String[] args) throws IOException {
			
			//Eingabe von außen wird eingelesen
			InputStreamReader isr = new InputStreamReader (System.in);
			BufferedReader keyb = new BufferedReader(isr);
			String h = keyb.readLine().toLowerCase();
			
			
			//Eingabe und invertierte Eingabe werden Verglichen
			if (h.equals(invert(h))) {System.out.println("Das wort "+ h + " ist ein Palindrom");
			} else {
			System.out.println("Das wort "+ h + " ist kein Palindrom");
			}
	}
			

}
