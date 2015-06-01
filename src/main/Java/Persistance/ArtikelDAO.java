/*
 * Licsense Header
 */

package Persistance;

import Domain.Artikel;
import Domain.ArtikelType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Max
 */
public class ArtikelDAO extends BaseDAO<Artikel>{
    private ArtikelTypeDAO artikeltypedao = new ArtikelTypeDAO();
    public void schrijfArtikelNaarDatabase(Artikel a) {
           
                try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            // create a SQL query
            String sql = "INSERT INTO to4.artikel "
                    + "(code, aantal, minimum, prijs, artikeltype)"
                    + " VALUES('" + a.getCode() + "','" + a.getAantal()  + "','" + a.getMinimum() +"','" + a.getPrijs() + "','" + a.getType() + "')";
            stmt.executeUpdate(sql);
           
            }catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    public Artikel getArtikelByCode(String cd){
       List<Artikel> artikel = selectArtikel("SELECT * FROM artikel WHERE code = \"" + cd + "\"");
        if(artikel != null && !artikel.isEmpty()){
            return artikel.get(0);
        } else {
            return null;
        }  
    }  
    
    
    public List<Artikel> getByCode(String cd) {
        List<Artikel> artikel = selectArtikel("SELECT * FROM artikel WHERE code = \"" + cd + "\"");
        if(artikel != null && !artikel.isEmpty()){
            return artikel;
        } else {
            return null;
        }  
    } 
    
    
    private List<Artikel> selectArtikel(String query){
        List<Artikel> results = new ArrayList<Artikel>();
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                String code = rs.getString("code");
                int aantal = rs.getInt("aantal");
                int min = rs.getInt("minimum");
                double prijs = rs.getDouble("prijs");
                String type = rs.getString("artikeltype");
                
                ArtikelType at = artikeltypedao.getByType(type);
                Artikel a = new Artikel(code, aantal, min, prijs, at);
                results.add(a);
            }
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return results;
    }

    @Override
    public void create(Artikel instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Artikel instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(Artikel instance, Artikel newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Artikel> getAll() {
        return selectArtikel("SELECT * FROM artikel");
    }
}
