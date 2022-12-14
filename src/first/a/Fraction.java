package first.a;

import java.math.BigInteger;

public final class Fraction extends Number implements Comparable<Fraction>{

    private static Fraction r;

    public Fraction (BigInteger z�hler, BigInteger nenner) {
        this.z�hler=z�hler;
        this.nenner=nenner;
    }

    protected BigInteger z�hler, nenner;

    public Fraction add(Fraction r){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        Fraction fractionsumme = new Fraction(x, y);
            if (this.nenner.equals(r.nenner)) {
                fractionsumme.z�hler = this.z�hler.add(r.z�hler);
                fractionsumme.nenner = this.nenner;
            }
            else {
                fractionsumme.nenner = KgV.kgv(this.nenner, r.nenner);
                fractionsumme.z�hler = ((fractionsumme.nenner.divide(this.nenner)).multiply(this.z�hler)).add((fractionsumme.nenner.divide(r.nenner)).multiply(r.z�hler));
            }
        return fractionsumme;
    }

    public Fraction subtract(Fraction r){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        Fraction fractiondifferenz = new Fraction(x, y);
        if (this.nenner.equals(r.nenner)) {
            fractiondifferenz.z�hler = this.z�hler.subtract(r.z�hler);
            fractiondifferenz.nenner = this.nenner;
        }
        else {
            fractiondifferenz.nenner = KgV.kgv(this.nenner, r.nenner);
            fractiondifferenz.z�hler = ((fractiondifferenz.nenner.divide(this.nenner)).multiply(this.z�hler)).subtract((fractiondifferenz.nenner.divide(r.nenner)).multiply(r.z�hler));
        }
        return fractiondifferenz;
    }

    public Fraction multiply(Fraction r){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        Fraction fractionprodukt = new Fraction(x, y);
        fractionprodukt.z�hler = this.z�hler.multiply(r.z�hler);
        fractionprodukt.nenner = this.nenner.multiply(r.nenner);

        return fractionprodukt;
    }

    public Fraction divide(Fraction r){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        Fraction fractionquotient = new Fraction(x, y);
        fractionquotient.z�hler = this.z�hler.multiply(r.nenner);
        fractionquotient.nenner = this.nenner.multiply(r.z�hler);

        return fractionquotient;
    }

    public String toString() {
        return "["+this.z�hler+"/"+this.nenner+"]";
    }

    public boolean isInteger (){
        int x = this.z�hler.compareTo(this.nenner);
        if (x >= 0 && (this.z�hler.remainder(this.nenner).equals(BigInteger.valueOf(0)))) {
            return true;
        }
         return false;
    }

    public static void main (String[] args){
        Fraction fraction1 = new Fraction(BigInteger.valueOf(8), BigInteger.valueOf(16));
        System.out.println(fraction1.z�hler + "/" + fraction1.nenner);
        Fraction fraction2 = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(3));
        System.out.println(fraction2.z�hler + "/" + fraction2.nenner);
        System.out.println((fraction1.add(fraction2)).z�hler + "/" + (fraction1.add(fraction2)).nenner);
        System.out.println((fraction1.subtract(fraction2)).z�hler + "/" + (fraction1.subtract(fraction2)).nenner);
        System.out.println((fraction1.multiply(fraction2)).z�hler + "/" + (fraction1.multiply(fraction2)).nenner);
        System.out.println((fraction1.divide(fraction2)).z�hler + "/" + (fraction1.divide(fraction2)).nenner);
        System.out.println(fraction1);
        System.out.println(fraction1.isInteger());
        System.out.println(fraction1.z�hler.remainder(fraction1.nenner));

    }