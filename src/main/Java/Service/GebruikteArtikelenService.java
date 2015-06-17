/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.GebruikteArtikelen;
import Domain.Onderhoudsbeurt;
import Persistance.GebruikteArtikelDAO;
import java.util.List;

/**
 *
 * @author andy
 */
public class GebruikteArtikelenService {
    GebruikteArtikelDAO gaDAO = new GebruikteArtikelDAO();
    
    public void schrijfGebruikteArtikelNaarDatabase(GebruikteArtikelen ga, int i){
            gaDAO.schrijfGebruikteArtikelNaarDatabase(ga, i);
    }
    
    public GebruikteArtikelen getGebruikteArtikel(int id){
      return gaDAO.getGebruikteArtikel(id);
    }
    
    public List<GebruikteArtikelen> getGAList(){
        return gaDAO.getAll();
    }
    
    public List<GebruikteArtikelen> getByID(int id){
        return gaDAO.getByOnderhoudsID(id);
    }
    
    public void wijzigGebruikteArtikel(GebruikteArtikelen ga, int onderhoudsID, int gaID){
        gaDAO.WijzigGebruikteArtikel(ga, onderhoudsID, gaID);
    }
    
    public boolean VerwijderGebruikteArtikel(Onderhoudsbeurt o){
        boolean result = false;
          if(gaDAO.VerwijderGebruikteArtikelen(o)){
              result = true;
          } 
          return result;
    }
}