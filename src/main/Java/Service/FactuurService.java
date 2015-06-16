/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.Factuur;
import Domain.Klant;
import Persistance.FactuurDAO;
import Persistance.KlantDAO;
import java.util.List;

/**
 *
 * @author Thijs
 */
public class FactuurService {
    private FactuurDAO fdao = new FactuurDAO();
    private KlantDAO kDAO = new KlantDAO();
    
    public Factuur getFactuur(String uN){
        return fdao.getFactuur(uN);
    }
    public List<Factuur> getAlleFacturen(String uname){
        return fdao.getAlleFacturen(uname);
    }
    public void addFactuur(int fN, double bp, boolean iB, String fD, String vD, String oS, Klant k){
        fdao.createFactuur(fN, fD, vD, bp, iB, oS, k);
    }
    public Klant getKlant(String u){
        return kDAO.getKlant(u);
    }
    public List<Factuur> getAll(){
        return fdao.getAll();
    }
    public Factuur getFactuur (int fNummer){
       return fdao.getFactuur(fNummer);
    }
    
}

