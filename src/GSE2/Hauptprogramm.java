package GSE2;

import java.text.DecimalFormat;

/**
 * Dies ist das Hauptprogramm mit der Main-Methode, in der für jeden Mitarbeiter die
 * tatsächliche und die voraussichtliche Einkommensteuer aufgerufen und ausgegeben wird.
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
		MV.setGearbeiteteÜberstunden(1); // Januar
		MV.entgeltBerechnen(); // Januar
		MV.setGearbeiteteÜberstunden(20); // Februar
        MV.entgeltBerechnen(); // Februar
		MV.setGearbeiteteÜberstunden(12); // Maerz
        MV.entgeltBerechnen(); // Maerz

		ATAngestellter PB = new ATAngestellter("Pascal", "Brostean", 2400F);
		PB.entgeltBerechnen(); // Januar
        PB.entgeltBerechnen(); // Februar
        PB.entgeltBerechnen(); // Maerz

		ISteuerZahler[] mitarbeiter = { PK, MV, PB };
		
		//System.out.println(PB);
		
		for (ISteuerZahler arbeiter : mitarbeiter) {
            System.out.println( "\n" + arbeiter+ 
            		"\nTatsächliche Einkommensteuer beträgt " + frmt.format(arbeiter.tatsächlicheEinkommenSteuer()) + " €" + 
            		"\nVorraussichtliche Einkommensteuer beträgt " + frmt.format(arbeiter.voraussichtlicheEinkommenSteuer()) + " €");
        }

	}
}
