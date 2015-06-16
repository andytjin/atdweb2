package Servlets;

import Domain.Klant;
import Service.FactuurService;
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
    int i;
    double d;
    private FactuurService fService = ServiceProvider.getFactuurService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String knop = request.getParameter("button");
        String fnummer = request.getParameter("Factuurnummer");
        String bprijs = request.getParameter("Brutoprijs");
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
        if (bprijs.equals("")) {
            b = false;
            msgs += "- Brutoprijs<br/>";
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
        if (!bprijs.equals("")) {
            d = Double.parseDouble(bprijs);
        }
        if (betaald != null) {
            if (betaald.equals("on")) {
                paid = true;
            }
        }
        request.getServletContext().setAttribute("msgs", msgs);
        RequestDispatcher rd = request.getRequestDispatcher("FactuurOverzichtBeheerder.jsp");
        
       
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
