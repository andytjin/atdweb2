package Domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Factuur implements Serializable {

    private int factuurNummer;
    private double brutoPrijs;
    private boolean isBetaald;
    private String omschrijving, factuurDatum, vervalDatum;
    private Klant betalendeKlant;

    public Factuur(int fN, String fD,String vD,double bp, boolean iB, String oS, Klant k) {
        factuurNummer = fN;
        brutoPrijs = bp;
        factuurDatum = fD;
        vervalDatum = vD;
        omschrijving = oS;
        isBetaald = iB;
        betalendeKlant = k;
    }

    public boolean checkFactuur(String vD) {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate vervalDate = LocalDate.parse(vD, formatter);

        if (currentDate.compareTo(vervalDate) > 0) {
            //Te laat
            return true;
        }
        return false;
    }

    public String toString() {
        String s = "De Klant: " + betalendeKlant.getNaam() + ", heeft";
        if (isBetaald) {
            s += "wel betaald en is succesvol afgerond";
        } else {
            s = " niet betaald en zal nog" + brutoPrijs + " euro moeten betalen";
        }
        return s;
    }

    public void setIsBetaald(boolean b) {
        isBetaald = b;
    }
    public String isBetaald() {
        String s = "";
        if (isBetaald == true) {
            s = "Ja";
        } else {
            s = "Nee";
        }
        return s;
    }

    public boolean getIsBetaald() {
        return isBetaald;
    }

    public int getFactuurNummer() {
        return factuurNummer;
    }

    public String getKlantNaam() {
        return betalendeKlant.getNaam();
    }

    public void setFactuurNummer(int fN) {
        factuurNummer = fN;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String oS) {
        omschrijving = oS;
    }

    public String getFactuurDatum() {
        return factuurDatum;
    }

    public void setFactuurDatum(String fD) {
        factuurDatum = fD;
    }

    public String getVervalDatum() {
        return vervalDatum;
    }

    public void setVervalDatum(String vD) {
        vervalDatum = vD;
    }

    public double getBrutoPrijs() {
        return brutoPrijs;
    }

    public void setBrutoPrijs(double bP) {
        brutoPrijs = bP;
    }
}
