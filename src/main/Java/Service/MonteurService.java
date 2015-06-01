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

    public List<Monteur> getAlleMonteurs() {
        return mDAO.getAll();
    }

    public Monteur getMonteur(int id) {

        return mDAO.getMonteur(id);
    }

}