package Servlets;

import Domain.Artikel;
import Domain.Klant;
import Domain.Onderhoudsbeurt;
import Domain.ParkeerDienst;
import Service.ArtikelService;
import Service.KlantService;
import Service.OnderhoudsService;
import Service.ParkeerService;
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
@WebServlet(name = "AdminPageServlet", urlPatterns = {"/AdminPageServlet"})
public class AdminPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");
        RequestDispatcher rd = request.getRequestDispatcher("AddMonteur.jsp");
        if (button.equals("log out")) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        if (button.equals("Home")) {
            rd = request.getRequestDispatcher("AdminPage.jsp");
        }
        if (button.equals("Factuur")) {
            KlantService ks = ServiceProvider.getKlantService();
            ParkeerService ps = ServiceProvider.getParkeerService();
            OnderhoudsService os = ServiceProvider.getOnderhoudsService();
            
            
            rd = request.getRequestDispatcher("FactuurOverzichtBeheerder.jsp");
            getServletContext().setAttribute("klanten", ks.getAlleKlanten());
            List<Onderhoudsbeurt> lijst = os.getAlleOnderhoudsbeurten();
            List<ParkeerDienst> list = ps.getAll();
            getServletContext().setAttribute("dienstNummer", lijst);
            getServletContext().setAttribute("pdiensten", list);
        }
        if(button.equals("Bestelling")){
            rd = request.getRequestDispatcher("Bestelling.jsp");
        }
        if (button.equals("Klanten")) {
            rd = request.getRequestDispatcher("KlantenOverzicht.jsp");
            KlantService ks = ServiceProvider.getKlantService();
            List<Klant> lijst = ks.getAlleKlanten();
            request.setAttribute("KlantenLijst", lijst);
        }
        
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

        rd.forward(request, response);
    }
}
