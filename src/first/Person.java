package first;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import second.MyIO;


public class Person implements Comparable <Person>,Cloneable, SimpleTreeNode{
    private String defaultVorname;
    private String defaultName;
    private String defaultBeruf;
    private int defaultGeburtsjahr;
    private float defaultKörpergröße;
    private String defaultGeburtsort;
    private int Alter;
    private ArrayList<String> children = new ArrayList <String>() ;

    public Person () {
        defaultVorname = MyIO.promptAndRead("Vorname:");
        defaultName = MyIO.promptAndRead("Name: ");
        defaultBeruf = MyIO.promptAndRead("Beruf: ");
        defaultGeburtsjahr = MyIO.readInt("Geburtsjahr: ");
        defaultKörpergröße = MyIO.readFloat("Körpergröße in Metern: ");
        defaultGeburtsort = MyIO.promptAndRead("Geburtsort: ");
        Alter = new GregorianCalendar().get(Calendar.YEAR);
        Alter = Alter - defaultGeburtsjahr;
        ArrayList<String> children = new ArrayList<String>();
    }

    public Person (String Vorname, String Name, String Beruf, int Geburtsjahr, float Körpergröße, String Geburtsort) {
        defaultVorname = Vorname;
        defaultName = Name;
        defaultBeruf = Beruf;
        defaultGeburtsjahr = Geburtsjahr;
        defaultKörpergröße = Körpergröße;
        defaultGeburtsort = Geburtsort;
        Alter = new GregorianCalendar().get(Calendar.YEAR);
        Alter = Alter - defaultGeburtsjahr;
        ArrayList<String> children = new ArrayList<String>();
    }
    
    public Person (Person n) {
        defaultVorname = n.defaultVorname;
        defaultName = n.defaultName;
        defaultBeruf = n.defaultBeruf;
        defaultGeburtsjahr = n.defaultGeburtsjahr;
        defaultKörpergröße = n.defaultKörpergröße;
        defaultGeburtsort = n.defaultGeburtsort;
        Alter = new GregorianCalendar().get(Calendar.YEAR);
        this.Alter = Alter - defaultGeburtsjahr;
       
    }

    public String Rechner(float defaultKörpergröße){
        String Hinweis;
        if (defaultKörpergröße < 1.52f){
            Hinweis = "klein";
        } else if (defaultKörpergröße > 1.57f){
            Hinweis = "groß";
        } else {
            Hinweis = "mittel";
        }
        return Hinweis;
    }

    public String toString() {
        int Alter;
        Alter = new GregorianCalendar().get(Calendar.YEAR);
        Alter = Alter - defaultGeburtsjahr;
        return "Person [Vorname="+defaultVorname+",Name="+defaultName
                +",Beruf="+defaultBeruf+",Geburtsjahr="+defaultGeburtsjahr
                +",Körpergröße="+defaultKörpergröße+"m("+Rechner(defaultKörpergröße)+"),Geburtsort="+defaultGeburtsort
                +",Alter="+Alter+ "  Kinder: " + children + "]";
    }

    public void compareWith (Person person) {

        float x = defaultKörpergröße - person.defaultKörpergröße;
        int y = Alter - person.Alter;

        String Ausgabe = "";
        if (defaultKörpergröße > person.defaultKörpergröße)
        {
            Ausgabe = Ausgabe + defaultVorname + " ist "+Math.abs(x)+" m größer als " + person.defaultVorname;
        }
        else if (defaultKörpergröße == person.defaultKörpergröße){
            Ausgabe = Ausgabe + defaultVorname + " ist gleich Groß wie " + person.defaultVorname;
        }
        else {
            Ausgabe = Ausgabe + defaultVorname + " ist "+Math.abs(x)+" m kleiner als " + person.defaultVorname;

        }
        Ausgabe = Ausgabe + " und ";
        if (Alter > person.Alter)
        {
            Ausgabe = Ausgabe + defaultVorname + " ist "+Math.abs(y)+" Jahre älter als " + person.defaultVorname;
        }
        else if (Alter == person.Alter){
            Ausgabe = Ausgabe + defaultVorname + " ist gleich Alt wie " + person.defaultVorname;
        }
        else {
            Ausgabe = Ausgabe + defaultVorname + " ist "+Math.abs(y)+" Jahre jünger als " + person.defaultVorname;

        }
        System.out.println(Ausgabe);
    }

    public static void main (String[] args) {
        Person a, b;
              //  a = new Person ();
                b = new Person ("Jens","Schilling","Gärtner",1980,1.82f,"Heilbronn");
                Person [] c = {new Person("Lisa", "Müller", "Informatikern", 1992, 1.73f, "Kaiserslautern")
                               , new Person("Pascal", "Brostean", "Student", 2000, 1.83f, "Neustadt")};
               // System.out.println(a);
                System.out.println(b);
                for (Person f : c){
                    System.out.println(f);
                }
               // a.compareWith(b);
                Person d = b.clone(b);
                d.defaultVorname = "Pascal" ;
              // System.out.println(b.compareTo(d));
               
               d.addChild("Hansi");
               d.addChild("Steve");
               d.addChild("Karon");
               
                System.out.println(d);
               
    }

	@Override
	public int compareTo(Person name) {
		int z = 0;
		int vergname = name.defaultVorname.toString().length() + name.defaultName.toString().length();
		int namen1 =  this.defaultVorname.toString().length() + this.defaultName.toString().length();
		if ( vergname > namen1) {z =  1;}
		if ( vergname < namen1) {z = -1;}
		if (vergname == namen1 ) {z = 0;}
		
		return z;
	}
	public Person clone(Person z) {
	
		Person n = new Person(z);
		
		return n;
		
		
	}

	@Override
	public void addChild(String child) {
		this.children.add(child);
	}

	@Override
	public int getChildCnt() {
		
		return children.size();
	}

	@Override
	public Object getChild(int pos) {
		
		return children.get(pos);
	}
}