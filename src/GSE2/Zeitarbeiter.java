package GSE2;

/**
 * Diese Klasse erstellt ein Zeitarbeiter Objekt dass die interfaces Mitarbeiter und Steuerzahler implementiert.
 *
 * @author Pascal Knie
 *@version 1.2, 06.04.2021
 */
public class Zeitarbeiter implements IMitarbeiter, ISteuerZahler {
	float stundenLohn;
	int gearbeiteteStunden = 0;
	float jahresGehaltBisHeute;
	private final vertragsArtT vertrag = vertragsArtT.ZEITARBEITSVERTRAG;
	String vorname;
	String nachname;

	/**
	 * Konstruktor für einen Zeitarbeiter mit Vor und Nachname und stundenlohn.
	 * 
	 * @param vorname     des Zeitarbeiters
	 * @param nachname    des Zeitarbeiter
	 * @param stundenLohn des Zeitarbeiters
	 */
	public Zeitarbeiter(String vorname, String nachname, float stundenLohn) {

		this.vorname = vorname;
		this.nachname = nachname;
		setStundenLohn(stundenLohn);
		
	}
	/**
	 * @return vertrag des Zeitarbeiters
	 */
	public vertragsArtT getVertrag() {
		return vertrag;
	}

	/**
	 * @return Stunden Lohn des Zeitarbeiters
	 */
	public double getStundenLohn() {
		return stundenLohn;
	}
	/**
	 * 
	 * @param stundenLohn des Zeitarbeiters
	 */
	private void setStundenLohn(float stundenLohn) {
		if (stundenLohn >= mindestLohn) {
			this.stundenLohn = stundenLohn;
		} else {
			System.out.println("Stundenlohn für Mitarbeiter " +vorname +" " +nachname+ " zu gering ( "+ stundenLohn+ "< 9.50 €/h)");
		}
	}

	/**
	 * 
	 * @return gearbeitete Zeit
	 */
	public int getGearbeiteteStunden() {
		return gearbeiteteStunden;
	}

	/**
	 * 
	 * @return jahresGehaltBisHeute Gehalt in diesem jahr
	 */
	public float getJahresGehaltBisHeute() {
		return jahresGehaltBisHeute;
	}

	/**
	 * 
	 * @param gearbeitet wie viele Stunden wurden gearbeitet
	 */
	public void setGearbeiteteStunden(int gearbeitet) {
		this.gearbeiteteStunden = gearbeitet;
	}
	/**
	 * @return vorname des Zeitarbeiters
	 */
	@Override
	public String getVorname() {
		
		return vorname;
	}
/**
 * @return nachname des Zeitarbeiters
 */
	@Override
	public String getNachname() {
		
		return nachname;
	}
	/**
	 * to String methode des Zeitarbeiters
	 * 
	 * @return Mitarbeiter vor, nachname und vertragsart.
	 */
	public String toString() {
		return "Mitarbeiter "+ vorname +" "+ nachname +" Vertragsart : "+ vertrag;
		
	}
	/**
	 * berechnet die Einkommensteuer vom bisherigen Jahr
	 * 
	 *  @return Steuern über das Jahr
	 */
	@Override
	public float tatsächlicheEinkommenSteuer() {
		
		return  jahresGehaltBisHeute * einkommenSteuersatz;
	}

	/**
	 * berechnet die voraussichtliche Einkommen Steuer des ganzen Jahres mit durchschnittlich 160 stunden pro Monat
	 * 
	 *  @return Steuern über das Jahr
	 */
	@Override
	public float voraussichtlicheEinkommenSteuer() {
		
		return (stundenLohn * 160 * 12) * einkommenSteuersatz;
	}
	
	/**
	 * Berechnet das entgelt des Zeitarbeiters.
	 * 
	 * @return entgelt
	 */
	@Override
	public float entgeltBerechnen() {
		
		jahresGehaltBisHeute += stundenLohn * gearbeiteteStunden;
		
		return stundenLohn * gearbeiteteStunden -(stundenLohn*gearbeiteteStunden*einkommenSteuersatz);
	}

}



