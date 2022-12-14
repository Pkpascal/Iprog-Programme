package GSE2;

/**
 * Diese Klasse erstellt ein Zeitarbeiter Objekt dass die interfaces Mitarbeiter und Steuerzahler implementiert.
 *
 * Gruppe: "Marvin Voss, Pascal Knie, Robin Eberle, Pascal Brostean
 *
 * @author Pascal Brostean
 * @version 2.0, 06.04.2021
 */

public class ATAngestellter implements IMitarbeiter, ISteuerZahler {

	float monatsLohn;
	float jahresGehaltBisHeute;
	private final vertragsArtT vertrag = vertragsArtT.AUßERTARIFLICHER_VERTRAG;
	String vorname;
    String nachname;

	/**
	 * Instanziiert einen neuen ATAngstellten.
	 *
	 * @param vorname    der Vorname des ATAngestellten
	 * @param nachname   der Nachname des ATAngestellten
	 * @param monatsLohn der entsprechender Monatslohn des ATAngestellten
	 */
	public ATAngestellter(String vorname, String nachname, float monatsLohn) {
		
		this.vorname = vorname;
        this.nachname = nachname;
		
		if (monatsLohn/160 < mindestLohn) {
            System.out.println("Stundenlohn für ATAngestellten "+vorname+" "+nachname+" zu gering! ("+monatsLohn/160+" €/h < 9.50 €/h)");
            } else {
            this.monatsLohn = monatsLohn;
        }
	}

	/**
	 * Gibt den Monatslohn zurück.
	 *
	 * @return der Monatslohn als float
	 */
	public float getMonatsLohn() {
		return monatsLohn;
	}

	/**
	 * Setzt den Monatslohn.
	 *
	 * @param monatsLohn der entsprechende Monatslohn als float
	 */
	public void setMonatsLohn(float monatsLohn) {
	    this.monatsLohn = monatsLohn;
	}
	

	/**
     * Gibt den Vertrag des ATAngstellten zurück.
     *
     * @return der vertrag als enum
     */
	public vertragsArtT getVertrag() {
		return vertrag;
	}

	/**
	 * Berechnet das Entgelt.
	 *
	 * @return der Monatslohn als float, ist in diesem Fall gleichzeitig das Entgelt
	 */
	public float entgeltBerechnen() {
	    jahresGehaltBisHeute += monatsLohn;
		return monatsLohn;
	}

	/**
	 * Berechnet die Einkommensteuer bis zum bisherigen Monat des Jahres.
	 * 
	 * @return Steuern über das Jahr
	 */
	@Override
	public float tatsächlicheEinkommenSteuer() {
		return (jahresGehaltBisHeute*einkommenSteuersatz);
	}

	/**
	 * Berechnet die voraussichtliche Einkommensteuer des ganzen Jahres mit durchschnittlich 160 Stunden pro Monat.
	 * 
	 * @return Steuern über das Jahr
	 */
	@Override
	public float voraussichtlicheEinkommenSteuer() {
		return (monatsLohn*12*einkommenSteuersatz);
	}

	/**
	 * Gibt den Vornamen des ATAngestellten zurück.
	 *
	 * @return der Vorname als String
	 */
	@Override
	public String getVorname() {
		return vorname;
	}

	/**
	 * Gibt dem Nachnamen des ATAngstellen zurück.
	 *
	 * @return der Nachname als String
	 */
	@Override
	public String getNachname() {
		return nachname;
	}

	/**
	 * to String Methode des ATAngestellten.
	 * 
	 * @return Mitarbeiter Vor, Nachname und Vertragsart
	 */
	public String toString() {
		return "Mitarbeiter "+vorname + " " + nachname +" "+ "Vertragsart: "+ vertrag;
	}
}