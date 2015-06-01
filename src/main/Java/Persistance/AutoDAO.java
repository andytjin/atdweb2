/*
 * Licsense Header
 */

package Persistance;

import Domain.Auto;
import Domain.Klant;
import Service.KlantService;
import Service.ServiceProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Max
 */
public class AutoDAO extends BaseDAO<Auto>{
    
    private KlantDAO klantDAO = new KlantDAO();
    
    public AutoDAO(){
        super();
    }

    private List<Auto> selectAuto(String query){
        List<Auto> results = new ArrayList<Auto>();
        try(Connection con = getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String kenteken = rs.getString("kenteken");
                String klant = rs.getString("klant");
                String naam = rs.getString("naam");
                String merk = rs.getString("merk");
                
                KlantService ks = ServiceProvider.getKlantService();
                Klant k = ks.getKlant(klant);
                Auto a = new Auto(kenteken, merk, naam, k);
                results.add(a);
            } 
        }catch(Exception e){
            e.printStackTrace();
        }
        return results;
    }

    public List<Auto> getAlleAutos(){
        return selectAuto("SELECT * FROM auto");
    }

    @Override
    public void create(Auto instance) {
        try(Connection con = getConnection()){
            PreparedStatement stmt = con.prepareStatement("INSERT INTO auto VALUES(" + instance.getKenteken() + ",'" + instance.getKlant().getUsername() + "','" + instance.getNaam() + "','" + instance.getMerk() + "');");
            int i = stmt.executeUpdate();
            System.out.println(i);
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }

    @Override
    public void delete(Auto instance) {
        
    }

    @Override
    public void change(Auto instance, Auto newInstance) {
        
    }

    @Override
    public List<Auto> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Auto> getAlleAutosByKlant(String UName){
        Klant k = klantDAO.getKlant(UName);
        List<Auto> alleAutosByKlant = selectAuto("SELECT * FROM auto WHERE Klant = \"" + k + "\"");
        return alleAutosByKlant;
    }
    
}
