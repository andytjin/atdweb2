/*
 * Licsense Header
 */

package Service;

import Domain.Artikel;
import Domain.ArtikelType;
import Persistance.ArtikelDAO;
import Persistance.ArtikelTypeDAO;
import java.util.List;

/**
 *
 * @author Max
 */
public class ArtikelService {
   private ArtikelDAO at = new ArtikelDAO();
   private ArtikelTypeDAO atpDAO = new ArtikelTypeDAO();
   
   
   
   
   public void schrijfArtikelNaarDatabase(Artikel a){
           at.schrijfArtikelNaarDatabase(a); 
    }
        
    public void schrijfArtikelTypeNaarDatabase(String atp){    
        atpDAO.schrijfArtikelTypeNaarDatabase(atp);
    }
    
    public void WijzigArtikel(Artikel a){
        at.WijzigArtikel(a);
    }
    
    public void verwijderArtikel(Artikel a){
           at.VerwijderArtikel(a); 
    }
        
    public void verwijderArtikelType(ArtikelType atp){    
        atpDAO.VerwijderArtikelType(atp);
    }
   
    public List<Artikel> getAlleArtikelen(){
        return at.getAll();
    }
    
    public Artikel getArtikelByCode(String code){
        return at.getArtikelByCode(code);
    }
   
}
