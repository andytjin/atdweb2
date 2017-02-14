/*
 * Licsense Header
 */
package Persistance;

import Domain.Artikel;
import Domain.ArtikelType;
import static Persistance.BaseDAO.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Max
 */
public class ArtikelDAO extends BaseDAO<Artikel> {

    private ArtikelTypeDAO artikeltypedao = new ArtikelTypeDAO();
    private String errorMessage = "";

    //   private GebruikteArtikelDAO gebruikteartikeldao = new GebruikteArtikelDAO();

    public void schrijfArtikelNaarDatabase(Artikel a) throws SQLException {

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            // create a SQL query
            String sql = "INSERT INTO atd.artikel "
                    + "(code, aantal, minimum, prijs, artikeltype)"
                    + " VALUES('" + a.getCode() + "','" + a.getAantal() + "','" + a.getMinimum() + "','" + a.getPrijs() + "','" + a.getType() + "')";
            try{
            stmt.executeUpdate(sql);
            
        } catch (SQLIntegrityConstraintViolationException e) {
            errorMessage  = "ArtikelID bestaat al";
            System.out.println(errorMessage);
        } catch (SQLException e) {
            // Other SQL Exception
        }
       }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void WijzigArtikel(Artikel a) {

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            // create a SQL query
            String sql = "UPDATE atd.artikel "
                    + "SET code = '" + a.getCode() + "', aantal = '" + a.getAantal() + "', minimum = '"
                    + a.getMinimum() + "', prijs = '" + a.getPrijs() + "', artikeltype = '" + a.getType() + "'" 
                    + " WHERE code = '" + a.getCode() + "'";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean VerwijderArtikel(Artikel a) {
        boolean result = false;
        boolean Artikel = getArtikelByCode(a.getCode()) != null;

        if (Artikel) {
            String query = "DELETE FROM artikel WHERE code = " + a.getCode();

            try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                Statement stmt = con.createStatement();
                if (stmt.executeUpdate(query) == 1) {
                    result = true;
                }

            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return result;
    }

    public Artikel getArtikelByCode(String cd) {
        List<Artikel> artikel = selectArtikel("SELECT * FROM artikel WHERE code = \"" + cd + "\"");
        if (artikel != null && !artikel.isEmpty()) {
            return artikel.get(0);
        } else {
            return null;
        }
    }

    /*  public GebruikteArtikelen GebruikteArtikelenbyCode(String code) {
     List<GebruikteArtikelen> artikel = gebruikteartikeldao.selectGebruikteArtikel("SELECT * FROM gebruikteartikelen WHERE artikel = \"" + code + "\"");
     if(artikel != null && !artikel.isEmpty()){
     return artikel.get(0);
     } else {
     return null;
     }  
     } */
    public List<Artikel> getByCode(String cd) {
        List<Artikel> artikel = selectArtikel("SELECT * FROM artikel WHERE code = \"" + cd + "\"");
        if (artikel != null && !artikel.isEmpty()) {
            return artikel;
        } else {
            return null;
        }
    }

    private List<Artikel> selectArtikel(String query) {
        List<Artikel> results = new ArrayList<Artikel>();
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String code = rs.getString("code");
                int aantal = rs.getInt("aantal");
                int min = rs.getInt("minimum");
                double prijs = rs.getDouble("prijs");
                String type = rs.getString("artikeltype");

                ArtikelType at = artikeltypedao.getByType(type);
                Artikel a = new Artikel(code, min, aantal, prijs, at);
                results.add(a);
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    public void wijzigArtikel(Artikel a) {

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            // create a SQL query
            String sql = "UPDATE atd.artikel "
                    + "SET code = '" + a.getCode() + "', aantal = '" + a.getAantal() + "', minimum = '"
                    + a.getMinimum() + "', prijs = '" + a.getPrijs() + "', artikeltype = '" + a.getType() + "'"
                    + " WHERE code = '" + a.getCode() + "'";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
