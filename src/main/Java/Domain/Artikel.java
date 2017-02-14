package Domain;

import java.io.Serializable;

public class Artikel implements Serializable{

	private String code;
	private ArtikelType type;
	private int aantal,minimum;
	private double prijs;
        
	public Artikel(String code, int minimum, int aantal, double prijs, ArtikelType type){
		this.code = code;
		this.minimum = minimum;
		this.aantal = aantal;
		this.prijs = prijs;
		this.type = type;
	}
	public void setAantal(int al){
		aantal = al;
	}
	public String getCode(){ return code; }
	public String getType(){ return type.getType(); }
	public int getAantal() { return aantal;}
	public int getMinimum() { return minimum; }
	public double getPrijs() { return prijs; }
	
        public ArtikelType getHetType(){
            return type;
        }
        
        
	public String toString(){
		//Hier wordt gekeken of er wel of niet besteld moet worden. Dan wordt dit in een String gezet, deze String wordt vervolgens gereturned.
		String s = "Van type: " + type.getType() + ", ";
		int a = minimum - aantal;
		if(a > 0){
			s += "moeten er " + a + " besteld worden";
		}
		else{
			s = "";
		}
		return s;
	}
}