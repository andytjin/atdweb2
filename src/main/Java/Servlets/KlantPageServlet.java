package Servlets;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
@WebServlet(name = "KlantPageServlet", urlPatterns = {"/KlantPageServlet"})
public class KlantPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String button = request.getParameter("button");
        
        RequestDispatcher rd = request.getRequestDispatcher("/KlantPage.jsp");
        
        if(button.equals("Home")){
            request.setAttribute("PageName", "Homepage");
            rd = request.getRequestDispatcher("/KlantPage.jsp");
        }
       if(button.equals("afspraak")){
            request.setAttribute("PageName", "Afspraak");
            rd = request.getRequestDispatcher("/Planning.jsp");
//            AutoService as = ServiceProvider.getAutoService();
//            Object obj = request.getSession().getAttribute("User");
//            Klant k = (Klant) obj;
//            List<Auto> lijst = as.getAutoByKlant(k);
//            request.getSession().setAttribute("autos", lijst);
        }
        if(button.equals("garage")){
            ParkeerplaatsService pps = ServiceProvider.getParkeerPlaatsService();
            request.setAttribute("bezettePlaatsen", pps.getAantalBezet());
            request.setAttribute("PageName", "Garage");
            rd = request.getRequestDispatcher("/Garage.jsp");
        }
        if(button.equals("mijn account")){
            AutoService as = ServiceProvider.getAutoService();
            Object obj = request.getSession().getAttribute("User");
            Klant k = (Klant) obj;
            List<Auto> lijst = as.getAutoByKlant(k);
            request.setAttribute("PageName", "Account Settings");
            request.getSession().setAttribute("autos", lijst);
            rd = request.getRequestDispatcher("/KlantSettings.jsp");
        }
        if(button.equals("Log uit")){
            request.setAttribute("PageName", "Auto Totaal Dienst");
            request.getSession().setAttribute("User", null);
            rd = request.getRequestDispatcher("/index.jsp");
        }
        if(button.equals("factuur")){
            FactuurService fService = ServiceProvider.getFactuurService();
            request.setAttribute("PageName", "Factuur");
            rd = request.getRequestDispatcher("FactuurOverzichtKlant.jsp");
            Object obj = request.getSession().getAttribute("User");
            Klant k = (Klant) obj;
            request.getSession().setAttribute("klantenfacturen" , fService.getAlleFacturen(k.getUsername()));
        }
        
        rd.forward(request, response);
        
        
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
