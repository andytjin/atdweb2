package Service;

import Domain.Onderhoudsbeurt;
import Persistance.OnderhoudsbeurtDAO;
import java.util.List;

/**
 *
 * @author freekvdp
 */
public class OnderhoudsbeurtService {
    private OnderhoudsbeurtDAO oDAO = new OnderhoudsbeurtDAO();
    
    public Onderhoudsbeurt getOnderhoudsbeurt(int dn){
        return oDAO.getOnderhoudsbeurt(dn);
    }
     public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten(){
        return oDAO.getAlleOnderhoudsbeurten();
    }
    
    public void addOnderhoudsbeurt(int dnummer, String dat, String ken){
        oDAO.create(dnummer, dat, ken);
    }
    public List<Onderhoudsbeurt> getAllObeurten(){
        return oDAO.getAlleOnderhoudsbeurten();
    }
    public Onderhoudsbeurt getOnderhoudsbeurt(String ken){
        return oDAO.getOnderhoudsbeurt(ken);
    }
    public int getHighestDNr(){
        List<Onderhoudsbeurt> all = oDAO.getAll();
        return all.size();
    }
    
}
