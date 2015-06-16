/*
 * Licsense Header
 */

package Service;

import Persistance.ParkeerplaatsDAO;

/**
 *
 * @author Max
 */
public class ParkeerplaatsService {

    private ParkeerplaatsDAO ppdao = new ParkeerplaatsDAO();
    
    public int getAantalBezet(){
        return ppdao.getAantalBezet();
    }
    public void setHuidigBezet(int i){
        ppdao.setAantalBezet(i);
    }
}
