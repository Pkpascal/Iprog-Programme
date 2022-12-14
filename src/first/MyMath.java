package first;

import java.math.BigInteger;

public class MyMath {

	public static long multiplyAll (int...y) {
		
		long s= 1;
		for (int i : y) {
			s= s * i;
		}
		return s; 
		
	}
		public static long addAll (int...x) {
			
			int s= 0;
			for (int i : x) {
				s+=i;
			}
			return s; 
		
		}

		public static void main(String[] args) {
			
			//System.out.println(addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21));
			
			//System.out.println(multiplyAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21));
			
			//System.out.println(max(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21));
			
			//System.out.println(min(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21));
			//System.out.println(isPrime(111));
			//System.out.println(nextPrime(100000000));
			System.out.println(isPrime(BigInteger.valueOf(5)));
		}
// Erweiterung der MyMath Metode :
	public static long max(long...x) {
		long m = Long.MIN_VALUE;
		for (long i : x) {
			m = m <= i ? i : m;
		}
		return m;
	}
	public static long min(long...x) {
		long m = Long.MAX_VALUE;
		for (long i : x) {
			m = m >= i ? i : m;
		}
		return m;
	}
	public static int max(int...x) {
		int m = Integer.MIN_VALUE;
		for (int i : x) {
			m = m <= i ? i : m;
		}
		return m;
	}
	public static int min(int...x) {
		int m = Integer.MAX_VALUE;
		for (int i : x) {
			m = m >= i ? i : m;
		}
		return m;
	}
	public static float max(float...x) {
		float m = Float.MIN_VALUE;
		for (float i : x) {
			m = m <= i ? i : m;
		}
		return m;
	}
	public static float min(float...x) {
		float m = Float.MAX_VALUE;
		for (float i : x) {
			m = m >= i ? i : m;
		}
		return m;
	}
	public static double max(double...x) {
		double m = Double.MIN_VALUE;
		for (double i : x) {
			m = m <= i ? i : m;
		}
		return m;
	}
	public static double min(double...x) {
		double m = Double.MAX_VALUE;
		for (double i : x) {
			m = m >= i ? i : m;
		}
		return m;
	}

	// Primzahlen Erweiterung der MyMath Klasse:
	static boolean isPrime(long n) {
		
		if(n==2) {return true;}

		 
		long p = 3;
		while (true) {
			
			if(n == p) {
				int divisor = 3;
				boolean isPossiblyPrime = true;
			while(divisor*divisor <= p && isPossiblyPrime) {
				isPossiblyPrime = ((p% divisor) != 0);
				divisor += 2;
			}
			if (isPossiblyPrime) {
				return true;
			}
			}
			if (p>n) { return false;}
			p += 2;
			
		}
	}
static boolean isPrime(BigInteger n) {
		
		if(n.compareTo(BigInteger.valueOf(2))== 0) {return true;}

		 
		BigInteger p = new BigInteger ("3");
		while (true) {
			
			if(n.compareTo(p) == 0) {
				BigInteger divisor = new BigInteger("3");
				boolean isPossiblyPrime = true;
			while(divisor.multiply(divisor).compareTo(p) ==-1 ||divisor.multiply(divisor).compareTo(p) == 0 && isPossiblyPrime) {
				isPossiblyPrime = ((p.mod(divisor) != BigInteger.ZERO));
				divisor = divisor.add(BigInteger.valueOf(2));
			}
			if (isPossiblyPrime) {
				return true;
			}
			}
			if (p.compareTo(n) == 1) {return false;}
			p = p.add(BigInteger.valueOf(2));
			
		}
	}
				
		
	
	
static long nextPrime(long n) {
		if( n<=1 ) {return 2;}
		long p = 3;
		
		while (true) {
			
			if (p>n) {
				
				long divisor = 3; 
			
				boolean isPossiblyPrime = true;
			
				while(divisor*divisor <= p && isPossiblyPrime) {
				isPossiblyPrime = ((p% divisor) != 0);
				divisor += 2;
			  }
			if (isPossiblyPrime) {
				return p;
			  }
			}
			p += 2;
		}
		
	}
}
