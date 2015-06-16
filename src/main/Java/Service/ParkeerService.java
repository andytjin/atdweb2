/*
 * Licsense Header
 */

package Service;

import Domain.ParkeerDienst;
import Persistance.ParkeerDAO;

/**
 *
 * @author Max
 */
public class ParkeerService {

    private ParkeerDAO pDao = new ParkeerDAO();
    
    public int getHoogsteParkeerNummer(){
        return pDao.getMaxParkeerID();
    }
    
    public void create(ParkeerDienst pd){
        pDao.create(pd);
    }
}
