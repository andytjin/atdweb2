package Servlets;

import Domain.Bedrijf;
import Domain.Klant;
import Domain.Monteur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String button = request.getParameter("button");
        String msgs = "De volgende velden zijn niet correct ingevuld<br/>";
        RequestDispatcher rd = request.getRequestDispatcher("KlantPage.jsp");
        boolean b = true;

        Object obj = request.getServletContext().getAttribute("bedrijf");
        Bedrijf bedrijf;
        if (obj != null) {
            bedrijf = (Bedrijf) obj;
        } else {
            bedrijf = new Bedrijf();
        }
        if (button.equals("Login")) {
            if (!username.equals("")) {
                Klant k = bedrijf.getKlant(username);
                if (k != null) {
                    if (k.checkPassword(password)) {
                        System.out.println("Wachtwoord correct");
                        if (username.equals("HenkPaladijn")) {
                            rd = request.getRequestDispatcher("AdminPage.jsp");
                        }
                    } else {
                        b = false;
                        msgs += "- Wachtwoord is onjuist";
                    }
                } else {
                    b = false;
                    msgs += "- Er is geen klant met deze gebruikers naam";
                    for (Klant k2 : bedrijf.getAlleKlanten()) {
                        System.out.println(k2.toString());
                    }
                }
            } else {
                b = false;
                msgs += "- Gebruikersnaam is niet ingevuld";
            }

        } else {
            if (username != null) {
                Monteur m = bedrijf.getMonteur(username);
                if (m != null) {
                    if (m.checkPassword(password)) {
                        System.out.println("password correct");
                        rd = request.getRequestDispatcher("MonteurPage.jsp");

                    } else {
                        msgs += "wachtwoord onjuist"; b=false;
                    }
                } else {
                    msgs += "Er bestaat geen monteur met dit ID"; b=false;
                }

            } else {
                msgs += "Gebruikersnaam of ID is niet ingevuld";b=false;
            }
        }
        if (!b) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        request.setAttribute("PageName", "HomePage");
        request.setAttribute("loginmsgs", msgs);
        rd.forward(request, response);
    }
}
