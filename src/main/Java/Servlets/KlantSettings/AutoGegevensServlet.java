package Servlets.KlantSettings;

import Domain.Auto;
import Domain.Klant;
import Service.AutoService;
import Service.ServiceProvider;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
public class AutoGegevensServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");

        /*Object obj = request.getServletContext().getAttribute("bedrijf");
         Bedrijf bedrijf = null;
         if (obj != null) {
         bedrijf = (Bedrijf) obj;
         }*/
        AutoService as = ServiceProvider.getAutoService();

        /*
         AUTO TOEVOEGEN
         */
        if (button.equals("Auto toevoegen")) {
            String kenteken = request.getParameter("kenteken");
            String type = request.getParameter("naam");
            String merk = request.getParameter("merk");
            boolean b = true;
            if (type.equals("")) {
                b = false;
            }
            if (merk.equals("")) {
                b = false;
            }
            if(kenteken.equals("")){
                b = false;
            }
            if (b) {
                Object object = request.getSession().getAttribute("User");
                Klant k = null;
                if (object != null) {
                    k = (Klant) object;
                    Auto a = new Auto(kenteken, type, merk, k);
                    as.create(a);
                    System.out.println("Auto toegevoegd");
                } else {
                    System.out.println("geen klant gevonden");
                }

            }
        }
        if (button.equals("verwijder")) {

        }

        request.setAttribute("PageName", "Auto gegevens");
        request.setAttribute("settingpage", "AutoGegevens");
        request.getRequestDispatcher("KlantSettings.jsp").forward(request, response);
    }
}
