/*
 * To change this license header, choose License Headers in Project Properties.
dd a comment to this line
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.Onderhoudsbeurt;
import Persistance.OnderhoudsDAO;
import Persistance.OnderhoudsbeurtDAO;
import java.util.List;

/**
 *
 * @author andy
 */
public class OnderhoudsService {
    OnderhoudsbeurtDAO onderhoudsbeurtdao = new OnderhoudsbeurtDAO();
    
    public void schrijfOnderhoudsbeurtNaarDatabase(Onderhoudsbeurt o, int besteedeuur){
        onderhoudsbeurtdao.schrijfOnderhoudsbeurtNaarDatabase(o, besteedeuur);
    }
    
    public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten(){
        return onderhoudsbeurtdao.getAlleOnderhoudsbeurten();
    }
    
    public void wijzigOnderhoudsbeurt(Onderhoudsbeurt o, int uur){
        onderhoudsbeurtdao.WijzigOnderhoudsbeurt(o, uur);
    }
    /*public Onderhoudsbeurt getOnderhoudsbeurt(String code){
        return onderhoudsbeurtdao.
    }*/
    
    public boolean VerwijderOnderhoudsbeurt(Onderhoudsbeurt o){
        boolean result = false;
          if(onderhoudsbeurtdao.VerwijderOnderhoudsbeurt(o)){
              result = true;
          } 
          return result;
    }
    
}   

