package first.a;

import java.io.*;
import java.net.URL;

public class Filter {
    public static void main(String[] arg) throws Exception {
        InputStreamReader isr;
        BufferedReader keyboard;
        isr = new InputStreamReader(System.in);
        keyboard = new BufferedReader(isr);
        String inputURL;
        String inputMuster;

        System.out.println("Welche URL soll im Folgenden durchsucht werden?: ");
        inputURL = keyboard.readLine();
        System.out.println("Nach welchem Muster soll gesucht werden?: ");
        inputMuster = keyboard.readLine().toLowerCase();

        URL u = new URL(inputURL);
        FilterInputStream ins = (FilterInputStream) u.openStream();
        InputStreamReader isr2 = new InputStreamReader(ins);
        BufferedReader chosenURL = new BufferedReader(isr2);
        String read = chosenURL.readLine().toLowerCase();
        while (read != null) {
            if (read.contains(inputMuster)) {
                System.out.println(read);
                read = chosenURL.readLine();
            }
            else {
                read = chosenURL.readLine();
            }
        }
    }
}
