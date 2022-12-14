

package GSE2;


public class test {
    public static void main(String[] args) {
        
            Angestellter Lisa = new Angestellter("Lisa", "Nicolaus", 10000, 2000);
            Angestellter Mike = new Angestellter("Mike", "Fischer", 20000, 3000);
            ATAngestellter Silas = new ATAngestellter("Silas", "Heinle", 30000);
            Zeitarbeiter Steffen = new Zeitarbeiter("Steffen", "Bauer", 40000);

            ISteuerZahler[] steuerzahler = {Lisa, Mike, Silas, Steffen};

            Lisa.setGearbeitete‹berstunden(20);
            Steffen.setGearbeiteteStunden(500);

            System.out.println("Einkommenssteuerberechnungen: ");

            System.out.println();

            for (ISteuerZahler mitarbeiter : steuerzahler) {
                System.out.println("Mitarbeiter: " + mitarbeiter);
                System.out.println("Besch‰ftigungsverh‰ltnis: " + mitarbeiter.getClass().getSimpleName());
                System.out.println("Einkommensteuer: " + mitarbeiter.tats‰chlicheEinkommenSteuer() + " Ä");
                System.out.println("Vorraussichtliche Einkommensteuer: " + mitarbeiter.voraussichtlicheEinkommenSteuer() + " Ä");
                System.out.println();
            }

            System.out.println();
            System.out.println("Test:");
            System.out.println();

            System.out.println("Mitarbeiter: " + Lisa);
            System.out.println("Besch‰ftigungsverh‰ltnis: " + Lisa.getClass().getSimpleName());
            System.out.println("Monatsgehalt: " + Lisa.getMonatsLohn() + " Ä");
            System.out.println("‹berstundentarif: " + Lisa.get‹berStundenTarif() + " Ä");
            System.out.println("Gearbeitete ‹berstunden: " + Lisa.getGearbeitete‹berstunden());
            System.out.println("Jahresgehalt: " + Lisa.entgeltBerechnen() + " Ä");
            System.out.println("Einkommensteuer: " + Lisa.tats‰chlicheEinkommenSteuer() + " Ä");
            System.out.println("Vorraussichtliche Einkommensteuer: " + Lisa.voraussichtlicheEinkommenSteuer() + " Ä");

            System.out.println();

            System.out.println("Mitarbeiter: " + Mike);
            System.out.println("Besch‰ftigungsverh‰ltnis: " + Mike.getClass().getSimpleName());
            System.out.println("Monatsgehalt: " + Mike.getMonatsLohn() + " Ä");
            System.out.println("‹berstundentarif: " + Mike.get‹berStundenTarif() + " Ä");
            System.out.println("Gearbeitete ‹berstunden: " + Mike.getGearbeitete‹berstunden());
            System.out.println("Jahresgehalt: " + Mike.entgeltBerechnen() + " Ä");
            System.out.println("Einkommensteuer: " + Mike.tats‰chlicheEinkommenSteuer() + " Ä");
            System.out.println("Vorraussichtliche Einkommensteuer: " + Mike.voraussichtlicheEinkommenSteuer() + " Ä");

            System.out.println();

            System.out.println("Mitarbeiter: " + Silas);
            System.out.println("Besch‰ftigungsverh‰ltnis: " + Silas.getClass().getSimpleName());
            System.out.println("Monatsgehalt: " + Silas.getMonatsLohn() + " Ä");
            System.out.println("Jahresgehalt: " + Silas.entgeltBerechnen() + " Ä");
            System.out.println("Einkommensteuer: " + Silas.tats‰chlicheEinkommenSteuer() + " Ä");
            System.out.println("Vorraussichtliche Einkommensteuer: " + Silas.voraussichtlicheEinkommenSteuer() + " Ä");

            System.out.println();

            System.out.println("Mitarbeiter: " + Steffen);
            System.out.println("Besch‰ftigungsverh‰ltnis: " + Steffen.getClass().getSimpleName());
            System.out.println("Stundenlohn: " + Steffen.getStundenLohn() + " Ä");
            System.out.println("Gearbeitete Stunden: " + Steffen.getGearbeiteteStunden());
            System.out.println("Jahresgehalt: " + Steffen.entgeltBerechnen() + " Ä");
            System.out.println("Einkommensteuer: " + Steffen.tats‰chlicheEinkommenSteuer() + " Ä");
            System.out.println("Vorraussichtliche Einkommensteuer: " + Steffen.voraussichtlicheEinkommenSteuer() + " Ä");

            System.out.println();

            System.out.println("Jahresentgelt: " + (Lisa.entgeltBerechnen() + Mike.entgeltBerechnen() + Silas.entgeltBerechnen() + Steffen.entgeltBerechnen()) + " Ä");
       
    }
}