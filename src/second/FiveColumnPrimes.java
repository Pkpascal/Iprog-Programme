package second;


/**
 * Dieses Programm gibt alle Primzahlen bis 4567 über 5 gleichzeitig laufende Threads aus, jeder Thread bekommt seine eigene Zeile zur unterscheidung. 
 * 
 * @version 1.0, 4. Mär 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 *
 */

	
	public class FiveColumnPrimes extends Thread {
		
		public static void main (String args[]) {
			FiveColumnPrimes first = new FiveColumnPrimes("",2); 
			for (int i=3; i <= 4567; first.send(i++)); 
			first.send (0); 
			System.out.println (""); 
			
			
			FiveColumnPrimes second = new FiveColumnPrimes("               ",2); 
		for (int i=3; i <= 4567; second.send(i++)); 
		second.send (0); 
		System.out.println ("");
		
		FiveColumnPrimes third = new FiveColumnPrimes("                              ",2); 
		for (int i=3; i <= 4567; third.send(i++)); 
		third.send (0); 
		System.out.println ("");
		
		FiveColumnPrimes forth = new FiveColumnPrimes("                                             ", 2); 
		for (int i=3; i <= 4567; forth.send(i++)); 
		forth.send (0); 
		System.out.println ("");
		
		FiveColumnPrimes fifth = new FiveColumnPrimes("                                                            ", 2); 
		for (int i=3; i <= 4567; fifth.send(i++)); 
		fifth.send (0); 
		System.out.println ("");
		
		}
		private int buffer = -1;
		private int p;
		private FiveColumnPrimes next; 
		private String abstand;
		
		
		FiveColumnPrimes (String abstand, int prime) { 
			
			super ("Primer-" + prime); 
			p = prime; 
			this.abstand = abstand;
			this.start(); 
			}
		
		synchronized void send(int i) { 
			try {
			while (buffer >= 0) wait();
			buffer = i; 
			notify(); 
			} catch (InterruptedException e) {}
			} 
	
	public void run() { 
		
		System.out.println (abstand +p);
		
		
		while (true) { 
		int n = receive(); 
		if (n == 0) { 
		if (next != null) next.send(n);
		break; 
		}
		if (n%p != 0) { 
		if (next != null) next.send(n);
		else next = new FiveColumnPrimes(abstand,n); 
		} 
		}
		}
	
	synchronized int receive() {
		int result = 0;
		try {
		while ((result=buffer)<0) wait(); 
		
		buffer = -1; 
		notify(); 
		
		} catch (InterruptedException e) {}
		return result;
		} 

	}
	

