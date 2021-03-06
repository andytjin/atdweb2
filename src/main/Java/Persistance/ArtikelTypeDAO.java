/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domain.Artikel;
import Domain.ArtikelType;
import static Persistance.BaseDAO.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy
 */
public class ArtikelTypeDAO extends BaseDAO<ArtikelType> {

    public void schrijfArtikelTypeNaarDatabase(String atp) {

        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = con.createStatement();
            // create a SQL query
            String sql = "INSERT INTO atd.artikeltype "
                    + "(artikeltype)"
                    + " VALUES('" + atp + "')";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WijzigArtikelType(Artikel a) {

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

    public boolean VerwijderArtikelType(ArtikelType at) {
        boolean result = false;
        boolean ArtikelType = getByType(at.getType()) != null;

        if (ArtikelType) {
            String query = "DELETE FROM artikeltype WHERE artikeltype = '" + at.getType() + "'";

            try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                Statement stmt = con.createStatement();
                stmt.executeUpdate(query);// 1 row updated!

            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return result;
    }

    public ArtikelType getByType(String tp) {
        List<ArtikelType> artikeltype = selectArtikelType("SELECT * FROM artikeltype WHERE artikeltype = \"" + tp + "\"");
        if (artikeltype != null && !artikeltype.isEmpty()) {
            return artikeltype.get(0);
        } else {
            return null;
        }
    }

    private List<ArtikelType> selectArtikelType(String query) {
        List<ArtikelType> results = new ArrayList<ArtikelType>();
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String type = rs.getString("artikeltype");
                ArtikelType tp = new ArtikelType(type);
                results.add(tp);
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public void create(ArtikelType instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ArtikelType instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(ArtikelType instance, ArtikelType newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ArtikelType> getAll() {
        return selectArtikelType("SELECT * FROM artikeltype");
    }

}
