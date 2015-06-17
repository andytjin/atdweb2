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
    static ArtikelService atkService = new ArtikelService();
    static MonteurService mService = new MonteurService();
    static PlanningService oService = new PlanningService();
    static GebruikteArtikelenService gaService = new GebruikteArtikelenService();
    static FactuurService fService = new FactuurService();
    static ParkeerService psService = new ParkeerService();
    static ParkeerplaatsService ppsService = new ParkeerplaatsService();
    static OnderhoudsService ohService = new OnderhoudsService();
    
    public static KlantService getKlantService() {
        return kService;
    }

    public static AutoService getAutoService() {
        return aService;
    }

    public static ArtikelService getArtikelService() {
        return atkService;
    }

    public static GebruikteArtikelenService getGebruikteArtikelenService() {
        return gaService;
    }

    public static MonteurService getMonteurService() {
        return mService;
    }

    public static PlanningService getPlanningService() {
        return oService;
    }
    
    public static FactuurService getFactuurService(){
        return fService;
    }
    
    public static ParkeerService getParkeerService(){
        return psService;
    }
    
    public static ParkeerplaatsService getParkeerPlaatsService(){
        return ppsService;
    }
    
    public static OnderhoudsService getOnderhoudsService(){
        return ohService;
    }
}
