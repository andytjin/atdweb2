/*
 * Licsense Header
 */

package Service;

import Domain.Klant;
import Persistance.KlantDAO;
import java.util.List;

/**
 *
 * @author Max
 */
public class KlantService {

    private KlantDAO kDAO = new KlantDAO();
    
    public Klant getKlant(String u){
        return kDAO.getKlant(u);
    }
    
    public List<Klant> getAlleKlanten(){
        return kDAO.getAlleKlanten();
    }
    
    public void addKlant(String uName, String nm, String pass, String ad, String gd, String tel, String pc, String email, boolean wh){
        kDAO.create(uName, nm, pass, ad, gd, tel, pc, email, wh);
    }
    
    public boolean heeftKlant(String username){
        boolean b = true;
        if(kDAO.getKlant(username) == null){
            b = false;
        }
        return b;
    }
}
