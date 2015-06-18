package Servlets;

import Domain.Artikel;
import Domain.Auto;
import Domain.Klant;
import Service.ArtikelService;
import Service.AutoService;
import Service.FactuurService;
import Service.ServiceProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
@WebServlet(name = "KlantPageServlet", urlPatterns = {"/KlantPageServlet"})
public class KlantPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String button = request.getParameter("button");

        RequestDispatcher rd = request.getRequestDispatcher("/KlantPage.jsp");

        if (button.equals("Home")) {
            request.setAttribute("PageName", "Homepage");
            rd = request.getRequestDispatcher("/KlantPage.jsp");
        }
        if (button.equals("afspraak")) {
            AutoService as = ServiceProvider.getAutoService();
            Klant k = (Klant) request.getSession().getAttribute("User");
            request.setAttribute("PageName", "Afspraak");
            List<Auto> alleAutos = as.getAutoByKlant(k);
            request.getSession().setAttribute("Autos", alleAutos);
            rd = request.getRequestDispatcher("/PlanningOverzicht.jsp");
        }
        if (button.equals("garage")) {
            ArtikelService as = ServiceProvider.getArtikelService();
            List<Artikel> alleArtikelen = as.getAlleArtikelen();
            List<Artikel> teBestellenArtikelen = new ArrayList<Artikel>();
            List<Artikel> bijnaBestellenArtikelen = new ArrayList<Artikel>();
             for (Artikel a : alleArtikelen) {
                if (a.getAantal() < a.getMinimum()) {
                    teBestellenArtikelen.add(a);
                } else if (a.getAantal() <= a.getMinimum() + 2) {
                    bijnaBestellenArtikelen.add(a);
                }
            }
            
            request.getSession().setAttribute("teBestellen", teBestellenArtikelen);
            request.getSession().setAttribute("bijnaBestellen", bijnaBestellenArtikelen);

            request.setAttribute("PageName", "Garage");
            rd = request.getRequestDispatcher("/Bestelling.jsp");
            System.out.println("IMPLEMENTEER GARAGE");
        }
        if (button.equals("mijn account")) {
            AutoService as = ServiceProvider.getAutoService();
            Object obj = request.getSession().getAttribute("User");
            Klant k = (Klant) obj;
            List<Auto> lijst = as.getAutoByKlant(k);
            request.setAttribute("PageName", "Account Settings");
            request.getSession().setAttribute("autos", lijst);
            rd = request.getRequestDispatcher("/KlantSettings.jsp");
        }
        if (button.equals("log out")) {
            request.setAttribute("PageName", "Auto Totaal Dienst");
            request.getSession().setAttribute("User", null);
            rd = request.getRequestDispatcher("/index.jsp");
        }
        if (button.equals("factuur")) {
            FactuurService fService = ServiceProvider.getFactuurService();
            request.setAttribute("PageName", "Factuur");
            rd = request.getRequestDispatcher("FactuurOverzichtKlant.jsp");
            Object obj = request.getSession().getAttribute("User");
            Klant k = (Klant) obj;
            request.getSession().setAttribute("klantenfacturen", fService.getAlleFacturen(k.getUsername()));
        }

        rd.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
