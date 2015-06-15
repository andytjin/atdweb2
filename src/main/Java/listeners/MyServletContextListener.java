/*
 * Licsense Header
 */
package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Max
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
       
        /*System.out.println("INITIALIZING");
         ServletContext sc = sce.getServletContext();
         Bedrijf hetBedrijf = new Bedrijf();
         try {
         //Toevoegen van alle Artikelen
         ArtikelService arts = ServiceProvider.getArtikelService();
         List<Artikel> artikelList = arts.getAlleArtikelen();
         if(artikelList != null){
         for(Artikel a : artikelList){
         hetBedrijf.voegArtikelToe();
         }
         }
            
         //Toevoegen van alle klanten
         KlantService ks = ServiceProvider.getKlantService();
         List<Klant> klantList = ks.getAlleKlanten();
         if (klantList != null) {
         for (Klant k : klantList) {
         hetBedrijf.voegKlantToe(k);
         }
         }
            
         //Toevoegen van alle auto's
         AutoService as = ServiceProvider.getAutoService();
         List<Auto> autoList = as.getAlleAutos();
         if(autoList != null){
         for(Auto a : autoList){
         hetBedrijf.voegAutoToe(a);
         }
         }
            
            
            
         } catch (Exception e) {
         hetBedrijf = new Bedrijf();
         Klant k = new Klant("Default", "default", "a", "adres", "01-01-1990", "123", "1234AB", "default@a.com", true);
         Klant k2 = new Klant("HenkPaladijn", "Henk Paladijn", "thema4", "adres", "01-01-1990", "0612345678", "1234AB", "henkpaladijn@atd.com", false);
         hetBedrijf.voegKlantToe(k);
         hetBedrijf.voegKlantToe(k2);
         System.out.println("No file found");
         }
         sc.setAttribute("bedrijf", hetBedrijf);
         System.out.println("INITIALIZING DONE");
         */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /*ystem.out.println("SAVING");
         Object obj = sce.getServletContext().getAttribute("bedrijf");
         Bedrijf hetBedrijf = (Bedrijf) obj;
         try {
            
         System.out.println("Saved users: " + hetBedrijf.toString());
         } catch (Exception e) {
         System.out.println("Saving gone wrong");
         e.printStackTrace();
         }
         */
    }
}
