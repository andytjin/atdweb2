package Domain;

import Security.Encrypter;
import java.io.Serializable;

public class Klant implements Serializable{

    private boolean WiltHerinnering;
    private String username, naam, password, adres, geboortedatum, telefoonnummer, postcode, emailadres;

    public Klant(String nm, String ad, String gd, String tel, String pc, String email, boolean wh) {
        naam = nm;
        adres = ad;
        geboortedatum = gd;
        telefoonnummer = tel;
        postcode = pc;
        emailadres = email;
        WiltHerinnering = wh;

    }

    public Klant(String uName, String nm, String pass, String ad, String gd, String tel, String pc, String email, boolean wh) {
        username = uName;
        naam = nm;
        password = pass;
        adres = ad;
        geboortedatum = gd;
        telefoonnummer = tel;
        postcode = pc;
        emailadres = email;
        WiltHerinnering = wh;

    }

    public boolean checkPassword(String pw) {
        String encrypt = Encrypter.md5Hash(pw);
        boolean b = false;
        if (password != null) {
            if (password.equals(encrypt)) {
                b = true;
            }
        }
        return b;
    }

    public void setPassword(String ps){
        password = ps;
    }
    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String email) {
        emailadres = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String pc) {
        postcode = pc;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String tel) {
        telefoonnummer = tel;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String gd) {
        geboortedatum = gd;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String ad) {
        adres = ad;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String nm) {
        naam = nm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String uname) {
        username = uname;
    }

    public String getWiltHerinnering() {
        String s = "";
        if (WiltHerinnering == true) {
            s = "Ja";
        } else if (WiltHerinnering == false) {
            s = "Nee";
        }
        return s;
    }

    public void setWiltHerinnering(boolean b) {
        WiltHerinnering = b;
    }

    public boolean isWiltHerinnering() {
        return WiltHerinnering;
    }

    public Klant getKlant() {
        return this;
    }
   
    @Override
   public String toString(){
      String s = username;
      return s;
   }
}
