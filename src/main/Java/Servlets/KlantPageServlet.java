package Servlets;

import java.io.IOException;

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
            System.out.println("IMPLEMENTEER AFSPRAAK");
        }
        if(button.equals("garage")){
            request.setAttribute("PageName", "Garage");
            System.out.println("IMPLEMENTEER GARAGE");
        }
        if(button.equals("mijn account")){
            request.setAttribute("PageName", "Account Settings");
            rd = request.getRequestDispatcher("/KlantSettings.jsp");
        }
        if(button.equals("log out")){
            request.setAttribute("PageName", "Auto Totaal Dienst");
            request.getSession().setAttribute("User", null);
            rd = request.getRequestDispatcher("/index.jsp");
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
