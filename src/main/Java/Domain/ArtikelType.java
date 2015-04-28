/*
 * Gemaakt door: Tristan en Roger
 */




package Domain;

import java.io.Serializable;

public class ArtikelType implements Serializable{
	private String type;
	
	public ArtikelType(String t){
		type = t;
	}
	
	public String getType() { return type; }

}