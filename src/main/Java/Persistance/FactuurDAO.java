/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domain.Factuur;
import Domain.Klant;
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
 * @author Thijs
 */
public class FactuurDAO extends BaseDAO <Factuur> {
    private KlantDAO kdao = new KlantDAO();

    public FactuurDAO() {
        super();
    }

    private List<Factuur> selectFacturen(String query) {
        List<Factuur> results = new ArrayList<Factuur>();
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);
            while (dbResultSet.next()) {
                int factuurNummer = dbResultSet.getInt(1);
                double brutoprijs = dbResultSet.getDouble(2);
                boolean isBetaald = dbResultSet.getBoolean(3);
                String omschrijving = dbResultSet.getString(4);
                String factuurdatum = dbResultSet.getString(5);
                String vervaldatum = dbResultSet.getString(6);
                String klantusername = dbResultSet.getString(7);                
                results.add(new Factuur(factuurNummer, factuurdatum, vervaldatum, brutoprijs, isBetaald, omschrijving, kdao.getKlant(klantusername)));
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return results;
    }

    public List<Factuur> getAll() {
        return selectFacturen("SELECT * FROM factuur");
    }

    public List<Factuur> getAlleFacturen(String username) {
        return selectFacturen("select * from factuur where klantusername = \"" + username + "\"");        
    }
    
    public Factuur getFactuur(String username) {
        List<Factuur> list = selectFacturen("select * from factuur where klantusername = \"" + username + "\"");
        Factuur f = null;
        try {
            f = list.get(0);
        } catch (Exception e) {
            System.out.println("Klant bestaat niet");
        }
        return f;
    }
    public Factuur getFactuur (int fNummer){
        return selectFacturen("select * from factuur where factuurNummer = " + fNummer+ ";").get(0);
    }

    public void createFactuur(int fN, String fD, String vD ,double bp , boolean iB, String oS, Klant k) {
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "INSERT INTO factuur (factuurNummer,factuurdatum,vervaldatum,brutoprijs,isBetaald,omschrijving,klantusername) VALUES(" + fN + ", \"" + fD + "\",\"" + vD + "\"," + bp + "," + iB + ", \"" + oS + "\", \"" + k + "\");";

            PreparedStatement pstmt = con.prepareStatement(query);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void create(Factuur instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Factuur instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(Factuur instance, Factuur newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
