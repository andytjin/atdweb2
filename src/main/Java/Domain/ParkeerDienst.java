package Domain;

import java.io.Serializable;

public class ParkeerDienst extends Dienst implements Serializable{

	private int aantalUur;
	private ParkeerPlaats deParkeerPlaats;

	public ParkeerDienst(int dN, String dat,int n){
		super(dN,dat);
		aantalUur = n;
	}
	public void setAantalUur(int aU){
		 aantalUur = aU;
	}
	public void berekenPrijs(){
		double p = 0.0;
		p = aantalUur * 5.0;	
		super.setNettoPrijs(p);
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