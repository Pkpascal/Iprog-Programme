package second;

/**
 * Dieses Programm läuft alle gerade Zahlen bis 100 durch, wenn eine Zahl nicht
 * restlos durch p teilbar ist wird sie weitergegeben, gleichzeitig wird sie
 * verdoppelt und mit p addiert um einen neuen "Ast" an Zahlen zu erstellen.
 * 
 * @version 1.0, 4. Mär 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 *
 */


/* Die Prozesse die Parallel in diesem Programm laufen wachsen exponentiell an. Ab einem bestimmten Punkt werden mehr Threads erstellt als geschloosen werden können. */
public class PrimeTree extends Thread {

	private int buffer = -1;
	private int p;
	private PrimeTree right;
	private PrimeTree left;

	PrimeTree(int prime) {

		super("Primer-" + prime);
		p = prime;

		this.start();
	}

	synchronized void send(int i) {
		try {
			while (buffer >= 0)
				wait();
			buffer = i;
			notify();
		} catch (InterruptedException e) {
		}
	}

	public void run() {
		System.out.println(currentThread() + " Primzahl: " + p);
		
		while (true) {
			int n = receive();
			

			if (n == 0) { 
					if (left != null) {
						left.send(0);	
					}
					
					 if (right != null) {
						right.send(0);
					}
					 
					 break;
				}
			

			if (n % p != 0) {
				if (right != null) {
					right.send(n);
				} else {
					right = new PrimeTree(n);
				}
				if (left != null) {
					left.send(2 * n + p);
				} else {
					left = new PrimeTree(2 * n + p);
				}

			}
		}
	}

	synchronized int receive() {
		int result = 0;
		try {
			while ((result = buffer) < 0)
				wait();

			buffer = -1;
			notify();

		} catch (InterruptedException e) {
		}
		return result;
	}

	public static void main(String[] args) {
		PrimeTree first = new PrimeTree(2);
		for (int i = 3; i <= 10; first.send(i++))
			;
		first.send(0);
		System.out.println(PrimeTree.currentThread() + " main beendet");
	}
}
