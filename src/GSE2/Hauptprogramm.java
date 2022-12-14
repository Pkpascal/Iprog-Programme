package GSE2;

import java.text.DecimalFormat;

/**
 * Dies ist das Hauptprogramm mit der Main-Methode, in der f¸r jeden Mitarbeiter die
 * tats‰chliche und die voraussichtliche Einkommensteuer aufgerufen und ausgegeben wird.
 *
 * @version 1.0, 06. April 2021
 * @author Robin Eberle
 */
public class Hauptprogramm {

	public static void main(String[] args) {

		DecimalFormat frmt = new DecimalFormat();
		frmt.setMaximumFractionDigits(2);

		Zeitarbeiter PK = new Zeitarbeiter("Pascal", "Knie", 9.77F);
		PK.setGearbeiteteStunden(160);
		PK.entgeltBerechnen(); // Januar
        PK.entgeltBerechnen(); // Februar
        PK.entgeltBerechnen(); // Maerz

		Angestellter MV = new Angestellter("Marvin", "Voss", 2000F, 1.12F);
		MV.setGearbeitete‹berstunden(1); // Januar
		MV.entgeltBerechnen(); // Januar
		MV.setGearbeitete‹berstunden(20); // Februar
        MV.entgeltBerechnen(); // Februar
		MV.setGearbeitete‹berstunden(12); // Maerz
        MV.entgeltBerechnen(); // Maerz

		ATAngestellter PB = new ATAngestellter("Pascal", "Brostean", 2400F);
		PB.entgeltBerechnen(); // Januar
        PB.entgeltBerechnen(); // Februar
        PB.entgeltBerechnen(); // Maerz

		ISteuerZahler[] mitarbeiter = { PK, MV, PB };
		
		//System.out.println(PB);
		
		for (ISteuerZahler arbeiter : mitarbeiter) {
            System.out.println( "\n" + arbeiter+ 
            		"\nTats‰chliche Einkommensteuer betr‰gt " + frmt.format(arbeiter.tats‰chlicheEinkommenSteuer()) + " Ä" + 
            		"\nVorraussichtliche Einkommensteuer betr‰gt " + frmt.format(arbeiter.voraussichtlicheEinkommenSteuer()) + " Ä");
        }

	}
}
