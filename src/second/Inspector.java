package second;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
/*
 * Dieses Programm beschreibt eine noch nicht inizialisierte Klasse und gibt alle Methoden, deren Namen, Parameter und Return wert zurück.
 * Es werden die implementierten Interfaces, die Superklassen und deren Interfaces und Superklassen herausgegeben.
 * 
 * 
 * @version 1.0, 17 Jun 2021
 * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
 */
public class Inspector {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(new DataInputStream(System.in))); // zum Lesen von
		while (true) {
			try {
				System.out.print("Klassenname oder ende eingeben: ");
				String buf = in.readLine(); // eine Zeile lesen
				if (buf.toLowerCase().startsWith("end")) {
					System.out.println("Programm beendet");
					break;
				} // Abbruch
				Class c = Class.forName(buf); // versuche Klasse zu laden

				System.out.println(methodenaufruf(c));
			} catch (IOException e) {
				System.out.println(e);
			} catch (ClassNotFoundException e) { // Klasse nicht gefunden
				System.out.println("Klasse nicht gefunden");
			} catch (ClassCastException e) { // kann nicht gecastet werden
				System.out.println(e);
			}
		}

	}
/**
 * In dieser Methode wird eine eingegebene Klasse mit allen Eigenschaften als String beschrieben und zurück gegeben.
 * 
 * @param c Klasse die beschrieben werden soll.
 * @return String der eigenschaften der Klasse.
 */
	@SuppressWarnings("rawtypes")
	public static String methodenaufruf(Class c) {
		String klasse = "";
		klasse += c.getName() + "\n";
		Method[] meths = c.getMethods();
		for (Method methode : meths) { // Methoden Array auslesen
			klasse += "\n\n Methode: ";
			klasse += methode.getName() + "\n";
			klasse += "\n Parameter: \n";

			Parameter[] parameter = methode.getParameters();
			for (Parameter param : parameter) { // Parameter Array auslesen.
				klasse += "- " + param.toString() + "\n";
			}

			klasse += "\n Return Typ: ";
			klasse += methode.getGenericReturnType() + "\n";
			klasse += "\n";
			klasse += "------------------------------------------------------------------------------------------------------";
		}
		klasse += "\n\n Interfaces der Klasse: \n";

		Class[] interfaces = c.getInterfaces();
		for (Class inter : interfaces) {  // Interface array Auslesen.
			klasse += "- " + inter.toString() + "\n";
		}
		klasse += "\n------------------------------------------------------------------------------------------------------";
		Class clazz = c.getSuperclass();
		int count = 1; // Menge der Superklassen. 

		while (clazz != null) {
			klasse += "\n\n" + count + ". Superklasse: \n ";
			klasse += "- " + clazz + "\n";
			klasse += " \n Interfaces der Superklasse: \n";

			Class[] superinterfaces = clazz.getInterfaces();
			for (Class inter : superinterfaces) {
				klasse += "- " + inter.toString() + "\n";
			}
			klasse += "\n";
			clazz = clazz.getSuperclass();

			count++;
			klasse += "------------------------------------------------------------------------------------------------------";
		}
		return klasse;
	}

}
