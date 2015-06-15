package Domain;

import java.io.Serializable;
import java.util.Calendar;

public class TankDienst extends Dienst implements Serializable{

    private GebruikteArtikelen hetBrandstofType;

    public TankDienst(int dN, Calendar Dat, Artikel bs, int i) {
        super(dN, Dat);
        hetBrandstofType = new GebruikteArtikelen(i, bs);
    }
    @Override
    public double prijs() {
        double p = 0.0;
        p = hetBrandstofType.getAantal() * hetBrandstofType.getHetArtikel().getPrijs();
        return p;
    }

    public int getAantalLiter() {
        return hetBrandstofType.getAantal();
    }

    public boolean equalsDienst(Object andere) {
        boolean b = false;
        if (andere instanceof TankDienst) {
            b = true;
        }
        return false;
    }

    public String getNaam() {
        return "Geen monteur";
    }

    public Onderhoudsbeurt getOnderhoudsbeurt() {
        return null;
    }

    public void setDeBrandstof(int n, Artikel bs) {
        hetBrandstofType = new GebruikteArtikelen(n, bs);
    }

    public String getDeBrandstof() {
        return hetBrandstofType.getHetArtikel().getCode();
    }
}
