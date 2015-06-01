/*
 * Licsense Header
 */
package Servlets;

import Domain.Klant;
import Domain.Monteur;
import Service.KlantService;
import Service.MonteurService;
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
        RequestDispatcher rd = request.getRequestDispatcher("/KlantPage.jsp");
        boolean b = true;

        KlantService ks = ServiceProvider.getKlantService();
        MonteurService ms = ServiceProvider.getMonteurService();
        if (username.equals("")) {
            msgs += "- Username is niet ingevuld";
            b = false;
        }
        if (password.equals("")) {
            msgs += "- Wachtwoord is niet ingevuld";
            b = false;
        }
        switch (button) {
            case "Login":
                Klant k = ks.getKlant(username);
                if (k != null) {
                    if (k.checkPassword(password)) {
                        System.out.println("Wachtwoord correct");
                        if (username.equals("HenkPaladijn")) {
                            rd = request.getRequestDispatcher("/AdminPage.jsp");
                        }
                        request.getSession().setAttribute("User", k);
                    } else {
                        b = false;
                        msgs += "- Wachtwoord is onjuist";
                    }
                } else {
                    b = false;
                    msgs += "- Er is geen klant met deze gebruikers naam";
                    for (Klant k2 : ks.getAlleKlanten()) {
                        System.out.println(k2.toString());
                    }
                }   break;
            case "Monteur login":
                int id = 0;
                try{
                    id = Integer.parseInt(username);
                }catch(Exception e){
                    msgs += "- ID is niet goed ingevuld";
                }
                Monteur m = ms.getMonteur(id);
                if(m != null){
                    if(m.checkPassword(password)){
                        request.getSession().setAttribute("User", m);
                        rd = request.getRequestDispatcher("MonteurPage.jsp");
                    }else{
                        msgs += "- Wachtwoord is fout";
                    }
                }else{
                    msgs += "- Monteur is niet gevonden";
                }
                break;
        }
        if (!b) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        request.setAttribute("loginmsgs", msgs);
        request.setAttribute("PageName", "Homepage");
        rd.forward(request, response);
    }

}
