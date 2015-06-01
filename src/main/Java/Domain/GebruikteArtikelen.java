/*
 * Gemaakt door: Tristan en Roger
 */




package Domain;

import java.io.Serializable;

public class GebruikteArtikelen implements Serializable{
	private int aantal;
	private Artikel hetArtikel;
	
	public GebruikteArtikelen(int a, Artikel hA){
		aantal = a;
		hetArtikel = hA;
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
