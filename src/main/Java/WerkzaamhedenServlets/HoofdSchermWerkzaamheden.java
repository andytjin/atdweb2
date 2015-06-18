package WerkzaamhedenServlets;

import Domain.Artikel;
import Domain.Auto;
import Domain.GebruikteArtikelen;
import Domain.Monteur;
import Domain.Onderhoudsbeurt;
import Service.ArtikelService;
import Service.AutoService;
import Service.GebruikteArtikelenService;
import Service.MonteurService;
import Service.OnderhoudsService;
import Service.ServiceProvider;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andy
 */
@WebServlet(name = "HoofdSchermWerkzaamheden", urlPatterns = {"/HoofdSchermWerkzaamheden"})
public class HoofdSchermWerkzaamheden extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String knop = request.getParameter("knop");

        if (knop.equals("werkzaamheidToevoegen")) {
            ArtikelService aService = ServiceProvider.getArtikelService();
            List<Artikel> lijst = aService.getAlleArtikelen();
            request.getSession().setAttribute("artikel", lijst);

            MonteurService mService = ServiceProvider.getMonteurService();
            List<Monteur> mlijst = mService.getAlleMonteurs();
            request.getSession().setAttribute("monteur", mlijst);

            AutoService auService = ServiceProvider.getAutoService();
            List<Auto> auLijst = auService.getAlleAutos();
            request.getSession().setAttribute("auto", auLijst);
            
            OnderhoudsService oService = ServiceProvider.getOnderhoudsService();
            List<Onderhoudsbeurt> oLijst = oService.getAlleOnderhoudsbeurten();
            request.getSession().setAttribute("onderhoudsbeurt", oLijst);
            
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidToevoegen.jsp");
            view.forward(request, response);
        }
        
        if (knop.equals("werkzaamheidWijzigen")) {
            ArtikelService aService = ServiceProvider.getArtikelService();
            List<Artikel> lijst = aService.getAlleArtikelen();
            request.getSession().setAttribute("artikel", lijst);

            MonteurService mService = ServiceProvider.getMonteurService();
            List<Monteur> mlijst = mService.getAlleMonteurs();
            request.getSession().setAttribute("monteur", mlijst);

            AutoService auService = ServiceProvider.getAutoService();
            List<Auto> auLijst = auService.getAlleAutos();
            request.getSession().setAttribute("auto", auLijst);
            
            OnderhoudsService oService = ServiceProvider.getOnderhoudsService();
            List<Onderhoudsbeurt> oLijst = oService.getAlleOnderhoudsbeurten();
            request.getSession().setAttribute("onderhoudsbeurt", oLijst);
            
            GebruikteArtikelenService gAService = ServiceProvider.getGebruikteArtikelenService();
            List<GebruikteArtikelen> gaLijst = gAService.getGAList();
            request.getSession().setAttribute("gebruikteartikelen", gaLijst);
            
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidWijzigen.jsp");
            view.forward(request, response);
        
        }
        
        if (knop.equals("werkzaamheidVerwijderen")) {
            ArtikelService aService = ServiceProvider.getArtikelService();
            List<Artikel> lijst = aService.getAlleArtikelen();
            request.getSession().setAttribute("artikel", lijst);

            MonteurService mService = ServiceProvider.getMonteurService();
            List<Monteur> mlijst = mService.getAlleMonteurs();
            request.getSession().setAttribute("monteur", mlijst);

            AutoService auService = ServiceProvider.getAutoService();
            List<Auto> auLijst = auService.getAlleAutos();
            request.getSession().setAttribute("auto", auLijst);
            
            OnderhoudsService oService = ServiceProvider.getOnderhoudsService();
            List<Onderhoudsbeurt> oLijst = oService.getAlleOnderhoudsbeurten();
            request.getSession().setAttribute("onderhoudsbeurt", oLijst);
            
            GebruikteArtikelenService gAService = ServiceProvider.getGebruikteArtikelenService();
            List<GebruikteArtikelen> gaLijst = gAService.getGAList();
            request.getSession().setAttribute("gebruikteartikelen", gaLijst);
            
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidVerwijderen.jsp");
            view.forward(request, response);
        
        }
        
        if (knop.equals("werkzaamheidOverzicht")) {
            ArtikelService aService = ServiceProvider.getArtikelService();
            List<Artikel> lijst = aService.getAlleArtikelen();
            request.getSession().setAttribute("artikel", lijst);

            MonteurService mService = ServiceProvider.getMonteurService();
            List<Monteur> mlijst = mService.getAlleMonteurs();
            request.getSession().setAttribute("monteur", mlijst);

            AutoService auService = ServiceProvider.getAutoService();
            List<Auto> auLijst = auService.getAlleAutos();
            request.getSession().setAttribute("auto", auLijst);
            
            OnderhoudsService oService = ServiceProvider.getOnderhoudsService();
            List<Onderhoudsbeurt> oLijst = oService.getAlleOnderhoudsbeurten();
            request.getSession().setAttribute("onderhoudsbeurt", oLijst);
            
            GebruikteArtikelenService gAService = ServiceProvider.getGebruikteArtikelenService();
            List<GebruikteArtikelen> gaLijst = gAService.getGAList();
            request.getSession().setAttribute("gebruikteartikelen", gaLijst);
            
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamhedenOverzicht.jsp");
            view.forward(request, response);
        }

    }

}
