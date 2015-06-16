/*
 * Licsense Header
 */
package Service;

import Domain.Auto;
import Domain.Klant;
import Persistance.AutoDAO;
import java.util.List;

/**
 *
 * @author Max
 */
public class AutoService {

    private AutoDAO aDAO = new AutoDAO();

    public List<Auto> getAlleAutos() {
        return aDAO.getAlleAutos();
    }

    public void create(Auto a) {
        aDAO.create(a);
    }

    public Auto getAutoByKenteken(String kenteken) {
        return aDAO.getAutoByKenteken(kenteken);
    }

    public List<Auto> getAutoByKlant(Klant k) {
        return aDAO.getAutoByKlant(k);
    }
}
