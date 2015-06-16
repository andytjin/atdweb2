/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.GebruikteArtikelen;
import Domain.Onderhoudsbeurt;
import Persistance.OnderhoudsbeurtDAO;

/**
 *
 * @author andy
 */
public class OnderhoudsService {
    OnderhoudsbeurtDAO onderhoudsbeurtdao = new OnderhoudsbeurtDAO();
    
    public void schrijfOnderhoudsbeurtNaarDatabase(Onderhoudsbeurt o, int ga, double prijs, int besteedeuur){
        onderhoudsbeurtdao.schrijfOnderhoudsbeurtNaarDatabase(o, ga, prijs, besteedeuur);
    }
    
}   

