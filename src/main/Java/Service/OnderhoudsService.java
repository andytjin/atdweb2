/*
 * To change this license header, choose License Headers in Project Properties.
dd a comment to this line
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.Onderhoudsbeurt;
import Persistance.OnderhoudsDAO;
import java.util.List;

/**
 *
 * @author andy
 */
public class OnderhoudsService {
    OnderhoudsDAO onderhoudsbeurtdao = new OnderhoudsDAO();
    
    public void schrijfOnderhoudsbeurtNaarDatabase(Onderhoudsbeurt o, int besteedeuur){
        onderhoudsbeurtdao.schrijfOnderhoudsbeurtNaarDatabase(o, besteedeuur);
    }
    
    public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten(){
        return onderhoudsbeurtdao.getAlleOnderhoudsbeurten();
    }
    
}   