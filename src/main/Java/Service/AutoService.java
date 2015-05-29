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
    public void create(Auto a){
        aDAO.create(a);
    }
}
