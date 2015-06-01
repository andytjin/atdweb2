package WerkzaamhedenServlets;

import Domain.Artikel;
import Domain.Auto;
import Domain.Monteur;
import Service.ArtikelService;
import Service.AutoService;
import Service.MonteurService;
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
            request.getServletContext().setAttribute("artikel", lijst);

            MonteurService mService = ServiceProvider.getMonteurService();
            List<Monteur> mlijst = mService.getAlleMonteurs();
            request.getServletContext().setAttribute("monteur", mlijst);

            AutoService auService = ServiceProvider.getAutoService();
            List<Auto> auLijst = auService.getAlleAutos();
            request.getServletContext().setAttribute("auto", auLijst);
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidToevoegen.jsp");
            view.forward(request, response);
        } else {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}