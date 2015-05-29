/*
 * Licsense Header
 */

package Service;

/**
 *
 * @author Max
 */
public class ServiceProvider {

    static KlantService kService = new KlantService();
    static AutoService aService = new AutoService();
    static MonteurService mService = new MonteurService();
    
    public static KlantService getKlantService(){
        return kService;
    }
    public static AutoService getAutoService(){
        return aService;
    }
    public static MonteurService getMonteurService(){
        return mService;
    }
}
