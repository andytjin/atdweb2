package Domain;

import java.io.Serializable;
import java.util.Calendar;

public abstract class Dienst implements Serializable{

	private int dienstNummer;
	private Calendar datum;
	//private double nettoPrijs;
	private Factuur deFactuur;
 
	public Dienst(int dN, Calendar dat){
		dienstNummer = dN;
		datum = dat;
	}
	
	public void setDeBetaling(Factuur f){
		deFactuur = f;
	}
	
	public Factuur getDeBetaling(){
		return deFactuur;
	}
	
	public String getKlantNaam(){
		return deFactuur.getKlantNaam();
	}
	
	public abstract double prijs();
	
	public abstract boolean equalsDienst(Object andere);
	
	public int getDienstNummer(){
		return dienstNummer;
	}
	
	public Calendar getDatum(){
		return datum;
	}
	
	public abstract String getNaam();
}
