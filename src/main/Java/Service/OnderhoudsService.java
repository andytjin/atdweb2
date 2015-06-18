/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.GebruikteArtikelen;
import Domain.Onderhoudsbeurt;
import Persistance.PlanningDAO;
import java.util.List;

/**
 *
 * @author andy
 */
public class OnderhoudsService {
    PlanningDAO onderhoudsbeurtdao = new PlanningDAO();
    
   
    
    public List<Onderhoudsbeurt> getAlleOnderhoudsbeurten(){
        return onderhoudsbeurtdao.getAlleOnderhoudsbeurten();
    }
    
}   

