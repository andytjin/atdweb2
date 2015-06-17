/*
 * Licsense Header
 */
package Persistance;

import Domain.ParkeerPlaats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Max
 */
public class ParkeerplaatsDAO extends BaseDAO<ParkeerPlaats> {

    private int selectParkeerPlaats(String query) {
        int result = 0;

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result = rs.getInt("bezettePlaatsen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getAantalBezet(){
        return selectParkeerPlaats("SELECT bezettePlaatsen FROM parkeerplaats;");
    }
    
    public void setAantalBezet(int i){
        String query = "UPDATE `atd`.`parkeerplaats` SET `bezettePlaatsen`='" + i + "' WHERE `parkeerplaatsID`='1';";
        try(Connection con = getConnection()){
            PreparedStatement stmt = con.prepareCall(query);
            int result = stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void create(ParkeerPlaats instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ParkeerPlaats instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(ParkeerPlaats instance, ParkeerPlaats newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ParkeerPlaats> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
