package first;

import second.MyIO;

public class MathPlotter {
    public static void plot(D2Method meth) {

        double beginn = MyIO.readDouble("Zahlenwert f�r Beginn: ");
        double ende = MyIO.readDouble("Zahlenwart f�r Ende: ");
        double schrittweite = MyIO.readDouble("Zahlenwert f�r Schrittweite: ");
        MyIO.writeln("");
        for (double a = beginn; a <= ende; a += schrittweite) {
            MyIO.writeln(a + "->" + meth.compute(a));
        }
    }


    public static void main(String[] args) {
        while (true){
        MyIO.writeln("Verf�gbare Funktionen: sin, cos, exp, log, sqrt, tan, square, cube, quad, tower");
        String mathfunc = MyIO.promptAndRead("W�hlen Sie eine Funktion aus (stop f�r Ende) : ");
        if (mathfunc.equals("stop")){
            MyIO.writeln("Programm Ende");
            break;
        }
        else {

            switch (mathfunc) {

                case "sin":
                    MyIO.writeln("<sin> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.sin(value);
                             }
                         }
                    );
                    break;

                case "cos":
                    MyIO.writeln("<cos> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.cos(value);
                             }
                         }
                    );
                    break;

                case "exp":
                    MyIO.writeln("<exp> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.exp(value);
                             }
                         }
                    );
                    break;

                case "log":
                    MyIO.writeln("<log> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.log(value);
                             }
                         }
                    );
                    break;

                case "sqrt":
                    MyIO.writeln("<sqrt> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.sqrt(value);
                             }
                         }
                    );
                    break;

                case "tan":
                    MyIO.writeln("<tan> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return Math.tan(value);
                             }
                         }
                    );
                    break;

                case "square":
                    MyIO.writeln("<square> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return value * value;
                             }
                         }
                    );
                    break;

                case "cube":
                    MyIO.writeln("<cube> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return value * value * value;
                             }
                         }
                    );
                    break;

                case "quad":
                    MyIO.writeln("<quad> ausgew�hlt!");
                    plot(new D2Method() {
                             @Override
                             public double compute(double value) {
                                 return value * value * value * value;
                             }
                         }
                    );
                    break;

                case "tower":
                    MyIO.writeln("<tower> ausgew�hlt!");
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