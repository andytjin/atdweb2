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
    static OnderhoudsService oService = new OnderhoudsService();
    static GebruikteArtikelenService gaService = new GebruikteArtikelenService();
    static FactuurService fService = new FactuurService();
    static PlanningService pService = new PlanningService();
    static BestellingService bService = new BestellingService();
    
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

    public static OnderhoudsService getOnderhoudsService() {
        return oService;
    }
    
    public static FactuurService getFactuurService(){
        return fService;
    }
    
    public static PlanningService getPlanningService(){
        return pService;
    }
    public static BestellingService getBestellingService(){
        return bService;
    }
}
