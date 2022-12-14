package GSE2;


/**
 * Interface zur Steuerberechnung f�r verschiedene Mitarbeiter Klassen
 * 
 * @version 1.0, 06. April 2021
 * @author Robin Eberle
 */
public interface ISteuerZahler {
	
	public final float einkommenSteuersatz = 0.36f;
	
	/**
	 *  Berechnet die auf das jahresgehaltBisHeute anfallende Einkommensteuer.
	 * 
	 * @return float	bisheriges versteuertes Einkommen
	 */
	public float tats�chlicheEinkommenSteuer();
	
	/**
	 * Abstrakte Methode zur berechnung der Einkommensteuer fuer das ganze Jahr.
	 * 
	 * @return float	das voraussichtlich versteuerte Einkommen fuer das gesamte Jahr.
	 */
	public float voraussichtlicheEinkommenSteuer();

}

