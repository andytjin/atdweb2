package Domain;

import java.io.Serializable;
import java.util.Calendar;

public class ParkeerDienst extends Dienst implements Serializable{

	private int aantalUur;
	private ParkeerPlaats deParkeerPlaats;
        private double basisTarief = 10;
        
	public ParkeerDienst(int dN, Calendar dat,int n){
		super(dN,dat);
		aantalUur = n;
	}
        
	public void setAantalUur(int aU){
		 aantalUur = aU;
	}
        
        @Override
	public double prijs(){
		double p = 0.0;
		p = aantalUur * 5.0;	
		return p + basisTarief;
	}
        
	public boolean equalsDienst(Object andere){
		boolean b = false;
		if(andere instanceof ParkeerDienst){
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
	public int getAantalUur() {
		return aantalUur;
	}
}