package GSE2;

/**
 * This Programm is a special class and implents the interfaces IMitarbeiter and ISteuerzahler.
 *
 * @author Marvin Voss
 * @version 1.1, 06 Apr 2021
 *
 */

public class Angestellter implements IMitarbeiter, ISteuerZahler {

	private float monatsLohn;
	private float �berStundenTarif;
	private int gearbeitete�berstunden;
	private float jahresGehaltBisHeute;
	private final vertragsArtT vertrag = vertragsArtT.TARIFVERTRAG;
	private final String vorname;
	private final String nachname;

	/**
	 * Constructor used to create an object of the type Angestellter
	 *
	 * @param pVorname          takes the vorname of the abstract class Mitarbeiter
	 *                          to set it to the local variable
	 * @param pNachname         takes the nachname of the abstract class Mitarbeiter
	 *                          to set it to the local variable
	 * @param pMonatsLohn       takes the monthly wage of the employee to set it to
	 *                          the local variable
	 * @param p�berstundenTarif takes the overtime rate of the employee to set it to
	 *                          the local variable
	 */
	public Angestellter(String pVorname, String pNachname, float pMonatsLohn, float p�berstundenTarif) {
		this.vorname = pVorname;
		this.nachname = pNachname;
		if ((pMonatsLohn / 160) >= mindestLohn) {
			this.monatsLohn = pMonatsLohn;
		} else {
			System.out.println("Mindestlohn von "+pVorname+" "+pNachname+" wird nicht eingehalten ("+pMonatsLohn/160+" �/h < 9.50 �/h)");
		}
		this.�berStundenTarif = p�berstundenTarif;
	}

	public vertragsArtT getVertrag() {
		return vertrag;
	}

	/**
	 * Returns monthly wage of the employee (Angestellter) as it is called on
	 * 
	 * @return float monthly wage of the current employer.
	 */
	public float getMonatsLohn() {
		return monatsLohn;
	}

	/**
	 * Returns the overtime rate as is is called on
	 * 
	 * @return float overtime rate of the employee.
	 */
	public float get�berStundenTarif() {
		return �berStundenTarif;
	}

	/**
	 * Returns the worked overtime of the employee
	 * 
	 * @return int �berstunden des Angestellten
	 */
	public int getGearbeitete�berstunden() {
		return gearbeitete�berstunden;
	}

	/**
	 * Sets the worked overtime of the employee
	 * 
	 * @param int pGearbeitete�berstunden worked overtime of the employee
	 */
	public void setGearbeitete�berstunden(int gearbeitete�berstunden) {
		this.gearbeitete�berstunden = gearbeitete�berstunden;
	}

	@Override
	/**
	 * Returns the calculated monthly wage of the employee.
	 * 
	 * @return float wage of the employee
	 */
	public float entgeltBerechnen() {

		jahresGehaltBisHeute += monatsLohn + ((monatsLohn / 160) * (�berStundenTarif * gearbeitete�berstunden));

		return (float) monatsLohn * gearbeitete�berstunden;
	}

	/**
	 * Returns the calculated monthly wage of the employee.
	 * 
	 * @return float wage of the employee
	 */
	public float getJahresGehaltBisHeute() {
		return (float) jahresGehaltBisHeute;
	}

	/**
	 * Returns the actual income tax of the employee.
	 * 
	 * @return float actual income tax of the employee
	 */
	@Override
	public float tats�chlicheEinkommenSteuer() {

		return (float) getJahresGehaltBisHeute() * einkommenSteuersatz;
	}

	/**
	 * Returns anticipated income tax of the employee. 
	 * 
	 * @return float anticipated income tax of the employee
	 */
	@Override
	public float voraussichtlicheEinkommenSteuer() {
		return (float) (monatsLohn * 12) * einkommenSteuersatz;
	}

	/**
	 * Returns first name of the employee.
	 * 
	 * @return String first name of the employee
	 */
	@Override
	public String getVorname() {
		return vorname;
	}

	@Override
	/**
	 * Returns the surname of the employee.
	 * 
	 * @return String surname of the employee
	 */
	public String getNachname() {
		return nachname;
	}

	@Override
	/**
	 * Create a String that contains first name, surname and contract type of the
	 * employee
	 * 
	 * @return String A String with the first name, surname and contract type of the
	 *         employee
	 */
	public String toString() {
		return "Mitarbeiter " + vorname + " " + nachname + " " + "Vertragsart: " + vertrag;
	}
}