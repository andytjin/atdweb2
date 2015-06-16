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
        String sAantal = request.getParameter("aantaluur");
        int aantal = Integer.parseInt(sAantal);
        ParkeerService ps = ServiceProvider.getParkeerService();
        ParkeerplaatsService pps = ServiceProvider.getParkeerPlaatsService();
        int maxAantal = 25;
        int huidigAantal = pps.getAantalBezet();
        
        String msgs = "";
        boolean b = true;
        
        if(huidigAantal == maxAantal){
            msgs += "Er is geen plek meer op de parkeerplaats";
            b = false;
        }
        if(aantal == 0){
            msgs += "Er kan geen plek gereserveerd worden voor 0 uur";
            b = false;
        }
        
        if(b){
            pps.setHuidigBezet(huidigAantal + 1);
            int id = ps.getHoogsteParkeerNummer() + 1;
            ParkeerDienst pd = new ParkeerDienst(id, Calendar.getInstance(), aantal);
            ps.create(pd);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/Garage.jsp");
        request.setAttribute("PageName", "Garage");
        rd.forward(request, response);
        
    }
}
