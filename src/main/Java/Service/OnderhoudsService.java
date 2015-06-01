/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.GebruikteArtikelen;
import Domain.Onderhoudsbeurt;
import Persistance.OnderhoudsbeurtDAO;
import java.util.List;

/**
 *
 * @author andy
 */
public class OnderhoudsService {
    OnderhoudsbeurtDAO onderhoudsbeurtdao = new OnderhoudsbeurtDAO();
    
    public void schrijfOnderhoudsbeurtNaarDatabase(Onderhoudsbeurt o, double prijs, int besteedeuur){
        onderhoudsbeurtdao.schrijfOnderhoudsbeurtNaarDatabase(o, prijs, besteedeuur);
    }
    
    public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten(){
        return onderhoudsbeurtdao.getAlleOnderhoudsbeurten();
    }
    
}   

