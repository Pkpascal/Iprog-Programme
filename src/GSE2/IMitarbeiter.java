package GSE2;

/**
 * Interface für die Entgeltberechnung verschiedener Mitarbeiter-Klassen 
 * 
 * @version 1.0, 06. April 2021
 * @author Robin Eberle
 */
public interface IMitarbeiter {

	public enum vertragsArtT {
		ZEITARBEITSVERTRAG, TARIFVERTRAG, AUßERTARIFLICHER_VERTRAG ;
		}
	public final float mindestLohn = 9.50f; // gesetzlicher Mindestlohn der auf Einhaltung ueberprueft werden muss
	
	/**
	 * Abstrakte Klasse zur Entgeltberechnung verschiedener Mitarbeiter.
	 * 
	 * @return float 	das monatliche Entgelt
	 */
	float entgeltBerechnen();

	String getVorname();

	String getNachname();

	String toString();

	vertragsArtT getVertrag();
}

