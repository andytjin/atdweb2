package Servlets;

import Domain.Klant;
import Service.KlantService;
import Service.ServiceProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        KlantService ks = ServiceProvider.getKlantService();

        String username = request.getParameter("Username");
        String realname = request.getParameter("Fullname");
        String pass1 = request.getParameter("Password");
        String pass2 = request.getParameter("PasswordConfirm");
        String email1 = request.getParameter("Email");
        String email2 = request.getParameter("EmailConfirm");
        String telnmr = request.getParameter("Phonenumber");
        String adres = request.getParameter("Address");
        String postcode = request.getParameter("Postcode");
        String geboortedatum = request.getParameter("DateofBirth");
        String sHerrinering = request.getParameter("Herrinnering");
        boolean herrinering = false;

        String msgs = "De volgende velden zijn niet correct ingevuld<br/>";
        boolean b = true;
        if (username.equals("")) {
            b = false;
            msgs += "- Gebruikersnaam <br/>";
        }
        if (realname.equals("")) {
            b = false;
            msgs += "- Naam<br/>";
        }
        if (pass1.equals("") || pass2.equals("")) {
            b = false;
            msgs += "- Wachtwoord<br/>";
        } else if (!pass1.equals(pass2)) {
            b = false;
            msgs += "- Wachtwoorden komen niet overeen<br/>";
        }
        if (email1.equals("") || email2.equals("")) {
            b = false;
            msgs += "- Email<br/>";
        } else if (!email1.equals(email2)) {
            b = false;
            msgs += "- Email adressen komen niet overeen<br/>";
        }
        if (adres.equals("")) {
            b = false;
            msgs += "- Adres<br/>";
        }
        if (postcode.equals("")) {
            b = false;
            msgs += "- Postcode<br/>";
        }
        if (geboortedatum.equals("")) {
            b = false;
            msgs += "- GeboorteDatum<br/>";
        }
        //TODO toevoegen extra checks voor geboortedatum en postcode.
        if (sHerrinering != null) {
            if (sHerrinering.equals("on")) {
                herrinering = true;
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

        if (b) {
            Klant k = new Klant(username, realname, pass1, adres, geboortedatum, telnmr, postcode, email1, herrinering);
            if (!ks.heeftKlant(k.getUsername())) {
                ks.addKlant(username, realname, pass1, adres, geboortedatum, telnmr, postcode, email1, herrinering);
                request.getSession().setAttribute("user", k);
                request.setAttribute("msgs", "U bent geregistreerd, log boven aan de pagina in.");
            } else {
                request.setAttribute("msgs", "Deze username bestaat al");
            }
        } else {
            request.setAttribute("msgs", msgs);
        }
        rd.forward(request, response);

    }
}
