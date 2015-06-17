package Servlets;

import Domain.ParkeerDienst;
import Service.ParkeerService;
import Service.ParkeerplaatsService;
import Service.ServiceProvider;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
public class GarageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] plaatsen = {"A1", "A2", "A3", "A4", "A5",
            "B1", "B2", "B3", "B4", "B5",
            "C1", "C2", "C3", "C4", "C5",
            "D1", "D2", "D3", "D4", "D5"};

        String sAantal = request.getParameter("aantaluur");
        int aantal = Integer.parseInt(sAantal);
       
        
        ParkeerService ps = ServiceProvider.getParkeerService();
        ParkeerplaatsService pps = ServiceProvider.getParkeerPlaatsService();
        
        ps.clearDBofOldFiles();
        
        int maxAantal = 25;
        int huidigAantal = pps.getAantalBezet();

        String msgs = "";
        boolean b = true;

        if (huidigAantal == maxAantal) {
            msgs += "Er is geen plek meer op de parkeerplaats";
            b = false;
        }
        if (aantal == 0) {
            msgs += "Er kan geen plek gereserveerd worden voor 0 uur";
            b = false;
        }

        if (b) {
            pps.setHuidigBezet(huidigAantal + 1);
            int id = ps.getHoogsteParkeerNummer() + 1;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DATE)+ (int) aantal / 24);
            ParkeerDienst pd = new ParkeerDienst(id, cal, aantal);
            ps.create(pd);
            msgs = "U heeft plaats " + plaatsen[huidigAantal] + " gereserveerd voor " + aantal + " uur"; 
        }
        RequestDispatcher rd = request.getRequestDispatcher("/Garage.jsp");
        request.setAttribute("PageName", "Garage");
        request.setAttribute("bezettePlaatsen", pps.getAantalBezet());
        request.setAttribute("msgs", msgs);
        rd.forward(request, response);

    }
}
