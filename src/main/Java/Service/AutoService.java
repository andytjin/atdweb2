/*
 * Licsense Header
 */

package Service;

import Domain.Auto;
import Persistance.AutoDAO;
import java.util.List;

/**
 *
 * @author Max
 */
public class AutoService {

    private AutoDAO aDAO = new AutoDAO();
    
    public List<Auto> getAlleAutos(){
        return aDAO.getAlleAutos();
    }
    public List<Auto> getAlleAutosByKlant(String UName){
        List<Auto> alleAutosByKlant = aDAO.getAlleAutosByKlant(UName);
        System.out.println(alleAutosByKlant.get(0).getKenteken());
        return alleAutosByKlant;
    }
    
    public void create(Auto a){
        aDAO.create(a);
    }
}
