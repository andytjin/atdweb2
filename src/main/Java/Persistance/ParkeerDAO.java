/*
 * Licsense Header
 */
package Persistance;

import Domain.ParkeerDienst;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Max
 */
public class ParkeerDAO extends BaseDAO<ParkeerDienst> {

    private List<ParkeerDienst> selectParkeerDienst(String query) {
        List<ParkeerDienst> results = new ArrayList<ParkeerDienst>();
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String pID = rs.getString("parkeerdienstID");
                String aUur = rs.getString("aantalUur");
                String date = rs.getString("datum");

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                try {
                    cal.setTime(sdf.parse(date));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                int aantalUur = Integer.parseInt(aUur);
                int parkeerdienstID = Integer.parseInt(pID);
                
                ParkeerDienst pd = new ParkeerDienst(parkeerdienstID, cal, aantalUur);
                results.add(pd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public ParkeerDienst getParkeerDienstByID(int id){
        String query = "select * from parkeerdienst where parkeerdienstID = " + id + ";";
        List<ParkeerDienst> results = selectParkeerDienst(query);
        ParkeerDienst deDienst = null;
        if(!results.isEmpty()){
            
            deDienst = results.get(0);
        }
        return deDienst;
    }
    
    public int getMaxParkeerID(){
        String query = "select * from parkeerdienst order by parkeerdienstID DESC;";
        List<ParkeerDienst> result = selectParkeerDienst(query);
        int i = 0;
        if(!result.isEmpty()){
            i = result.get(0).getDienstNummer();
        }
        return i;
        
    }
    
    @Override
    public void create(ParkeerDienst instance) {
        String query = "insert into parkeerdienst values("+instance.getDienstNummer()+", 1, "+instance.getAantalUur()+",'"+instance.getSQLdatum()+"');";
        try(Connection con = getConnection()){
            PreparedStatement stmt = con.prepareCall(query);
            int i = stmt.executeUpdate();
            if(i == 1){
                System.out.println("Gelukt");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ParkeerDienst instance) {
        String query = "DELETE FROM parkeerdienst WHERE parkeerdienstID = "+instance.getDienstNummer() + ";";
        try(Connection con = getConnection()){
            PreparedStatement stmt = con.prepareCall(query);
            int i = stmt.executeUpdate();
            if(i == 1){
                System.out.println("Parkeerdienst: " + instance.getDienstNummer() + " is verwijderd");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void change(ParkeerDienst instance, ParkeerDienst newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ParkeerDienst> getAll() {
        return selectParkeerDienst("SELET * FROM parkeerdienst");
    }

    public void checkDates() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(cal.getTime());
        
        
        String query = "select * from parkeerdienst where datum < date('" + datum + "');";
        List<ParkeerDienst> lijst = selectParkeerDienst(query);
        for(ParkeerDienst p : lijst){
            delete(p);
        }
    }

}
