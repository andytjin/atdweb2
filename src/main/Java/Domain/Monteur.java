/*
 * Gemaakt door: Tristan en Roger
 */

package Domain;

import java.io.Serializable;

public class Monteur implements Serializable{

	private int ID;
	private String naam;
	private String wachtwoord;
        
	public Monteur(String nm,int id){
		naam = nm;
		ID = id;
	}
	
        public int getID(){
            return ID;
        }
        
        public boolean checkPassword(String s){
            boolean b = false;
            if(wachtwoord.equals(s)){
                b = true;
            }
            return b;
        }
	public String getNaam(){
		return naam;
	}
}