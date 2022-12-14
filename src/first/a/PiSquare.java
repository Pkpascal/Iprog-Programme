package first.a;
/**
 * Dieses Programm fragt nach einer Zahl mit der die Wurzel aus 
 * 6*(x*x) + 6*(x-1*x-1)+...+6*(0*0) berechnet wird 
 * 
 * @author Marvin Voss, Pascal Brostean, Pacal Knie, Robin Eberle
 *
 */
public class PiSquare {

	public static void main(String[] args) {
		
		System.out.println("Dieses Programm verlangt eine zahl mit der die Wurzel aus \n 6/(x*x) + 6/(x-1*x-1)+... berechnet wird");
		
		while(true) {
			
		long x = MyIO.readLong("Bitte Zahl Eingeben: ");
		long z = 0;
		
		if ( x<= 0) {
			System.out.println("nur positive Zahlen! \n");

		}
		else {
		while (x > 0) {
			z += 6/x*x ; x--;
		}
		
		double zOut = (double) z ;
		System.out.println("die  Rechnung ergibt: " + Math.sqrt(zOut));

		break;
		}
	}
	}

}
