package second;

import org.junit.*;
import org.junit.Assert.*;

import Maxprogramm.Fraction;

import java.math.BigInteger;

public class FractionTest {
	/*
	 * Hier werden die Methoden der Fraction Klasse getestet.
	 * @version 1.0, 12 Mar 2021
     * @author Marvin Voss, Pascal Brostean, Pascal Knie, Robin Eberle
	 */

    @Test  
    /*Hier wird getestet ob der konstruktor die Fraction beim erstellen kürz indem wir 2 Fractions
     *  "expected" und "actual" erstellen und deren Zähler und Nenner mithilfe der assertEquals methode miteinander Vergleichen. 
     * @param
     * @return void
     */ 

    public void test_constructor_5_5() {
        Fraction expected = new Fraction(new BigInteger("1"), new BigInteger("1"));
        Fraction actual = new Fraction(new BigInteger("5"), new BigInteger("5"));
        Assert.assertEquals("test_constructor_5_5_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_constructor_5_5_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_constructor_minus5_10() {
        Fraction expected = new Fraction(new BigInteger("-1"), new BigInteger("2"));
        Fraction actual = new Fraction(new BigInteger("-5"), new BigInteger("10"));
        Assert.assertEquals("test_constructor_minus5_10_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_constructor_minus5_10_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_constructor_0_1() {
        Fraction expected = new Fraction(new BigInteger("0"), new BigInteger("100"));
        Fraction actual = new Fraction(new BigInteger("0"), new BigInteger("1"));
        Assert.assertEquals("test_constructor_0_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_constructor_0_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_constructor_120_10() {
        Fraction expected = new Fraction(new BigInteger("12000"), new BigInteger("1000"));
        Fraction actual = new Fraction(new BigInteger("120"), new BigInteger("10"));
        Assert.assertEquals("test_constructor_120_10_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_constructor_120_10_nenner", expected.nenner, actual.nenner);
    }
    /*Hier wird getestet ob die kürzen methode die Fraction korrekt kürz indem wir zwei Fraction
     *  "expected" und "actual" erstellen und deren Zähler und Nenner mithilfe der assertEquals methode miteinander Vergleichen. 
     * @param
     * @return void
     */ 

    @Test
    public void test_kürzen_5_10() {
        Fraction expected = new Fraction(new BigInteger("1"), new BigInteger("2"));
        Fraction actual = new Fraction(new BigInteger("5"), new BigInteger("10"));
        Assert.assertEquals("test_kürzen_5_10_zähler", expected.zähler, actual.kürzen(actual).zähler);
        Assert.assertEquals("test_kürzen_5_10_nenner", expected.nenner, actual.kürzen(actual).nenner);
    }

    @Test
    public void test_kürzen_10_5() {
        Fraction expected = new Fraction(new BigInteger("2"), new BigInteger("1"));
        Fraction actual = new Fraction(new BigInteger("10"), new BigInteger("5"));
        Assert.assertEquals("test_kürzen_10_5_zähler", expected.zähler, actual.kürzen(actual).zähler);
        Assert.assertEquals("test_kürzen_10_5_nenner", expected.nenner, actual.kürzen(actual).nenner);
    }

    @Test
    public void test_minus10_minus5() {
        Fraction expected = new Fraction(new BigInteger("2"), new BigInteger("1"));
        Fraction actual = new Fraction(new BigInteger("-10"), new BigInteger("-5"));
        Assert.assertEquals("test_minus10_minus5_zähler", expected.zähler, actual.kürzen(actual).zähler);
        Assert.assertEquals("test_minus10_minus5_nenner", expected.nenner, actual.kürzen(actual).nenner);
    }

    @Test
    public void test_kürzen_maxlong_maxlong() {
        Fraction expected = new Fraction(new BigInteger("1"), new BigInteger("1"));
        Fraction actual = new Fraction(BigInteger.valueOf(Long.MAX_VALUE), BigInteger.valueOf(Long.MAX_VALUE));
        Assert.assertEquals("test_kürzen_maxlong_maxlong_zähler", expected.zähler, actual.kürzen(actual).zähler);
        Assert.assertEquals("test_kürzen_maxlong_maxlong_nenner", expected.nenner, actual.kürzen(actual).nenner);
    }

    @Test
    public void test_kürzen_minlong_minlong() {
        Fraction expected = new Fraction(new BigInteger("1"), new BigInteger("1"));
        Fraction actual = new Fraction(BigInteger.valueOf(Long.MIN_VALUE), BigInteger.valueOf(Long.MIN_VALUE));
        Assert.assertEquals("test_kürzen_minlong_minlong_zähler", expected.zähler, actual.kürzen(actual).zähler);
        Assert.assertEquals("test_kürzen_minlong_minlong_nenner", expected.nenner, actual.kürzen(actual).nenner);
    }
    /*Hier wird getestet ob die add methode zwei Fraction korrekt addiert und kürz indem wir 2 Fractions
     *  "expected" und "actual" erstellen und deren Zähler und nenner mithilfe der assertEquals methode miteinander Vergleichen. 
     * @param
     * @return void
     */ 

    @Test
    public void test_add_4_1_and_1_1() {
        Fraction a = new Fraction(new BigInteger("4"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("1"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("5"), new BigInteger("1"));
        Fraction actual = a.add(b);
        Assert.assertEquals("test_add_4_1_and_1_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_add_4_1_and_1_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_add_0_1_and_10_1() {
        Fraction a = new Fraction(new BigInteger("0"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("10"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("10"), new BigInteger("1"));
        Fraction actual = a.add(b);

        Assert.assertEquals("test_add_0_1_and_10_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_add_0_1_and_10_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_add_minus4_1_and_1_1() {
        Fraction a = new Fraction(new BigInteger("-4"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("1"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("-3"), new BigInteger("1"));
        Fraction actual = a.add(b);

        Assert.assertEquals("test_add_minus4_1_and_1_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_add_minus4_1_and_1_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_add_1234_1_and_1234_1() {
        Fraction a = new Fraction(new BigInteger("1234"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("1234"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("2468"), new BigInteger("1"));
        Fraction actual = a.add(b);

        Assert.assertEquals("test_add_1234_1_and_1234_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_add_1234_1_and_1234_1_nenner", expected.nenner, actual.nenner);
    }

    @Test(expected = ArithmeticException.class)
    public void test_add_10_0_and_10_10() {
        Fraction frac = new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(0));
        Fraction frac2 = new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(10));
        frac.add(frac2);
    }
    /*Hier wird getestet ob die substract methode zwei Fraction korrekt subtrahiert und kürz indem wir 2 Fractions
     *  "expected" und "actual" erstellen und deren Zähler und nenner mithilfe der assertEquals methode miteinander Vergleichen. 
     * @param
     * @return void
     */

    @Test
    public void test_subtract_1_4_from_1_2() {
        Fraction a = new Fraction(new BigInteger("1"), new BigInteger("2"));
        Fraction b = new Fraction(new BigInteger("1"), new BigInteger("4"));
        Fraction expected = new Fraction(new BigInteger("1"), new BigInteger("4"));
        Fraction actual = a.subtract(b);
        Assert.assertEquals("test_subtract_1_4_from_1_2_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_subtract_1_4_from_1_2_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_subtract_20_1_from_10_1() {
        Fraction a = new Fraction(new BigInteger("10"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("20"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("-10"), new BigInteger("1"));
        Fraction actual = a.subtract(b);
        Assert.assertEquals("test_subtract_20_1_from_10_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_subtract_20_1_from_10_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_subtract_0_1_from_5_1() {
        Fraction a = new Fraction(new BigInteger("5"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("0"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("5"), new BigInteger("1"));
        Fraction actual = a.subtract(b);
        Assert.assertEquals("test_subtract_0_1_from_5_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_subtract_0_1_from_5_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_subtract_50000_1_from_100050_1() {
        Fraction a = new Fraction(new BigInteger("100050"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("50000"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("50050"), new BigInteger("1"));
        Fraction actual = a.subtract(b);
        Assert.assertEquals("test_subtract_50000_1_from_100050_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_subtract_50000_1_from_100050_1_nenner", expected.nenner, actual.nenner);
    }

    @Test(expected = ArithmeticException.class)
    public void test_subtract_10_10_from_10_0() {
        Fraction frac = new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(0));
        Fraction frac2 = new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(10));
        frac.subtract(frac2);
    }
    /*Hier wird getestet ob die kgv methode das Kleinste Gemeinsame vielfache von zwei BigInteger korrekt findet indem wir 2 BigInteger
     *  "expected" und "actual" erstellen sie mithilfe der assertEquals methode miteinander Vergleichen. 
     * @param
     * @return void
     */

    @Test
    public void test_kgv_5_10() {
        BigInteger a = new BigInteger("5");
        BigInteger b = new BigInteger("10");
        BigInteger expected = new BigInteger("10");
        BigInteger actual = Fraction.kgv(a, b);
        Assert.assertEquals("test_kgv_5_10", expected, actual);
    }

    @Test
    public void test_kgv_1123871_1238() {
        BigInteger a = new BigInteger("1123871");
        BigInteger b = new BigInteger("1238");
        BigInteger expected = new BigInteger("1391352298");
        BigInteger actual = Fraction.kgv(a, b);
        Assert.assertEquals("test_kgv_1123871_1238", expected, actual);
    }

    @Test
    public void test_kgv_minus5_1() {
        BigInteger a = new BigInteger("-5");
        BigInteger b = new BigInteger("1");
        BigInteger expected = new BigInteger("-5");
        BigInteger actual = Fraction.kgv(a, b);
        Assert.assertEquals("test_kgv_minus5_1", expected, actual);
    }

    @Test
    public void test_kgv_22_7() {
        BigInteger a = new BigInteger("22");
        BigInteger b = new BigInteger("7");
        BigInteger expected = new BigInteger("154");
        BigInteger actual = Fraction.kgv(a, b);
        Assert.assertEquals("test_kgv_22_7", expected, actual);
    }
    
    /*Hier wird getestet ob die Multiply methode zwei Fraction korrekt multipliziert und kürz indem wir 2 Fractions
     *  "expected" und "actual" erstellen und deren Zähler und nenner mithilfe der assertEquals methode miteinander Vergleichen. 
     * @param
     * @return void
     */

    @Test
    public void test_multiply_5_1_with_3_1() {
        Fraction a = new Fraction(new BigInteger("5"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("3"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("15"), new BigInteger("1"));
        Fraction actual = a.multiply(b);
        Assert.assertEquals("test_multiply_5_1_with_3_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_multiply_5_1_with_3_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_multiply_100_1_with_1000_1() {
        Fraction a = new Fraction(new BigInteger("100"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("1000"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("100000"), new BigInteger("1"));
        Fraction actual = a.multiply(b);
        Assert.assertEquals("test_multiply_100_1_with_1000_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_multiply_100_1_with_1000_1_nenner", expected.nenner, actual.nenner);
    }
    @Test
    public void test_multiply_minus5_1_with_10_1() {
        Fraction a = new Fraction(new BigInteger("-5"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("10"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("-50"), new BigInteger("1"));
        Fraction actual = a.multiply(b);
        Assert.assertEquals("test_multiply_minus5_1_with_10_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_multiply_minus5_1_with_10_1_nenner", expected.nenner, actual.nenner);
    }
    @Test
    public void test_multiply_1_2_with_1_5() {
        Fraction a = new Fraction(new BigInteger("1"), new BigInteger("2"));
        Fraction b = new Fraction(new BigInteger("1"), new BigInteger("5"));
        Fraction expected = new Fraction(new BigInteger("1"), new BigInteger("10"));
        Fraction actual = a.multiply(b);
        Assert.assertEquals("test_multiply_1_2_with_1_5_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_multiply_1_2_with_1_5_nenner", expected.nenner, actual.nenner);
    }
    /*Hier wird getestet ob die divide methode zwei Fraction korrekt dividiert und kürz indem wir 2 Fractions
     *  "expected" und "actual" erstellen und deren Zähler und nenner mithilfe der assertEquals methode miteinander Vergleichen. 
     * @param
     * @return void
     */

    @Test
    public void test_divide_10_1_with_5_1() {
        Fraction a = new Fraction(new BigInteger("10"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("5"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("2"), new BigInteger("1"));
        Fraction actual = a.divide(b);
        Assert.assertEquals("test_divide_10_1_with_5_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_divide_10_1_with_5_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_divide_1_1_with_5_1() {
        Fraction a = new Fraction(new BigInteger("1"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("5"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("1"), new BigInteger("5"));
        Fraction actual = a.divide(b);
        Assert.assertEquals("test_divide_1_1_with_5_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_divide_1_1_with_5_1_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_divide_100000_1_with_5000000_1() {
        Fraction a = new Fraction(new BigInteger("100000"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("5000000"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("1"), new BigInteger("50"));
        Fraction actual = a.divide(b);
        Assert.assertEquals("test_divide_100000_1_with_5000000_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_divide_100000_1_with_5000000_nenner", expected.nenner, actual.nenner);
    }

    @Test
    public void test_divide_minus30_1_with_10_1() {
        Fraction a = new Fraction(new BigInteger("-30"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("10"), new BigInteger("1"));
        Fraction expected = new Fraction(new BigInteger("-3"), new BigInteger("1"));
        Fraction actual = a.divide(b);
        Assert.assertEquals("test_divide_minus30_1_with_10_1_zähler", expected.zähler, actual.zähler);
        Assert.assertEquals("test_divide_minus30_1_with_10_1_nenner", expected.nenner, actual.nenner);
    }
    /*Hier wird getestet ob die String methode die Fraction korrekt Darstellt indem wir eine Fraction
     * erstellen und diesen  mithilfe der assertEquals methode mit dem erwarteten String Vergleichen. 
     * @param
     * @return void
     */

    @Test
    public void test_toString_5_1() {
        Fraction a = new Fraction(new BigInteger("5"), new BigInteger("1"));
        String expected = "[5/1]";
        String actual = a.toString();
        Assert.assertEquals("test_toString_5_1", expected, actual);
    }

    @Test
    public void test_toString_minus40_8() {
        Fraction a = new Fraction(new BigInteger("-40"), new BigInteger("8"));
        String expected = "[-5/1]";
        String actual = a.toString();
        Assert.assertEquals("test_toString_minus40_8", expected, actual);
    }

    @Test
    public void test_toString_196895_17() {
        Fraction a = new Fraction(new BigInteger("196895"), new BigInteger("17"));
        String expected = "[196895/17]";
        String actual = a.toString();
        Assert.assertEquals("test_toString_196895_17", expected, actual);
    }

    @Test
    public void test_toString_0_1() {
        Fraction a = new Fraction(new BigInteger("0"), new BigInteger("1"));
        String expected = "[0/1]";
        String actual = a.toString();
        Assert.assertEquals("test_toString_0_1", expected, actual);
    }
    /*Hier wird getestet ob die IsInteger methode einen Fraction erkennt die auch als Integer dargestellt werden kann indem wir eine Fraction
     *  erstellen und sie mithilfe der assertEquals methode mit dem erwarteten Integer Vergleichen. 
     * @param
     * @return void
     */

    @Test
    public void test_isInteger_0_1() {
        Fraction a = new Fraction(new BigInteger("0"), new BigInteger("1"));
        boolean expected = false;
        boolean actual = a.isInteger();
        Assert.assertEquals("test_isInteger_0_1", expected, actual);
    }

    @Test
    public void test_isInteger_minus60_1() {
        Fraction a = new Fraction(new BigInteger("-60"), new BigInteger("1"));
        boolean expected = false;
        boolean actual = a.isInteger();
        Assert.assertEquals("test_isInteger_minus60_1", expected, actual);
    }

    @Test
    public void test_isInteger_3075457_1() {
        Fraction a= new Fraction(new BigInteger("3075457"), new BigInteger("1"));
        boolean expected = true;
        boolean actual = a.isInteger();
        Assert.assertEquals("test_isInteger_3075457_1", expected, actual);
    }

    @Test
    public void test_isInteger_1_4() {
        Fraction a = new Fraction(new BigInteger("1"), new BigInteger("4"));
        boolean expected = false;
        boolean actual = a.isInteger();
        Assert.assertEquals("test_isInteger_1_4", expected, actual);
    }
    /*Hier wird getestet ob die compareTo methode zwei Fractions korrekt auf gleichheit überprüft  indem wir zwei Fraction
     *"expected" und "actual"  erstellen und sie mithilfe der assertEquals methode miteinander Vergleichen. 
     * @param
     * @return void
     */

    @Test
    public void test_compareTo_6_1_and_6_1() {
        Fraction a = new Fraction(new BigInteger("6"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("6"), new BigInteger("1"));
        int expected = 0;
        int actual = a.compareTo(b);
        Assert.assertEquals("test_compareTo_6_1_and_6_1", expected, actual);
    }

    @Test
    public void test_compareTo_minus10_5_and_minus10_5() {
        Fraction a = new Fraction(new BigInteger("-10"), new BigInteger("5"));
        Fraction b = new Fraction(new BigInteger("-10"), new BigInteger("5"));
        int expected = 0;
        int actual = a.compareTo(b);
        Assert.assertEquals("test_compareTo_minus10_5_and_minus10_5", expected, actual);
    }

    @Test
    public void test_compareTo_1_123456_and_1_123456() {
        Fraction a = new Fraction(new BigInteger("1"), new BigInteger("123456"));
        Fraction b = new Fraction(new BigInteger("1"), new BigInteger("123456"));
        int expected = 0;
        int actual = a.compareTo(b);
        Assert.assertEquals("test_compareTo_minus10_5_and_minus10_5", expected, actual);
    }

    @Test
    public void test_compareTo_0_1_and_0_1() {
        Fraction a = new Fraction(new BigInteger("0"), new BigInteger("1"));
        Fraction b = new Fraction(new BigInteger("0"), new BigInteger("1"));
        int expected = 0;
        int actual = a.compareTo(b);
        Assert.assertEquals("test_compareTo_0_1_and_0_1", expected, actual);
    }
    /*Hier wird getestet ob die doubleValue methode eine Fraction korrekt in eine double Zahl umwandelt indem wir eine Fraction
     *  erstellen und sie mithilfe der assertEquals methode mit der erwarteten Zahl Vergleichen. 
     * @param
     * @return void
     */


    @Test
    public void test_doubleValue_1_2() {
        Fraction a = new Fraction(new BigInteger("1"), new BigInteger("2"));
        double expectedD = 0.5;
        double actualD = a.doubleValue();
        String expected = "" + expectedD;
        String actual = "" + actualD;
        Assert.assertEquals("test_doubleValue_1_2", expected, actual);
    }

    @Test
    public void test_doubleValue_0_1() {
        Fraction a = new Fraction(new BigInteger("0"), new BigInteger("1"));
        double expectedD = 0;
        double actualD = a.doubleValue();
        String expected = "" + expectedD;
        String actual = "" + actualD;
        Assert.assertEquals("test_doubleValue_0_1", expected, actual);
    }

    @Test
    public void test_doubleValue_minus40_1() {
        Fraction a = new Fraction(new BigInteger("-40"), new BigInteger("1"));
        double expectedD = -40;
        double actualD = a.doubleValue();
        String expected = "" + expectedD;
        String actual = "" + actualD;
        Assert.assertEquals("test_doubleValue_minus40_1", expected, actual);
    }

    @Test
    public void test_doubleValue_4567_1() {
        Fraction a = new Fraction(new BigInteger("4567"), new BigInteger("1"));
        double expectedD = 4567;
        double actualD = a.doubleValue();
        String expected = "" + expectedD;
        String actual = "" + actualD;
        Assert.assertEquals("test_doubleValue_4567_1", expected, actual);
    }
    /*Hier wird getestet ob die floatValue methode eine Fraction korrekt in eine float Zahl umwandelt indem wir eine Fraction
     *  erstellen und sie mithilfe der assertEquals methode mit der erwarteten Zahl Vergleichen. 
     * @param
     * @return void
     */

    @Test
    public void test_floatValue_5_1() {
        Fraction a = new Fraction(new BigInteger("5"), new BigInteger("1"));
        float expectedF = 5;
        float actualF = a.floatValue();
        String expected = "" + expectedF;
        String actual = "" + actualF;
        Assert.assertEquals("test_floatValue_5_1", expected, actual);
    }

    @Test
    public void test_floatValue_0_1() {
        Fraction a = new Fraction(new BigInteger("0"), new BigInteger("1"));
        float expectedF = 0;
        float actualF = a.floatValue();
        String expected = "" + expectedF;
        String actual = "" + actualF;
        Assert.assertEquals("test_floatValue_0_1", expected, actual);
    }

    @Test
    public void test_floatValue_minus40_1() {
        Fraction a = new Fraction(new BigInteger("-40"), new BigInteger("1"));
        float expectedF = -40;
        float actualF = a.floatValue();
        String expected = "" + expectedF;
        String actual = "" + actualF;
        Assert.assertEquals("test_floatValue_minus40_1", expected, actual);
    }

    @Test
    public void test_floatValue_4567_1() {
        Fraction a = new Fraction(new BigInteger("4567"), new BigInteger("1"));
        float expectedF = 4567;
        float actualF = a.floatValue();
        String expected = "" + expectedF;
        String actual = "" + actualF;
        Assert.assertEquals("test_floatValue_4567_1", expected, actual);
    }

    /*Hier wird getestet ob die intValue methode eine Fraction korrekt in eine Integer Zahl umwandelt indem wir eine Fraction
     *  erstellen und sie mithilfe der assertEquals methode mit der erwarteten Zahl Vergleichen. 
     * @param
     * @return void
     */
    @Test
    public void test_intValue_3_1() {
        Fraction a = new Fraction(new BigInteger("3"), new BigInteger("1"));
        int expected = 3;
        int actual = a.intValue();
        Assert.assertEquals("test_intValue_3_1", expected, actual);
    }

    @Test
    public void test_intValue_50_2() {
        Fraction a = new Fraction(new BigInteger("50"), new BigInteger("2"));
        int expected = 25;
        int actual = a.intValue();
        Assert.assertEquals("test_intValue_50_2", expected, actual);
    }

    @Test
    public void test_intValue_0_1() {
        Fraction a = new Fraction(new BigInteger("0"), new BigInteger("1"));
        int expected = 0;
        int actual = a.intValue();
        Assert.assertEquals("test_intValue_0_1", expected, actual);
    }

    @Test
    public void test_intValue_minus30_1() {
        Fraction a = new Fraction(new BigInteger("-30"), new BigInteger("1"));
        int expected = -30;
        int actual = a.intValue();
        Assert.assertEquals("test_intValue_minus30_1", expected, actual);
    }

    /*Hier wird getestet ob die longValue methode eine Fraction korrekt in eine Long Zahl umwandelt indem wir eine Fraction
     *  erstellen und sie mithilfe der assertEquals methode mit der erwarteten Zahl Vergleichen. 
     * @param
     * @return void
     */
    @Test
    public void test_longValue_0_1() {
        Fraction a = new Fraction(new BigInteger("0"), new BigInteger("1"));
        long expected = 0;
        long actual = a.longValue();
        Assert.assertEquals("test_longValue_0_1", expected, actual);
    }

    @Test
    public void test_longValue_minus50_1() {
        Fraction a = new Fraction(new BigInteger("-50"), new BigInteger("1"));
        long expected = -50;
        long actual = a.longValue();
        Assert.assertEquals("test_longValue_minus50_1", expected, actual);
    }

    @Test
    public void test_longValue_10_2() {
        Fraction a = new Fraction(new BigInteger("10"), new BigInteger("2"));
        long expected = 5;
        long actual = a.longValue();
        Assert.assertEquals("test_longValue_10_2", expected, actual);
    }

    @Test
    public void test_longValue_12345_1() {
        Fraction a = new Fraction(new BigInteger("12345"), new BigInteger("1"));
        long expected = 12345;
        long actual = a.longValue();
        Assert.assertEquals("test_longValue_12345_1", expected, actual);;
    }

}