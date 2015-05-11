/*
 * Licsense Header
 */
package listeners;

import Domain.Bedrijf;
import Domain.Klant;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.servlet.ServletContext;
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
        System.out.println("INITIALIZING");
        ServletContext sc = sce.getServletContext();
        Bedrijf hetBedrijf = null;
        try {
            FileInputStream fis = new FileInputStream("bedrijf.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if (obj != null) {
                hetBedrijf = (Bedrijf) obj;
            }
            System.out.println("File read");
            ois.close();
            fis.close();

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
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("SAVING");
        Object obj = sce.getServletContext().getAttribute("bedrijf");
        Bedrijf hetBedrijf = (Bedrijf) obj;
        try {
            FileOutputStream fos = new FileOutputStream("bedrijf.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hetBedrijf);
            oos.close();
            fos.close();
            System.out.println("Saved users: " + hetBedrijf.toString());
        } catch (Exception e) {
            System.out.println("Saving gone wrong");
            e.printStackTrace();
        }
        
    }
}
