package Service;

import Domain.Onderhoudsbeurt;
import Persistance.OnderhoudsDAO;
import java.util.List;

/**
 *
 * @author freekvdp
 */
public class PlanningService {

    private OnderhoudsDAO oDAO = new OnderhoudsDAO();

    public Onderhoudsbeurt getOnderhoudsbeurt(int dn) {
        return oDAO.getOnderhoudsbeurt(dn);
    }

    public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten() {
        return oDAO.getAlleOnderhoudsbeurten();
    }

    public void addOnderhoudsbeurt(int dnummer, String dat, String ken) {
        oDAO.create(dnummer, dat, ken);
    }

    public List<Onderhoudsbeurt> getAllObeurten() {
        return oDAO.getAlleOnderhoudsbeurten();
    }

    public Onderhoudsbeurt getOnderhoudsbeurt(String ken) {
        return oDAO.getOnderhoudsbeurt(ken);
    }

    public int getHighestDNr() {
        return oDAO.getHighestDienstnr();
    }

}
