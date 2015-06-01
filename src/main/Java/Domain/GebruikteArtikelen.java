/*
 * Gemaakt door: Tristan en Roger
 */




package Domain;

import java.io.Serializable;

public class GebruikteArtikelen implements Serializable{
	private int aantal;
	private Artikel hetArtikel;
        private int GebruikteArtikelID;
        private static int doorteller;
	
	public GebruikteArtikelen(int a, Artikel hA){
		doorteller++;
                GebruikteArtikelID = doorteller;
                aantal = a;
		hetArtikel = hA;
                
	}
        
        public String getArtikelID(){ return hetArtikel.getCode(); }
        
        public int getGebruikteArtikelID(){
            return GebruikteArtikelID;
        }
        
	public Artikel getHetArtikel(){
		return hetArtikel;
	}
	
	public int getAantal(){
		return aantal;
	}
	
	public String toString(){
		return "" + hetArtikel.getCode() + " : " +aantal;
	}
}
