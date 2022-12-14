package first.a;

import java.util.Scanner;

public class Ggt {

	public static void main(String[] args)  {
	
		@SuppressWarnings("resource")
		Scanner Input = new Scanner (System.in);
		int x = Input.nextInt();
		int y = Input.nextInt();
		
			int z = 1;
			int ergebnis = 0;
			int test = 1;
			while (test == 1)
			if (z == 0)  {
				y = ergebnis;
				System.out.println("der ggt ist " + ergebnis);
				test = 0;
			}
			else { 
				z = x % y;
			}

	}		
}	
