package Service;

import Domain.Onderhoudsbeurt;
import Persistance.PlanningDAO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author freekvdp
 */
public class PlanningService {
    private PlanningDAO pDAO = new PlanningDAO();
    
    public Onderhoudsbeurt getOnderhoudsbeurt(int dn){
        return pDAO.getOnderhoudsbeurt(dn);
    }
     public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten(){
        return pDAO.getAlleOnderhoudsbeurten();
    }
    
    public void addOnderhoudsbeurt(Onderhoudsbeurt o){
        System.out.println("PlanningService: addOnderhoudsbeurt CHECK");
        pDAO.createPlanning(o);
    }
    public List<Onderhoudsbeurt> getAllObeurten(){
        return pDAO.getAlleOnderhoudsbeurten();
    }
    public List<Onderhoudsbeurt> getOnderhoudsbeurten(String ken){
        return pDAO.getOnderhoudsbeurten(ken);
    }
    public int getHighestDNr(){
        List<Onderhoudsbeurt> all = pDAO.getAll();
        return all.size();
    }
    
}
