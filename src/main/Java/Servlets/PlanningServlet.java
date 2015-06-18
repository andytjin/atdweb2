package Servlets;

import Domain.Auto;
import Domain.Klant;
import Domain.Onderhoudsbeurt;
import Service.AutoService;
import Service.FactuurService;
import Service.ParkeerplaatsService;
import Service.PlanningService;
import Service.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author freekvdp
 */
@WebServlet(name = "PlanningServlet", urlPatterns = {"/PlanningServlet"})
public class PlanningServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "";
        //Auto selecteren
        AutoService as = ServiceProvider.getAutoService();
        PlanningService ps = ServiceProvider.getPlanningService();
        Onderhoudsbeurt ob = null;
        Auto auto = null;
        List<Auto> alleAutos = null;

        Klant k = (Klant) request.getSession().getAttribute("User");
        String knop = request.getParameter("button");
        String dat = request.getParameter("SelectedDate");
        RequestDispatcher rd = request.getRequestDispatcher("/KlantPage.jsp");

        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date.setTime(sdf.parse(dat));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (knop.equals("Akkoord")) {
            try {
                Object o = request.getSession().getAttribute("Autos");
                if (o != null) {
                    alleAutos = (List<Auto>) o;
                    System.out.println("Alle autos is NIET null");
                } else {
                    System.out.println("Alle autos is null");
                }
                //System.out.println(alleAutos.size());
                String selectedAuto = request.getParameter("autoradios");
                if (!selectedAuto.equals("")) {
                    System.out.println("geselecteerde auto: " + selectedAuto);

                    for (Auto a : alleAutos) {
                        if (a.getKenteken().equals(selectedAuto)) {

                            auto = a;
                            System.out.println("auto gevonden");
                        }
                    }

                }
            } catch (Exception e) {
                error = "U heeft nog geen autos toegevoegd aan dit account";
            }

            if (auto != null) {
                //System.out.println("auto is NIET null!!");
                //TODO
                int dnr = 1;
                //System.out.println(os.getHighestDNr());
                try {
                    System.out.println(dat);
                    dnr = ps.getHighestDNr() + 1;
                    System.out.println("--------dit is de try!!!!!");
                    Onderhoudsbeurt o = new Onderhoudsbeurt(dnr, date, auto);
                    ps.addOnderhoudsbeurt(o);
                    System.out.println("onderhoudsbeurt toegevoegd!!!!!!");
                    rd = request.getRequestDispatcher("PlanningOverzicht.jsp");
                } catch (Exception e) {
                    System.out.println("dit is de catch!!!!!--------");
                    e.printStackTrace();
                }

                //request.getSession().setAttribute("SelectedAuto", auto);
            } else {
                System.out.println("FOUT! Auto is null");
                error = "U moet eerst een auto selecteren voordat u door kunt gaan";
            }
        }

        if (knop.equals("Auto Toevoegen")) {
            rd = request.getRequestDispatcher("/KlantSettingsPages/AutoGegevens.jsp");
        }
        if (knop.equals("Terug")) {
            rd = request.getRequestDispatcher("KlantPage.jsp");
        }
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
