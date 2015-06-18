/*
 * Licsense Header
 */
package Service;

import Domain.Artikel;
import Domain.ArtikelType;
import Domain.GebruikteArtikelen;
import Persistance.ArtikelDAO;
import Persistance.ArtikelTypeDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Max
 */
public class ArtikelService {
   private ArtikelDAO at = new ArtikelDAO();
   private ArtikelTypeDAO atpDAO = new ArtikelTypeDAO();
   
   
   
   
   public void schrijfArtikelNaarDatabase(Artikel a) throws SQLException {
           at.schrijfArtikelNaarDatabase(a); 
    }
    
    public void schrijfArtikelTypeNaarDatabase(String atp) {        
        atpDAO.schrijfArtikelTypeNaarDatabase(atp);
    }
    
    public void WijzigArtikel(Artikel a){
        at.WijzigArtikel(a);
    }
    
public boolean verwijderArtikel(Artikel a){
    boolean result = false;
      if(at.VerwijderArtikel(a)){
          result = true;
      } 
      return result;
}
        
    public void verwijderArtikelType(ArtikelType atp){    
        atpDAO.VerwijderArtikelType(atp);
    }
    
    public List<Artikel> getAlleArtikelen() {
        return at.getAll();
    }
    
    public Artikel getArtikelByCode(String code) {
        return at.getArtikelByCode(code);
    }
    
    public String getErrorMessage(){
        return at.getErrorMessage();
    }
    
    public List<ArtikelType> getAlleTypen(){
        return atpDAO.getAll();
    }
   

    public void wijzigArtikel(Artikel a) {
        at.wijzigArtikel(a);
    }
    
}
