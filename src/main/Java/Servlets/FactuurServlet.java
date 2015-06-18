package Servlets;

import Domain.*;
import Service.ArtikelService;
import Service.FactuurService;
import Service.GebruikteArtikelenService;
import Service.PlanningService;
import Service.ParkeerService;
import Service.ServiceProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thijs
 */
@WebServlet(name = "FactuurServlet", urlPatterns = {"/FactuurServlet"})
public class FactuurServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Onderhoudsbeurt deOnderhoudsbeurt = new Onderhoudsbeurt();
         ParkeerDienst deParkeerdienst = new ParkeerDienst();
         TankDienst deTankdienst = new TankDienst();*/
        GebruikteArtikelenService gaService = ServiceProvider.getGebruikteArtikelenService();
        PlanningService oService = ServiceProvider.getPlanningService();
        ArtikelService aService = ServiceProvider.getArtikelService();
        FactuurService fService = ServiceProvider.getFactuurService();
        ParkeerService pService = ServiceProvider.getParkeerService();

        int i = 0;
        int p = 0;
        int dN = 0;
        double d = 0;

        String knop = request.getParameter("button");
        String fnummer = request.getParameter("Factuurnummer");
        String parkeernummer = request.getParameter("pdiensten");
        String arbeidsuren = request.getParameter("arbeidsuren");
        String dienstNummer = request.getParameter("dienstNummer");
        String betaald = request.getParameter("Betaald");
        String fD = request.getParameter("Factuurdatum");
        String vdatum = request.getParameter("Vervaldatum");
        String oS = request.getParameter("Omschrijving");
        String knaam = request.getParameter("Klantnaam");
        boolean paid = false;

        String msgs = "De volgende velden zijn niet correct ingevuld<br/>";
        boolean b = true;

        if (fnummer.equals("")) {
            b = false;
            msgs += "- Factuurnummer <br/>";
        }

        if (knaam.equals("")) {
            b = false;
            msgs += "- Klantnaam<br/>";
        }

        if (vdatum.equals("")) {
            b = false;
            msgs += "- Vervaldatum<br/>";
        }

        if (oS.equals("")) {
            b = false;
            msgs += "- Omschrijving<br/>";
        }

        if (fD.equals("")) {
            b = false;
            msgs += "- Factuurdatum<br/>";
        }

        if (!fnummer.equals("")) {
            i = Integer.parseInt(fnummer);
        }
        if (betaald != null) {
            if (betaald.equals("on")) {
                paid = true;
            }
        }

        request.getServletContext()
                .setAttribute("msgs", msgs);
        RequestDispatcher rd = request.getRequestDispatcher("FactuurOverzichtBeheerder.jsp");

        if (knop.equals(
                "Bereken")) {
            d = 0.0;
            if (!arbeidsuren.equals("")) {
                i = Integer.parseInt(arbeidsuren);
            }
            if (!dienstNummer.equals("")) {
                dN = Integer.parseInt(dienstNummer);
            }
            Onderhoudsbeurt deOnderhoudsbeurt = oService.getOnderhoudsbeurt(dN);
            for (GebruikteArtikelen ga : gaService.getGebruikteArtikelByOnderhoudsbeurt(dN)) {
                deOnderhoudsbeurt.voegArtikelToe(ga.getHetArtikel(), ga.getAantal(), dN);

            }
            System.out.println(deOnderhoudsbeurt.getGebruikteArtikelen());
            //deOnderhoudsbeurt.setDeArtikelen(gaService.getGebruikteArtikelByOnderhoudsbeurt(dN));
            deOnderhoudsbeurt.setAantalBestedeUur(i);
            d += deOnderhoudsbeurt.prijs();
            if (!parkeernummer.equals("")) {
                p = Integer.parseInt(parkeernummer);
            }
            ParkeerDienst deParkeerDienst = pService.getParkeerDienstByID(p);
            d += deParkeerDienst.prijs();
            System.out.println(d);
            request.setAttribute("prijs", d);

        }

        if (knop.equals("Aanmaken")) {
            if (b) {
                fService.addFactuur(i, d, paid, fD, vdatum, oS, fService.getKlant(knaam));
                request.setAttribute("msgs", "Factuur toegevoegd!");
            } else {
                request.setAttribute("msgs", msgs);
            }
        }

        rd.forward(request, response);
    }

}
