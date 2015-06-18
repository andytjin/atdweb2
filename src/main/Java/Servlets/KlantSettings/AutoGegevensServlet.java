package Servlets.KlantSettings;

import Domain.Auto;
import Domain.Klant;
import Service.AutoService;
import Service.FactuurService;
import Service.ParkeerplaatsService;
import Service.ServiceProvider;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
public class AutoGegevensServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");

        AutoService as = ServiceProvider.getAutoService();

        if (button.equals("Auto toevoegen")) {
            String kenteken = request.getParameter("kenteken");
            String type = request.getParameter("naam");
            String merk = request.getParameter("merk");
            boolean b = true;
            if (type.equals("")) {
                b = false;
            }
            if (merk.equals("")) {
                b = false;
            }
            if (kenteken.equals("")) {
                b = false;
            }
            if (b) {
                Object object = request.getSession().getAttribute("User");
                Klant k = null;
                if (object != null) {
                    k = (Klant) object;
                    Auto a = new Auto(kenteken.toUpperCase(), type, merk, k);
                    as.create(a);
                    System.out.println("Auto toegevoegd");
                } else {
                    System.out.println("geen klant gevonden");
                }

            }
        }
        if (button.equals("verwijder")) {

        }
        RequestDispatcher rd = request.getRequestDispatcher("/KlantPage.jsp");
        Klant k = (Klant) request.getSession().getAttribute("User");
        request.getSession().setAttribute("User", k);
        ParkeerplaatsService pps = ServiceProvider.getParkeerPlaatsService();
        request.setAttribute("bezettePlaatsen", pps.getAantalBezet());
        List<Auto> lijst = as.getAutoByKlant(k);
        request.setAttribute("PageName", "Account Settings");
        request.getSession().setAttribute("autos", lijst);
        FactuurService fService = ServiceProvider.getFactuurService();
        request.getSession().setAttribute("klantenfacturen", fService.getAlleFacturen(k.getUsername()));
        request.setAttribute("PageName", "Homepage");
        rd.forward(request, response);
    }
}
