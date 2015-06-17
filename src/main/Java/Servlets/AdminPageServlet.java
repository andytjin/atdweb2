package Servlets;

import Domain.Klant;
import Domain.Onderhoudsbeurt;
import Domain.ParkeerDienst;
import Service.KlantService;
import Service.OnderhoudsService;
import Service.ParkeerService;
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
@WebServlet(name = "AdminPageServlet", urlPatterns = {"/AdminPageServlet"})
public class AdminPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");
        RequestDispatcher rd = request.getRequestDispatcher("AddMonteur.jsp");
        if (button.equals("log out")) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        if (button.equals("Home")) {
            rd = request.getRequestDispatcher("AdminPage.jsp");
        }
        if (button.equals("Factuur")) {
            KlantService ks = ServiceProvider.getKlantService();
            ParkeerService ps = ServiceProvider.getParkeerService();
            OnderhoudsService os = ServiceProvider.getOnderhoudsService();
            
            
            rd = request.getRequestDispatcher("FactuurOverzichtBeheerder.jsp");
            request.getServletContext().setAttribute("klanten", ks.getAlleKlanten());
            List<Onderhoudsbeurt> lijst = os.getAlleOnderhoudsbeurten();
            System.out.println(lijst);
            List<ParkeerDienst> list = ps.getAll();
            request.getServletContext().setAttribute("dienstNummer", lijst);
            request.getServletContext().setAttribute("pdiensten", list);
        }
        if (button.equals("Klanten")) {
            rd = request.getRequestDispatcher("KlantenOverzicht.jsp");
            KlantService ks = ServiceProvider.getKlantService();
            List<Klant> lijst = ks.getAlleKlanten();
            request.setAttribute("KlantenLijst", lijst);
        }
        rd.forward(request, response);
    }
}
