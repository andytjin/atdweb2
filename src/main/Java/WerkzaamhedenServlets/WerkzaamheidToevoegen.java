package WerkzaamhedenServlets;

import Domain.Auto;
import Domain.Monteur;
import Domain.Onderhoudsbeurt;
import Service.AutoService;
import Service.MonteurService;
import Service.OnderhoudsService;
import Service.ServiceProvider;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        if (knop.equals("Opslaan")) {
            MonteurService mService = ServiceProvider.getMonteurService();
            Monteur m = mService.getMonteurByID(MonteurID);
            AutoService auService = ServiceProvider.getAutoService();
            Auto au = auService.getAutoByKenteken(kenteken);
            //datum, aantalbestede uren, nettoprijs
            OnderhoudsService oService = ServiceProvider.getOnderhoudsService();

            Calendar date = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            try {
                date.setTime(sdf.parse(datum));
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("TEST : " + datum);

            Onderhoudsbeurt o = new Onderhoudsbeurt(ohID, date, au, m);
            if (bestedeUur.equals("")) {
                System.out.println("velden zijn leeg");
            } else {
              
                int uur = Integer.parseInt(bestedeUur);
                oService.schrijfOnderhoudsbeurtNaarDatabase(o,uur);
                List<Onderhoudsbeurt> oLijst = oService.getAlleOnderhoudsbeurten();
                request.getSession().setAttribute("onderhoudsbeurt", oLijst);
            }
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidToevoegen.jsp");
            view.forward(request, response);

        }

        RequestDispatcher view = request.getRequestDispatcher("/MonteurPage.jsp");
        view.forward(request, response);
    }

}
