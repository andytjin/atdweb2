/*
 * Gemaakt door: Tristan en Roger
 */

package Domain;

import java.io.Serializable;

public class Monteur implements Serializable{

	private int ID;
	private String naam;
	
	public Monteur(String nm,int id){
		naam = nm;
		ID = id;
	}
	
        public int getID(){
            return ID;
        }
        
	public String getNaam(){
		return naam;
	}
}