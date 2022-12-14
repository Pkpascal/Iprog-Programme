

package GSE2;


public class test {
    public static void main(String[] args) {
        
            Angestellter Lisa = new Angestellter("Lisa", "Nicolaus", 10000, 2000);
            Angestellter Mike = new Angestellter("Mike", "Fischer", 20000, 3000);
            ATAngestellter Silas = new ATAngestellter("Silas", "Heinle", 30000);
            Zeitarbeiter Steffen = new Zeitarbeiter("Steffen", "Bauer", 40000);

            ISteuerZahler[] steuerzahler = {Lisa, Mike, Silas, Steffen};

            Lisa.setGearbeiteteÜberstunden(20);
            Steffen.setGearbeiteteStunden(500);

            System.out.println("Einkommenssteuerberechnungen: ");

            System.out.println();

            for (ISteuerZahler mitarbeiter : steuerzahler) {
                System.out.println("Mitarbeiter: " + mitarbeiter);
                System.out.println("Beschäftigungsverhältnis: " + mitarbeiter.getClass().getSimpleName());
                System.out.println("Einkommensteuer: " + mitarbeiter.tatsächlicheEinkommenSteuer() + " €");
                System.out.println("Vorraussichtliche Einkommensteuer: " + mitarbeiter.voraussichtlicheEinkommenSteuer() + " €");
                System.out.println();
            }

            System.out.println();
            System.out.println("Test:");
            System.out.println();

            System.out.println("Mitarbeiter: " + Lisa);
            System.out.println("Beschäftigungsverhältnis: " + Lisa.getClass().getSimpleName());
            System.out.println("Monatsgehalt: " + Lisa.getMonatsLohn() + " €");
            System.out.println("Überstundentarif: " + Lisa.getÜberStundenTarif() + " €");
            System.out.println("Gearbeitete Überstunden: " + Lisa.getGearbeiteteÜberstunden());
            System.out.println("Jahresgehalt: " + Lisa.entgeltBerechnen() + " €");
            System.out.println("Einkommensteuer: " + Lisa.tatsächlicheEinkommenSteuer() + " €");
            System.out.println("Vorraussichtliche Einkommensteuer: " + Lisa.voraussichtlicheEinkommenSteuer() + " €");

            System.out.println();

            System.out.println("Mitarbeiter: " + Mike);
            System.out.println("Beschäftigungsverhältnis: " + Mike.getClass().getSimpleName());
            System.out.println("Monatsgehalt: " + Mike.getMonatsLohn() + " €");
            System.out.println("Überstundentarif: " + Mike.getÜberStundenTarif() + " €");
            System.out.println("Gearbeitete Überstunden: " + Mike.getGearbeiteteÜberstunden());
            System.out.println("Jahresgehalt: " + Mike.entgeltBerechnen() + " €");
            System.out.println("Einkommensteuer: " + Mike.tatsächlicheEinkommenSteuer() + " €");
            System.out.println("Vorraussichtliche Einkommensteuer: " + Mike.voraussichtlicheEinkommenSteuer() + " €");

            System.out.println();

            System.out.println("Mitarbeiter: " + Silas);
            System.out.println("Beschäftigungsverhältnis: " + Silas.getClass().getSimpleName());
            System.out.println("Monatsgehalt: " + Silas.getMonatsLohn() + " €");
            System.out.println("Jahresgehalt: " + Silas.entgeltBerechnen() + " €");
            System.out.println("Einkommensteuer: " + Silas.tatsächlicheEinkommenSteuer() + " €");
            System.out.println("Vorraussichtliche Einkommensteuer: " + Silas.voraussichtlicheEinkommenSteuer() + " €");

            System.out.println();

            System.out.println("Mitarbeiter: " + Steffen);
            System.out.println("Beschäftigungsverhältnis: " + Steffen.getClass().getSimpleName());
            System.out.println("Stundenlohn: " + Steffen.getStundenLohn() + " €");
            System.out.println("Gearbeitete Stunden: " + Steffen.getGearbeiteteStunden());
            System.out.println("Jahresgehalt: " + Steffen.entgeltBerechnen() + " €");
            System.out.println("Einkommensteuer: " + Steffen.tatsächlicheEinkommenSteuer() + " €");
            System.out.println("Vorraussichtliche Einkommensteuer: " + Steffen.voraussichtlicheEinkommenSteuer() + " €");

            System.out.println();

            System.out.println("Jahresentgelt: " + (Lisa.entgeltBerechnen() + Mike.entgeltBerechnen() + Silas.entgeltBerechnen() + Steffen.entgeltBerechnen()) + " €");
       
    }
}