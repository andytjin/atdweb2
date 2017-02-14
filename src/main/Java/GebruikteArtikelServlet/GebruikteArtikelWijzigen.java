package GebruikteArtikelServlet;

import Domain.Artikel;
import Domain.GebruikteArtikelen;
import Service.ArtikelService;
import Service.GebruikteArtikelenService;
import Service.ServiceProvider;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
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
@WebServlet(name = "GebruikteArtikelWijzigen", urlPatterns = {"/GebruikteArtikelWijzigen"})
public class GebruikteArtikelWijzigen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String knop = request.getParameter("knop");
        String gaID = request.getParameter("gebruikteartikelen");
        String onderhoudsbeurtID = request.getParameter("onderhoudsbeurt");
        String artikelID = request.getParameter("artikel");
        String aantalArt = request.getParameter("ga");
        String gaString = "";

        int ohID = 0;
        int aantalGA = 0;
        int gebruikteArtikelID = 0;

        try {
            Scanner sc = new Scanner(gaID);
            sc.useDelimiter("\\s*,\\s*");
            gaString = sc.next();

            sc.close();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        if (!gaID.equals("")) {
            gebruikteArtikelID = Integer.parseInt(gaString);
        }

        if (!onderhoudsbeurtID.equals("")) {
            ohID = Integer.parseInt(onderhoudsbeurtID);
        }

        if (aantalArt.equals("")) {
            aantalGA = Integer.parseInt(aantalArt);
        }

        if (knop.equals("Opslaan")) {
            ArtikelService aService = ServiceProvider.getArtikelService();
            Artikel a = aService.getArtikelByCode(artikelID);
            GebruikteArtikelen ga = new GebruikteArtikelen(aantalGA, a);
            GebruikteArtikelenService gService = ServiceProvider.getGebruikteArtikelenService();

            gService.wijzigGebruikteArtikel(ga, ohID, gebruikteArtikelID);
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidWijzigen.jsp");
            view.forward(request, response);
        }
    }
}
