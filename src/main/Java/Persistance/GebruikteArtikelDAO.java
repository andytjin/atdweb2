/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domain.Artikel;
import Domain.ArtikelType;
import Domain.GebruikteArtikelen;
import Domain.Onderhoudsbeurt;
import static Persistance.BaseDAO.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy
 */
public class GebruikteArtikelDAO extends BaseDAO<GebruikteArtikelen>{
    private ArtikelDAO artikeldao = new ArtikelDAO();
   
    public void schrijfGebruikteArtikelNaarDatabase(GebruikteArtikelen ga, int i) {
           
                try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            // create a SQL query
            List<GebruikteArtikelen> lijst = selectGebruikteArtikel("select * from gebruikteartikelen");
            String sql = "INSERT INTO atd.gebruikteartikelen "
                    + "(gebruikteartikelenID, aantal, artikel, onderhoudsbeurtID)"
                    + " VALUES('" + (lijst.size() + 2) + "','" + ga.getAantal()  + "','" + ga.getArtikelID()+ "','" + i + "')";
            stmt.executeUpdate(sql);
            
            }catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    
    
    
    public List<GebruikteArtikelen> getByOnderhoudsID(int id) {
        List<GebruikteArtikelen> artikel = selectGebruikteArtikel("SELECT * FROM gebruikteartikelen WHERE onderhoudsbeurtID = \"" + id + "\"");
        if(artikel != null && !artikel.isEmpty()){
            return artikel;
        } else {
            return null;
        }  
    } 
    
    public GebruikteArtikelen getGebruikteArtikel(int id) {
        List<GebruikteArtikelen> artikel = selectGebruikteArtikel("SELECT * FROM gebruikteartikelen WHERE gebruikteartikelenID = \"" + id + "\"");
        if(artikel != null && !artikel.isEmpty()){
            return artikel.get(0);
        } else {
            return null;
        }  
    }
    
   
    
    public List<GebruikteArtikelen> selectGebruikteArtikel(String query){
        List<GebruikteArtikelen> results = new ArrayList<GebruikteArtikelen>();
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("gebruikteartikelenID");
                int aantal = rs.getInt("aantal"); 
                String artikelcode = rs.getString("artikel");
                int OHid = rs.getInt("onderhoudsbeurtID");
                
                Artikel a = artikeldao.getArtikelByCode(artikelcode);
                GebruikteArtikelen ga = new GebruikteArtikelen(aantal, a);
                ga.setOnderhoudsbeurtid(OHid);
                results.add(ga);
            }
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return results;
    }
    
    
    
    @Override
    public void create(GebruikteArtikelen instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(GebruikteArtikelen instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(GebruikteArtikelen instance, GebruikteArtikelen newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GebruikteArtikelen> getAll() {
       return selectGebruikteArtikel("SELECT * FROM gebruikteartikelen");
    }
    
}