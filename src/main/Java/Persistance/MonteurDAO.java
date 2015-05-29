/*
 * Licsense Header
 */
package Persistance;

import Domain.Monteur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Max
 */
public class MonteurDAO extends BaseDAO<Monteur> {

    public MonteurDAO() {
        super();
    }

    private List<Monteur> selectMonteurs(String query) {
        List<Monteur> results = new ArrayList<Monteur>();
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("monteurID");
                String naam = rs.getString("naam");
                String pass = rs.getString("password");
                Monteur m = new Monteur(naam, id, pass);
                results.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public void create(int id, String naam, String pass) {
        try (Connection con = getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO monteur (monteurID,naam,password) VALUES(" + id + ", \"" + naam + "\", \"" + pass + "\");");
            int i = pstmt.executeUpdate();
            if (i == 1) {
                System.out.println("Monteur is toegevoegd");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Monteur getMonteur(int id){
        return selectMonteurs("SELECT * FROM monteur WHERE monteurID = " + id + ";").get(0);
    }
    
    @Override
    public void create(Monteur instance){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Monteur instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(Monteur instance, Monteur newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Monteur> getAll() {
        return selectMonteurs("SELECT * FROM monteur");
    }

}
