package Domain;

import java.io.Serializable;
import java.util.*;

public class Bedrijf implements Serializable {

    private String naam;
    private ArrayList<Klant> alleKlanten = new ArrayList<Klant>();
    private ArrayList<Factuur> alleFacturen = new ArrayList<Factuur>();
    private ArrayList<Dienst> alleDiensten = new ArrayList<Dienst>();
    private ParkeerPlaats deParkeerPlaats;
    private ArrayList<Artikel> alleArtikelen = new ArrayList<Artikel>();
    private ArrayList<Monteur> alleMonteurs = new ArrayList<Monteur>();
    private ArrayList<Auto> alleAutos = new ArrayList<Auto>();

    public Bedrijf() {
        naam = "ATD Systeem";
    }
    public void voegAutoToe(Auto a){
        alleAutos.add(a);
    }
    public void voegKlantToe(Klant nweKlant) {
        if (!heeftKlant(nweKlant.getUsername())) {
            alleKlanten.add(nweKlant);
            System.out.println("toegevoegd");
        }
    }

    public void voegMonteurToe(Monteur m) {
        if(!heeftMonteur(m.getID())){
            alleMonteurs.add(m);
            System.out.println("toegevoegd");
        }
    }

    public boolean heeftMonteur(int id2) {
        boolean b = false;
        for (Monteur m : alleMonteurs) {
            if (m.getID() == id2) {
                b = true;
            }
        }
        return b;
    }

    public boolean heeftKlant(String kN) {
        boolean b = false;
        for (Klant k : alleKlanten) {
            if (k.getUsername().equals(kN)) {
                b = true;
            }
        }
        return b;
    }

    public Klant getKlant(String uN) {
        Klant gezocht = null;
        for (Klant k : alleKlanten) {
            if (k.getUsername().equals(uN)) {
                gezocht = k;
            }
        }
        return gezocht;
    }

    public void verwijderKlant(Klant exKlant) {
        if (heeftKlant(exKlant.getNaam())) {
            alleKlanten.remove(exKlant);
        }
    }

    public void voegDienstToe(Dienst d) {
        alleDiensten.add(d);
    }

    public void voegFactuurToe(Factuur f) {
        alleFacturen.add(f);
    }

    public int aantalKlanten() {
        return alleKlanten.size();
    }

    public ArrayList<Klant> getAlleKlanten() {
        return alleKlanten;
    }

    public ArrayList<Artikel> getAlleArtikelen() {
        return alleArtikelen;
    }

    public ArrayList<Factuur> getAlleFacturen() {
        return alleFacturen;
    }

    public ArrayList<Dienst> getAlleDiensten() {
        return alleDiensten;
    }

    public ArrayList<Monteur> getAlleMonteurs() {
        return alleMonteurs;
    }

    public ArrayList<Auto> getAlleAutos() {
        return alleAutos;
    }

    public String toString() {
        String s = "Bedrijf " + naam + " heeft "
                + aantalKlanten() + " klanten\n";
        for (Klant k : alleKlanten) {
            s += k + "\n";
        }
        return s;
    }

}
