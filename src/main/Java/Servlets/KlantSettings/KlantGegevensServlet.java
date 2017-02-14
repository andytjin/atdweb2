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
public class KlantGegevensServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");
        String username = request.getParameter("username");
        String naam = request.getParameter("naam");
        String adres = request.getParameter("adres");
        String gdatum = request.getParameter("gdatum");
        String tel = request.getParameter("telnmmr");
        String postcode = request.getParameter("postcode");
        String email = request.getParameter("email");

        String oldpass = request.getParameter("wachtwoord");
        String pass1 = request.getParameter("nwachtwoord1");
        String pass2 = request.getParameter("nwachtwoord2");
        boolean passchange = false;

        RequestDispatcher rd = request.getRequestDispatcher("/KlantPage.jsp");
        boolean b = true;
        String msgs = "De volgende velden zijn miet correct ingevuld<br/>";

        if (button.equals("Terug")) {
            b = false;
            rd.forward(request, response);
        }
        if (naam.equals("")) {
            b = false;
            msgs += "-Naam<br/>";
        }
        if (adres.equals("")) {
            b = false;
            msgs += "-Adres<br/>";
        }
        if (gdatum.equals("")) {
            b = false;
            msgs += "-Geboortedatum<br/>";
        }
        if (tel.equals("")) {
            b = false;
            msgs += "-Telefoonnummer<br/>";
        }
        if (postcode.equals("")) {
            b = false;
            msgs += "-Postcode<br/>";
        }
        if (email.equals("")) {
            b = false;
            msgs += "-Email<br/>";
        }
        if (!oldpass.equals("") && !pass1.equals("") && !pass2.equals("")) {
            if (pass1.equals(pass2)) {
                passchange = true;
            } else {
                msgs += "De nieuwe wachtwoorden komen niet overeen";
                b = false;
            }
        }
        if (b) {
            Object obj = request.getSession().getAttribute("User");
            Klant k = null;
            if (obj != null) {
                k = (Klant) obj;
            }
            if (k != null) {
                if (passchange) {
                    k.setPassword(pass1);
                }
                k.setNaam(naam);
                k.setAdres(adres);
                k.setGeboortedatum(gdatum);
                k.setTelefoonnummer(tel);
                k.setPostcode(postcode);
                k.setEmailadres(email);
                msgs = "Gegevens zijn opgeslagen";
            }
        }

        AutoService as = ServiceProvider.getAutoService();
        request.setAttribute("settingmsgs1", msgs);
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
