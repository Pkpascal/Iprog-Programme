package first.a;

import java.math.BigInteger;

import second.MyIO;

/**
 * Dieses Programm berechnet das kleinste gemeinsame Vielfache von zwei BigIntegern und gibt es aus.
 * 
 * @author Marvin Voss, Pascal Brostean, Pacal Knie, Robin Eberle
 *
 */
public class KgV {
	public static BigInteger kgv (BigInteger x, BigInteger y) {
		BigInteger z = new BigInteger("0");
		z= (x.multiply(y)).divide(ggt(x,y));
		return z;
	}
	
	public static BigInteger ggt (BigInteger x, BigInteger y) {
		BigInteger z = new BigInteger("0");
	if ( y == BigInteger.ZERO) {z = x;} 
	else {z = ggt (y,x.mod(y));}
	 return z;
	}

	public static void main(String[] args)throws Exception {
		System.out.println("Dieses Programm gibt das kleinste gemeinsame Vielfache (kgv) von 2 Zahlen aus :");
		BigInteger x = MyIO.readBigInt("Erste  Zahl :");
		BigInteger y = MyIO.readBigInt("Zweite Zahl :");
		System.out.println("das kgv von " + x + " und " + y + " ist:\n" + kgv(x,y));
		
		
	}
}
