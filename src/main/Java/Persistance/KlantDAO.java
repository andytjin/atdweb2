/*
 * Licsense Header
 */
package Persistance;

import Domain.Klant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Max
 */
public class KlantDAO extends BaseDAO<Klant> {
    

    public KlantDAO() {
        super();
    }

    private List<Klant> selectKlanten(String query) {
        List<Klant> results = new ArrayList<Klant>();

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String realname = rs.getString("realname");
                String pass = rs.getString("password");
                String adres = rs.getString("adres");
                String geboorte = rs.getString("geboortedatum");
                String tel = rs.getString("telefoonnummer");
                String postcode = rs.getString("postcode");
                String emailadres = rs.getString("emailadres");
                boolean her = rs.getBoolean("herinnering");
                Klant k = new Klant(username, realname, pass, adres, geboorte, tel, postcode, emailadres, her);

                results.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public void create(String uName, String nm, String pass, String ad, String gd, String tel, String pc, String email, boolean wh) {
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "INSERT INTO klant VALUES(\"" + uName + "\", \"" + nm + "\", \"" + pass + "\", \"" + ad + "\",  \"" + gd + "\", \"" + tel + "\", \"" + pc + "\", \"" + email + "\", " + wh + ")";
            PreparedStatement pstmt = con.prepareStatement(query);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Klant getKlant(String username) {
        List<Klant> list = selectKlanten("select * from klant where username = \"" + username + "\"");
        Klant k = null;
        try {
            k = list.get(0);
        } catch (Exception e) {
            System.out.println("Klant bestaat niet");
        }

        return k;
    }

    public List<Klant> getAlleKlanten() {
        return selectKlanten("select * from klant");
    }

    @Override
    public void delete(Klant instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(Klant instance, Klant newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Klant> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //Create wordt niet gebruikt voor klant omdat we het wachtwoord niet uit klant kunnen halen.
    @Override
    public void create(Klant instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
