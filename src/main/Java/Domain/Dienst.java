package Domain;

import java.io.Serializable;
import java.util.Calendar;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class Dienst implements Serializable{

	private int dienstNummer;
	private Calendar datum;
	//private double nettoPrijs;
	private Factuur deFactuur;
        private String calendarNaarString;
 
	public Dienst(int dN, Calendar dat){
		dienstNummer = dN;
		datum = dat;
	}
	
        public String getCalendarNaarString(){
            
            Calendar cal = datum;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            calendarNaarString = sdf.format(cal.getTime());
            
            return calendarNaarString;
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
        
        public java.sql.Date getSQLdatum(){
            return new Date(getDatum().getTimeInMillis());
        }
	
	public abstract String getNaam();
}
