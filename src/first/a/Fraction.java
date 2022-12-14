package first.a;

import java.math.BigInteger;

public final class Fraction extends Number implements Comparable<Fraction>{

    private static Fraction r;

    public Fraction (BigInteger zähler, BigInteger nenner) {
        this.zähler=zähler;
        this.nenner=nenner;
    }

    protected BigInteger zähler, nenner;

    public Fraction add(Fraction r){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        Fraction fractionsumme = new Fraction(x, y);
            if (this.nenner.equals(r.nenner)) {
                fractionsumme.zähler = this.zähler.add(r.zähler);
                fractionsumme.nenner = this.nenner;
            }
            else {
                fractionsumme.nenner = KgV.kgv(this.nenner, r.nenner);
                fractionsumme.zähler = ((fractionsumme.nenner.divide(this.nenner)).multiply(this.zähler)).add((fractionsumme.nenner.divide(r.nenner)).multiply(r.zähler));
            }
        return fractionsumme;
    }

    public Fraction subtract(Fraction r){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        Fraction fractiondifferenz = new Fraction(x, y);
        if (this.nenner.equals(r.nenner)) {
            fractiondifferenz.zähler = this.zähler.subtract(r.zähler);
            fractiondifferenz.nenner = this.nenner;
        }
        else {
            fractiondifferenz.nenner = KgV.kgv(this.nenner, r.nenner);
            fractiondifferenz.zähler = ((fractiondifferenz.nenner.divide(this.nenner)).multiply(this.zähler)).subtract((fractiondifferenz.nenner.divide(r.nenner)).multiply(r.zähler));
        }
        return fractiondifferenz;
    }

    public Fraction multiply(Fraction r){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        Fraction fractionprodukt = new Fraction(x, y);
        fractionprodukt.zähler = this.zähler.multiply(r.zähler);
        fractionprodukt.nenner = this.nenner.multiply(r.nenner);

        return fractionprodukt;
    }

    public Fraction divide(Fraction r){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        Fraction fractionquotient = new Fraction(x, y);
        fractionquotient.zähler = this.zähler.multiply(r.nenner);
        fractionquotient.nenner = this.nenner.multiply(r.zähler);

        return fractionquotient;
    }

    public String toString() {
        return "["+this.zähler+"/"+this.nenner+"]";
    }

    public boolean isInteger (){
        int x = this.zähler.compareTo(this.nenner);
        if (x >= 0 && (this.zähler.remainder(this.nenner).equals(BigInteger.valueOf(0)))) {
            return true;
        }
         return false;
    }

    public static void main (String[] args){
        Fraction fraction1 = new Fraction(BigInteger.valueOf(8), BigInteger.valueOf(16));
        System.out.println(fraction1.zähler + "/" + fraction1.nenner);
        Fraction fraction2 = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(3));
        System.out.println(fraction2.zähler + "/" + fraction2.nenner);
        System.out.println((fraction1.add(fraction2)).zähler + "/" + (fraction1.add(fraction2)).nenner);
        System.out.println((fraction1.subtract(fraction2)).zähler + "/" + (fraction1.subtract(fraction2)).nenner);
        System.out.println((fraction1.multiply(fraction2)).zähler + "/" + (fraction1.multiply(fraction2)).nenner);
        System.out.println((fraction1.divide(fraction2)).zähler + "/" + (fraction1.divide(fraction2)).nenner);
        System.out.println(fraction1);
        System.out.println(fraction1.isInteger());
        System.out.println(fraction1.zähler.remainder(fraction1.nenner));

    }