package Domain;

import java.io.Serializable;

public class Auto implements Serializable {

    private String kenteken;
    private String naam;
    private String merk;
    private Klant deEigenaar;

    public Auto(String ken, String nm, String mk, Klant dE) {
        kenteken = ken;
        naam = nm;
        merk = mk;
        deEigenaar = dE;
    }

    public String getNaam() {
        return naam;
    }

    public String getMerk() {
        return merk;
    }

    public Klant getKlant() {
        return deEigenaar;
    }
    
    public String getKenteken(){
        return kenteken;
    }

    public String getDeEigenaarsNaam() {
        return deEigenaar.getNaam();
    }
    
    public String getDeEigenaarUName(){
        return deEigenaar.getUsername();
    }
    public String toString(){
        return merk;
    }
}
