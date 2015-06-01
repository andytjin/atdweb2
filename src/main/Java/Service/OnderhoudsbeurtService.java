/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        return oDAO.getHighestDienstnr();
    }
    
}
