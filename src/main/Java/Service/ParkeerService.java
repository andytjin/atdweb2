/*
 * Licsense Header
 */
package Service;

import Domain.ParkeerDienst;
import Persistance.ParkeerDAO;
import java.util.List;

/**
 *
 * @author Max
 */
public class ParkeerService {

    private ParkeerDAO pDao = new ParkeerDAO();

    public int getHoogsteParkeerNummer() {
        return pDao.getMaxParkeerID();
    }

    public List<ParkeerDienst> getAll() {
        return pDao.getAll();
    }

    public void create(ParkeerDienst pd) {
        pDao.create(pd);
    }

    public ParkeerDienst getParkeerDienstByID(int id) {
        return pDao.getParkeerDienstByID(id);
    }

    public void clearDBofOldFiles() {
        pDao.checkDates();
    }
}
