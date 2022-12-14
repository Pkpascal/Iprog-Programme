package first;

import second.MyIO;

public class MathPlotter {
    public static void plot(D2Method meth) {

        double beginn = MyIO.readDouble("Zahlenwert für Beginn: ");
        double ende = MyIO.readDouble("Zahlenwart für Ende: ");
        double schrittweite = MyIO.readDouble("Zahlenwert für Schrittweite: ");
        MyIO.writeln("");
        for (double a = beginn; a <= ende; a += schrittweite) {
            MyIO.writeln(a + "->" + meth.compute(a));
        }
    }


    public static void main(String[] args) {
        while (true){
        MyIO.writeln("Verfügbare Funktionen: sin, cos, exp, log, sqrt, tan, square, cube, quad, tower");
        String mathfunc = MyIO.promptAndRead("Wählen Sie eine Funktion aus (stop für Ende) : ");
        if (mathfunc.equals("stop")){
            MyIO.writeln("Programm Ende");
            break;
        }
        else {

            switch (mathfunc) {

                case "sin":
                    MyIO.writeln("<sin> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.sin(value);
                             }
                         }
                    );
                    break;

                case "cos":
                    MyIO.writeln("<cos> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.cos(value);
                             }
                         }
                    );
                    break;

                case "exp":
                    MyIO.writeln("<exp> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.exp(value);
                             }
                         }
                    );
                    break;

                case "log":
                    MyIO.writeln("<log> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.log(value);
                             }
                         }
                    );
                    break;

                case "sqrt":
                    MyIO.writeln("<sqrt> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.sqrt(value);
                             }
                         }
                    );
                    break;

                case "tan":
                    MyIO.writeln("<tan> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.tan(value);
                             }
                         }
                    );
                    break;

                case "square":
                    MyIO.writeln("<square> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return value * value;
                             }
                         }
                    );
                    break;

                case "cube":
                    MyIO.writeln("<cube> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return value * value * value;
                             }
                         }
                    );
                    break;

                case "quad":
                    MyIO.writeln("<quad> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return value * value * value * value;
                             }
                         }
                    );
                    break;

                case "tower":
                    MyIO.writeln("<tower> ausgewählt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.pow(value, Math.pow(value, value));
                             }
                         }
                    );
                    break;

                default:
                    MyIO.writeln("Falsche Eingabe, versuche es erneut!");
                    break;
            }
            System.out.println();
        }
        }
    }
}