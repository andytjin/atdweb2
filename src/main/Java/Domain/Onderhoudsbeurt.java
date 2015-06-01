/*
 * Gemaakt door: Tristan en Roger
 */




package Domain;
import java.io.Serializable;
import java.util.ArrayList;

public class Onderhoudsbeurt extends Dienst implements Serializable{

	private int aantalBestedeUur;
	private Auto deAuto;
        private String kenteken = deAuto.getKenteken();
	private Monteur deMonteur;
	private ArrayList<GebruikteArtikelen> deArtikelen = new ArrayList<GebruikteArtikelen>();
	
	public Onderhoudsbeurt(int dN, String Dat, Auto auto, Monteur dM){
		super(dN,Dat);
		deAuto = auto;
		deMonteur = dM;
		aantalBestedeUur = 0;
	}
        public Onderhoudsbeurt(int dN, String Dat, String ken){
            super(dN,Dat);
            kenteken = ken;
            aantalBestedeUur = 0;
        }
	
	public void berekenPrijs() {
		double p = 0.0;
		p = aantalBestedeUur * 50.0;
		for(GebruikteArtikelen ga : deArtikelen){
			p += ga.getHetArtikel().getPrijs() * ga.getAantal();
		}
		System.out.println("Roger is dik");
		super.setNettoPrijs(p);
	}
	
	public void voegArtikelToe(Artikel a, int n){
		deArtikelen.add(new GebruikteArtikelen(n, a));
	}
	
	public ArrayList<GebruikteArtikelen> getGebruikteArtikelen(){
		return deArtikelen;
	}
	
	public void setAantalBestedeUur(int u){
		aantalBestedeUur = u;
	}
	
	public int getAantalBestedeUur(){
		return aantalBestedeUur;
	}
	
	public boolean equalsDienst(Object andere){
		boolean b = false;
		if(andere instanceof Onderhoudsbeurt){
			b = true;
		}
		return b;
	}
	
	public String getNaam() {
		return deMonteur.getNaam();
	}
	
	public void setDeMonteur(Monteur m){
		deMonteur = m;
	}

	public Onderhoudsbeurt getOnderhoudsbeurt() {
		return this;
	}
        
        public String getKenteken(){
            return kenteken;
        }
}
