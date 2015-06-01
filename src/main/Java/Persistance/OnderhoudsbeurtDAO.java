/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domain.Artikel;
import Domain.Auto;
import Domain.GebruikteArtikelen;
import Domain.Monteur;
import Domain.Onderhoudsbeurt;
import static Persistance.BaseDAO.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy
 */
public class OnderhoudsbeurtDAO extends BaseDAO<Onderhoudsbeurt>{
private MonteurDAO monteurdao = new MonteurDAO();
private GebruikteArtikelDAO gebruikteartikeldao = new GebruikteArtikelDAO();
private AutoDAO autodao = new AutoDAO();
private List<GebruikteArtikelen> gebruikteArtikelenLijst = null;
    public void schrijfOnderhoudsbeurtNaarDatabase(Onderhoudsbeurt o, int ga, double prijs, int bestedeuur) {
           
                try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            // create a SQL query
            String sql = "INSERT INTO to4.onderhoudsbeurt "
                    + "(onderhoudsbeurtID, datum, kenteken, monteurID, aantalbestedeuren, nettoprijs, gebruikteartikelen)"
                    + " VALUES('" + o.getDienstNummer()+ "','" + o.getDatum()  + "','" + o.getKenteken() + "','" + o.getMonteurID() + "','" + bestedeuur + "','" +  prijs + "','" + ga + "')";
            stmt.executeUpdate(sql);
           
            }catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    public List<Onderhoudsbeurt> getByID(int id) {
        List<Onderhoudsbeurt> artikel = selectOnderhoudsbeurt("SELECT * FROM gebruikteartikelen WHERE gebruikteartikelenID = \"" + id + "\"");
        if(artikel != null && !artikel.isEmpty()){
            return artikel;
        } else {
            return null;
        }  
    } 
    
    public List<GebruikteArtikelen> getAlleGebruikteArtikelen(int id){
        return gebruikteartikeldao.getByID(id);
    }
    
    private List<Onderhoudsbeurt> selectOnderhoudsbeurt(String query){
        List<Onderhoudsbeurt> results = new ArrayList<Onderhoudsbeurt>();
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("onderhoudsbeurtID");
                String datum = rs.getString("datum"); 
                String kenteken = rs.getString("kenteken");
                int monteurid = rs.getInt("monteurID");
                int bestedeUur = rs.getInt("aantalbestedeuren");
                double nettoprijs = rs.getDouble("nettoprijs");
                int gaID = rs.getInt("gebruikteartikelen");
               
               Auto au = autodao.getAutoByKenteken(kenteken); 
               Monteur mo = monteurdao.getMonteurByID(monteurid);
              
               Onderhoudsbeurt o = new Onderhoudsbeurt(id, datum, au, mo); 
               o.setAantalBestedeUur(bestedeUur);
               o.setNettoPrijs(nettoprijs);
               
               
               gebruikteArtikelenLijst = (List<GebruikteArtikelen>) gebruikteartikeldao.getByID(gaID);
               if(gebruikteArtikelenLijst != null){
                   for(GebruikteArtikelen g : gebruikteArtikelenLijst){
                        o.voegArtikelToe(g.getHetArtikel(), g.getAantal(), id);
                   }
                  } else {
                     System.out.println("er zijn geen gebruikte artikelen");
                  }
               results.add(o);
            }
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return results;
    }
    @Override
    public void create(Onderhoudsbeurt instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Onderhoudsbeurt instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(Onderhoudsbeurt instance, Onderhoudsbeurt newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Onderhoudsbeurt> getAll() {
       return selectOnderhoudsbeurt("SELECT * FROM onderhoudsbeurt");
    }
    public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten(){
        return selectOnderhoudsbeurt("SELECT * FROM onderhoudsbeurt");
    }
    
    public void create(int dnr, String dat, String ken){
        try(Connection con = getConnection()){
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Onderhoudsbeurt" + "(onderhoudsbeurtID, datum, kenteken)" + "VALUES(\"" + dnr + "\", \"" + dat + "\", \"" + ken + "\")");
            int i = stmt.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Onderhoudsbeurt getOnderhoudsbeurt(String ken){
        List<Onderhoudsbeurt> list = selectOnderhoudsbeurt("SELECT * FROM onderhoudsbeurt WHERE kenteken = '"+ken+"'");
        Onderhoudsbeurt o = null;
        try{
            o = list.get(0);
        } catch (Exception e){
            System.out.println("Onderhoudsbeurt bestaat niet!");
        }
        return o;
    }
    public Onderhoudsbeurt getOnderhoudsbeurt(int dn){
        List<Onderhoudsbeurt> list = selectOnderhoudsbeurt("SELECT * FROM onderhoudsbeurt WHERE onderhoudsbeurtID = '"+dn+"'");
        Onderhoudsbeurt o = null;
        try{
            o = list.get(0);
        } catch (Exception e){
            System.out.println("Onderhoudsbeurt bestaat niet!");
        }
        return o;
    }
    public int getHighestDienstnr(){
        
        List<Onderhoudsbeurt> list = selectOnderhoudsbeurt("SELECT MAX(onderhoudsbeurtID) FROM onderhoudsbeurt");
        Onderhoudsbeurt ohb = list.get(0);
        int i = ohb.getDienstNummer();
        System.out.println(i);
        return i;
    }
    
}
