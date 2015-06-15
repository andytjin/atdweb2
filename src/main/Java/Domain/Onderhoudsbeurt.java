package Domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Onderhoudsbeurt extends Dienst implements Serializable{
        
	private int aantalBestedeUur;
	private Auto deAuto;
	private Monteur deMonteur;
	private ArrayList<GebruikteArtikelen> deArtikelen = new ArrayList<GebruikteArtikelen>();
        
	public Onderhoudsbeurt(int dN, Calendar Dat, Auto dA, Monteur dM){
		super(dN,Dat);
		deAuto = dA;
		deMonteur = dM;
		aantalBestedeUur = 0;
	}
	@Override
	public double prijs() {
		double p = 0.0;
		p = aantalBestedeUur * 50.0;
		for(GebruikteArtikelen ga : deArtikelen){
			p += ga.getHetArtikel().getPrijs() * ga.getAantal();
                }
		return p;
	}
	
        public String getKenteken(){
            return deAuto.getKenteken();
        }
        
        public int getMonteurID(){
            return deMonteur.getID();
        }
        
	public void voegArtikelToe(Artikel a, int n, int id){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
}







