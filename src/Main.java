import controller.SystemController;
import enums.Disciplin;
import model.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    public void run() throws FileNotFoundException {
        Filhåndtering f1 = new Filhåndtering();
        ArrayList<Medlem> medlemsliste = ArraylistMedlemmer();
        f1.saveMedlemsliste(medlemsliste);

        ArrayList<Medlem> loadedMedlemsliste = f1.loadMedlemsliste();
        System.out.println(loadedMedlemsliste.get(0));
        System.out.println(loadedMedlemsliste.get(1));
        System.out.println(loadedMedlemsliste.get(2));
        System.out.println(loadedMedlemsliste.get(3));

      System.out.println();

      ArrayList<Ansat> ansatListe = ArraylistAnsatte();
      //ArrayList<Ansat> ansatListe = new ArrayList<>();
      f1.saveAnsatLoginListe(ansatListe);

      ArrayList<Ansat> loadedAnsatListe = f1.loadAnsatLoginListe();
      System.out.println(loadedAnsatListe.get(0));
      System.out.println(loadedAnsatListe.get(1));
      System.out.println(loadedAnsatListe.get(2));
      f1.saveAnsatLoginListe(loadedAnsatListe);
    }
     public ArrayList<Medlem> ArraylistMedlemmer() {
        ArrayList<Medlem> medlemsliste = new ArrayList<>();
         Medlem m1 = new Medlem("Hans", LocalDate.parse("2014-10-01"), true, 0);
         Medlem m2 = new Medlem( "Lars", LocalDate.parse("1995-09-09"), false, 0);
         Medlem m3 = new Medlem( "Norman", LocalDate.parse("2009-03-25"), false, 0);
         Medlem m4 = new Medlem( "Helle", LocalDate.parse("1993-04-15"), true, 0);
         Svømmedisciplin s1 = new Svømmedisciplin(true, Disciplin.BUTTERFLY, 100.25,LocalDate.parse("2007-12-03"));
         Svømmedisciplin s2 = new Svømmedisciplin(false, Disciplin.CRAWL, 2.25,LocalDate.parse("2005-03-07"));
         Svømmedisciplin s3 = new Svømmedisciplin(true, Disciplin.RYGCRAWL, 0, null);
         Svømmedisciplin s4 = new Svømmedisciplin(false, Disciplin.BRYSTSVØMNING, 152.00,LocalDate.parse("2010-07-15"));
         ArrayList<Svømmedisciplin> svømmedisciplins = new ArrayList<>();
         svømmedisciplins.addAll(Arrays.asList(s1, s2, s3, s4));
         Medlem m5 = new KonkurrenceSvømmer(m4, 1, svømmedisciplins);
         medlemsliste.addAll(Arrays.asList(m1, m2, m3, m5));
         return medlemsliste;
     }

     public ArrayList<Ansat> ArraylistAnsatte() {
        ArrayList<Ansat> ansatListe = new ArrayList<>();
        Ansat a1 = new Formand("Lars", "Lars");
        Ansat a2 = new Kasserer("Børge", "Børge");
        Ansat a3 = new Træner("Torben", "Torben");
        ansatListe.addAll(Arrays.asList(a1, a2, a3));
        return ansatListe;
     }

}
