package Domain;

import java.io.Serializable;

public class GebruikteArtikelen implements Serializable{
	private int aantal;
	private Artikel hetArtikel;
        private int gebruikteArtikelId;
        private static int doorteller = 0;
	private int onderhoudsBeurtId;
        
	public GebruikteArtikelen(int a, Artikel hA){
                aantal = a;
		hetArtikel = hA;
                
	}
        
        public int getOnderhoudsBeurtId(){
            return onderhoudsBeurtId;
        }
        
        public void setOnderhoudsBeurtId(int id){
            onderhoudsBeurtId = id;
        }
        
        public void setGebruikteArtikelId(int id){
            gebruikteArtikelId = id;
        }
        
        public String getArtikelID(){ return hetArtikel.getCode(); }
        
        public int getGebruikteArtikelId(){
            return gebruikteArtikelId;
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
