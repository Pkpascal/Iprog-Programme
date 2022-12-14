package first.a;

public enum Monat {
    Januar(1), Februar(2), Maerz(3),
    April(4), Mai(5), Juni(6), Juli(7),
    August(8), September(9), Oktober(10),
    November(11), Dezember(12);


    private final int number;

    Monat(int number) {
        this.number = number;
    }

    public int getNumber(Monat m) {
        return number;
    }

    public static void main(String[] args) {
        Liste1();
        Liste2();
    }

    public static void Liste1() {
        System.out.println("Die Liste aller Monate in denen ein 'e' vorkommt und deren Nummer ungerade ist: ");
        for (Monat m : Monat.values()) {
            if (m.toString().contains("e")) {
                int x = m.getNumber(m);
                if (x % 2 != 0) {
                    System.out.print(m + " ");
                }
            }
        }
    }

    public static void Liste2() {
        System.out.println("\nDie Liste aller Monate in denen ein 'u' vorkommt und deren Nummer gerade ist: ");
        for (Monat m : Monat.values()) {
            if (m.toString().contains("u")) {
                int x = m.getNumber(m);
                if (x % 2 == 0) {
                    System.out.print(m + " ");
                }
            }
        }
    }
}
