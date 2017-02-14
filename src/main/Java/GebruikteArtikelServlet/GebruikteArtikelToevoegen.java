package GebruikteArtikelServlet;

import Domain.Artikel;
import Domain.GebruikteArtikelen;
import Service.ArtikelService;
import Service.GebruikteArtikelenService;
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
@WebServlet(name = "GebruikteArtikelToevoegen", urlPatterns = {"/GebruikteArtikelToevoegen"})
public class GebruikteArtikelToevoegen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String gaAantal = request.getParameter("ga");
        String ArtikelCode = request.getParameter("artikel");
        String onderhoudsID = request.getParameter("onderhoudsbeurt");
        int gAantal = 0;
        int ohID = 0;
        boolean b = true;

        if (onderhoudsID.equals("")) {
            b = false;
        } else {
            ohID = Integer.parseInt(onderhoudsID);
        }

        if (gaAantal.equals("")) {
            b = false;
        } else {
            gAantal = Integer.parseInt(gaAantal);
        }
        if (b) {

            ArtikelService aService = ServiceProvider.getArtikelService();
            GebruikteArtikelenService gaService = ServiceProvider.getGebruikteArtikelenService();

            if (gAantal > 0) {
                Artikel a = aService.getArtikelByCode(ArtikelCode);
                if ((a.getAantal() - gAantal) < 0) {
                    request.setAttribute("msgs", "Niet genoeg op voorraad");
                } else {
                    a.setAantal(a.getAantal() - gAantal);
                    GebruikteArtikelen ga = new GebruikteArtikelen(gAantal, a);
                    aService.WijzigArtikel(a);
                    gaService.schrijfGebruikteArtikelNaarDatabase(ga, ohID);
                }
            }

            //   List<GebruikteArtikelen> gaLijst = gaService.getGAList();
            List<GebruikteArtikelen> gaLijst = gaService.getByID(ohID);
            request.setAttribute("gaLijst", gaLijst);

        }
        RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidToevoegen.jsp");
        view.forward(request, response);
    }
}
