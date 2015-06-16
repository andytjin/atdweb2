/*
 * Licsense Header
 */
package Service;

import Domain.Monteur;
import Persistance.MonteurDAO;
import java.util.List;

/**
 *
 * @author Max
 */
public class MonteurService {

    private MonteurDAO mDAO = new MonteurDAO();

    public MonteurService() {

    }

    public void voegMonteurToe(int id, String naam, String pass) {
        mDAO.create(id, naam, pass);
    }

    public Monteur getMonteurByID(int id) {
        return mDAO.getMonteurByID(id);
    }

    public List<Monteur> getAlleMonteurs() {
        return mDAO.getAll();
    }

}
