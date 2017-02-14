/*
 * Licsense Header
 */
package Servlets;

import Domain.Auto;
import Domain.Klant;
import Domain.Monteur;
import Domain.Onderhoudsbeurt;
import Service.AutoService;
import Service.FactuurService;
import Service.KlantService;
import Service.MonteurService;
import Service.ParkeerplaatsService;
import Service.PlanningService;
import Service.ServiceProvider;
import java.io.IOException;
import java.util.ArrayList;
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
        PlanningService ps = ServiceProvider.getPlanningService();
        
        if (username.equals("")) {
            msgs += "- Username is niet ingevuld";
            b = false;
        }
        if (password.equals("")) {
            msgs += "- Wachtwoord is niet ingevuld";
            b = false;
        }
        if (button.equals("Login")) {
            Klant k = ks.getKlant(username);
            if (k != null) {
                if (k.checkPassword(password)) {
                    System.out.println("Wachtwoord correct");
                    if (username.equals("HenkPaladijn")) {
                        rd = request.getRequestDispatcher("/AdminPage.jsp");
                    }
                    request.getSession().setAttribute("User", k);
                    AutoService as = ServiceProvider.getAutoService();
                    ParkeerplaatsService pps = ServiceProvider.getParkeerPlaatsService();
                    request.setAttribute("bezettePlaatsen", pps.getAantalBezet());
                    List<Auto> lijst = as.getAutoByKlant(k);
                    request.setAttribute("PageName", "Account Settings");
                    request.getSession().setAttribute("autos", lijst);
                    FactuurService fService = ServiceProvider.getFactuurService();
                    
                    List<Onderhoudsbeurt> olijst = new ArrayList<Onderhoudsbeurt>();
                    for(Auto a : lijst){
                        System.out.println("--- ZoekOpdracht onderhoudsbeurten [LoginServlet line: 78]");
                        System.out.println("- zoekend naar onderhouds beurt bij kenteken: " + a.getKenteken());
                        List<Onderhoudsbeurt> gevonden = ps.getOnderhoudsbeurten(a.getKenteken());
                        for(Onderhoudsbeurt o : gevonden){
                            olijst.add(o);
                            System.out.println("- Onderhouds beurt gevonden en toegevoegd");
                        }
                        System.out.println("-- Einde zoekopdracht");
                    }
                    
                    request.getSession().setAttribute("klantenfacturen", fService.getAlleFacturen(k.getUsername()));
                    request.setAttribute("PageName", "Homepage");
                    for(Onderhoudsbeurt o : olijst){
                        System.out.println("ONDERHOUDS BEURRRT" + o.getDienstNummer());
                    }
                    request.getSession().setAttribute("Planningen", olijst);
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
            }
        } else {
            int id = 0;
            try {
                id = Integer.parseInt(username);
            } catch (Exception e) {
                msgs += "- ID is niet goed ingevuld";
            }
            Monteur m = ms.getMonteurByID(id);
            if (m != null) {
                if (m.checkPassword(password)) {
                    request.getSession().setAttribute("User", m);
                    rd = request.getRequestDispatcher("/MonteurPage.jsp");
                    request.setAttribute("PageName", "MonteurPage");
                    System.out.println("MONTEUR");
                } else {
                    msgs += "- Wachtwoord is fout";
                    b = false;
                }
            } else {
                msgs += "- Monteur is niet gevonden";
                b = false;
            }
        }
        if (!b) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        request.setAttribute("loginmsgs", msgs);

        rd.forward(request, response);
    }

}
