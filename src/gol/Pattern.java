package gol;
public class Pattern {

    private String   name;
    private String[] pattern;

    /**
     * class to handle patterns
     */

    public String getName() {
        return name;
    }

    void setName(String nazwa) {
        this.name = nazwa;
    }

    public String[] getPattern() {
        return pattern;
    }

    public void setPattern(String[] wzorzec) {
        this.pattern = wzorzec;
    }

    public Pattern(String nazwa, String[] wzorzec) {
        this.name = nazwa;
        this.pattern = wzorzec;
    }

    public String toString() {
        return name;
    }

    //loads the example Pattern
    public static Pattern[] setPattern() {
        Pattern[] pattern = new Pattern[3];
        pattern[0] = new Pattern("Worm", new String[]{"0#0", "0##", "#0#"});
        pattern[1] = new Pattern("Glider Gun", new String [] {"000000000000000000000000#0000000000",
                "0000000000000000000000#0#0000000000", "000000000000##000000##000000000000##",
                "00000000000#000#0000##000000000000##", "##00000000#00000#000##000000000000000",
                "##00000000#000#0##0000#0#0000000000", "0000000000#00000#0000000#000000000000", 
                "00000000000#000#0000000000000000000", "000000000000##0000000000000000000000"});
        pattern[2] = new Pattern("Spaceship", new String [] {"#####0000000000000",
                "#0000#0000000##000", "#00000000000##0###", "0#000000000##0####",
                "000##000##0##00##0", "00000#0000#00#0000", "000000#0#0#0#00000",
                "0000000#0000000000", "0000000#0000000000", "000000#0#0#0#00000",
                "00000#0000#00#0000", "000##000##0##00##0", "0#000000000##0####",
                "#00000000000##0###", "#0000#0000000##000", "#####0000000000000"});
        return pattern;
    }
}