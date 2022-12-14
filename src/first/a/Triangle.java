package first.a;
/**
 * Dieses Programm fragt nach einer Zahl und Zeichnet aus der Anzahl als Basis einen Baum 
 * 
 * @author Marvin Voss, Pascal Brostean, Pacal Knie, Robin Eberle
 *
 */
public class Triangle {

	 static int tabAnzahl;
	 static int sternenAnzahl;
	 
	public static String corona (String x) {
		int counter = sternenAnzahl;
		while(tabAnzahl<counter) {
			x+= " "; counter--;
		}
		
		return x;
	}
	public static void main(String[] args) {
		
		System.out.println("Dieses Programm zeichnet einen Baum aus ´*´ Ziffern");
		
		 sternenAnzahl = MyIO.readInt("Wie viele Einheiten groß soll der Baumwerden? >");
		 tabAnzahl = 0;
		 
		String stern = "*"; 		
		int rundenAnzahl = sternenAnzahl;
		int count = 1;

		while (count <= rundenAnzahl )
		{	 
			System.out.println(corona(" ") + stern); stern+= " *";
		 count++;sternenAnzahl--;
		}
	}
}

