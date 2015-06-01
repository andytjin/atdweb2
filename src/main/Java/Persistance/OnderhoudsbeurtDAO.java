/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domain.Onderhoudsbeurt;
import static Persistance.BaseDAO.DB_PASSWORD;
import static Persistance.BaseDAO.DB_URL;
import static Persistance.BaseDAO.DB_USERNAME;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freekvdp
 */
public class OnderhoudsbeurtDAO {
    private AutoDAO autoDAO;
    public OnderhoudsbeurtDAO(){
        super();
    }

    private List<Onderhoudsbeurt> selectOnderhoudsbeurt(String query){
        List<Onderhoudsbeurt> results = new ArrayList<Onderhoudsbeurt>();
        try(Connection con = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int dienstNummer = rs.getInt("onderhoudsbeurtID");
                String datum = rs.getString("datum");
                String kenteken = rs.getString("kenteken");

            } 
        }catch(Exception e){
            e.printStackTrace();
        }
        return results;
    }
    public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten(){
        return selectOnderhoudsbeurt("SELECT * FROM onderhoudsbeurt");
    }
    
    public void create(int dnr, String dat, String ken){
        try(Connection con = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
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
