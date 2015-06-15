package WerkzaamhedenServlets;

import Domain.Auto;
import Domain.Monteur;
import Domain.Onderhoudsbeurt;
import Service.AutoService;
import Service.MonteurService;
import Service.OnderhoudsService;
import Service.ServiceProvider;
import java.io.IOException;
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
 * @author andy
 */
@WebServlet(name = "WerkzaamheidToevoegen", urlPatterns = {"/WerkzaamheidToevoegen"})
public class WerkzaamheidToevoegen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String knop = request.getParameter("knop");
        String onderhoudsbeurtID = request.getParameter("werkzaamheid");
        String datum = request.getParameter("datum");
        String nettoPrijs = request.getParameter("prijs");
        String bestedeUur = request.getParameter("uur");
        String kenteken = request.getParameter("auto");
        String monteurID = request.getParameter("monteur");
        int ohID = 0;
        int MonteurID = 0;

        if (onderhoudsbeurtID.equals("")) {
            System.out.println("onderhoudsID = null");
        } else {

            ohID = Integer.parseInt(onderhoudsbeurtID);
        }

        if (monteurID.equals("")) {
            System.out.println("MonteurID = null");
        } else {
            MonteurID = Integer.parseInt(monteurID);
        }

        //int GAID = Integer.parseInt(gaID);
        //int MonteurID = Integer.parseInt(monteurID);
        //artikel moet opgeslagen worden in gebruikte artikel
        //auto moet in auto database
        //monteur in monteur
        //onderhoudsbeurt bevat autoid, monteurid en gebruikte artikelen id
        //datum, aantalbestede uren, nettoprijs
        if (knop.equals("Opslaan")) {

            MonteurService mService = ServiceProvider.getMonteurService();
            Monteur m = mService.getMonteurByID(MonteurID);
            AutoService auService = ServiceProvider.getAutoService();
            Auto au = auService.getAutoByKenteken(kenteken);

            OnderhoudsService oService = ServiceProvider.getOnderhoudsService();

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            try {
                cal.setTime(sdf.parse(datum));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            System.out.println("TEST : "  + datum);
            
            Onderhoudsbeurt o = new Onderhoudsbeurt(ohID, cal, au, m);
            if (nettoPrijs.equals("") || bestedeUur.equals("")) {
                System.out.println("velden zijn leeg");
            } else {
                double prijs = Double.parseDouble(nettoPrijs);
                int uur = Integer.parseInt(bestedeUur);
                oService.schrijfOnderhoudsbeurtNaarDatabase(o, prijs, uur);
                List<Onderhoudsbeurt> oLijst = oService.getAlleOnderhoudsbeurten();
                request.getSession().setAttribute("onderhoudsbeurt", oLijst);
            }
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidToevoegen.jsp");
            view.forward(request, response);

        }
        if (knop.equals("Terug")) {
            RequestDispatcher view = request.getRequestDispatcher("/MonteurPage.jsp");
            view.forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
