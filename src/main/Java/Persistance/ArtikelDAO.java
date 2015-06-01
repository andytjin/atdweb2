/*
 * Licsense Header
 */

package Persistance;

import Domain.Artikel;
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
            }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
